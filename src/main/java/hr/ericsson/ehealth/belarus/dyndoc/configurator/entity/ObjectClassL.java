package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CLASS_L")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class ObjectClassL extends BaseEntity {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(generator = "object_class_l_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(
      name = "object_class_l_seq",
      sequenceName = "object_class_l_seq",
      allocationSize = 1)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "OBJECT_CLASS_ID", nullable = false)
  private ObjectClass objectClass;

  @Column(name = "OBJECT_CLASS_NAME", nullable = false, length = 500)
  private String objectClassName;

  @Column(name = "LANGUAGE_ID", nullable = false, length = 10)
  private String languageId;

  @Column(name = "STATUS", length = 1)
  @Pattern(regexp = "^[DN]$")
  @ColumnDefault("'D'")
  private String status;
}
