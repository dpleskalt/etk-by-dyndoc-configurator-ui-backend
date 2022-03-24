package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

  @Column(name = "NOTE", length = 4000)
  private String note;

  @Column(name = "CREATION_DATE", nullable = false, updatable = false)
  @CreatedDate
  private LocalDate creationDate;

  @Column(name = "CREATED_BY", nullable = false, length = 100)
  @CreatedBy
  private String createdBy;

  @Column(name = "LAST_UPDATE_DATE")
  @LastModifiedDate
  private LocalDate updateDate;

  @Column(name = "LAST_UPDATED_BY", length = 100)
  @LastModifiedBy
  private String updatedBy;

  @Column(name = "STATUS", nullable = false, length = 1)
  @Pattern(regexp = "^[DN]$")
  @ColumnDefault("'D'")
  private String status;
}
