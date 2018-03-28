package org.churchsource.sermon.preacher;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PreacherRepository extends AbstractRepository<Preacher> {

  @PersistenceContext
  private EntityManager em;

  public List<Preacher> getAllPreachers() {
    return em.createNamedQuery(PreacherNamedQueryConstants.NAME_FIND_ALL_PREACHERS, Preacher.class).getResultList();
  }

  public Preacher getPreacherById(Long id) {
    List<Preacher> preachers = em.createNamedQuery(PreacherNamedQueryConstants.NAME_FIND_PREACHER_BY_ID, Preacher.class).setParameter("id", id)
        .getResultList();
    return preachers == null || preachers.isEmpty() ? null : preachers.get(0); 
  }

  public void saveNewOrUpdateExistingPreacher(Preacher aPreacherEntity) {
    if(getPreacherById(aPreacherEntity.getId()) != null) {
      update(aPreacherEntity);
    } else {
      save(aPreacherEntity);
    }
  }

  public Preacher getPreacherByName(String preacherName) {
    List<Preacher> preachers = em.createNamedQuery(PreacherNamedQueryConstants.NAME_FIND_PREACHER_BY_NAME, Preacher.class).setParameter("name", preacherName)
        .getResultList();
    return preachers == null || preachers.isEmpty() ? null : preachers.get(0); 
  }
}