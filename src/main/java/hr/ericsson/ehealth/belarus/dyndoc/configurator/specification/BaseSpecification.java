package hr.ericsson.ehealth.belarus.dyndoc.configurator.specification;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
  @Spec(path = "creationDate", spec = Equal.class),
  @Spec(
      path = "creationDate",
      params = {"createDateLt", "createDateGt"},
      spec = Between.class),
  @Spec(path = "createdBy", spec = Like.class),
  @Spec(path = "updateDate", spec = Equal.class),
  @Spec(
      path = "updateDate",
      params = {"updateDateLt", "updateDateGt"},
      spec = Between.class),
  @Spec(path = "updatedBy", spec = Like.class),
  @Spec(path = "status", spec = Equal.class),
})
public interface BaseSpecification {}
