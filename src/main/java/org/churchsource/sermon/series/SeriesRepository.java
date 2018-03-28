package org.churchsource.sermon.series;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SeriesRepository extends AbstractRepository<Series> {

  @PersistenceContext
  private EntityManager em;

  public List<Series> getAllSeries() {
    return em.createNamedQuery(SeriesNamedQueryConstants.NAME_FIND_ALL_SERIES, Series.class).getResultList();
  }

  public Series getSeriesById(Long id) {
    List<Series> series = em.createNamedQuery(SeriesNamedQueryConstants.NAME_FIND_SERIES_BY_ID, Series.class).setParameter("id", id)
        .getResultList();
    return series == null || series.isEmpty() ? null : series.get(0); 
  }

  public void saveNewOrUpdateExistingSeries(Series aSeries) {
    if(getSeriesById(aSeries.getId()) != null) {
      update(aSeries);
    } else {
      save(aSeries);
    }
  }

  public Series getSeriesByName(String seriesName) {
    List<Series> series = em.createNamedQuery(SeriesNamedQueryConstants.NAME_FIND_SERIES_BY_NAME, Series.class).setParameter("name", seriesName)
        .getResultList();
    return series == null || series.isEmpty() ? null : series.get(0);
  }
}