package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_TYPE_SECTIONS")
public class ObjectTypeSection {

  @Id
  @Column(name = "OBJECT_TYPE_SEC_ID", nullable = false)
  private Integer objectTypeSecId;

  @ManyToOne
  @JoinColumn(name = "OBJECT_TYPE_ID", nullable = false)
  private ObjectType objectTypeId;

  @ManyToOne
  @JoinColumn(name = "OBJECT_SECTION_ID", nullable = false)
  private ObjectSection objectSectionId;

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
