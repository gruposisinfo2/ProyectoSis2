-- -------------------------------------------------------------------------
-- PostgreSQL SQL create tables
-- exported at Tue Apr 16 16:14:00 PDT 2019 with easyDesigner
-- -------------------------------------------------------------------------

-- -------------------------------------------------------------------------
-- Table: docente
-- -------------------------------------------------------------------------
CREATE TABLE "docente" (
  "cod_docente" INTEGER NOT NULL,
  "nom_docente" VARCHAR NOT NULL,
  "ape_docente" VARCHAR NULL,
  PRIMARY KEY ("cod_docente")
);

-- -------------------------------------------------------------------------
-- Table: estudiante
-- -------------------------------------------------------------------------
CREATE TABLE "estudiante" (
  "cod_sis" INTEGER NOT NULL,
  "id_estudiante" SERIAL NOT NULL,
  "nom_estudiante" VARCHAR NOT NULL,
  "ape_estudiante" VARCHAR NOT NULL,
  PRIMARY KEY ("cod_sis", "id_estudiante")
);

-- -------------------------------------------------------------------------
-- Table: grupo
-- -------------------------------------------------------------------------
CREATE TABLE "grupo" (
  "estudiante_cod_sis" INTEGER NOT NULL,
  "estudiante_id_estudiante" INTEGER NOT NULL,
  "docente_cod_docente" INTEGER NOT NULL,
  PRIMARY KEY ("estudiante_cod_sis", "estudiante_id_estudiante", "docente_cod_docente")
);

-- -------------------------------------------------------------------------
-- Relations for table: grupo
-- -------------------------------------------------------------------------
ALTER TABLE "grupo" ADD FOREIGN KEY ("estudiante_cod_sis", "estudiante_id_estudiante") 
    REFERENCES "estudiante" ("cod_sis", "id_estudiante")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "grupo" ADD FOREIGN KEY ("docente_cod_docente") 
    REFERENCES "docente" ("cod_docente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

