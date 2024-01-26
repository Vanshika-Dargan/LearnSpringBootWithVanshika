DROP TABLE IF EXISTS "employees";

DROP SEQUENCE IF EXISTS employees_id_seq;
CREATE SEQUENCE employees_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 100 CACHE 1;

CREATE TABLE "employees"(
"id" bigint DEFAULT nextval('employees_id_seq') NOT NULL,
"name" text,
"dept" text,
CONSTRAINT "employees_pkey" PRIMARY KEY("id")

)