---------------------------------------------------------------

CREATE TABLE IF NOT EXISTS THR_OBJECT_CLASS
(
  OBJECT_CLASS_ID     INT                             NOT NULL,
  OBJECT_CLASS_CODE   VARCHAR(100)                    NOT NULL,
  OBJECT_CLASS_NAME   VARCHAR(500)                    NOT NULL,
  NOTE      VARCHAR(4000),
  ORDER_SEQ INT,
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (OBJECT_CLASS_ID)
);

----------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_CATEGORY
(
  OBJECT_CATEGORY_ID    INT                          NOT NULL,
  OBJECT_CATEGORY_CODE  VARCHAR(100)                 NOT NULL,
  OBJECT_CATEGORY_NAME  VARCHAR(500)                 NOT NULL,
  OBJECT_CLASS_ID       INT                        NOT NULL,
  NOTE      VARCHAR(4000),
  ORDER_SEQ INT,
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  IS_PARENT     VARCHAR(1) DEFAULT 'N',
  PRIMARY KEY (OBJECT_CATEGORY_ID),
  FOREIGN KEY (OBJECT_CLASS_ID) REFERENCES THR_OBJECT_CLASS (OBJECT_CLASS_ID)
);

------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_TYPE
(
  OBJECT_TYPE_ID    INT                          NOT NULL,
  OBJECT_TYPE_CODE  VARCHAR(100)                 NOT NULL,
  OBJECT_TYPE_NAME  VARCHAR(500)                 NOT NULL,
  OBJECT_CLASS_ID   INT                          NOT NULL,
  NOTE      VARCHAR(4000),
  ORDER_SEQ INT,
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (OBJECT_TYPE_ID),
  FOREIGN KEY (OBJECT_CLASS_ID) REFERENCES THR_OBJECT_CLASS (OBJECT_CLASS_ID)
);

---------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_GROUP
(
  OBJECT_GROUP_ID       INT                         NOT NULL,
  OBJECT_GROUP_CODE     VARCHAR(100)                NOT NULL,
  OBJECT_CATEGORY_ID    INT                         NOT NULL,
  ORGANIZATION_CODE     VARCHAR(50)                      NOT NULL,
  NOTE      VARCHAR(4000),
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (OBJECT_GROUP_ID),
  FOREIGN KEY (OBJECT_CATEGORY_ID) REFERENCES THR_OBJECT_CATEGORY (OBJECT_CATEGORY_ID)
);
--------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_ITEMS_TYPE
(
ITEM_TYPE_ID            VARCHAR(20)            NOT NULL,
ITEM_TYPE_CODE          VARCHAR(100)           NOT NULL,
ITEM_TYPE_NAME          VARCHAR(500)           NOT NULL,
NOTE                    VARCHAR(4000),
ORDER_SEQ               INT,
VALID_FROM              DATE                   NOT NULL,
VALID_TO                DATE,
CREATION_DATE           DATE                   NOT NULL,
CREATED_BY              VARCHAR(100)           NOT NULL,
LAST_UPDATE_DATE        DATE,
LAST_UPDATED_BY         VARCHAR(100),
STATUS                  VARCHAR(1) DEFAULT 'D' NOT NULL,
PRIMARY KEY (ITEM_TYPE_ID)

);


