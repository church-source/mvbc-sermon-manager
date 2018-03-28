package org.churchsource.sermon.recordings;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Recording {

  private String fileName;
  private Date date;
  private String serviceAmOrPm;
  private String filePath;
  private String recordingLength;
}
