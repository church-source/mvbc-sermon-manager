package org.churchsource.sermon.hello;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.media.MediaItemService;
import org.churchsource.sermon.recordings.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @Autowired
  RecordingService recordingService;

  @Autowired
  MediaItemService mediaItemService;

  @PersistenceContext
  private EntityManager entityManager;

  @RequestMapping("/")
  public String index() {
    return "Hello";
  }
}