CREATE TABLE IF NOT EXISTS THR_OBJECT_ITEMS_TYPE_L
(ID                     INT             NOT NULL,
ITEM_TYPE_ID            VARCHAR(20)     NOT NULL,
ITEM_TYPE_NAME          VARCHAR(500)    NOT NULL,
LANGUAGE_ID             VARCHAR(10)     NOT NULL,
NOTE                    VARCHAR(4000),
CREATION_DATE           DATE            NOT NULL,
CREATED_BY              VARCHAR(100)    NOT NULL,
LAST_UPDATE_DATE        DATE,
LAST_UPDATED_BY         VARCHAR(100),
STATUS                  VARCHAR(1)      DEFAULT 'D' NOT NULL
);
--------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_DEFAULT
(
  OBJECT_DEF_ID         INT                         NOT NULL,
  OBJECT_CATEGORY_ID    INT                         NOT NULL,
  OBJECT_TYPE_ID        INT                         NOT NULL,
  LABEL                 VARCHAR(50),
  ORDER_SEQ             INT,
  MANDATORY             VARCHAR(1) DEFAULT 'N',
  NOTE                  VARCHAR(4000),
  VALID_FROM            DATE NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)                NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  COLUMN_NUM            INT                       NOT NULL,
  ROW_NUM               INT                        NOT NULL,
  HEIGHT                INT                        NOT NULL,
  WIDTH                 INT                        NOT NULL,
  ITEM_TYPE_ID          VARCHAR(20)               NOT NULL,
  ITEM_SIZE             INT                        NOT NULL,
  LOV_URL               VARCHAR(4000),
  PRIMARY KEY (OBJECT_DEF_ID),
  FOREIGN KEY (OBJECT_CATEGORY_ID) REFERENCES THR_OBJECT_CATEGORY (OBJECT_CATEGORY_ID),
  FOREIGN KEY (OBJECT_TYPE_ID) REFERENCES THR_OBJECT_TYPE (OBJECT_TYPE_ID),
  FOREIGN KEY (ITEM_TYPE_ID) REFERENCES THR_OBJECT_ITEMS_TYPE (ITEM_TYPE_ID)
);

---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_ITEMS
(
  OBJECT_ITEM_ID        INT                         NOT NULL,
  OBJECT_GROUP_ID       INT                         NOT NULL,
  OBJECT_TYPE_ID        INT                         NOT NULL,
  LABEL                 VARCHAR(50),
  ORDER_SEQ             INT,
  MANDATORY             VARCHAR(1) DEFAULT 'N',
  NOTE                  VARCHAR(4000),
  VALID_FROM            DATE NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  COLUMN_NUM            INT                        NOT NULL,
  ROW_NUM               INT                        NOT NULL,
  HEIGHT                INT                        NOT NULL,
  WIDTH                 INT                        NOT NULL,
  ITEM_TYPE_ID          VARCHAR(20)                NOT NULL,
  ITEM_SIZE             INT                       NOT NULL,
  LOV_URL               VARCHAR(4000),
  PRIMARY KEY (OBJECT_ITEM_ID),
  FOREIGN KEY (OBJECT_GROUP_ID) REFERENCES THR_OBJECT_GROUP (OBJECT_GROUP_ID),
  FOREIGN KEY (OBJECT_TYPE_ID) REFERENCES THR_OBJECT_TYPE (OBJECT_TYPE_ID),
  FOREIGN KEY (ITEM_TYPE_ID) REFERENCES THR_OBJECT_ITEMS_TYPE (ITEM_TYPE_ID)
);

-------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_GROUP_HIS
(
  OBJECT_GROUP_ID       INT                       NOT NULL,
  OBJECT_GROUP_CODE     VARCHAR(100)              NOT NULL,
  OBJECT_CATEGORY_ID    INT                       NOT NULL,
  ORGANIZATION_CODE     VARCHAR(50)                    NOT NULL,
  NOTE                  VARCHAR(4000),
  VALID_FROM            DATE                            NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                            NOT NULL,
  CREATED_BY            VARCHAR(100)              NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1) DEFAULT 'D'    NOT NULL,
  EVENT_TYPE            VARCHAR(1),
  EVENT_USER            VARCHAR(240),
  EVENT_TIME            DATE
);

