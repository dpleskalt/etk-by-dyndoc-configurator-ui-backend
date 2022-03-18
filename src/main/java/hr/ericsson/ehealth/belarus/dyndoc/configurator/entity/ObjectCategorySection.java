package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.sql.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "THR_OBJECT_CATEGORY_SECTIONS")
public class ObjectCategorySection {

  @Id
  @Column(name = "OBJECT_CAT_SEC_ID", nullable = false)
  private Integer objectCatSecId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_CATEGORY_ID", nullable = false)
  private ObjectCategory thrObjectCategory;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_SECTION_ID", nullable = false)
  private ObjectSection thrObjectSection;

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

  @Column(name = "MANDATORY", nullable = false)
  private String mandatory;
}
