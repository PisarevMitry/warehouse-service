CREATE SEQUENCE IF NOT EXISTS product_category_seq;
CREATE TABLE IF NOT EXISTS "product_category"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_category_seq')),
    "title"     VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_category (id)
);
/*
 ToDo
 */
CREATE SEQUENCE IF NOT EXISTS product_special_condition_seq;
CREATE TABLE IF NOT EXISTS "product_special_condition"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_special_condition_seq')),
    "description" TEXT                        DEFAULT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_photo_seq;
CREATE TABLE IF NOT EXISTS "product_photo"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_photo_seq')),
    "url"       VARCHAR,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_photo (id)
);

CREATE SEQUENCE IF NOT EXISTS product_feedback_seq;
CREATE TABLE IF NOT EXISTS "product_feedback"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_feedback_seq')),
    "grade"       INTEGER            NOT NULL DEFAULT 5,
    "description" TEXT,
    "create_dttm" TIMESTAMP,
    "client_id"   BIGINT,
    "parent_id"   BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_feedback (id)

);

/*
 ToDo: Add relative_product
 */
CREATE SEQUENCE IF NOT EXISTS product_seq;
CREATE TABLE IF NOT EXISTS "product"
(
    "id"                   BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_seq')),
    "title"                VARCHAR,
    "description"          TEXT,
    "price"                INTEGER,
    "amount"               INTEGER                     DEFAULT 0,
    "photo_id"             BIGINT                      DEFAULT NULL,
    "option"               JSON                        DEFAULT NULL,
    "category_id"          BIGINT                      DEFAULT NULL,
    "feedback_id"          BIGINT                      DEFAULT NULL,
    "special_condition_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (photo_id) REFERENCES product_photo (id),
    FOREIGN KEY (category_id) REFERENCES product_category (id),
    FOREIGN KEY (feedback_id) REFERENCES product_feedback (id),
    FOREIGN KEY (special_condition_id) REFERENCES product_special_condition (id)
);