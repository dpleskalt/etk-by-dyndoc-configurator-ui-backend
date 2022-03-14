package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_RESOURCES_SECTIONS")
public class ObjectResourcesSections {

  @Id
  @Column(name = "OBJECT_RES_SEC_ID", nullable = false)
  private Integer objectResSecId;

  @Column(name = "OBJECT_RESOURCE_CODE", nullable = false)
  private String objectResourceCode;

  @Column(name = "OBJECT_RESOURCE_NAME", nullable = false)
  private String objectResourceName;

  @Column(name = "OBJECT_RESOURCE_TYPE")
  private String objectResourceType;

  @Column(name = "OBJECT_SECTION_ID", nullable = false)
  private Integer objectSectionId;

  @Column(name = "NOTE")
  private String note;

  @Column(name = "ORDER_SEQ")
  private Integer orderSeq;

  @Column(name = "VALID_FROM", nullable = false)
  private Date validFrom;

  @Column(name = "VALID_TO")
  private Date validTo;

  @Column(name = "CREATION_DATE", nullable = false)
  private Date creationDate;

  @Column(name = "CREATED_BY", nullable = false)
  private String createdBy;

  @Column(name = "LAST_UPDATE_DATE")
  private Date lastUpdateDate;

  @Column(name = "LAST_UPDATED_BY")
  private String lastUpdatedBy;

  @Column(name = "STATUS", nullable = false)
  private String status;
}