------------------------------------------------
CREATE TABLE IF NOT EXISTS  THR_OBJECT_ITEMS_HIS
(
  OBJECT_ITEM_ID        INT                         NOT NULL,
  OBJECT_GROUP_ID       INT                         NOT NULL,
  OBJECT_TYPE_ID        INT                         NOT NULL,
  LABEL                 VARCHAR(50),
  ORDER_SEQ             INT,
  MANDATORY             VARCHAR(1) DEFAULT 'N',
  NOTE                  VARCHAR(4000),
  VALID_FROM            DATE NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  EVENT_TYPE            VARCHAR(1),
  EVENT_USER            VARCHAR(240),
  EVENT_TIME            DATE,
  COLUMN_NUM            INT                       NOT NULL,
  ROW_NUM               INT                        NOT NULL,
  HEIGHT                INT                       NOT NULL,
  WIDTH                 INT                      NOT NULL,
  ITEM_TYPE_ID          VARCHAR(20)               NOT NULL,
  ITEM_SIZE             INT                        NOT NULL,
  LOV_URL               VARCHAR(4000)
);

---------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_CLASS_L
( ID                    INT                  NOT NULL,
  OBJECT_CLASS_ID       INT               NOT NULL,
  OBJECT_CLASS_NAME     VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (OBJECT_CLASS_ID) REFERENCES THR_OBJECT_CLASS (OBJECT_CLASS_ID)
);

---------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_CATEGORY_L
( ID                    INT                  NOT NULL,
  OBJECT_CATEGORY_ID    INT               NOT NULL,
  OBJECT_CATEGORY_NAME  VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL,

  FOREIGN KEY (OBJECT_CATEGORY_ID) REFERENCES THR_OBJECT_CATEGORY (OBJECT_CATEGORY_ID)
);

----------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_TYPE_L
( ID                    INT                  NOT NULL,
  OBJECT_TYPE_ID        INT               NOT NULL,
  OBJECT_TYPE_NAME      VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL,
   FOREIGN KEY (OBJECT_TYPE_ID) REFERENCES THR_OBJECT_TYPE (OBJECT_TYPE_ID)
);

----------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_REFRANGE_CATEGORY
(
  REFRANGE_CAT_ID     INT                             NOT NULL,
  REFRANGE_CAT_CODE   VARCHAR(100)                    NOT NULL,
  REFRANGE_CAT_NAME   VARCHAR(500)                    NOT NULL,
  NOTE      VARCHAR(4000),
  ORDER_SEQ INT,
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (REFRANGE_CAT_ID)
);

------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_REFRANGE_CATEGORY_L
( ID                    INT                  NOT NULL,
  REFRANGE_CAT_ID       INT               NOT NULL,
  REFRANGE_CAT_NAME     VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
);

--------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_REFRANGE_CONTEXT
(
  REFRANGE_CON_ID     INT                             NOT NULL,
  REFRANGE_CON_CODE   VARCHAR(100)                    NOT NULL,
  REFRANGE_CON_NAME   VARCHAR(500)                    NOT NULL,
  NOTE      VARCHAR(4000),
  ORDER_SEQ INT,
  VALID_FROM DATE NOT NULL,
  VALID_TO DATE,
  CREATION_DATE         DATE                        NOT NULL,
  CREATED_BY            VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS  VARCHAR(1)                      DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (REFRANGE_CON_ID)
);

--------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_REFRANGE_CONTEXT_L
( ID                    INT                  NOT NULL,
  REFRANGE_CON_ID       INT               NOT NULL,
  REFRANGE_CON_NAME     VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
);

--------------------------------------------------------------
CREATE TABLE IF NOT EXISTS THR_OBJECT_REFRANGE
(
  REFRANGE_ID       INT                      NOT NULL,
  OBJECT_TYPE_ID    INT                   NOT NULL,
  REFRANGE_CAT_ID   INT                   NOT NULL,
  REFRANGE_CON_ID   INT,
  REFVAL_LOW        INT,
  REFVAL_HIGH       INT,
  REFVAL_TEXT       VARCHAR(250),
  GENDER            VARCHAR(50),
  AGE_LOW           INT,
  AGE_HIGH          INT,
  GEST_AGE_LOW      INT,
  GEST_AGE_HIGH     INT,
  NOTE              VARCHAR(4000),
  VALID_FROM        DATE                        NOT NULL,
  VALID_TO          DATE,
  CREATION_DATE     DATE                        NOT NULL,
  CREATED_BY        VARCHAR(100)          NOT NULL,
  LAST_UPDATE_DATE  DATE,
  LAST_UPDATED_BY   VARCHAR(100),
  STATUS            VARCHAR(1)            DEFAULT 'D'                   NOT NULL,
  PRIMARY KEY (REFRANGE_ID),
  FOREIGN KEY (REFRANGE_CAT_ID) REFERENCES THR_OBJECT_REFRANGE_CATEGORY (REFRANGE_CAT_ID),
  FOREIGN KEY (REFRANGE_CON_ID) REFERENCES THR_OBJECT_REFRANGE_CONTEXT (REFRANGE_CON_ID),
  FOREIGN KEY (OBJECT_TYPE_ID) REFERENCES THR_OBJECT_TYPE (OBJECT_TYPE_ID)
);

