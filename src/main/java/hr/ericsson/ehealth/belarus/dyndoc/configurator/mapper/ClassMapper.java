package hr.ericsson.ehealth.belarus.dyndoc.configurator.mapper;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClass;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClassL;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DesignationModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

  @Mapping(target = "designation", source = "objectClassL")
  ClassModel toClassModel(ObjectClass objectClass);

  @Mapping(target = "objectClassL", source = "designation")
  ObjectClass toEntity(ClassModel classModel);

  List<ClassModel> toClassModelList(List<ObjectClass> objectClass);

  @Mapping(target = "language", source = "languageId")
  @Mapping(target = "value", source = "objectClassName")
  DesignationModel toDesignationModel(ObjectClassL objectItemsLabelL);

  @Mapping(target = "languageId", source = "language")
  @Mapping(target = "objectClassName", source = "value")
  ObjectClassL toObjectClassL(DesignationModel designationModel);

  List<DesignationModel> toDesignationModelList(List<ObjectClassL> objectClassLS);
}
