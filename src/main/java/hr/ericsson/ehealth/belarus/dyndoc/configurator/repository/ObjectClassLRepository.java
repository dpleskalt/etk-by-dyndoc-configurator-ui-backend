package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClassL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectClassLRepository extends JpaRepository<ObjectClassL, Integer> {}