CREATE TABLE IF NOT EXISTS THR_OBJECT_ITEMS_LABEL_L
( ID                    INT                  NOT NULL,
  OBJECT_ITEM_ID        INT                  NOT NULL,
  OBJECT_ITEM_LABEL     VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)            NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL,
  FOREIGN KEY (OBJECT_ITEM_ID) REFERENCES THR_OBJECT_ITEMS (OBJECT_ITEM_ID)

);


ALTER TABLE THR_OBJECT_ITEMS ADD COLUMN IF NOT EXISTS DECIMAL_PLACES INTEGER;
ALTER TABLE THR_OBJECT_DEFAULT ADD COLUMN IF NOT EXISTS DECIMAL_PLACES INTEGER;
ALTER TABLE THR_OBJECT_ITEMS_HIS ADD COLUMN IF NOT EXISTS DECIMAL_PLACES INTEGER;

ALTER TABLE THR_OBJECT_CLASS
ADD COLUMN IF NOT EXISTS INPUT_FORM VARCHAR(1);

ALTER TABLE THR_OBJECT_ITEMS
ADD COLUMN IF NOT EXISTS UNIT_CODE VARCHAR;


ALTER TABLE THR_OBJECT_DEFAULT
ADD COLUMN IF NOT EXISTS UNIT_CODE VARCHAR;
---------------------------------------------------
CREATE SEQUENCE IF NOT EXISTS THR_OBJECT_GROUP_SEQ
  START 1
  MINVALUE 1
  NO CYCLE;

CREATE SEQUENCE IF NOT EXISTS THR_OBJECT_ITEMS_SEQ
  START 1
  MINVALUE 1
  NO CYCLE;
------------------------------------------------------
CREATE SEQUENCE IF NOT EXISTS object_class_l_seq
    START 1
    MINVALUE 1
    NO CYCLE;

ALTER TABLE thr_object_class_l ALTER COLUMN id SET DEFAULT nextval('object_class_l_seq');

CREATE SEQUENCE IF NOT EXISTS object_class_seq
    START 1
    MINVALUE 1
    NO CYCLE;

ALTER TABLE thr_object_class ALTER COLUMN object_class_id SET DEFAULT nextval('object_class_seq');

CREATE TABLE IF NOT EXISTS thr_object_events
(
object_event_id INT NOT NULL,
object_event_code VARCHAR(100)  NOT NULL,
object_event_name VARCHAR(500)  NOT NULL,
display_type VARCHAR(100)  NOT NULL,
note VARCHAR(4000) ,
order_seq INT,
valid_from date NOT NULL,
valid_to date,
creation_date date NOT NULL,
created_by VARCHAR(100)  NOT NULL,
last_update_date date,
last_updated_by VARCHAR(100) ,
status VARCHAR(1)  NOT NULL DEFAULT 'D',
PRIMARY KEY (object_event_id)
);
COMMENT ON COLUMN thr_object_events.display_type
IS 'Moguće vrijednosti: text, icon, button';

