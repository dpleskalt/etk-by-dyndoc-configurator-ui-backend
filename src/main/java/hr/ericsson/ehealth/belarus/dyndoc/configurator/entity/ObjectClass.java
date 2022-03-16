package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CLASS")
public class ObjectClass {
  @Id
  @Column(name = "OBJECT_CLASS_ID", nullable = false)
  private Integer objectClassId;

  @Column(name = "OBJECT_CLASS_CODE", nullable = false, length = 100)
  private String objectClassCode;

  @Column(name = "OBJECT_CLASS_NAME", nullable = false, length = 500)
  private String objectClassName;

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
  @Pattern(regexp = "^[DN]$")
  @ColumnDefault("'D'")
  private String status;

  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "OBJECT_CLASS_ID")
  private List<ObjectCategory> objectCategory;

  @Column(name = "INPUT_FORM", nullable = false, length = 1)
  private String inputForm;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  @JoinColumn(name = "OBJECT_CLASS_ID")
  private List<ObjectClassL> objectClassL;
}
