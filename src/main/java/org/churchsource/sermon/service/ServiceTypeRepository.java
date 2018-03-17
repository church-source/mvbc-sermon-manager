package org.churchsource.sermon.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.churchsource.sermon.model.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceTypeRepository extends AbstractRepository<ServiceType> {

  @PersistenceContext
  private EntityManager em;

  public List<ServiceType> getAllServiceTypes() {
    return em.createNamedQuery(ServiceTypeNamedQueryConstants.NAME_FIND_ALL_SERVICE_TYPES, ServiceType.class).getResultList();
  }

  public ServiceType getServiceTypeById(Long id) {
    List<ServiceType> serviceTypes = em.createNamedQuery(ServiceTypeNamedQueryConstants.NAME_FIND_SERVICE_TYPE_BY_ID, ServiceType.class).setParameter("id", id)
        .getResultList();
    return serviceTypes == null || serviceTypes.isEmpty() ? null : serviceTypes.get(0); 
  }

  public void saveNewOrUpdateExistingServiceType(ServiceType aServiceType) {
    if(getServiceTypeById(aServiceType.getId()) != null) {
      update(aServiceType);
    } else {
      save(aServiceType);
    }
  }
}