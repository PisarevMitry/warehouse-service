TRUNCATE TABLE shipped_product;
TRUNCATE TABLE accounting_product;
TRUNCATE TABLE product;
TRUNCATE TABLE product_photo;
TRUNCATE TABLE product_category;

DROP SEQUENCE IF EXISTS shipped_product_seq;
DROP SEQUENCE IF EXISTS accounting_product_seq;
DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS product_photo_seq;
DROP SEQUENCE IF EXISTS product_category_seq;