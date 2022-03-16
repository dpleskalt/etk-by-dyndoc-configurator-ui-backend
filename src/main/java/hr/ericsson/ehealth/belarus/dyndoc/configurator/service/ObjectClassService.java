package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.mapper.ClassMapper;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ObjectClassService {

  private final ObjectClassRepository objectClassRepository;
  private final ClassMapper classMapper;

  public ClassModel getById(Integer id) {
    return classMapper.toClassModel(objectClassRepository.getById(id));
  }
}
