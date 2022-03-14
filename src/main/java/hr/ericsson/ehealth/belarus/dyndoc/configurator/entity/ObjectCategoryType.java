package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CATEGORY_TYPE")
public class ObjectCategoryType {
  @Id
  @Column(name = "CATEGORY_TYPE_ID", nullable = false)
  private Integer categoryTypeId;

  @Column(name = "CATEGORY_TYPE_CODE", nullable = false, length = 100)
  private String categoryTypeCode;

  @Column(name = "CATEGORY_TYPE_NAME", nullable = false, length = 500)
  private String categoryTypeName;

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
}