CREATE TABLE IF NOT EXISTS thr_object_events_class
( object_event_class_id INT NOT NULL,
object_event_id INT NOT NULL,
object_class_id INT NOT NULL,
note VARCHAR(4000) ,
order_seq INT,
valid_from date NOT NULL,
valid_to date,
creation_date date NOT NULL,
created_by VARCHAR(100)  NOT NULL,
last_update_date date,
last_updated_by VARCHAR(100) ,
status VARCHAR(1)  NOT NULL DEFAULT 'D',
PRIMARY KEY (object_event_class_id)
);

CREATE TABLE IF NOT EXISTS thr_object_events_type
( object_event_type_id INT NOT NULL,
object_event_id INT NOT NULL,
object_type_id INT NOT NULL,
note VARCHAR(4000) ,
order_seq INT,
valid_from date NOT NULL,
valid_to date,
creation_date date NOT NULL,
created_by VARCHAR(100)  NOT NULL,
last_update_date date,
last_updated_by VARCHAR(100) ,
status VARCHAR(1)  NOT NULL DEFAULT 'D',
PRIMARY KEY (object_event_type_id)
);

CREATE TABLE IF NOT EXISTS THR_OBJECT_SECTIONS
(
  OBJECT_SECTION_ID    INT               NOT NULL,
  OBJECT_SECTION_CODE  VARCHAR(100)      NOT NULL,
  OBJECT_SECTION_NAME  VARCHAR(500)      NOT NULL,
  NOTE                  VARCHAR(4000),
  ORDER_SEQ             INT,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
);

ALTER TABLE THR_OBJECT_SECTIONS ADD
  CONSTRAINT THR_OBJECT_SECTIONS_PK
  PRIMARY KEY (OBJECT_SECTION_ID);


CREATE TABLE THR_OBJECT_SECTIONS_L
(
  ID                    INT                 NOT NULL,
  OBJECT_SECTION_ID    INT               NOT NULL,
  OBJECT_SECTION_NAME  VARCHAR(500)      NOT NULL,
  LANGUAGE_ID           VARCHAR(10)       NOT NULL,
  NOTE                  VARCHAR(4000),
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
);

--------------------------------------------------------------

CREATE TABLE THR_OBJECT_CATEGORY_SECTIONS
( OBJECT_CAT_SEC_ID     INT               NOT NULL,
  OBJECT_CATEGORY_ID    INT               NOT NULL,
  OBJECT_SECTION_ID    INT               NOT NULL,
  NOTE                  VARCHAR(4000),
  ORDER_SEQ             INT,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL,
   MANDATORY VARCHAR(1) DEFAULT 'N'
  );

ALTER TABLE THR_OBJECT_CATEGORY_SECTIONS ADD
  CONSTRAINT THR_OBJECT_CAT_SEC_PK
  PRIMARY KEY (OBJECT_CAT_SEC_ID);

ALTER TABLE THR_OBJECT_CATEGORY_SECTIONS ADD
  CONSTRAINT THR_OBJCATS_SEC_FK
  FOREIGN KEY (OBJECT_SECTION_ID)
  REFERENCES THR_OBJECT_SECTIONS (OBJECT_SECTION_ID);

ALTER TABLE THR_OBJECT_CATEGORY_SECTIONS ADD
  CONSTRAINT THR_OBJCATS_CAT_FK
  FOREIGN KEY (OBJECT_CATEGORY_ID)
  REFERENCES THR_OBJECT_CATEGORY (OBJECT_CATEGORY_ID);

------------------------------------------------------

CREATE TABLE THR_OBJECT_TYPE_SECTIONS
( OBJECT_TYPE_SEC_ID    INT              NOT NULL,
  OBJECT_TYPE_ID        INT              NOT NULL,
  OBJECT_SECTION_ID     INT              NOT NULL,
  NOTE                  VARCHAR(4000),
  ORDER_SEQ             INT,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
  );

ALTER TABLE THR_OBJECT_TYPE_SECTIONS ADD
  CONSTRAINT THR_OBJECT_TYPE_SECTIONS_PK
  PRIMARY KEY (OBJECT_TYPE_SEC_ID);

