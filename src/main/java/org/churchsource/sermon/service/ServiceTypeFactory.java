package org.churchsource.sermon.service;

import org.churchsource.sermon.service.wp.WPServiceType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class ServiceTypeFactory {


  public ServiceType createEntity(WPServiceType wpServiceType) {
    ServiceType aServiceType = new ServiceType();
    aServiceType.setId(wpServiceType.getId());
    aServiceType.setName(wpServiceType.getName());
    return aServiceType;
  }

}