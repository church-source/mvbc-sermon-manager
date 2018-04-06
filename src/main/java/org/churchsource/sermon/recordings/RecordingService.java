package org.churchsource.sermon.recordings;

import java.io.File;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcSermonToUpload;
import org.churchsource.sermon.mvbcuploaded.wp.WPMvbcUploadedSermon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RecordingService {

  @Autowired
  private RecordingFactory recordingFactory;

  @Value("${sermon.recording.path}")
  private String sermonRecordingPath;
  
  @Autowired
  private WpSermonToUploadFactory sermonUploadFactory;
  
  @Value("${api.username}")
  private String apiUser;

  @Value("${api.password}")
  private String apiPassword;
  
  public List<Recording> uploadAllNewRecordings() {
    log.warn("a test warning!");
    log.info("got here");
    File recordingPath = new File(sermonRecordingPath);
    log.info(recordingPath.getAbsolutePath());
    log.info("Recording Path: " + sermonRecordingPath);
    List<String> mp3Paths = new ArrayList<String>();
    getMp3s(recordingPath, mp3Paths);
    for(String path : mp3Paths) { 
      File recordingFile = new File(path);
      try {
        Recording aRecording = recordingFactory.createRecording(recordingFile);
        
          WPMvbcSermonToUpload sermonToUpload = sermonUploadFactory.createSermonToUpload(aRecording);
          
          if(sermonToUpload != null) {
            log.info("Do Test Update");
            log.info(sermonToUpload.toString());
            uploadSermon(sermonToUpload);
          }
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
    return null;
  }

  private void uploadSermon(WPMvbcSermonToUpload sermonToUpload) throws JsonProcessingException {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String auth = apiUser +":"+ apiPassword;
    byte[] encodedAuth = Base64.encodeBase64( 
       auth.getBytes(Charset.forName("US-ASCII")) );
    String authHeader = "Basic " + new String( encodedAuth );
    headers.set( "Authorization", authHeader );
    
    ObjectMapper mapper = new ObjectMapper();
    String requestJSON = mapper.writeValueAsString(sermonToUpload);
    HttpEntity<String> requestEntity = new HttpEntity<>(requestJSON, headers);
 
    log.info("request JSON String: " + requestJSON);
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    ResponseEntity<String> response = restTemplate.exchange("https://www.mountainviewbaptist.co.za/wp-json/wp/v2/wpfc_sermon",
        HttpMethod.POST, requestEntity, String.class);
    log.info(response.getBody());

  }
  
  private void getMp3s(File f, List<String> mp3Paths) {
    File[] files;
    if (f.isDirectory() && (files = f.listFiles()) != null) {
        log.info("In Directory");
        for (File file : files) {
          getMp3s(file, mp3Paths);
        }
    }
    else {
        String path = f.getPath();
        log.info("checking file: " + path);
        if (path.endsWith(".mp3")) {
            log.info("Adding file: " + f.getPath());
            mp3Paths.add(f.getPath());
        }
    }
  }
}