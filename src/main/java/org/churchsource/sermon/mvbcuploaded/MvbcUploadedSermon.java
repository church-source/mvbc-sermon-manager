package org.churchsource.sermon.mvbcuploaded;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.churchsource.sermon.model.SermonManagerEntity;
import org.churchsource.sermon.preacher.Preacher;
import org.churchsource.sermon.series.Series;
import org.churchsource.sermon.service.ServiceType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
@Getter
@Setter
@ToString (callSuper = true)
@Entity
@Table(name="mvbc_uploaded_sermons")
@NamedQueries({
  @NamedQuery(name = MvbcNamedQueryConstants.NAME_FIND_UPLOADED_SERMON_BY_ID, query = MvbcNamedQueryConstants.QUERY_FIND_UPLOADED_SERMON_BY_ID),
  @NamedQuery(name = MvbcNamedQueryConstants.NAME_FIND_ALL_UPLOADED_SERMONS, query = MvbcNamedQueryConstants.QUERY_FIND_ALL_UPLOADED_SERMONS)})
public class MvbcUploadedSermon extends SermonManagerEntity <Long> {

  /**
   * 
   */
  private static final long serialVersionUID = 1456604725825821737L;

  private Date sermonDate;

  private String title;

  private String sermonAudio;

  private String sermonAudioFileName;

  private String biblePassage;

  @ManyToOne
  private Preacher preacher;

  @ManyToOne
  private ServiceType serviceType;

  @ManyToOne
  private Series series;

  private int featuredMedia; 

}
