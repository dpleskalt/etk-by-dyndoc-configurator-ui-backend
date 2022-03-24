package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CLASS")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@DynamicInsert
public class ObjectClass extends BaseEntity {
  @Id
  @Column(name = "OBJECT_CLASS_ID", nullable = false)
  @GeneratedValue(generator = "object_class_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(
      name = "object_class_seq",
      sequenceName = "object_class_seq",
      allocationSize = 1)
  private Integer objectClassId;

  @Column(name = "OBJECT_CLASS_CODE", nullable = false, length = 100)
  private String objectClassCode;

  @Column(name = "OBJECT_CLASS_NAME", nullable = false, length = 500)
  private String objectClassName;

  @Column(name = "ORDER_SEQ")
  private Integer orderSeq;

  @Column(name = "VALID_FROM", nullable = false)
  private LocalDate validFrom;

  @Column(name = "VALID_TO")
  private Date validTo;

  @OneToMany(cascade = CascadeType.MERGE)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "OBJECT_CLASS_ID")
  @ToString.Exclude
  private List<ObjectCategory> objectCategory;

  @Column(name = "INPUT_FORM", nullable = false, length = 1)
  private String inputForm;

  @OneToMany(mappedBy = "objectClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @Fetch(value = FetchMode.SUBSELECT)
  @ToString.Exclude
  private List<ObjectClassL> objectClassL;

  public void setObjectClassL(List<ObjectClassL> objectClassLs) {
    this.objectClassL = objectClassLs;
    for (var classL : this.objectClassL) {
      classL.setObjectClass(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ObjectClass that = (ObjectClass) o;
    return objectClassId != null && Objects.equals(objectClassId, that.objectClassId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
