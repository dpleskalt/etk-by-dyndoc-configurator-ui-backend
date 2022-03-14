package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_GROUP")
public class ObjectGroup {
  @Id
  @Column(name = "OBJECT_GROUP_ID", nullable = false)
  private Integer objectGroupId;

  @Column(name = "OBJECT_GROUP_CODE", nullable = false, length = 100)
  private String objectGroupCode;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_CATEGORY_ID", nullable = false)
  private ObjectCategory thrObjectCategory;

  @Column(name = "ORGANIZATION_CODE", nullable = false, length = 50)
  private String organizationCode;

  @Column(name = "NOTE", length = 4000)
  private String note;

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
