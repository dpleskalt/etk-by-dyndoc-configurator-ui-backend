package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import java.math.BigDecimal;
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
@Table(name = "THR_OBJECT_DEFAULT")
public class ObjectDefault {
  @Id
  @Column(name = "OBJECT_DEF_ID", nullable = false)
  private Integer objectDefaultId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_CATEGORY_ID", nullable = false)
  private ObjectCategory thrObjectCategory;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OBJECT_TYPE_ID", nullable = false)
  private ObjectType thrObjectType;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ITEM_TYPE_ID", nullable = false)
  private ObjectItemsType thrObjectItemsType;

  @Column(name = "LABEL", length = 50)
  private String label;

  @Column(name = "ORDER_SEQ")
  private Integer orderSeq;

  @Column(name = "MANDATORY", length = 1)
  @ColumnDefault("'N'")
  private String mandatory;

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

  @Column(name = "COLUMN_NUM")
  private Integer columnNum;

  @Column(name = "ROW_NUM")
  private Integer rowNum;

  @Column(name = "HEIGHT")
  private Integer height;

  @Column(name = "WIDTH")
  private Integer width;

  @Column(name = "ITEM_SIZE", nullable = false)
  private Integer itemSize;

  @Column(name = "LOV_URL", length = 4000)
  private String lovUrl;

  @Column(name = "decimal_places")
  private Integer decimalPlaces;

  @Column(name = "UNIT_CODE")
  private String unitCode;

  @Column(name = "parent_id")
  private Integer parentId;

  @Column(name = "MIN_VALUE")
  private BigDecimal minimumValue;

  @Column(name = "MAX_VALUE")
  private BigDecimal maximumValue;

  @Column(name = "DEFAULT_VALUE")
  private String defaultValue;

  @Column(name = "PARENT_QUERY_PARAM")
  private String parentQueryParam;
}
