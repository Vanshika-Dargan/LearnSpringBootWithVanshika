

DROP TABLE IF EXISTS "country";

CREATE TABLE "country"(
"id" bigint NOT NULL,
"name" text,
"gdp" numeric(10,2),
CONSTRAINT "country_pk" PRIMARY KEY("id")
);


DROP TABLE IF EXISTS "city";

DROP TABLE IF EXISTS "city";

CREATE TABLE "city" (
  "id" bigint NOT NULL,
  "name" text,
  "country_id" bigint,
  CONSTRAINT "city_pk" PRIMARY KEY("id"),
  CONSTRAINT "country_fk" FOREIGN KEY ("country_id") REFERENCES "country" ("id")
);


