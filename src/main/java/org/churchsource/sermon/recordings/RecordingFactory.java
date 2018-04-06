package org.churchsource.sermon.recordings;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tritonus.share.sampled.file.TAudioFileFormat;

@Transactional(readOnly = true, noRollbackFor=Exception.class)
@Service
public class RecordingFactory {
  static DateFormat sermon_date_format = new SimpleDateFormat("yyyyMMdd");

  public Recording createRecording(File recordedFile) throws ParseException, IOException, UnsupportedAudioFileException {
    Recording aRecording = new Recording();

    String fileName = recordedFile.getName();
    aRecording.setFileName(fileName);

    String date = fileName.split("-")[0];
    String amOrPm = fileName.split("-")[1];
    aRecording.setDate(sermon_date_format.parse(date));

    aRecording.setFilePath(recordedFile.getCanonicalPath());

    amOrPm = amOrPm.replaceAll("Sermon", "");
    aRecording.setServiceAmOrPm(amOrPm);
    
    aRecording.setRecordingLength(getDurationWithMp3Spi(recordedFile));
    return aRecording;
  }

  private String getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof TAudioFileFormat) {
        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
        String key = "duration";
        Long microseconds = (Long) properties.get(key);
        int mili = (int) (microseconds / 1000);
        int sec = (mili / 1000) % 60;
        int min = (mili / 1000) / 60;
        return "00:" + min + ":" + sec;
    } else {
        throw new UnsupportedAudioFileException();
    }

}
}
