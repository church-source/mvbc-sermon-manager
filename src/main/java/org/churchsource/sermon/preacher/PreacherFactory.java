package org.churchsource.sermon.preacher;

import org.churchsource.sermon.preacher.wp.WPPreacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class PreacherFactory {

  @Autowired
  private PreacherRepository preahcerRepository;

  public Preacher createEntity(WPPreacher preacher) {
    Preacher aPreacher = new Preacher();
    aPreacher.setId(preacher.getId());
    aPreacher.setName(preacher.getName());
    return aPreacher;
  }

}