/*
Navicat PGSQL Data Transfer

Source Server         : GestionAcademicaUCE
Source Server Version : 90507
Source Host           : localhost:5432
Source Database       : GestionAcademicaUCE
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90507
File Encoding         : 65001

Date: 2017-12-23 15:27:25
*/


-- ----------------------------
-- Sequence structure for areas_academ_id_seq
-- ----------------------------
DROP SEQUENCE "public"."areas_academ_id_seq";
CREATE SEQUENCE "public"."areas_academ_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 3
 CACHE 1;
SELECT setval('"public"."areas_academ_id_seq"', 3, true);

-- ----------------------------
-- Sequence structure for asignatura_docente_id_seq
-- ----------------------------
DROP SEQUENCE "public"."asignatura_docente_id_seq";
CREATE SEQUENCE "public"."asignatura_docente_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval('"public"."asignatura_docente_id_seq"', 2, true);

-- ----------------------------
-- Sequence structure for asignaturas_id_seq
-- ----------------------------
DROP SEQUENCE "public"."asignaturas_id_seq";
CREATE SEQUENCE "public"."asignaturas_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."asignaturas_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for aula_id_seq
-- ----------------------------
DROP SEQUENCE "public"."aula_id_seq";
CREATE SEQUENCE "public"."aula_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;
SELECT setval('"public"."aula_id_seq"', 4, true);

-- ----------------------------
-- Sequence structure for bibliografia_id_seq
-- ----------------------------
DROP SEQUENCE "public"."bibliografia_id_seq";
CREATE SEQUENCE "public"."bibliografia_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9
 CACHE 1;
SELECT setval('"public"."bibliografia_id_seq"', 9, true);

-- ----------------------------
-- Sequence structure for carga_horaria_id_seq
-- ----------------------------
DROP SEQUENCE "public"."carga_horaria_id_seq";
CREATE SEQUENCE "public"."carga_horaria_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for carreras_id_seq
-- ----------------------------
DROP SEQUENCE "public"."carreras_id_seq";
CREATE SEQUENCE "public"."carreras_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."carreras_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for co_requisitos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."co_requisitos_id_seq";
CREATE SEQUENCE "public"."co_requisitos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for configuraciones_ch_id_seq
-- ----------------------------
DROP SEQUENCE "public"."configuraciones_ch_id_seq";
CREATE SEQUENCE "public"."configuraciones_ch_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for contenidos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."contenidos_id_seq";
CREATE SEQUENCE "public"."contenidos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 13
 CACHE 1;
SELECT setval('"public"."contenidos_id_seq"', 13, true);

-- ----------------------------
-- Sequence structure for coordinador_area_id_seq
-- ----------------------------
DROP SEQUENCE "public"."coordinador_area_id_seq";
CREATE SEQUENCE "public"."coordinador_area_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for coordinador_asignatura_id_seq
-- ----------------------------
DROP SEQUENCE "public"."coordinador_asignatura_id_seq";
CREATE SEQUENCE "public"."coordinador_asignatura_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."coordinador_asignatura_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for cursos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."cursos_id_seq";
CREATE SEQUENCE "public"."cursos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 10
 CACHE 1;
SELECT setval('"public"."cursos_id_seq"', 10, true);

-- ----------------------------
-- Sequence structure for detalle_ch_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_ch_id_seq";
CREATE SEQUENCE "public"."detalle_ch_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_informe_area_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_informe_area_id_seq";
CREATE SEQUENCE "public"."detalle_informe_area_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_informe_asignatura_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_informe_asignatura_id_seq";
CREATE SEQUENCE "public"."detalle_informe_asignatura_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_materia_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_materia_id_seq";
CREATE SEQUENCE "public"."detalle_materia_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_proy_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_proy_id_seq";
CREATE SEQUENCE "public"."detalle_proy_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_reporte_docente_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_reporte_docente_id_seq";
CREATE SEQUENCE "public"."detalle_reporte_docente_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for detalle_reunion_id_seq
-- ----------------------------
DROP SEQUENCE "public"."detalle_reunion_id_seq";
CREATE SEQUENCE "public"."detalle_reunion_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for facultades_id_seq
-- ----------------------------
DROP SEQUENCE "public"."facultades_id_seq";
CREATE SEQUENCE "public"."facultades_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."facultades_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for formulario_id_seq
-- ----------------------------
DROP SEQUENCE "public"."formulario_id_seq";
CREATE SEQUENCE "public"."formulario_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for informes_area_id_seq
-- ----------------------------
DROP SEQUENCE "public"."informes_area_id_seq";
CREATE SEQUENCE "public"."informes_area_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for informes_asignatura_id_seq
-- ----------------------------
DROP SEQUENCE "public"."informes_asignatura_id_seq";
CREATE SEQUENCE "public"."informes_asignatura_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for menu_id_seq
-- ----------------------------
DROP SEQUENCE "public"."menu_id_seq";
CREATE SEQUENCE "public"."menu_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for modulos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."modulos_id_seq";
CREATE SEQUENCE "public"."modulos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for notificaciones_id_seq
-- ----------------------------
DROP SEQUENCE "public"."notificaciones_id_seq";
CREATE SEQUENCE "public"."notificaciones_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for parametrizacion_id_seq
-- ----------------------------
DROP SEQUENCE "public"."parametrizacion_id_seq";
CREATE SEQUENCE "public"."parametrizacion_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for perf_mod_id_seq
-- ----------------------------
DROP SEQUENCE "public"."perf_mod_id_seq";
CREATE SEQUENCE "public"."perf_mod_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for perfiles_id_seq
-- ----------------------------
DROP SEQUENCE "public"."perfiles_id_seq";
CREATE SEQUENCE "public"."perfiles_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for pre_requisitos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."pre_requisitos_id_seq";
CREATE SEQUENCE "public"."pre_requisitos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for proyectos_id_seq
-- ----------------------------
DROP SEQUENCE "public"."proyectos_id_seq";
CREATE SEQUENCE "public"."proyectos_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for reporte_docente_id_seq
-- ----------------------------
DROP SEQUENCE "public"."reporte_docente_id_seq";
CREATE SEQUENCE "public"."reporte_docente_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for reuniones_id_seq
-- ----------------------------
DROP SEQUENCE "public"."reuniones_id_seq";
CREATE SEQUENCE "public"."reuniones_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for rol_usuario_id_seq
-- ----------------------------
DROP SEQUENCE "public"."rol_usuario_id_seq";
CREATE SEQUENCE "public"."rol_usuario_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for roles_id_seq
-- ----------------------------
DROP SEQUENCE "public"."roles_id_seq";
CREATE SEQUENCE "public"."roles_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seguimiento_silabo_id_seq
-- ----------------------------
DROP SEQUENCE "public"."seguimiento_silabo_id_seq";
CREATE SEQUENCE "public"."seguimiento_silabo_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for silabo_id_seq
-- ----------------------------
DROP SEQUENCE "public"."silabo_id_seq";
CREATE SEQUENCE "public"."silabo_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."silabo_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for tipo_ch_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tipo_ch_id_seq";
CREATE SEQUENCE "public"."tipo_ch_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for tramite_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tramite_id_seq";
CREATE SEQUENCE "public"."tramite_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for unidades_id_seq
-- ----------------------------
DROP SEQUENCE "public"."unidades_id_seq";
CREATE SEQUENCE "public"."unidades_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4
 CACHE 1;
SELECT setval('"public"."unidades_id_seq"', 4, true);

