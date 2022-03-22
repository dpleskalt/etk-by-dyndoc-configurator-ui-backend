package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectCategoryRepository extends JpaRepository<ObjectCategory, Integer> {}
