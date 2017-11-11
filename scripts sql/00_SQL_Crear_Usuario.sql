-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
  usu_codigo integer NOT NULL DEFAULT nextval('usuario_usu_codigo_seq'::regclass),
  usu_nombre character varying(30),
  usu_login character varying(30),
  usu_password character varying(30),
  CONSTRAINT usuario_pkey PRIMARY KEY (usu_codigo),
  CONSTRAINT usuario_usu_login_key UNIQUE (usu_login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;
