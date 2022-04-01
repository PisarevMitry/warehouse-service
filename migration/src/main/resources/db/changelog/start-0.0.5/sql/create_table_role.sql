CREATE SEQUENCE IF NOT EXISTS "role_seq";
CREATE TABLE IF NOT EXISTS "role"
(
    "id"    BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('role_seq'),
    "title" VARCHAR
);