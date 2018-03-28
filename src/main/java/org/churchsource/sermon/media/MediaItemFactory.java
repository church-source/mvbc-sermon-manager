package org.churchsource.sermon.media;

import org.churchsource.sermon.media.wp.WPMedia;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class MediaItemFactory {

  public MediaItem createEntity(WPMedia wpMediaItem) {
    MediaItem aMediaItem = new MediaItem();
    aMediaItem.setId(wpMediaItem.getId());
    aMediaItem.setTitle(wpMediaItem.getTitle().getRendered());
    aMediaItem.setPath(wpMediaItem.getGuid().getRendered());
    return aMediaItem;
  }

}