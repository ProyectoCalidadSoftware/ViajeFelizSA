-- Table: public.grupo

-- DROP TABLE public.grupo;

CREATE TABLE public.grupo
(
  gru_codigo integer NOT NULL DEFAULT nextval('grupo_gru_codigo_seq'::regclass),
  gru_nombre character varying(50),
  gru_id character varying(50),
  CONSTRAINT grupo_pkey PRIMARY KEY (gru_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.grupo
  OWNER TO postgres;
