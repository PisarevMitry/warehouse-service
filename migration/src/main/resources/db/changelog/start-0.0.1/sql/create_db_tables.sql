CREATE SEQUENCE IF NOT EXISTS product_category_seq;
CREATE TABLE IF NOT EXISTS "product_category"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_category_seq')),
    "title"     VARCHAR            NOT NULL,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_category (id)
);

CREATE SEQUENCE IF NOT EXISTS product_photo_seq;
CREATE TABLE IF NOT EXISTS "product_photo"
(
    "id"        BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_photo_seq')),
    "url"       VARCHAR            NOT NULL,
    "parent_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES product_photo (id)
);

CREATE SEQUENCE IF NOT EXISTS product_seq;
CREATE TABLE IF NOT EXISTS "product"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_seq')),
    "title"       VARCHAR            NOT NULL,
    "description" TEXT                        DEFAULT NULL,
    "price"       INTEGER                     DEFAULT NULL,
    "amount"      INTEGER                     DEFAULT 0,
    "photo_id"    BIGINT                      DEFAULT NULL,
    "option"      JSON                        DEFAULT NULL,
    "category_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (photo_id) REFERENCES product_photo (id),
    FOREIGN KEY (category_id) REFERENCES product_category (id)
);

CREATE SEQUENCE IF NOT EXISTS product_seq;
CREATE TABLE IF NOT EXISTS "product"
(
    "id"          BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('product_seq')),
    "title"       VARCHAR            NOT NULL,
    "description" TEXT                        DEFAULT NULL,
    "photo_id"    BIGINT                      DEFAULT NULL,
    "option"      JSON                        DEFAULT NULL,
    "category_id" BIGINT                      DEFAULT NULL,
    FOREIGN KEY (photo_id) REFERENCES product_photo (id),
    FOREIGN KEY (category_id) REFERENCES product_category (id)
);

CREATE SEQUENCE IF NOT EXISTS accounting_product_seq;
CREATE TABLE IF NOT EXISTS "accounting_product"
(
    "id"         BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('accounting_product_seq')),
    "product_id" BIGINT             NOT NULL,
    "amount"     INTEGER                     DEFAULT 0,
    "price"      INTEGER                     DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE SEQUENCE IF NOT EXISTS shipped_product_seq;
CREATE TABLE IF NOT EXISTS "shipped_product"
(
    "id"                 BIGINT PRIMARY KEY NOT NULL DEFAULT (nextval('shipped_product_seq')),
    "product_id"         BIGINT             NOT NULL,
    "amount_difference"  INTEGER                     DEFAULT 0,
    "receiver"           VARCHAR            NOT NULL,
    "sender"             VARCHAR            NOT NULL,
    "carrier"            VARCHAR                     DEFAULT NULL,
    "number_of_contract" VARCHAR                     DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
);
