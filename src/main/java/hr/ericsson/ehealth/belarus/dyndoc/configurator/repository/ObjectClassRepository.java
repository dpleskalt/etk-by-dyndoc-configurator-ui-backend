package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClass;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectClassRepository
    extends JpaRepository<ObjectClass, Integer>, JpaSpecificationExecutor<ObjectClass> {

  default ObjectClass getById(Integer id) {
    return findById(id)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    String.format("Object class with id %s was not found.", id)));
  }
}
