CREATE SEQUENCE "role_seq";
CREATE TABLE "role"
(
    "id"    BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('role_seq'),
    "title" VARCHAR
);