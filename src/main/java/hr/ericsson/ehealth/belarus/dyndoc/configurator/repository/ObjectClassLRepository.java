package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClassL;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectClassLRepository extends JpaRepository<ObjectClassL, Integer> {

  default ObjectClassL getById(Integer id) {
    return findById(id)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    String.format("ObjectClassL with id %s was not found.", id)));
  }
}
