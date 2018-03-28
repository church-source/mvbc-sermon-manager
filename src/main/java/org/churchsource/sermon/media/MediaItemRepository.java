package org.churchsource.sermon.media;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MediaItemRepository extends AbstractRepository<MediaItem> {

  @PersistenceContext
  private EntityManager em;

  public List<MediaItem> getAllMediaItems() {
    return em.createNamedQuery(MediaItemNamedQueryConstants.NAME_FIND_ALL_MEDIA_ITEMS, MediaItem.class).getResultList();
  }

  public MediaItem getMediaItemById(Long id) {
    List<MediaItem> mediaItems = em.createNamedQuery(MediaItemNamedQueryConstants.NAME_FIND_MEDIA_ITEM_BY_ID, MediaItem.class).setParameter("id", id)
        .getResultList();
    return mediaItems == null || mediaItems.isEmpty() ? null : mediaItems.get(0); 
  }

  public void saveNewOrUpdateExistingMediaItem(MediaItem aMediaItem) {
    if(getMediaItemById(aMediaItem.getId()) != null) {
      update(aMediaItem);
    } else {
      save(aMediaItem);
    }
  }

  public MediaItem getMediaItemByFileTitle(String title) {
    List<MediaItem> mediaItems = em.createNamedQuery(MediaItemNamedQueryConstants.NAME_FIND_MEDIA_ITEM_BY_TITLE, MediaItem.class).setParameter("title", title)
        .getResultList();
    return mediaItems == null || mediaItems.isEmpty() ? null : mediaItems.get(0); 
  }
}