package hr.ericsson.ehealth.belarus.dyndoc.configurator.specification;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClass;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Join(path = "objectClassL", alias = "classL")
@And({
  @Spec(path = "objectClassCode", spec = Equal.class),
  @Spec(path = "objectClassName", spec = Like.class),
  @Spec(path = "orderSeq", spec = Equal.class),
  @Spec(path = "validFrom", spec = Equal.class),
  @Spec(
      path = "validFrom",
      params = {"validFromLt", "validFromGt"},
      spec = Between.class),
  @Spec(path = "validTo", spec = Equal.class),
  @Spec(
      path = "validTo",
      params = {"validToLt", "validToGt"},
      spec = Between.class),
  @Spec(path = "inputForm", spec = Equal.class),
  @Spec(path = "classL.objectClassName", params = "value", spec = Like.class),
  @Spec(path = "classL.languageId", params = "language", spec = Like.class),
})
public interface ObjectClassSpec extends BaseSpecification, Specification<ObjectClass> {}
