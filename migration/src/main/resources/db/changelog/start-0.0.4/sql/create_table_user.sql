CREATE SEQUENCE "user_seq";
CREATE TABLE "user"
(
    "id"       BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
    "login"    VARCHAR,
    "password" VARCHAR,
    "role"     VARCHAR
);