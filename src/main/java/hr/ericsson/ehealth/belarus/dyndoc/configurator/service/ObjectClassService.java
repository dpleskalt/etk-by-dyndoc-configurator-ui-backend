package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClass;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectClassL;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.entity.ObjectStatus;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.mapper.ClassMapper;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DesignationModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassLRepository;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassRepository;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.specification.ObjectClassSpec;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class ObjectClassService {

  private final ObjectClassRepository objectClassRepository;
  private final ObjectClassLRepository objectClassLRepository;
  private final ClassMapper classMapper;

  public ClassModel getById(Integer id) {
    return classMapper.toClassModel(objectClassRepository.getById(id));
  }

  @Transactional
  public ClassModel createObjectClass(ClassModel classModel) {
    ObjectClass objectClass = classMapper.toEntity(classModel);
    return classMapper.toClassModel(objectClassRepository.save(objectClass));
  }

  @Transactional
  public ClassModel updateObjectClass(Integer objectClassId, ClassModel classModel) {
    ObjectClass objectClass = objectClassRepository.getOne(objectClassId);

    List<DesignationModel> designations = classModel.getDesignation();
    List<ObjectClassL> updatedObjectClassLs = new ArrayList<>();
    for (var designation : designations) {
      ObjectClassL objectClassL = objectClassLRepository.getOne(designation.getId());
      ObjectClassL updateObjectClassLFromDesignationModel =
          classMapper.updateObjectClassLFromDesignationModel(designation, objectClassL);
      updatedObjectClassLs.add(updateObjectClassLFromDesignationModel);
    }

    objectClass.setObjectClassL(updatedObjectClassLs);
    ObjectClass updatedObjectClass =
        classMapper.updateObjectClassFromClassModel(classModel, objectClass);

    ObjectClass savedObjectClass = objectClassRepository.saveAndFlush(updatedObjectClass);
    return classMapper.toClassModel(savedObjectClass);
  }

  @Transactional
  public void remove(Integer objectClassId) {

    ObjectClass objectClass = objectClassRepository.getOne(objectClassId);
    objectClass.setStatus(ObjectStatus.N.getValue());

    objectClass
        .getObjectClassL()
        .forEach(objectClassL -> objectClassL.setStatus(ObjectStatus.N.getValue()));
    objectClass
        .getObjectCategory()
        .forEach(
            objectCategory -> {
              objectCategory.setStatus(ObjectStatus.N.getValue());
              objectCategory
                  .getObjectCategoryL()
                  .forEach(objectCategoryL -> objectCategoryL.setStatus(ObjectStatus.N.getValue()));
            });

    objectClassRepository.save(objectClass);
  }

  @Transactional
  public Page<ClassModel> getAll(ObjectClassSpec objectClassSpec, Pageable pageable) {
    return objectClassRepository.findAll(objectClassSpec, pageable).map(classMapper::toClassModel);
  }
}
