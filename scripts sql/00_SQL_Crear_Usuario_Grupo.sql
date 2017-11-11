-- Table: public.usuario_grupo

-- DROP TABLE public.usuario_grupo;

CREATE TABLE public.usuario_grupo
(
  usg_codigo integer NOT NULL DEFAULT nextval('usuario_grupo_usg_codigo_seq'::regclass),
  usg_usuario integer,
  usg_grupo integer,
  CONSTRAINT usuario_grupo_pkey PRIMARY KEY (usg_codigo),
  CONSTRAINT usuario_grupo_usg_grupo_fkey FOREIGN KEY (usg_grupo)
      REFERENCES public.grupo (gru_codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_grupo_usg_usuario_fkey FOREIGN KEY (usg_usuario)
      REFERENCES public.usuario (usu_codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario_grupo
  OWNER TO postgres;