-- ----------------------------
-- Sequence structure for usuarios_perfiles_id_seq
-- ----------------------------
DROP SEQUENCE "public"."usuarios_perfiles_id_seq";
CREATE SEQUENCE "public"."usuarios_perfiles_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for area_academica
-- ----------------------------
DROP TABLE IF EXISTS "public"."area_academica";
CREATE TABLE "public"."area_academica" (
"id" int4 DEFAULT nextval('areas_academ_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."area_academica" IS 'Contiene las areas academicas de la facultad';
COMMENT ON COLUMN "public"."area_academica"."id" IS 'Identificador unicao de cada area academica';
COMMENT ON COLUMN "public"."area_academica"."nombre" IS 'Nombre del area academica';

-- ----------------------------
-- Table structure for asignatura_docente
-- ----------------------------
DROP TABLE IF EXISTS "public"."asignatura_docente";
CREATE TABLE "public"."asignatura_docente" (
"id" int4 DEFAULT nextval('asignatura_docente_id_seq'::regclass) NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_docente" varchar(10) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."asignatura_docente" IS 'Tabal que contiene la lista de docentes asigndos a cierta asignatura';
COMMENT ON COLUMN "public"."asignatura_docente"."id" IS 'Identificador unico de la tabla';
COMMENT ON COLUMN "public"."asignatura_docente"."cod_asignatura" IS 'Codigo que relaciona con la tabla asignatura';
COMMENT ON COLUMN "public"."asignatura_docente"."cod_docente" IS 'Codigo que relaciona con la tabla usuario tipo docente';

-- ----------------------------
-- Table structure for asignaturas
-- ----------------------------
DROP TABLE IF EXISTS "public"."asignaturas";
CREATE TABLE "public"."asignaturas" (
"id" int4 DEFAULT nextval('asignaturas_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default",
"codigo" varchar(10) COLLATE "default",
"creditos" int4,
"unidad_curricular" varchar(50) COLLATE "default",
"tipo_asignatura" varchar(50) COLLATE "default",
"descripcion" text COLLATE "default",
"objetivo_general" text COLLATE "default",
"objetivos_especifivos" text COLLATE "default",
"contribucion_formacion_prof" text COLLATE "default",
"resultados_aprendizaje" text COLLATE "default",
"cod_area" int4 NOT NULL,
"cod_carrera" int4 NOT NULL,
"cod_silabo" int4,
"cod_curso" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."asignaturas" IS 'Tabla de asignaturas disponibles';
COMMENT ON COLUMN "public"."asignaturas"."id" IS 'Identificado unico de cada asignatura';
COMMENT ON COLUMN "public"."asignaturas"."nombre" IS 'Nombre de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."codigo" IS 'Codigo demidentificacion de la asignatura en la malla curricular';
COMMENT ON COLUMN "public"."asignaturas"."creditos" IS 'Numero de creditos de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."unidad_curricular" IS 'Unidad de organización curricular';
COMMENT ON COLUMN "public"."asignaturas"."tipo_asignatura" IS 'Tipo de asignatura';
COMMENT ON COLUMN "public"."asignaturas"."descripcion" IS 'Descripcion de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."objetivo_general" IS 'Objetivo general de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."objetivos_especifivos" IS 'Objetivos especifocos de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."contribucion_formacion_prof" IS 'Descripcion de la contribucion en el ambiot profesional del estudiante';
COMMENT ON COLUMN "public"."asignaturas"."resultados_aprendizaje" IS 'Describe los resultados de aprendizaje de la asignatura';
COMMENT ON COLUMN "public"."asignaturas"."cod_area" IS 'Codigo que relaciona con el area academica';
COMMENT ON COLUMN "public"."asignaturas"."cod_carrera" IS 'Codigo que relaciona con la carrera a la que pertenece la Asignatura';
COMMENT ON COLUMN "public"."asignaturas"."cod_silabo" IS 'Codigo que relaciona con el silabo';
COMMENT ON COLUMN "public"."asignaturas"."cod_curso" IS 'Codigo que relaciona con el curso al que pertenece dicha asignatura';

-- ----------------------------
-- Table structure for aula
-- ----------------------------
DROP TABLE IF EXISTS "public"."aula";
CREATE TABLE "public"."aula" (
"id" int4 DEFAULT nextval('aula_id_seq'::regclass) NOT NULL,
"nomenclatura" varchar(24) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."aula" IS 'Listado de aulas disponibles';
COMMENT ON COLUMN "public"."aula"."id" IS 'Codigo unico de cada aula';
COMMENT ON COLUMN "public"."aula"."nomenclatura" IS 'Codificacion del aula';

-- ----------------------------
-- Table structure for bibliografia
-- ----------------------------
DROP TABLE IF EXISTS "public"."bibliografia";
CREATE TABLE "public"."bibliografia" (
"id" int4 DEFAULT nextval('bibliografia_id_seq'::regclass) NOT NULL,
"descripcion" varchar(1000) COLLATE "default",
"tipo1" varchar(50) COLLATE "default",
"tipo2" varchar(50) COLLATE "default",
"disponibilidad_uce" bool,
"biblioteca_virtual" varchar(100) COLLATE "default",
"cod_unidad" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."bibliografia" IS 'Tabla que contiene la bibliografia de cada unidad.';
COMMENT ON COLUMN "public"."bibliografia"."id" IS 'Identificador unico de cada bibliografia';
COMMENT ON COLUMN "public"."bibliografia"."descripcion" IS 'Descripcion de  la bibliografia ccomo el nombre, autor o enlace';
COMMENT ON COLUMN "public"."bibliografia"."tipo1" IS 'Almacena el tipo de bilbiografia, ya sea basica o virtual';
COMMENT ON COLUMN "public"."bibliografia"."tipo2" IS 'Campo que alacane ael tipo de bibliografia, como puede ser basica o complementaria';
COMMENT ON COLUMN "public"."bibliografia"."disponibilidad_uce" IS 'Campo que determina si la bibliografia se encuentra disponible en la Biblioteca de la Universidad';
COMMENT ON COLUMN "public"."bibliografia"."biblioteca_virtual" IS 'Campo que almacena el nombre de la biblioteca virtual donde se encuatra alogado.';
COMMENT ON COLUMN "public"."bibliografia"."cod_unidad" IS 'Codigo que relaciona con la tabla de unidad a la que pertence dicha bibliografia';

-- ----------------------------
-- Table structure for carga_horaria
-- ----------------------------
DROP TABLE IF EXISTS "public"."carga_horaria";
CREATE TABLE "public"."carga_horaria" (
"id" int4 DEFAULT nextval('carga_horaria_id_seq'::regclass) NOT NULL,
"fecha" date,
"hora_inicial" date,
"hora_fin" date,
"cod_tipo_ch" int4 NOT NULL,
"cod_docente" varchar(10) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."carga_horaria" IS 'Tabla de las cargas horarias y de leccionario de los docentes';
COMMENT ON COLUMN "public"."carga_horaria"."id" IS 'Identificador unico de cada carga horaria';
COMMENT ON COLUMN "public"."carga_horaria"."fecha" IS 'Fecha de elaboracion de la carga horaria';
COMMENT ON COLUMN "public"."carga_horaria"."hora_inicial" IS 'Almacena la hora de inicio de actividad horaria';
COMMENT ON COLUMN "public"."carga_horaria"."hora_fin" IS 'Almacena la hora de finalización de actividad horaria';
COMMENT ON COLUMN "public"."carga_horaria"."cod_tipo_ch" IS 'Codigo para relacionar con la tabla de tipos de Carga Horaria que realiza el docente';
COMMENT ON COLUMN "public"."carga_horaria"."cod_docente" IS 'Codigo que relaciona con el usuario docente';

-- ----------------------------
-- Table structure for carreras
-- ----------------------------
DROP TABLE IF EXISTS "public"."carreras";
CREATE TABLE "public"."carreras" (
"id" int4 DEFAULT nextval('carreras_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default",
"cod_facultad" int4 NOT NULL,
"mision" text COLLATE "default",
"vision" text COLLATE "default",
"perfil_egreso" text COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."carreras" IS 'Tabla que contendra las carreras de todas las facultades';
COMMENT ON COLUMN "public"."carreras"."id" IS 'Identificador unico de la carrera';
COMMENT ON COLUMN "public"."carreras"."nombre" IS 'Nombre de la carrera';
COMMENT ON COLUMN "public"."carreras"."cod_facultad" IS 'Identificador de relación con la facultad';
COMMENT ON COLUMN "public"."carreras"."mision" IS 'Mision de la carrera';
COMMENT ON COLUMN "public"."carreras"."vision" IS 'Vision de la carrera';
COMMENT ON COLUMN "public"."carreras"."perfil_egreso" IS 'Pefil del egresado de la carrera';

-- ----------------------------
-- Table structure for co_requisitos
-- ----------------------------
DROP TABLE IF EXISTS "public"."co_requisitos";
CREATE TABLE "public"."co_requisitos" (
"id" int4 DEFAULT nextval('co_requisitos_id_seq'::regclass) NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_asignatura_co" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."co_requisitos" IS 'Listado de materias de corequisito para una asignatura';
COMMENT ON COLUMN "public"."co_requisitos"."id" IS 'Identificador unico de cada corequisito';
COMMENT ON COLUMN "public"."co_requisitos"."cod_asignatura" IS 'Codigo de la asignatura que tiene los correqusiitos';
COMMENT ON COLUMN "public"."co_requisitos"."cod_asignatura_co" IS 'Codigo de la asignatura correquerida';

-- ----------------------------
-- Table structure for configuraciones_ch
-- ----------------------------
DROP TABLE IF EXISTS "public"."configuraciones_ch";
CREATE TABLE "public"."configuraciones_ch" (
"id" int4 DEFAULT nextval('configuraciones_ch_id_seq'::regclass) NOT NULL,
"cod_profesor" varchar(10) COLLATE "default" NOT NULL,
"periodo_inicial" date,
"periodo_final" date,
"hat" int4,
"hco" int4,
"hga" int4,
"hic" int4,
"hi" int4,
"hpc" int4,
"hpe" int4,
"hta" int4,
"hti" int4,
"hvs" int4,
"hat1" int4,
"hco1" int4,
"hga1" int4,
"hic1" int4,
"hi1" int4,
"hpc1" int4,
"hpe1" int4,
"hta1" int4,
"hti1" int4,
"hvs1" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."configuraciones_ch" IS 'Tabla que almacena las configuraciones de cafrga horaria de cadadocente';
COMMENT ON COLUMN "public"."configuraciones_ch"."id" IS 'Identificador uico de cada configuracion';
COMMENT ON COLUMN "public"."configuraciones_ch"."cod_profesor" IS 'Codigo que relaciona conel docente';
COMMENT ON COLUMN "public"."configuraciones_ch"."periodo_inicial" IS 'Periodo inicial de las configuraciones de carga horaria del docente';
COMMENT ON COLUMN "public"."configuraciones_ch"."periodo_final" IS 'Periodo final de las configuraciones de carga horaria del docente';
COMMENT ON COLUMN "public"."configuraciones_ch"."hat" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hco" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hga" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hic" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hi" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hpc" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hpe" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hta" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hti" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hvs" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hat1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hco1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hga1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hic1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hi1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hpc1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hpe1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hta1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hti1" IS 'Configuracion ..';
COMMENT ON COLUMN "public"."configuraciones_ch"."hvs1" IS 'Configuracion ..';

-- ----------------------------
-- Table structure for contenidos
-- ----------------------------
DROP TABLE IF EXISTS "public"."contenidos";
CREATE TABLE "public"."contenidos" (
"id" int4 DEFAULT nextval('contenidos_id_seq'::regclass) NOT NULL,
"n_item" int4 NOT NULL,
"descripcion" varchar(250) COLLATE "default",
"actividades" text COLLATE "default",
"mecanismos_eval" text COLLATE "default",
"sesion" int4,
"hora_clase" date,
"cod_unidad" int4 NOT NULL,
"porcentaje" float8
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."contenidos" IS 'Tabla que contendra los contenidos de cada unidad correspondiente a la materia';
COMMENT ON COLUMN "public"."contenidos"."id" IS 'Identificador unico de cada item de contenido';
COMMENT ON COLUMN "public"."contenidos"."n_item" IS 'Número de item de cada contenido correspondiente a cada unidad';
COMMENT ON COLUMN "public"."contenidos"."descripcion" IS 'Describe el tema a tratar del contenido';
COMMENT ON COLUMN "public"."contenidos"."actividades" IS 'Describe las actividades a realizar en cada contenido';
COMMENT ON COLUMN "public"."contenidos"."mecanismos_eval" IS 'Describe los mecanismos a utilizar para la evaluacion de dicho contenido';
COMMENT ON COLUMN "public"."contenidos"."sesion" IS 'Especifica la sesion en la que se tratra dicho contenido respecto al tiempo';
COMMENT ON COLUMN "public"."contenidos"."hora_clase" IS 'Establece la hora de durabilidad de el contenido';
COMMENT ON COLUMN "public"."contenidos"."cod_unidad" IS 'Cidigo que relaciona el contenido con la unidad correspondiente de la asignatura';
COMMENT ON COLUMN "public"."contenidos"."porcentaje" IS 'Porcentaje de acuerdo al total de contenidos';

-- ----------------------------
-- Table structure for coordinador_area
-- ----------------------------
DROP TABLE IF EXISTS "public"."coordinador_area";
CREATE TABLE "public"."coordinador_area" (
"id" int4 DEFAULT nextval('coordinador_area_id_seq'::regclass) NOT NULL,
"cod_coordinador" varchar(10) COLLATE "default" NOT NULL,
"cod_area" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."coordinador_area" IS 'Tabla que contiene la lista de coordinadores correspondientes a cada area';
COMMENT ON COLUMN "public"."coordinador_area"."id" IS 'Identificador unico de la tabla';
COMMENT ON COLUMN "public"."coordinador_area"."cod_coordinador" IS 'Codigo para relacion con tabla de usurios para asignar coordinador';
COMMENT ON COLUMN "public"."coordinador_area"."cod_area" IS 'Codigo para relacion con la tabla de Areas Academicas para asignacion de coordinadores';

-- ----------------------------
-- Table structure for coordinador_asignatura
-- ----------------------------
DROP TABLE IF EXISTS "public"."coordinador_asignatura";
CREATE TABLE "public"."coordinador_asignatura" (
"id" int4 DEFAULT nextval('coordinador_asignatura_id_seq'::regclass) NOT NULL,
"cod_coordinador" varchar(10) COLLATE "default" NOT NULL,
"cod_asignatura" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."coordinador_asignatura" IS 'Tabla que contiene la lista de coordinadores de asignatura';
COMMENT ON COLUMN "public"."coordinador_asignatura"."id" IS 'Identificador unico para la tabla';
COMMENT ON COLUMN "public"."coordinador_asignatura"."cod_coordinador" IS 'Clave para relacion con la table de usurios y asignar el coordinador de asignatura';
COMMENT ON COLUMN "public"."coordinador_asignatura"."cod_asignatura" IS 'Codigo para relacion con la tabla de asignaturas';

-- ----------------------------
-- Table structure for cursos
-- ----------------------------
DROP TABLE IF EXISTS "public"."cursos";
CREATE TABLE "public"."cursos" (
"id" int4 DEFAULT nextval('cursos_id_seq'::regclass) NOT NULL,
"nombre" varchar(30) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."cursos" IS 'Tabla que gestiona los semestres de cada carrera';
COMMENT ON COLUMN "public"."cursos"."id" IS 'Identificador unico de cada semestre';
COMMENT ON COLUMN "public"."cursos"."nombre" IS 'Describe el semetre de cada materia';

-- ----------------------------
-- Table structure for detalle_ch
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_ch";
CREATE TABLE "public"."detalle_ch" (
"id" int4 DEFAULT nextval('detalle_ch_id_seq'::regclass) NOT NULL,
"cod_materia" int4,
"cod_aula" int4,
"cod_estudiante" varchar(10) COLLATE "default",
"actividad" text COLLATE "default",
"cod_proyecto" int4,
"cod_curso" int4,
"cod_carga_horaria" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_ch" IS 'Tabla que contiene el detalle de actividades de los docentes del modulo de carga horaria';
COMMENT ON COLUMN "public"."detalle_ch"."id" IS 'Identificador unico de cada detalle de carga horaria';
COMMENT ON COLUMN "public"."detalle_ch"."cod_materia" IS 'Codigo que relaciona con la tabla materia';
COMMENT ON COLUMN "public"."detalle_ch"."cod_aula" IS 'Codigo que relaciona con el codigo de Aula';
COMMENT ON COLUMN "public"."detalle_ch"."cod_estudiante" IS 'Codigo para obtener el usuario estudiante de la tabla estudiantes';
COMMENT ON COLUMN "public"."detalle_ch"."actividad" IS 'Campo que detalla las actividades realizadas para el control de carga horaria';
COMMENT ON COLUMN "public"."detalle_ch"."cod_proyecto" IS 'Codigo que relaciona con tabla de Proyectos';
COMMENT ON COLUMN "public"."detalle_ch"."cod_curso" IS 'Codigo que relaciona con tabla de cursos';
COMMENT ON COLUMN "public"."detalle_ch"."cod_carga_horaria" IS 'Codigo que relaciona con la tabla de carga horaria';

-- ----------------------------
-- Table structure for detalle_informe_area
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_informe_area";
CREATE TABLE "public"."detalle_informe_area" (
"id" int4 DEFAULT nextval('detalle_informe_area_id_seq'::regclass) NOT NULL,
"cod_asignatura" int4 NOT NULL,
"porcentaje_silabo" float4,
"n_unidades_estudiadas" int4,
"cod_semestre" int4 NOT NULL,
"cod_docente" varchar(10) COLLATE "default" NOT NULL,
"cod_informe_area" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_informe_area" IS 'Tabla que contiene el detalle de los informes de area';
COMMENT ON COLUMN "public"."detalle_informe_area"."id" IS 'Identificador unico de cada detalle del informe de area';
COMMENT ON COLUMN "public"."detalle_informe_area"."cod_asignatura" IS 'Codigo que relaciona con la asignatura correspondiente al docente del cual se detalla en el informe';
COMMENT ON COLUMN "public"."detalle_informe_area"."porcentaje_silabo" IS 'Campo que registra el porcentaje de silabo completado por el docente';
COMMENT ON COLUMN "public"."detalle_informe_area"."n_unidades_estudiadas" IS 'Campo que registra el numero de unidades que a completado un docente';
COMMENT ON COLUMN "public"."detalle_informe_area"."cod_semestre" IS 'Codigo que relaciona con el semestre al que pertenece la asignatura en el reporte';
COMMENT ON COLUMN "public"."detalle_informe_area"."cod_docente" IS 'Codigo que relaciona con la tabla de usuarios para determinar el docente de la materia';
COMMENT ON COLUMN "public"."detalle_informe_area"."cod_informe_area" IS 'Codigo que relaciona con el informe de area';

-- ----------------------------
-- Table structure for detalle_informe_asignatura
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_informe_asignatura";
CREATE TABLE "public"."detalle_informe_asignatura" (
"id" int4 DEFAULT nextval('detalle_informe_asignatura_id_seq'::regclass) NOT NULL,
"curso" varchar(30) COLLATE "default",
"total_estudiantes" int4,
"n_promovidos" int4,
"n_no_promovidos" int4,
"n_desertores" int4,
"porcentaje_aprobados" float4,
"cod_informe_asignatura" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_informe_asignatura" IS 'Tabla que registra el detalle de los informes del coordinador de asignatura';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."id" IS 'Identificador unico de cada detalle del informe';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."curso" IS 'Campo que contiene el curso que se imparte la asignatura';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."total_estudiantes" IS 'Campo que contiene el total de estudiantes de cada curso';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."n_promovidos" IS 'Numero de promovidos de cada curso';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."n_no_promovidos" IS 'Campo que contiene la cantidad de estudiantes no promovidos';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."n_desertores" IS 'Campo que registra el numero de estudiantes desertores de cada curso';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."porcentaje_aprobados" IS 'Campo que registra el porcentaje de estudiantes aprobados en cada curso';
COMMENT ON COLUMN "public"."detalle_informe_asignatura"."cod_informe_asignatura" IS 'Codigo que relaciona con el informe de asignatura al que corresponde el detalle';

-- ----------------------------
-- Table structure for detalle_proyecto
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_proyecto";
CREATE TABLE "public"."detalle_proyecto" (
"id" int4 DEFAULT nextval('detalle_proy_id_seq'::regclass) NOT NULL,
"descripcion_avance" text COLLATE "default",
"evidencia" varchar(256) COLLATE "default",
"cod_proyecto" int4 NOT NULL,
"avance_real" float4,
"avance_estimado" float4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_proyecto" IS 'Tabla que contiene el detalle de avance del proyecto';
COMMENT ON COLUMN "public"."detalle_proyecto"."id" IS 'Identificador unico de la tabla';
COMMENT ON COLUMN "public"."detalle_proyecto"."descripcion_avance" IS 'Campo que almacena el avance del proyecto';
COMMENT ON COLUMN "public"."detalle_proyecto"."evidencia" IS 'Campo que gurda la ruta del archivo de evidencia de avance del proyecto';
COMMENT ON COLUMN "public"."detalle_proyecto"."cod_proyecto" IS 'Codigo que relaciona con la tabla proyecto';
COMMENT ON COLUMN "public"."detalle_proyecto"."avance_real" IS 'Porcentaje de avance real del proyecto';
COMMENT ON COLUMN "public"."detalle_proyecto"."avance_estimado" IS 'Porcentaje de avance esperado del proyecto';

-- ----------------------------
-- Table structure for detalle_reporte_docente
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_reporte_docente";
CREATE TABLE "public"."detalle_reporte_docente" (
"id" int4 DEFAULT nextval('detalle_reporte_docente_id_seq'::regclass) NOT NULL,
"n_estudiates16_20" int4,
"n_estudiantes12_16" int4,
"n_estudiantes_menor12" int4,
"total_estudiantes" int4,
"asistencias" int4,
"cod_reporte_docente" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_reporte_docente" IS 'Tabla que contiene los detalles de cada reporte que realiza el docente de sus asignaturas';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."id" IS 'Identificado unico de cada campo del detalle del reporte de docentes';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."n_estudiates16_20" IS 'Campo que contiene el numero qde estudiantes que tiene la nota entre 16 y 20';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."n_estudiantes12_16" IS 'Campo que contiene el numero qde estudiantes que tiene la nota entre 12 y 16';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."n_estudiantes_menor12" IS 'Campo que contiene el numero de estudiantes que tiene la nota menor a 12';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."total_estudiantes" IS 'Caampo que contiene el total de estudiantes del curso';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."asistencias" IS 'Campo que registra el total de asistencia';
COMMENT ON COLUMN "public"."detalle_reporte_docente"."cod_reporte_docente" IS 'Codigo que relaciona con el reporte al que pertenece el detalle';

-- ----------------------------
-- Table structure for detalle_reunion
-- ----------------------------
DROP TABLE IF EXISTS "public"."detalle_reunion";
CREATE TABLE "public"."detalle_reunion" (
"id" int4 DEFAULT nextval('detalle_reunion_id_seq'::regclass) NOT NULL,
"cod_invitado" varchar(10) COLLATE "default" NOT NULL,
"cod_reunion" int4 NOT NULL,
"asistencia" bool
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."detalle_reunion" IS 'Tabla que contiene el detalle de personal convocado a la reunion';
COMMENT ON COLUMN "public"."detalle_reunion"."id" IS 'Identificador de detalle de reunion';
COMMENT ON COLUMN "public"."detalle_reunion"."cod_invitado" IS 'Codigo que identifica el usuario invitado a la reunion';
COMMENT ON COLUMN "public"."detalle_reunion"."cod_reunion" IS 'Codigo que identifica la reunion a la que debe de asistir';
COMMENT ON COLUMN "public"."detalle_reunion"."asistencia" IS 'Campo que valida la asistencia del invitado a la reunion';

-- ----------------------------
-- Table structure for evaluacion
-- ----------------------------
DROP TABLE IF EXISTS "public"."evaluacion";
CREATE TABLE "public"."evaluacion" (
"id" int4 DEFAULT nextval('detalle_materia_id_seq'::regclass) NOT NULL,
"eval_practica_1h" int4,
"eval_autonomo_1h" int4,
"eval_trabajos_indiv_1h" int4,
"eval_trabajos_grup_1h" int4,
"eval_trabajos_integrador_1h" int4,
"eval_practica_2h" int4,
"eval_atonomo_2h" int4,
"eval_trabajos_indiv_2h" int4,
"eval_trabajos_grup_2h" int4,
"eval_trabajos_integrador_2h" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."evaluacion" IS 'Tabla que contiene los parametros de evaluacion de la asignatura en un silabo';
COMMENT ON COLUMN "public"."evaluacion"."id" IS 'Identificador unico de la evaluación';
COMMENT ON COLUMN "public"."evaluacion"."eval_practica_1h" IS 'Puntaje de la tecnica de evaluación escrita o practica, parcial o final';
COMMENT ON COLUMN "public"."evaluacion"."eval_autonomo_1h" IS 'Puntaje de la tecnica de evaluación autonomo y/o virtual';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_indiv_1h" IS 'Puntaje de la tecnica de evaluación de trabajos individuales del primer hemisemestre';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_grup_1h" IS 'Puntaje de la tecnica de evaluación de trabajos grupales del primer hemisemestre';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_integrador_1h" IS 'Puntaje de la tecnica de evaluación de trabajos integradores del primer hemisemestre';
COMMENT ON COLUMN "public"."evaluacion"."eval_practica_2h" IS 'Puntaje de la tecnica de evaluación escrita o practica, parcial o final';
COMMENT ON COLUMN "public"."evaluacion"."eval_atonomo_2h" IS 'Puntaje de la tecnica de evaluación de trabajo autonomo y/o virtual';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_indiv_2h" IS 'Puntaje de la tecnica de evaluación de trabajos individuales';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_grup_2h" IS 'Puntaje de la tecnica de evaluación de trabajos grupales';
COMMENT ON COLUMN "public"."evaluacion"."eval_trabajos_integrador_2h" IS 'Puntaje de la tecnica de evaluación de trabajos integradores';

-- ----------------------------
-- Table structure for facultades
-- ----------------------------
DROP TABLE IF EXISTS "public"."facultades";
CREATE TABLE "public"."facultades" (
"id" int4 DEFAULT nextval('facultades_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default",
"mision" text COLLATE "default",
"vision" text COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."facultades" IS 'Tabla que contendra información especifica de cada Facultad';
COMMENT ON COLUMN "public"."facultades"."id" IS 'Identificador unico de cada facultad';
COMMENT ON COLUMN "public"."facultades"."nombre" IS 'Nombre de la facultad';
COMMENT ON COLUMN "public"."facultades"."mision" IS 'Describe la mision de la facultad';
COMMENT ON COLUMN "public"."facultades"."vision" IS 'Describe la vision de la facultad';

-- ----------------------------
-- Table structure for formulario
-- ----------------------------
DROP TABLE IF EXISTS "public"."formulario";
CREATE TABLE "public"."formulario" (
"id_formulario" int4 DEFAULT nextval('formulario_id_seq'::regclass) NOT NULL,
"cod_tramite" int4 NOT NULL,
"cod_carrera" int4 NOT NULL,
"cod_solicitante" varchar(10) COLLATE "default" NOT NULL,
"fecha_formulario" date,
"fecha_clase" date,
"razon" varchar(500) COLLATE "default" NOT NULL,
"observacion" varchar(500) COLLATE "default",
"documento" varchar(200) COLLATE "default",
"estado" bool,
"cod_asignatura" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."formulario" IS 'Almacena formularios de peticiones del personal...';
COMMENT ON COLUMN "public"."formulario"."id_formulario" IS 'Identificador unico de cada formulario';
COMMENT ON COLUMN "public"."formulario"."cod_tramite" IS 'Codigo que relaciona con tabla tramite';
COMMENT ON COLUMN "public"."formulario"."cod_carrera" IS 'Codigo que relaciona con la tabla carrera';
COMMENT ON COLUMN "public"."formulario"."cod_solicitante" IS 'Codigo que relaciona con tabla usuario que solicita el tramite';
COMMENT ON COLUMN "public"."formulario"."fecha_formulario" IS 'Fecha en que se realiza el formulario';
COMMENT ON COLUMN "public"."formulario"."fecha_clase" IS 'Fecha de la clase en la que solicita tramite';
COMMENT ON COLUMN "public"."formulario"."razon" IS 'Razón por la que realiza el tramite';
COMMENT ON COLUMN "public"."formulario"."observacion" IS 'Campo de observacion del tramite';
COMMENT ON COLUMN "public"."formulario"."documento" IS 'Campo que almacena la ruta del documento en el que se almacena el documento de respaldo de solicitud';
COMMENT ON COLUMN "public"."formulario"."estado" IS 'Campo que determina el estado de la solicitud';
COMMENT ON COLUMN "public"."formulario"."cod_asignatura" IS 'Identificador que relaciona con tabla asignatura';

-- ----------------------------
-- Table structure for informes_area
-- ----------------------------
DROP TABLE IF EXISTS "public"."informes_area";
CREATE TABLE "public"."informes_area" (
"id" int4 DEFAULT nextval('informes_area_id_seq'::regclass) NOT NULL,
"fecha" date,
"cod_area" int4 NOT NULL,
"cod_coordinador" varchar(10) COLLATE "default" NOT NULL,
"observaciones" text COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."informes_area" IS 'Tabla con informacion de los reportes de area';
COMMENT ON COLUMN "public"."informes_area"."id" IS 'Identificador unico de cada reporte';
COMMENT ON COLUMN "public"."informes_area"."fecha" IS 'Fecha del informe';
COMMENT ON COLUMN "public"."informes_area"."cod_area" IS 'Identificador que relaciona con la tabla areas academicas';
COMMENT ON COLUMN "public"."informes_area"."cod_coordinador" IS 'Codigo que relaciona con el usuario que realizó el informe';
COMMENT ON COLUMN "public"."informes_area"."observaciones" IS 'Campo que registra las observaciones del informe';

-- ----------------------------
-- Table structure for informes_asignatura
-- ----------------------------
DROP TABLE IF EXISTS "public"."informes_asignatura";
CREATE TABLE "public"."informes_asignatura" (
"id" int4 DEFAULT nextval('informes_asignatura_id_seq'::regclass) NOT NULL,
"fecha" date,
"cod_coordinador" varchar(10) COLLATE "default" NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_semestre" int4 NOT NULL,
"observaciones" text COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."informes_asignatura" IS 'Tabla que almacena los reportes de coordinadores de asignatura';
COMMENT ON COLUMN "public"."informes_asignatura"."id" IS 'Identificador unico de los informes de asignatura';
COMMENT ON COLUMN "public"."informes_asignatura"."fecha" IS 'Fecha de realización del informe de asignatura';
COMMENT ON COLUMN "public"."informes_asignatura"."cod_coordinador" IS 'Codigo que relaciona con el coordinador de asignatura que realiza el informe';
COMMENT ON COLUMN "public"."informes_asignatura"."cod_asignatura" IS 'Codigo que relaciona con la asignatura que se realiza el informe';
COMMENT ON COLUMN "public"."informes_asignatura"."cod_semestre" IS 'Codigo que relaciona con el semestre que relaciona con el semestre al que pertenece la materia';
COMMENT ON COLUMN "public"."informes_asignatura"."observaciones" IS 'Campo que registra las observaciones del informe de asignaturas';

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."menu";
CREATE TABLE "public"."menu" (
"id" int4 DEFAULT nextval('menu_id_seq'::regclass) NOT NULL,
"nombre" varchar(150) COLLATE "default",
"enlace" varchar(200) COLLATE "default",
"cod_modulo" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."menu" IS 'Tabla para definir los items del menu de opciones de cada modulo del sistema';
COMMENT ON COLUMN "public"."menu"."id" IS 'Identificador unico de cada item de menu';
COMMENT ON COLUMN "public"."menu"."nombre" IS 'Nombre del item del menu';
COMMENT ON COLUMN "public"."menu"."enlace" IS 'Enlace de la opcion de menu en el sistema';
COMMENT ON COLUMN "public"."menu"."cod_modulo" IS 'Codigo que relaciona con la tabla mdoulos';

-- ----------------------------
-- Table structure for modulos
-- ----------------------------
DROP TABLE IF EXISTS "public"."modulos";
CREATE TABLE "public"."modulos" (
"id" int4 DEFAULT nextval('modulos_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."modulos" IS 'Tabla que contiene los modulos disponibles del sistema';
COMMENT ON COLUMN "public"."modulos"."id" IS 'Identificador unico para cada modulo';
COMMENT ON COLUMN "public"."modulos"."nombre" IS 'Nombre del modulo';

-- ----------------------------
-- Table structure for notificaciones
-- ----------------------------
DROP TABLE IF EXISTS "public"."notificaciones";
CREATE TABLE "public"."notificaciones" (
"id" int8 DEFAULT nextval('notificaciones_id_seq'::regclass) NOT NULL,
"fecha" date,
"descripcion" varchar(256) COLLATE "default",
"estado" bool,
"cod_usuario_emisor" varchar(10) COLLATE "default" NOT NULL,
"cod_usuario_receptor" varchar(10) COLLATE "default" NOT NULL,
"mod_tarea" varchar(200) COLLATE "default",
"adjunto" varchar(250) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."notificaciones" IS 'Tabla que contiene las notificaciones de cada usuario';
COMMENT ON COLUMN "public"."notificaciones"."id" IS 'Identificador unico de cada notificacion';
COMMENT ON COLUMN "public"."notificaciones"."fecha" IS 'Fecha de notificacion';
COMMENT ON COLUMN "public"."notificaciones"."descripcion" IS 'Descripción de la notificación';
COMMENT ON COLUMN "public"."notificaciones"."estado" IS 'Estado de la notificacion';
COMMENT ON COLUMN "public"."notificaciones"."cod_usuario_emisor" IS 'Codigo de usuario emisor de la notificacion';
COMMENT ON COLUMN "public"."notificaciones"."cod_usuario_receptor" IS 'Codigo de usuario receptor de la notificacion';
COMMENT ON COLUMN "public"."notificaciones"."mod_tarea" IS 'Campo que determina la tarea pendiente';
COMMENT ON COLUMN "public"."notificaciones"."adjunto" IS 'Campo que registra la ruta del archivo adjunto que se envia en la notificacion';

-- ----------------------------
-- Table structure for parametrizacion
-- ----------------------------
DROP TABLE IF EXISTS "public"."parametrizacion";
CREATE TABLE "public"."parametrizacion" (
"id" int4 DEFAULT nextval('parametrizacion_id_seq'::regclass) NOT NULL,
"dias_justificacion" int4,
"dias_permiso" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."parametrizacion" IS 'Tabla de parametrizacion de permisos y justificaciones de vacacion';
COMMENT ON COLUMN "public"."parametrizacion"."id" IS 'Identificador unico de cada parametrizacion';
COMMENT ON COLUMN "public"."parametrizacion"."dias_justificacion" IS 'Numero de dias a justificar';
COMMENT ON COLUMN "public"."parametrizacion"."dias_permiso" IS 'Numero de dias de permiso';

-- ----------------------------
-- Table structure for perf_mod
-- ----------------------------
DROP TABLE IF EXISTS "public"."perf_mod";
CREATE TABLE "public"."perf_mod" (
"id" int4 DEFAULT nextval('perf_mod_id_seq'::regclass) NOT NULL,
"cod_modulo" int4 NOT NULL,
"cod_perfil" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."perf_mod" IS 'Tabla que relaaciona los perfiles con los modulos';
COMMENT ON COLUMN "public"."perf_mod"."id" IS 'Identificador unico para la tabla';
COMMENT ON COLUMN "public"."perf_mod"."cod_modulo" IS 'Csdiog que relaciona con la tabla Modulos';
COMMENT ON COLUMN "public"."perf_mod"."cod_perfil" IS 'Codigo que relaciona con la tabla Perfiles';

-- ----------------------------
-- Table structure for perfiles
-- ----------------------------
DROP TABLE IF EXISTS "public"."perfiles";
CREATE TABLE "public"."perfiles" (
"id" int4 DEFAULT nextval('perfiles_id_seq'::regclass) NOT NULL,
"nombre" varchar(50) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."perfiles" IS 'Tabla que almacena los perfiles de usuarios';
COMMENT ON COLUMN "public"."perfiles"."id" IS 'Identificador unico de cada perfil';
COMMENT ON COLUMN "public"."perfiles"."nombre" IS 'Nombre del perfil';

-- ----------------------------
-- Table structure for pre_requisitos
-- ----------------------------
DROP TABLE IF EXISTS "public"."pre_requisitos";
CREATE TABLE "public"."pre_requisitos" (
"id_pre_requisito" int4 DEFAULT nextval('pre_requisitos_id_seq'::regclass) NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_asignatura_pre" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."pre_requisitos" IS 'Tabla que contiene la lista de asignaturas pre requeridas en otra asignatura';
COMMENT ON COLUMN "public"."pre_requisitos"."id_pre_requisito" IS 'Identificador unico para cada prerequisito';
COMMENT ON COLUMN "public"."pre_requisitos"."cod_asignatura" IS 'Codigo que relaciona con tabla de asignatura';
COMMENT ON COLUMN "public"."pre_requisitos"."cod_asignatura_pre" IS 'Codigo que relaciona con la tabla de asignaturas para los prerequisitos';

-- ----------------------------
-- Table structure for proyectos
-- ----------------------------
DROP TABLE IF EXISTS "public"."proyectos";
CREATE TABLE "public"."proyectos" (
"id" int4 DEFAULT nextval('proyectos_id_seq'::regclass) NOT NULL,
"cod_tutor" varchar(10) COLLATE "default" NOT NULL,
"nombre" varchar(150) COLLATE "default" NOT NULL,
"descripcion" text COLLATE "default",
"periodo_inicial" date,
"periodo_final" date
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."proyectos" IS 'Tabla que contiene los proyectos de investigacion en los que trabaja un docente';
COMMENT ON COLUMN "public"."proyectos"."id" IS 'Identificador unico de cada proyecto';
COMMENT ON COLUMN "public"."proyectos"."cod_tutor" IS 'Codigo que relaciona con el usuario que sera el tutor del proyecto';
COMMENT ON COLUMN "public"."proyectos"."nombre" IS 'Nombre del proyecto';
COMMENT ON COLUMN "public"."proyectos"."descripcion" IS 'Descripcion del proyecto';
COMMENT ON COLUMN "public"."proyectos"."periodo_inicial" IS 'Perido inicial del proyecto';
COMMENT ON COLUMN "public"."proyectos"."periodo_final" IS 'Periodo final del proyecto';

-- ----------------------------
-- Table structure for reporte_docente
-- ----------------------------
DROP TABLE IF EXISTS "public"."reporte_docente";
CREATE TABLE "public"."reporte_docente" (
"id" int4 DEFAULT nextval('reporte_docente_id_seq'::regclass) NOT NULL,
"fecha" date,
"cod_docente" varchar(10) COLLATE "default" NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_semestre" int4 NOT NULL,
"curso" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."reporte_docente" IS 'Tabla que almacena informacion de los reportes del docente';
COMMENT ON COLUMN "public"."reporte_docente"."id" IS 'Identificador unico de cada reporte del docente';
COMMENT ON COLUMN "public"."reporte_docente"."fecha" IS 'Fecha del reporte';
COMMENT ON COLUMN "public"."reporte_docente"."cod_docente" IS 'Codigo que relaciona con el docente que realiza el reporte';
COMMENT ON COLUMN "public"."reporte_docente"."cod_asignatura" IS 'Codigo que relaciona con la asignatura sobre la que se realiza el reporte';
COMMENT ON COLUMN "public"."reporte_docente"."cod_semestre" IS 'Codigo que relaciona con el semetre al que pertenece la asignatura que se realiza el reporte';
COMMENT ON COLUMN "public"."reporte_docente"."curso" IS 'Campo que regustra el curso de la asignatura que se realiza el reporte';

-- ----------------------------
-- Table structure for reuniones
-- ----------------------------
DROP TABLE IF EXISTS "public"."reuniones";
CREATE TABLE "public"."reuniones" (
"id" int4 DEFAULT nextval('reuniones_id_seq'::regclass) NOT NULL,
"tema" varchar(100) COLLATE "default" NOT NULL,
"descripcion" text COLLATE "default",
"fecha" date,
"cod_encargado" varchar(10) COLLATE "default" NOT NULL,
"observaciones" text COLLATE "default",
"acta" varchar(200) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."reuniones" IS 'Tabla que gestiona las reuniones del personal academico';
COMMENT ON COLUMN "public"."reuniones"."id" IS 'Identificador unico para cada reunion';
COMMENT ON COLUMN "public"."reuniones"."tema" IS 'Tema a tratar en la reunion';
COMMENT ON COLUMN "public"."reuniones"."descripcion" IS 'Descripcion del tema de reunion';
COMMENT ON COLUMN "public"."reuniones"."fecha" IS 'Fecha de la reunion';
COMMENT ON COLUMN "public"."reuniones"."cod_encargado" IS 'Codigo del usuario encargado de convocar a la reunion';
COMMENT ON COLUMN "public"."reuniones"."observaciones" IS 'Observaciones obtenidas durante la reunion';
COMMENT ON COLUMN "public"."reuniones"."acta" IS 'Campo que almacena la ruta del acta digital de reunion';

-- ----------------------------
-- Table structure for rol_usuario
-- ----------------------------
DROP TABLE IF EXISTS "public"."rol_usuario";
CREATE TABLE "public"."rol_usuario" (
"id" int4 DEFAULT nextval('rol_usuario_id_seq'::regclass) NOT NULL,
"cod_rol" int4 NOT NULL,
"cod_usuario" varchar(10) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."rol_usuario" IS 'Tabla que establece la relacion entre los usuarios y roles';
COMMENT ON COLUMN "public"."rol_usuario"."id" IS 'Identificador unico para la relacion entre las tablas roles - usuarios';
COMMENT ON COLUMN "public"."rol_usuario"."cod_rol" IS 'Codigo para relacion con tabla Roles';
COMMENT ON COLUMN "public"."rol_usuario"."cod_usuario" IS 'Clave para relacion con tabla Usuarios';

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."roles";
CREATE TABLE "public"."roles" (
"id" int4 DEFAULT nextval('roles_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default" NOT NULL,
"cod_modulo" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."roles" IS 'Tabla que contiene los roles de los usuarios dentro del sistema';
COMMENT ON COLUMN "public"."roles"."id" IS 'Identificador unico para cada rol';
COMMENT ON COLUMN "public"."roles"."nombre" IS 'Describe el rol para los usurios';
COMMENT ON COLUMN "public"."roles"."cod_modulo" IS 'Codigo que relaciona con el modulo ';

-- ----------------------------
-- Table structure for seguimiento_silabo
-- ----------------------------
DROP TABLE IF EXISTS "public"."seguimiento_silabo";
CREATE TABLE "public"."seguimiento_silabo" (
"cod_estudiante" varchar(10) COLLATE "default" NOT NULL,
"cod_docente" varchar(10) COLLATE "default" NOT NULL,
"cod_asignatura" int4 NOT NULL,
"cod_silabo" int4 NOT NULL,
"cod_unidad" int4 NOT NULL,
"cod_contenido" int4 NOT NULL,
"observacion_docente" text COLLATE "default",
"estado_contenido" varchar(50) COLLATE "default",
"confirmacion_estudiante" bool,
"observaciones_estudiante" text COLLATE "default",
"id" int8 DEFAULT nextval('seguimiento_silabo_id_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."seguimiento_silabo" IS 'Tabla que realiza el seguimiento del silabo a los docentes';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_estudiante" IS 'Codigo del estudiante que verifica el contenido impartido por el docente';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_docente" IS 'Codigo del docene que se le hace seguimiento de silabo';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_asignatura" IS 'Codigo de la asignatura a la que se le ahce seguimiento';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_silabo" IS 'Codigo del silabo al que se le hace seguimiento';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_unidad" IS 'Codigo de la unidad a la que se le hace seguimiento';
COMMENT ON COLUMN "public"."seguimiento_silabo"."cod_contenido" IS 'Codigo del contenido al que se le hace seguimiento';
COMMENT ON COLUMN "public"."seguimiento_silabo"."observacion_docente" IS 'Observaciones del docente en base al tema dado';
COMMENT ON COLUMN "public"."seguimiento_silabo"."estado_contenido" IS 'Estado en el que se encuentra el contenido';
COMMENT ON COLUMN "public"."seguimiento_silabo"."confirmacion_estudiante" IS 'campo que verifica si el contenido fue impartido';
COMMENT ON COLUMN "public"."seguimiento_silabo"."observaciones_estudiante" IS 'Observaiones realziadas por el estudiante en base al contenido tratado';
COMMENT ON COLUMN "public"."seguimiento_silabo"."id" IS 'Identificador unico de cada seguimineto';

-- ----------------------------
-- Table structure for silabos
-- ----------------------------
DROP TABLE IF EXISTS "public"."silabos";
CREATE TABLE "public"."silabos" (
"id" int4 DEFAULT nextval('silabo_id_seq'::regclass) NOT NULL,
"periodo_inicial" date,
"periodo_final" date,
"nh_presencial" int4,
"nh_practicas" int4,
"nht_presencial" int4,
"nht_virtual" int4,
"perfil_docente_academ" text COLLATE "default",
"perfil_docente_prof" text COLLATE "default",
"descrip_perfil_docente" text COLLATE "default",
"vigente" bool,
"observaciones" text COLLATE "default",
"revision_ca" bool,
"revision_dc" bool,
"revision_docentes" bool[],
"aprobado" bool,
"fecha_elaboracion" date NOT NULL,
"fecha_revision" date,
"fecha_aprobacion" date,
"cod_evaluacion" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."silabos" IS 'Tabla que contiene el silabo de una asignatura';
COMMENT ON COLUMN "public"."silabos"."id" IS 'Identificador unico para cada silabo';
COMMENT ON COLUMN "public"."silabos"."periodo_inicial" IS 'Periodo inicial del silabo';
COMMENT ON COLUMN "public"."silabos"."periodo_final" IS 'Periodo final del silabo';
COMMENT ON COLUMN "public"."silabos"."nh_presencial" IS 'Numero de horas presenciales de la asignatura';
COMMENT ON COLUMN "public"."silabos"."nh_practicas" IS 'Numero de horas practicas de la asignatura';
COMMENT ON COLUMN "public"."silabos"."nht_presencial" IS 'Numero de horas tutorias presenciales';
COMMENT ON COLUMN "public"."silabos"."nht_virtual" IS 'Numero de horas tutorias virtuales';
COMMENT ON COLUMN "public"."silabos"."perfil_docente_academ" IS 'Descrbe el perfil academico del docente';
COMMENT ON COLUMN "public"."silabos"."perfil_docente_prof" IS 'Describe el perfil profesional del docente';
COMMENT ON COLUMN "public"."silabos"."descrip_perfil_docente" IS 'Describe de foma general el perfil del docente';
COMMENT ON COLUMN "public"."silabos"."vigente" IS 'Campo que determina si el silabo esta vigente';
COMMENT ON COLUMN "public"."silabos"."observaciones" IS 'Observaciones que se han hecho durante la revision y aprobacion del silabo';
COMMENT ON COLUMN "public"."silabos"."revision_ca" IS 'Verifica si fue revisado por el coordinador de area';
COMMENT ON COLUMN "public"."silabos"."revision_dc" IS 'Verifica si fue refisado por el director de carrera';
COMMENT ON COLUMN "public"."silabos"."revision_docentes" IS 'Verifica si los profesores revisaron el silabo';
COMMENT ON COLUMN "public"."silabos"."aprobado" IS 'Verifica si el silabo fue aprobado';
COMMENT ON COLUMN "public"."silabos"."fecha_elaboracion" IS 'Fecha en la que se elaboro el silabo';
COMMENT ON COLUMN "public"."silabos"."fecha_revision" IS 'Fecha en la que se reviso el silabo';
COMMENT ON COLUMN "public"."silabos"."fecha_aprobacion" IS 'Fecha en la que se aprobo el silabo';
COMMENT ON COLUMN "public"."silabos"."cod_evaluacion" IS 'Codigo que relaciona con la tabla de evaluaciones';

-- ----------------------------
-- Table structure for tipo_ch
-- ----------------------------
DROP TABLE IF EXISTS "public"."tipo_ch";
CREATE TABLE "public"."tipo_ch" (
"id" int4 DEFAULT nextval('tipo_ch_id_seq'::regclass) NOT NULL,
"nombre" varchar(100) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tipo_ch" IS 'Tabla que contiene los tipos de carga horaria que tiene un docente';
COMMENT ON COLUMN "public"."tipo_ch"."id" IS 'Identificador unico de cada tipo de carga horaria';
COMMENT ON COLUMN "public"."tipo_ch"."nombre" IS 'Nombre del tipo de carga horaria';

-- ----------------------------
-- Table structure for tramite
-- ----------------------------
DROP TABLE IF EXISTS "public"."tramite";
CREATE TABLE "public"."tramite" (
"id" int4 DEFAULT nextval('tramite_id_seq'::regclass) NOT NULL,
"nombre" varchar(20) COLLATE "default" NOT NULL,
"key_pagina" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tramite" IS 'Tabla que contiene los tramites disponibles que puede realizar un usuario';
COMMENT ON COLUMN "public"."tramite"."id" IS 'Identificador unico de cada tramite';
COMMENT ON COLUMN "public"."tramite"."nombre" IS 'Nombre del tramite';
COMMENT ON COLUMN "public"."tramite"."key_pagina" IS 'Campo de key pagina';

-- ----------------------------
-- Table structure for unidades
-- ----------------------------
DROP TABLE IF EXISTS "public"."unidades";
CREATE TABLE "public"."unidades" (
"id" int4 DEFAULT nextval('unidades_id_seq'::regclass) NOT NULL,
"nombre" varchar(256) COLLATE "default" NOT NULL,
"objetivo" text COLLATE "default",
"res_aprendizaje" text COLLATE "default",
"nh_aprendizaje_teorico" int4,
"nh_practicas_lab" int4,
"nh_tutoria_presencial" int4,
"nh_tutorias_virtual" int4,
"nh_trabajo_autonomo" int4,
"metodologia_aprendizaje" text COLLATE "default",
"recursos_didactivos" text COLLATE "default",
"cod_silabo" int4 NOT NULL,
"evid_aprendizaje" text COLLATE "default",
"numeral" int4 NOT NULL,
"porcentaje" float8
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."unidades" IS 'Tabla que contedra las unidades de cada asignatura';
COMMENT ON COLUMN "public"."unidades"."id" IS 'Identificador unico de cada unidad';
COMMENT ON COLUMN "public"."unidades"."nombre" IS 'Nombre de la unidad';
COMMENT ON COLUMN "public"."unidades"."objetivo" IS 'Objetivo de la unidad';
COMMENT ON COLUMN "public"."unidades"."res_aprendizaje" IS 'Descripcion del resultado de aprendizaje de la unidad';
COMMENT ON COLUMN "public"."unidades"."nh_aprendizaje_teorico" IS 'Numero de horas de Aprendijaze teorico';
COMMENT ON COLUMN "public"."unidades"."nh_practicas_lab" IS 'Numero de horas de practicas de laboratorio';
COMMENT ON COLUMN "public"."unidades"."nh_tutoria_presencial" IS 'Numero de horas de tutorias presencial';
COMMENT ON COLUMN "public"."unidades"."nh_tutorias_virtual" IS 'Numero de horas de aprendizaje de tutorias en Aula Virtual';
COMMENT ON COLUMN "public"."unidades"."nh_trabajo_autonomo" IS 'Numero de horas de trabajo autonomo';
COMMENT ON COLUMN "public"."unidades"."metodologia_aprendizaje" IS 'Campo que describe la metodologia de aprendizaje de la unidad';
COMMENT ON COLUMN "public"."unidades"."recursos_didactivos" IS 'Campo que describe los recursos didactivos utlizados en la unidad';
COMMENT ON COLUMN "public"."unidades"."cod_silabo" IS 'Codigo que relaciona la unidad con el silabo al que pertenece';
COMMENT ON COLUMN "public"."unidades"."evid_aprendizaje" IS 'Describe la evidencia de aprendizaje que debe realizar el estudiante en base al perfil de la materia';
COMMENT ON COLUMN "public"."unidades"."numeral" IS 'Numeral de la unidad de cada silabo';
COMMENT ON COLUMN "public"."unidades"."porcentaje" IS 'Porcentaje respecto al total de unidades';

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS "public"."usuarios";
CREATE TABLE "public"."usuarios" (
"id" varchar(10) COLLATE "default" NOT NULL,
"user_name" varchar(20) COLLATE "default" NOT NULL,
"user_pass" varchar(128) COLLATE "default" NOT NULL,
"nombre_p" varchar(30) COLLATE "default",
"apellido_p" varchar(30) COLLATE "default",
"correo_inst" varchar(100) COLLATE "default" NOT NULL,
"correo_pers" varchar(100) COLLATE "default",
"telefono" varchar(20) COLLATE "default",
"apellido_m" varchar(30) COLLATE "default",
"nombre_s" varchar(30) COLLATE "default",
"user_pic" bytea,
"user_firma" bytea,
"estado" bool
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."usuarios" IS 'Tabla que almacena los usuarios del sistema';
COMMENT ON COLUMN "public"."usuarios"."id" IS 'Identificador unico de cada usuario en este caso sera la cedula';
COMMENT ON COLUMN "public"."usuarios"."user_name" IS 'Nombre de usuario NICK dentro del sistema';
COMMENT ON COLUMN "public"."usuarios"."user_pass" IS 'Clave del usuario codificada';
COMMENT ON COLUMN "public"."usuarios"."nombre_p" IS 'Primer nombre del usuario';
COMMENT ON COLUMN "public"."usuarios"."apellido_p" IS 'Apellido parterno del usuario';
COMMENT ON COLUMN "public"."usuarios"."correo_inst" IS 'Correo institucional del usuario';
COMMENT ON COLUMN "public"."usuarios"."correo_pers" IS 'Correo personal del usuario';
COMMENT ON COLUMN "public"."usuarios"."telefono" IS 'Telefono del usuario';
COMMENT ON COLUMN "public"."usuarios"."apellido_m" IS 'Campo que contiene el apellido materno del usuario';
COMMENT ON COLUMN "public"."usuarios"."nombre_s" IS 'Campo que almacena el segundo nombre del usuario';
COMMENT ON COLUMN "public"."usuarios"."user_pic" IS 'Foto del usuario';
COMMENT ON COLUMN "public"."usuarios"."user_firma" IS 'Campo que guardara la firma de los usuarios para cuando se requiera formar un documento';
COMMENT ON COLUMN "public"."usuarios"."estado" IS 'Campo que verifica el estado del usuario que puede ser activo = true o dado de baja =false';

-- ----------------------------
-- Table structure for usuarios_perfiles
-- ----------------------------
DROP TABLE IF EXISTS "public"."usuarios_perfiles";
CREATE TABLE "public"."usuarios_perfiles" (
"id" int4 DEFAULT nextval('usuarios_perfiles_id_seq'::regclass) NOT NULL,
"cod_usuario" varchar(10) COLLATE "default" NOT NULL,
"cod_perfil" int4 NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."usuarios_perfiles" IS 'Tabla que relaciona el usuario con un perfil';
COMMENT ON COLUMN "public"."usuarios_perfiles"."id" IS 'Identificador unico de la tabla';
COMMENT ON COLUMN "public"."usuarios_perfiles"."cod_usuario" IS 'Codigo que relaciona con la tabla de usuarios';
COMMENT ON COLUMN "public"."usuarios_perfiles"."cod_perfil" IS 'Codigo que relaciona con la tabla de perfiles';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."areas_academ_id_seq" OWNED BY "area_academica"."id";
ALTER SEQUENCE "public"."asignatura_docente_id_seq" OWNED BY "asignatura_docente"."id";
ALTER SEQUENCE "public"."asignaturas_id_seq" OWNED BY "asignaturas"."id";
ALTER SEQUENCE "public"."aula_id_seq" OWNED BY "aula"."id";
ALTER SEQUENCE "public"."bibliografia_id_seq" OWNED BY "bibliografia"."id";
ALTER SEQUENCE "public"."carga_horaria_id_seq" OWNED BY "carga_horaria"."id";
ALTER SEQUENCE "public"."carreras_id_seq" OWNED BY "carreras"."id";
ALTER SEQUENCE "public"."co_requisitos_id_seq" OWNED BY "co_requisitos"."id";
ALTER SEQUENCE "public"."configuraciones_ch_id_seq" OWNED BY "configuraciones_ch"."id";
ALTER SEQUENCE "public"."contenidos_id_seq" OWNED BY "contenidos"."id";
ALTER SEQUENCE "public"."coordinador_area_id_seq" OWNED BY "coordinador_area"."id";
ALTER SEQUENCE "public"."coordinador_asignatura_id_seq" OWNED BY "coordinador_asignatura"."id";
ALTER SEQUENCE "public"."cursos_id_seq" OWNED BY "cursos"."id";
ALTER SEQUENCE "public"."detalle_ch_id_seq" OWNED BY "detalle_ch"."id";
ALTER SEQUENCE "public"."detalle_informe_area_id_seq" OWNED BY "detalle_informe_area"."id";
ALTER SEQUENCE "public"."detalle_informe_asignatura_id_seq" OWNED BY "detalle_informe_asignatura"."id";
ALTER SEQUENCE "public"."detalle_materia_id_seq" OWNED BY "evaluacion"."id";
ALTER SEQUENCE "public"."detalle_proy_id_seq" OWNED BY "detalle_proyecto"."id";
ALTER SEQUENCE "public"."detalle_reporte_docente_id_seq" OWNED BY "detalle_reporte_docente"."id";
ALTER SEQUENCE "public"."detalle_reunion_id_seq" OWNED BY "detalle_reunion"."id";
ALTER SEQUENCE "public"."facultades_id_seq" OWNED BY "facultades"."id";
ALTER SEQUENCE "public"."formulario_id_seq" OWNED BY "formulario"."id_formulario";
ALTER SEQUENCE "public"."informes_area_id_seq" OWNED BY "informes_area"."id";
ALTER SEQUENCE "public"."informes_asignatura_id_seq" OWNED BY "informes_asignatura"."id";
ALTER SEQUENCE "public"."menu_id_seq" OWNED BY "menu"."id";
ALTER SEQUENCE "public"."modulos_id_seq" OWNED BY "modulos"."id";
ALTER SEQUENCE "public"."notificaciones_id_seq" OWNED BY "notificaciones"."id";
ALTER SEQUENCE "public"."parametrizacion_id_seq" OWNED BY "parametrizacion"."id";
ALTER SEQUENCE "public"."perf_mod_id_seq" OWNED BY "perf_mod"."id";
ALTER SEQUENCE "public"."perfiles_id_seq" OWNED BY "perfiles"."id";
ALTER SEQUENCE "public"."pre_requisitos_id_seq" OWNED BY "pre_requisitos"."id_pre_requisito";
ALTER SEQUENCE "public"."proyectos_id_seq" OWNED BY "proyectos"."id";
ALTER SEQUENCE "public"."reporte_docente_id_seq" OWNED BY "reporte_docente"."id";
ALTER SEQUENCE "public"."reuniones_id_seq" OWNED BY "reuniones"."id";
ALTER SEQUENCE "public"."rol_usuario_id_seq" OWNED BY "rol_usuario"."id";
ALTER SEQUENCE "public"."roles_id_seq" OWNED BY "roles"."id";
ALTER SEQUENCE "public"."seguimiento_silabo_id_seq" OWNED BY "seguimiento_silabo"."id";
ALTER SEQUENCE "public"."silabo_id_seq" OWNED BY "silabos"."id";
ALTER SEQUENCE "public"."tipo_ch_id_seq" OWNED BY "tipo_ch"."id";
ALTER SEQUENCE "public"."tramite_id_seq" OWNED BY "tramite"."id";
ALTER SEQUENCE "public"."unidades_id_seq" OWNED BY "unidades"."id";
ALTER SEQUENCE "public"."usuarios_perfiles_id_seq" OWNED BY "usuarios_perfiles"."id";

-- ----------------------------
-- Primary Key structure for table area_academica
-- ----------------------------
ALTER TABLE "public"."area_academica" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table asignatura_docente
-- ----------------------------
ALTER TABLE "public"."asignatura_docente" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table asignaturas
-- ----------------------------
ALTER TABLE "public"."asignaturas" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table aula
-- ----------------------------
ALTER TABLE "public"."aula" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table bibliografia
-- ----------------------------
ALTER TABLE "public"."bibliografia" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table carga_horaria
-- ----------------------------
ALTER TABLE "public"."carga_horaria" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table carreras
-- ----------------------------
ALTER TABLE "public"."carreras" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table co_requisitos
-- ----------------------------
ALTER TABLE "public"."co_requisitos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table configuraciones_ch
-- ----------------------------
ALTER TABLE "public"."configuraciones_ch" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table contenidos
-- ----------------------------
ALTER TABLE "public"."contenidos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table coordinador_area
-- ----------------------------
ALTER TABLE "public"."coordinador_area" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table coordinador_asignatura
-- ----------------------------
ALTER TABLE "public"."coordinador_asignatura" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cursos
-- ----------------------------
ALTER TABLE "public"."cursos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_ch
-- ----------------------------
ALTER TABLE "public"."detalle_ch" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_informe_area
-- ----------------------------
ALTER TABLE "public"."detalle_informe_area" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_informe_asignatura
-- ----------------------------
ALTER TABLE "public"."detalle_informe_asignatura" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_proyecto
-- ----------------------------
ALTER TABLE "public"."detalle_proyecto" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_reporte_docente
-- ----------------------------
ALTER TABLE "public"."detalle_reporte_docente" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table detalle_reunion
-- ----------------------------
ALTER TABLE "public"."detalle_reunion" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table evaluacion
-- ----------------------------
ALTER TABLE "public"."evaluacion" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table facultades
-- ----------------------------
ALTER TABLE "public"."facultades" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table formulario
-- ----------------------------
ALTER TABLE "public"."formulario" ADD PRIMARY KEY ("id_formulario");

-- ----------------------------
-- Primary Key structure for table informes_area
-- ----------------------------
ALTER TABLE "public"."informes_area" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table informes_asignatura
-- ----------------------------
ALTER TABLE "public"."informes_asignatura" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table menu
-- ----------------------------
ALTER TABLE "public"."menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table modulos
-- ----------------------------
ALTER TABLE "public"."modulos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table notificaciones
-- ----------------------------
ALTER TABLE "public"."notificaciones" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table parametrizacion
-- ----------------------------
ALTER TABLE "public"."parametrizacion" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table perf_mod
-- ----------------------------
ALTER TABLE "public"."perf_mod" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table perfiles
-- ----------------------------
ALTER TABLE "public"."perfiles" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table pre_requisitos
-- ----------------------------
ALTER TABLE "public"."pre_requisitos" ADD PRIMARY KEY ("id_pre_requisito");

-- ----------------------------
-- Primary Key structure for table proyectos
-- ----------------------------
ALTER TABLE "public"."proyectos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table reporte_docente
-- ----------------------------
ALTER TABLE "public"."reporte_docente" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table reuniones
-- ----------------------------
ALTER TABLE "public"."reuniones" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table rol_usuario
-- ----------------------------
ALTER TABLE "public"."rol_usuario" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE "public"."roles" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table seguimiento_silabo
-- ----------------------------
ALTER TABLE "public"."seguimiento_silabo" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table silabos
-- ----------------------------
ALTER TABLE "public"."silabos" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tipo_ch
-- ----------------------------
ALTER TABLE "public"."tipo_ch" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tramite
-- ----------------------------
ALTER TABLE "public"."tramite" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table unidades
-- ----------------------------
ALTER TABLE "public"."unidades" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table usuarios
-- ----------------------------
ALTER TABLE "public"."usuarios" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table usuarios_perfiles
-- ----------------------------
ALTER TABLE "public"."usuarios_perfiles" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."asignatura_docente"
-- ----------------------------
ALTER TABLE "public"."asignatura_docente" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."asignatura_docente" ADD FOREIGN KEY ("cod_docente") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."asignaturas"
-- ----------------------------
ALTER TABLE "public"."asignaturas" ADD FOREIGN KEY ("cod_carrera") REFERENCES "public"."carreras" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."asignaturas" ADD FOREIGN KEY ("cod_area") REFERENCES "public"."area_academica" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."asignaturas" ADD FOREIGN KEY ("cod_silabo") REFERENCES "public"."silabos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."asignaturas" ADD FOREIGN KEY ("cod_curso") REFERENCES "public"."cursos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."bibliografia"
-- ----------------------------
ALTER TABLE "public"."bibliografia" ADD FOREIGN KEY ("cod_unidad") REFERENCES "public"."unidades" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."carga_horaria"
-- ----------------------------
ALTER TABLE "public"."carga_horaria" ADD FOREIGN KEY ("cod_docente") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."carga_horaria" ADD FOREIGN KEY ("cod_tipo_ch") REFERENCES "public"."tipo_ch" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."carreras"
-- ----------------------------
ALTER TABLE "public"."carreras" ADD FOREIGN KEY ("cod_facultad") REFERENCES "public"."facultades" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."co_requisitos"
-- ----------------------------
ALTER TABLE "public"."co_requisitos" ADD FOREIGN KEY ("cod_asignatura_co") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."co_requisitos" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."configuraciones_ch"
-- ----------------------------
ALTER TABLE "public"."configuraciones_ch" ADD FOREIGN KEY ("cod_profesor") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."contenidos"
-- ----------------------------
ALTER TABLE "public"."contenidos" ADD FOREIGN KEY ("cod_unidad") REFERENCES "public"."unidades" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."coordinador_area"
-- ----------------------------
ALTER TABLE "public"."coordinador_area" ADD FOREIGN KEY ("cod_coordinador") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."coordinador_area" ADD FOREIGN KEY ("cod_area") REFERENCES "public"."area_academica" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."coordinador_asignatura"
-- ----------------------------
ALTER TABLE "public"."coordinador_asignatura" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."coordinador_asignatura" ADD FOREIGN KEY ("cod_coordinador") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_ch"
-- ----------------------------
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_carga_horaria") REFERENCES "public"."carga_horaria" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_aula") REFERENCES "public"."aula" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_estudiante") REFERENCES "public"."usuarios" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_proyecto") REFERENCES "public"."proyectos" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_curso") REFERENCES "public"."cursos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_ch" ADD FOREIGN KEY ("cod_materia") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_informe_area"
-- ----------------------------
ALTER TABLE "public"."detalle_informe_area" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_informe_area" ADD FOREIGN KEY ("cod_docente") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_informe_area" ADD FOREIGN KEY ("cod_semestre") REFERENCES "public"."cursos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_informe_area" ADD FOREIGN KEY ("cod_informe_area") REFERENCES "public"."informes_area" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_informe_asignatura"
-- ----------------------------
ALTER TABLE "public"."detalle_informe_asignatura" ADD FOREIGN KEY ("cod_informe_asignatura") REFERENCES "public"."informes_asignatura" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_proyecto"
-- ----------------------------
ALTER TABLE "public"."detalle_proyecto" ADD FOREIGN KEY ("cod_proyecto") REFERENCES "public"."proyectos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_reporte_docente"
-- ----------------------------
ALTER TABLE "public"."detalle_reporte_docente" ADD FOREIGN KEY ("cod_reporte_docente") REFERENCES "public"."reporte_docente" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."detalle_reunion"
-- ----------------------------
ALTER TABLE "public"."detalle_reunion" ADD FOREIGN KEY ("cod_invitado") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."detalle_reunion" ADD FOREIGN KEY ("cod_reunion") REFERENCES "public"."reuniones" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."formulario"
-- ----------------------------
ALTER TABLE "public"."formulario" ADD FOREIGN KEY ("cod_tramite") REFERENCES "public"."tramite" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."formulario" ADD FOREIGN KEY ("cod_carrera") REFERENCES "public"."carreras" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."formulario" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."formulario" ADD FOREIGN KEY ("cod_solicitante") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."informes_area"
-- ----------------------------
ALTER TABLE "public"."informes_area" ADD FOREIGN KEY ("cod_area") REFERENCES "public"."area_academica" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."informes_area" ADD FOREIGN KEY ("cod_coordinador") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."informes_asignatura"
-- ----------------------------
ALTER TABLE "public"."informes_asignatura" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."informes_asignatura" ADD FOREIGN KEY ("cod_coordinador") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."informes_asignatura" ADD FOREIGN KEY ("cod_semestre") REFERENCES "public"."cursos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."menu"
-- ----------------------------
ALTER TABLE "public"."menu" ADD FOREIGN KEY ("cod_modulo") REFERENCES "public"."modulos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."notificaciones"
-- ----------------------------
ALTER TABLE "public"."notificaciones" ADD FOREIGN KEY ("cod_usuario_receptor") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."notificaciones" ADD FOREIGN KEY ("cod_usuario_emisor") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."perf_mod"
-- ----------------------------
ALTER TABLE "public"."perf_mod" ADD FOREIGN KEY ("cod_perfil") REFERENCES "public"."perfiles" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."perf_mod" ADD FOREIGN KEY ("cod_modulo") REFERENCES "public"."modulos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."pre_requisitos"
-- ----------------------------
ALTER TABLE "public"."pre_requisitos" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."pre_requisitos" ADD FOREIGN KEY ("cod_asignatura_pre") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."proyectos"
-- ----------------------------
ALTER TABLE "public"."proyectos" ADD FOREIGN KEY ("cod_tutor") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."reporte_docente"
-- ----------------------------
ALTER TABLE "public"."reporte_docente" ADD FOREIGN KEY ("cod_semestre") REFERENCES "public"."cursos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."reporte_docente" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."reporte_docente" ADD FOREIGN KEY ("cod_docente") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."reuniones"
-- ----------------------------
ALTER TABLE "public"."reuniones" ADD FOREIGN KEY ("cod_encargado") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."rol_usuario"
-- ----------------------------
ALTER TABLE "public"."rol_usuario" ADD FOREIGN KEY ("cod_usuario") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."rol_usuario" ADD FOREIGN KEY ("cod_rol") REFERENCES "public"."roles" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."roles"
-- ----------------------------
ALTER TABLE "public"."roles" ADD FOREIGN KEY ("cod_modulo") REFERENCES "public"."modulos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."seguimiento_silabo"
-- ----------------------------
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_estudiante") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_asignatura") REFERENCES "public"."asignaturas" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_silabo") REFERENCES "public"."silabos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_unidad") REFERENCES "public"."unidades" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_contenido") REFERENCES "public"."contenidos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."seguimiento_silabo" ADD FOREIGN KEY ("cod_docente") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."silabos"
-- ----------------------------
ALTER TABLE "public"."silabos" ADD FOREIGN KEY ("cod_evaluacion") REFERENCES "public"."evaluacion" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."unidades"
-- ----------------------------
ALTER TABLE "public"."unidades" ADD FOREIGN KEY ("cod_silabo") REFERENCES "public"."silabos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."usuarios_perfiles"
-- ----------------------------
ALTER TABLE "public"."usuarios_perfiles" ADD FOREIGN KEY ("cod_perfil") REFERENCES "public"."perfiles" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "public"."usuarios_perfiles" ADD FOREIGN KEY ("cod_usuario") REFERENCES "public"."usuarios" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;
