package org.churchsource.sermon.sermon;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SermonPlannerRepository extends AbstractRepository<SermonPlannerItem> {

  @PersistenceContext
  private EntityManager em;

  public List<SermonPlannerItem> getAllSermonPlannerItems() {
    return em.createNamedQuery(SermonPlannerNamedQueryConstants.NAME_FIND_ALL_SERMON_PLANNER_ITEMS, SermonPlannerItem.class).getResultList();
  }

  public SermonPlannerItem getSermonPlannerById(Long id) {
    List<SermonPlannerItem> sermonPlannerItems = em.createNamedQuery(SermonPlannerNamedQueryConstants.QUERY_FIND_SERMON_PLANNER_ITEM_BY_ID, SermonPlannerItem.class).setParameter("id", id)
        .getResultList();
    return sermonPlannerItems == null || sermonPlannerItems.isEmpty() ? null : sermonPlannerItems.get(0); 
  }

  public void saveSermonPlanningItem(SermonPlannerItem aSermonPlannerItem) {
    save(aSermonPlannerItem);
  }
  
  public void deleteAllSermonPlanningItems() {
    em.createQuery("DELETE FROM SermonPlannerItem").executeUpdate();
    em.flush();
  }
}