package hr.ericsson.ehealth.belarus.dyndoc.configurator.mapper;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClass;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClassL;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DesignationModel;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClassMapper {

  @Mapping(target = "designation", source = "objectClassL")
  ClassModel toClassModel(ObjectClass objectClass);

  @Mapping(target = "objectClassL", source = "designation")
  ObjectClass toEntity(ClassModel classModel);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ObjectClass updateObjectClassFromClassModel(
      ClassModel classModel, @MappingTarget ObjectClass objectClass);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ObjectClassL updateObjectClassLFromDesignationModel(
      DesignationModel designationModel, @MappingTarget ObjectClassL objectClassL);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  List<ObjectClassL> updateObjectClassLsFromClassModel(
      List<DesignationModel> designationModels, @MappingTarget List<ObjectClassL> objectClassLs);

  List<ClassModel> toClassModelList(List<ObjectClass> objectClass);

  @Mapping(target = "language", source = "languageId")
  @Mapping(target = "value", source = "objectClassName")
  @Mapping(target = "objectClassId", source = "objectClassL.objectClass.objectClassId")
  DesignationModel toDesignationModel(ObjectClassL objectClassL);

  @Mapping(target = "languageId", source = "language")
  @Mapping(target = "objectClassName", source = "value")
  @Mapping(target = "objectClass.objectClassId", source = "objectClassId")
  ObjectClassL toObjectClassL(DesignationModel designationModel);

  List<DesignationModel> toDesignationModelList(List<ObjectClassL> objectClassLS);

  List<ObjectClassL> toObjectClassLList(List<DesignationModel> designationModels);
}
