package org.churchsource.sermon.sermonplanner;

import java.util.List;

import org.churchsource.sermon.googlesheet.planner.Entry;
import org.churchsource.sermon.googlesheet.planner.GoogleSheetSermonPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("sermon")
@Slf4j
public class SermonController {

  private static final String SERMON_PLANNER_LINK 
  = "https://spreadsheets.google.com/feeds/list/19fmsMGR_yNdaGO3vXZHpEaPe6W3x279orFcbXwx7UtQ/2/public/values?alt=json";

  @Autowired
  private SermonPlannerRepository sermonPlannerRepository;

  @Autowired
  private SermonPlannerFactory sermonPlannerFactory;
  
  @GetMapping("/{id}")
  public SermonPlannerItem getSermonPlannerItem(@PathVariable Long id) {
    return sermonPlannerRepository.getSermonPlannerById(id);
  }

  @GetMapping("")
  public List<SermonPlannerItem> getAllSermonPlannerItems() {
    return sermonPlannerRepository.getAllSermonPlannerItems();
  }

  @RequestMapping(value = "/sermonplanner", method = RequestMethod.POST)
  public String syncSermonPlanner() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    sermonPlannerRepository.deleteAllSermonPlanningItems();
    GoogleSheetSermonPlanner sermonPlanner = restTemplate.getForObject(SERMON_PLANNER_LINK, GoogleSheetSermonPlanner.class);
    for(Entry plannerEntry: sermonPlanner.getFeed().getEntry()) {
      SermonPlannerItem item = sermonPlannerFactory.createSermonPlannerItem(plannerEntry);
      sermonPlannerRepository.saveOrUpdateSermonPlanningItem(item);
      log.info(item.toString());
    }
    
    return null;
  }
  
}
