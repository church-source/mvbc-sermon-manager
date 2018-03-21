package org.churchsource.sermon.sermonplanner;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.churchsource.sermon.model.SermonManagerEntityWithAutoIncrement;

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
@Table(name="sermon_planner")
@NamedQueries({
  @NamedQuery(name = SermonPlannerNamedQueryConstants.QUERY_FIND_SERMON_PLANNER_ITEM_BY_ID, 
      query = SermonPlannerNamedQueryConstants.QUERY_FIND_SERMON_PLANNER_ITEM_BY_ID),
  @NamedQuery(name = SermonPlannerNamedQueryConstants.NAME_FIND_ALL_SERMON_PLANNER_ITEMS, 
      query = SermonPlannerNamedQueryConstants.QUERY_FIND_ALL_SERMON_PLANNER_ITEMS),
@NamedQuery(name = SermonPlannerNamedQueryConstants.NAME_FIND_SERMON_PLANNER_ITEM_BY_UNIQUE_GOOGLE_ID, 
      query = SermonPlannerNamedQueryConstants.QUERY_FIND_SERMON_PLANNER_ITEM_BY_UNIQUE_GOOGLE_ID)})
public class SermonPlannerItem extends SermonManagerEntityWithAutoIncrement <Long> {

  private static final long serialVersionUID = -865182316865182132L;

  private Date updated;

  private String uniqueGoogleId;

  private Date date;

  private SermonServiceAmPm amOrPm;

  private String service;

  private String preacher;

  private String title;

  private String passage; 

  private String series;
}