ALTER TABLE THR_OBJECT_TYPE_SECTIONS ADD
  CONSTRAINT THR_OBJTYPS_SEC_FK
  FOREIGN KEY (OBJECT_SECTION_ID)
  REFERENCES THR_OBJECT_SECTIONS (OBJECT_SECTION_ID);

ALTER TABLE THR_OBJECT_TYPE_SECTIONS ADD
  CONSTRAINT THR_OBJTYPS_TYP_FK
  FOREIGN KEY (OBJECT_TYPE_ID)
  REFERENCES THR_OBJECT_TYPE (OBJECT_TYPE_ID);

------------------------------------------------------------------

CREATE TABLE THR_OBJECT_RESOURCES_SECTIONS
(
  OBJECT_RES_SEC_ID     INT               NOT NULL,
  OBJECT_RESOURCE_CODE  VARCHAR(100)      NOT NULL,
  OBJECT_RESOURCE_NAME  VARCHAR(500)      NOT NULL,
  OBJECT_RESOURCE_TYPE  VARCHAR(500),
  OBJECT_SECTION_ID     INT               NOT NULL,
  NOTE                  VARCHAR(4000),
  ORDER_SEQ             INT,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  CREATION_DATE         DATE                    NOT NULL,
  CREATED_BY            VARCHAR(100)      NOT NULL,
  LAST_UPDATE_DATE      DATE,
  LAST_UPDATED_BY       VARCHAR(100),
  STATUS                VARCHAR(1)        DEFAULT 'D'                   NOT NULL
);

-------------------------------------------

---------------------------------------------------------
ALTER TABLE thr_object_items
ADD COLUMN parent_id INT;

ALTER TABLE thr_object_items_his
ADD COLUMN unit_code VARCHAR ;

ALTER TABLE thr_object_items_his
ADD COLUMN parent_id INT;

ALTER TABLE thr_object_default
ADD COLUMN parent_id INT;
----------------------------------------
ALTER TABLE thr_object_items
ADD COLUMN min_value NUMERIC;

ALTER TABLE thr_object_items
ADD COLUMN max_value NUMERIC;

ALTER TABLE thr_object_items
ADD COLUMN default_value varchar(500) ;

ALTER TABLE thr_object_items_his
ADD COLUMN min_value NUMERIC;

ALTER TABLE thr_object_items_his
ADD COLUMN max_value NUMERIC;

ALTER TABLE thr_object_items_his
ADD COLUMN default_value varchar(500) ;

ALTER TABLE thr_object_default
ADD COLUMN min_value NUMERIC;

ALTER TABLE thr_object_default
ADD COLUMN max_value NUMERIC;

ALTER TABLE thr_object_default
ADD COLUMN default_value varchar(500) ;
---------------------------------------------------
ALTER TABLE thr_object_category
ADD COLUMN composition_code varchar(100) ;
--------------------------------------------------------------

ALTER TABLE thr_object_items
ADD COLUMN parent_query_param varchar(100) ;

ALTER TABLE thr_object_items_his
ADD COLUMN parent_query_param varchar(100) ;

ALTER TABLE thr_object_default
ADD COLUMN parent_query_param varchar(100) ;

--------------------------------------------------------------
CREATE TABLE THR_OBJECT_CATEGORY_TYPE
(
  CATEGORY_TYPE_ID    integer               NOT NULL,
  CATEGORY_TYPE_CODE  varchar(100)      NOT NULL,
  CATEGORY_TYPE_NAME  varchar(500)    NOT NULL,
  NOTE                  varchar(4000),
  ORDER_SEQ             integer,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  creation_date date NOT NULL,
  created_by varchar(100)   NOT NULL,
  last_update_date date,
  last_updated_by varchar(100)  ,
  status varchar(1) NOT NULL DEFAULT 'D'
);

ALTER TABLE THR_OBJECT_CATEGORY_TYPE
ADD CONSTRAINT THR_OBJECT_CATEGORY_TYPE_PK PRIMARY KEY (CATEGORY_TYPE_ID);

alter table THR_OBJECT_CATEGORY
add CATEGORY_TYPE_ID    integer;

