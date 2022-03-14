package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CATEGORY")
public class ObjectCategory {

  @Id
  @Column(name = "OBJECT_CATEGORY_ID", nullable = false)
  private Integer objectCategoryId;

  @Column(name = "OBJECT_CATEGORY_CODE", nullable = false, length = 100)
  private String objectCategoryCode;

  @Column(name = "OBJECT_CATEGORY_NAME", nullable = false, length = 500)
  private String objectCategoryName;

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

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  @JoinColumn(name = "OBJECT_CATEGORY_ID")
  private List<ObjectCategoryL> thrObjectCategoryL;

  @Column(name = "COMPOSITION_CODE", length = 100)
  private String compositionCode;

  @Column(name = "IS_PARENT", nullable = false, length = 1)
  @ColumnDefault("'N'")
  private String isParent;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CATEGORY_TYPE_ID")
  private ObjectCategoryType thrObjectCategoryType;

  @Column(name = "PERMISSION_CODE", length = 100)
  private String permissionCode;
}
