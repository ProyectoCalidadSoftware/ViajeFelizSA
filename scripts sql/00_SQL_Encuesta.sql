-- Table: public.encuesta

-- DROP TABLE public.encuesta;

CREATE TABLE public.encuesta
(
  id_encuesta integer NOT NULL DEFAULT nextval('encuesta_id_encuesta_seq'::regclass),
  puntaje_ubicacion_encuesta integer NOT NULL,
  puntaje_habitaciones_encuesta integer NOT NULL,
  puntaje_servicio_encuesta integer NOT NULL,
  puntaje_limpieza_encuesta integer NOT NULL,
  puntaje_calidad_encuesta integer NOT NULL,
  puntaje_comodidad_encuesta integer NOT NULL,
  puntaje_comida_encuesta integer NOT NULL,
  puntaje_mascotas_encuesta integer NOT NULL,
  id_encuesta_alojamiento integer NOT NULL DEFAULT nextval('encuesta_id_encuesta_alojamiento_seq'::regclass),
  promedio_encuesta character varying(255) NOT NULL,
  CONSTRAINT encuesta_pkey PRIMARY KEY (id_encuesta),
  CONSTRAINT encuesta_id_encuesta_alojamiento_fkey FOREIGN KEY (id_encuesta_alojamiento)
      REFERENCES public.alojamiento (id_alojamiento) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.encuesta
  OWNER TO postgres;