alter table THR_OBJECT_CATEGORY
add PERMISSION_CODE    varchar(100)  ;

ALTER TABLE THR_OBJECT_CATEGORY
ADD CONSTRAINT TMD_OBJ_CAT_TYP_FK FOREIGN KEY (CATEGORY_TYPE_ID)
  REFERENCES THR_OBJECT_CATEGORY_TYPE (CATEGORY_TYPE_ID);

CREATE TABLE THR_OBJECT_EVENTS_CATEGORY
(
  EVENT_CATEGORY_ID    integer               NOT NULL,
  EVENT_CATEGORY_CODE  varchar(100)     NOT NULL,
  EVENT_CATEGORY_NAME  varchar(500)     NOT NULL,
  NOTE                  varchar(4000) ,
  ORDER_SEQ             integer,
  VALID_FROM            DATE                    NOT NULL,
  VALID_TO              DATE,
  creation_date date NOT NULL,
  created_by varchar(100)  NOT NULL,
  last_update_date date,
  last_updated_by varchar(100) ,
  status varchar(1)  NOT NULL DEFAULT 'D'
);

ALTER TABLE THR_OBJECT_EVENTS_CATEGORY
ADD CONSTRAINT THR_OBJECT_EVENTS_CATEGORY_PK PRIMARY KEY (EVENT_CATEGORY_ID);

---------------------------------------

alter table THR_OBJECT_EVENTS
add EVENT_CATEGORY_ID integer;

ALTER TABLE THR_OBJECT_EVENTS
ADD CONSTRAINT THR_OBJEVN_CAT_FK FOREIGN KEY (EVENT_CATEGORY_ID)
  REFERENCES THR_OBJECT_EVENTS_CATEGORY (EVENT_CATEGORY_ID);


CREATE TABLE THR_OBJECT_EVENTS_CATEGORY_L
(
    id integer NOT NULL,
    event_category_id integer NOT NULL,
    event_category_name varchar(500)  NOT NULL,
    language_id varchar(10)  NOT NULL,
    note varchar(4000) ,
    creation_date date NOT NULL,
    created_by varchar(100)  NOT NULL,
    last_update_date date,
    last_updated_by varchar(100) ,
    status varchar(1)  NOT NULL DEFAULT 'D'
);

CREATE TABLE THR_OBJECT_EVENTS_L
(
    id integer NOT NULL,
    OBJECT_EVENT_ID integer NOT NULL,
    OBJECT_EVENT_NAME varchar(500)  NOT NULL,
    language_id varchar(10)  NOT NULL,
    note varchar(4000) ,
    creation_date date NOT NULL,
    created_by varchar(100)  NOT NULL,
    last_update_date date,
    last_updated_by varchar(100) ,
    status varchar(1)  NOT NULL DEFAULT 'D'
);

CREATE TABLE THR_OBJECT_CATEGORY_TYPE_L
(
    id integer NOT NULL,
    CATEGORY_TYPE_ID integer NOT NULL,
    CATEGORY_TYPE_NAME varchar(500)  NOT NULL,
    language_id varchar(10)  NOT NULL,
    note varchar(4000) ,
    creation_date date NOT NULL,
    created_by varchar(100)  NOT NULL,
    last_update_date date,
    last_updated_by varchar(100) ,
    status varchar(1)  NOT NULL DEFAULT 'D'
);


alter table THR_OBJECT_EVENTS_TYPE
ADD OBJECT_CATEGORY_ID integer;

alter table THR_OBJECT_EVENTS_TYPE
alter column OBJECT_TYPE_ID DROP NOT NULL;

ALTER TABLE THR_OBJECT_EVENTS_TYPE
ADD CONSTRAINT TIO_OET_CAT_FK FOREIGN KEY (OBJECT_CATEGORY_ID)
REFERENCES THR_OBJECT_CATEGORY (OBJECT_CATEGORY_ID);

alter table THR_OBJECT_EVENTS_TYPE
alter column OBJECT_CATEGORY_ID SET NOT NULL;