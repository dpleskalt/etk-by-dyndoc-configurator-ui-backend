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
@Table(name = "THR_OBJECT_TYPE_L")
public class ObjectTypeL {
  @Id
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Column(name = "OBJECT_TYPE_ID", nullable = false)
  private Integer objectTypeId;

  @Column(name = "OBJECT_TYPE_NAME", nullable = false, length = 500)
  private String objectTypeName;

  @Column(name = "LANGUAGE_ID", nullable = false, length = 10)
  private String languageId;

  @Column(name = "NOTE", length = 4000)
  private String note;

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
