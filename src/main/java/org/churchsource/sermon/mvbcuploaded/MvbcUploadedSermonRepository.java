package org.churchsource.sermon.mvbcuploaded;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MvbcUploadedSermonRepository extends AbstractRepository<MvbcUploadedSermon> {

  @PersistenceContext
  private EntityManager em;

  public List<MvbcUploadedSermon> getAllMvbcUploadedSermons() {
    return em.createNamedQuery(MvbcNamedQueryConstants.NAME_FIND_ALL_UPLOADED_SERMONS, MvbcUploadedSermon.class).getResultList();
  }

  public MvbcUploadedSermon getMvbcUploadedSermonById(Long id) {
    List<MvbcUploadedSermon> series = em.createNamedQuery(MvbcNamedQueryConstants.NAME_FIND_UPLOADED_SERMON_BY_ID, MvbcUploadedSermon.class).setParameter("id", id)
        .getResultList();
    return series == null || series.isEmpty() ? null : series.get(0); 
  }

  public void saveNewOrUpdateExistingUploadedSermon(MvbcUploadedSermon aSermon) {
    if(getMvbcUploadedSermonById(aSermon.getId()) != null) {
      update(aSermon);
    } else {
      save(aSermon);
    }
  }
}