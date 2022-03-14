package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_TYPE")
public class ObjectType {
  @Id
  @Column(name = "OBJECT_TYPE_ID", nullable = false)
  private Integer objectTypeId;

  @Column(name = "OBJECT_TYPE_CODE", nullable = false, length = 100)
  private String objectTypeCode;

  @Column(name = "OBJECT_TYPE_NAME", nullable = false, length = 500)
  private String objectTypeName;

  @Column(name = "NOTE", length = 4000)
  private String note;

  @Column(name = "ORDER_SEQ")
  private Integer orderSeq;

  @Column(name = "VALID_FROM", nullable = false)
  private Date validFrom;

  @Column(name = "VALID_TO")
  private Date validTo;

  @Column(name = "CREATION_DATE", nullable = false)
  private Date creationDate;

  @Column(name = "CREATED_BY", nullable = false, length = 100)
  private String createdBy;

  @Column(name = "LAST_UPDATE_DATE")
  private Date updateDate;

  @Column(name = "LAST_UPDATED_BY", length = 100)
  private String updatedBy;

  @Column(name = "STATUS", nullable = false, length = 1)
  @ColumnDefault("'D'")
  private String status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_CLASS_ID", nullable = false)
  private ObjectClass thrObjectClass;

  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "OBJECT_TYPE_ID")
  private List<ObjectTypeL> thrObjectTypeL;
}
