package org.churchsource.sermon.media;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.churchsource.sermon.mvbcuploaded.MvbcUploadedSermon;
import org.churchsource.sermon.mvbcuploaded.MvbcUploadedSermonRepository;
import org.churchsource.sermon.series.wp.WPSermonSeries;
import org.churchsource.sermon.sermonplanner.SermonPlannerItem;
import org.churchsource.sermon.sermonplanner.SermonPlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MediaItemService {

  @Autowired
  private MediaItemRepository mediaItemRepository;

  @Value("${sermon.images.path}")
  private String sermonImagesPath;
  
  @Value("${api.username}")
  private String apiUser;

  @Value("${api.password}")
  private String apiPassword;

  public void uploadAllNewSermonImages() {

    File recordingPath = new File(sermonImagesPath);
    List<String> imagePaths = new ArrayList<String>();
    getImagePaths(recordingPath, imagePaths);
    for(String path : imagePaths) { 
      File imageFile = new File(path);
      try {
        String fileNameWithoutExtension = imageFile.getName();
        log.info(fileNameWithoutExtension);
        if(fileNameWithoutExtension.contains(".")) {
          fileNameWithoutExtension = fileNameWithoutExtension.split("\\.")[0];
        }
        log.info("Querying for: " + fileNameWithoutExtension);
        MediaItem alreadyUploadedMediaItem = mediaItemRepository.getMediaItemByFileTitle(fileNameWithoutExtension);
        //hack to make this case insensitive TODO dont think this is needed here. 
        if(alreadyUploadedMediaItem == null) {
          alreadyUploadedMediaItem = mediaItemRepository.getMediaItemByFileTitle(fileNameWithoutExtension.toUpperCase());
          if(alreadyUploadedMediaItem != null) {
            fileNameWithoutExtension = fileNameWithoutExtension.toUpperCase();
          }
        }
        
        if(alreadyUploadedMediaItem == null) {
          log.info("New Media Item: " + imageFile.getName());
          MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
          bodyMap.add("file", new FileSystemResource(imageFile));
          
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.MULTIPART_FORM_DATA);
          headers.setContentDispositionFormData("attachment", imageFile.getName());
          String auth = apiUser +":"+ apiPassword;
          byte[] encodedAuth = Base64.encodeBase64( 
             auth.getBytes(Charset.forName("US-ASCII")) );
          String authHeader = "Basic " + new String( encodedAuth );
          headers.set( "Authorization", authHeader );
          
          HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
          
          RestTemplate restTemplate = new RestTemplate();
          restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
          ResponseEntity<String> response = restTemplate.exchange("https://www.mountainviewbaptist.co.za/wp-json/wp/v2/media/",
                  HttpMethod.POST, requestEntity, String.class);
          log.info(response.getBody());
        } else {
          log.info("Existing Media Item: " + alreadyUploadedMediaItem.toString());
        }
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }
  
  HttpHeaders createHeaders(String username, String password, String fileName){
    return new HttpHeaders() {{
          String auth = username + ":" + password;
          byte[] encodedAuth = Base64.encodeBase64( 
             auth.getBytes(Charset.forName("US-ASCII")) );
          String authHeader = "Basic " + new String( encodedAuth );
          set( "Authorization", authHeader );
          setContentType(MediaType.IMAGE_JPEG);
          setContentDispositionFormData("attachment", fileName);
       }};
 }

  private void getImagePaths(File f, List<String> imagePaths) {
    File[] files;
    if (f.isDirectory() && (files = f.listFiles()) != null) {
        log.info("In Directory");
        for (File file : files) {
          getImagePaths(file, imagePaths);
        }
    }
    else {
        String path = f.getPath();
        if (path.endsWith(".jpg") /*|| path.endsWith(".png")*/) {
            log.info("Adding file: " + f.getPath());
            imagePaths.add(f.getPath());
        }
    }
  }
}