-- Table: public.alojamiento

-- DROP TABLE public.alojamiento;

CREATE TABLE public.alojamiento
(
  id_alojamiento integer NOT NULL DEFAULT nextval('alojamiento_id_alojamiento_seq'::regclass),
  nombre_alojamiento character varying(255) NOT NULL,
  tipo_alojamiento boolean NOT NULL,
  personas_alojamiento integer NOT NULL,
  habitaciones_alojamiento integer NOT NULL,
  banos_alojamiento integer NOT NULL,
  calefaccion_alojamiento boolean NOT NULL,
  aire_acondicionado_alojamiento boolean NOT NULL,
  mascotas_alojamiento boolean NOT NULL,
  ciudad_alojamiento character varying(255) NOT NULL,
  barrio_alojamiento character varying(255) NOT NULL,
  descripcion_alojamiento character varying(400) NOT NULL,
  precio_alojamiento bigint NOT NULL,
  direccion_alojamiento character varying(255),
  CONSTRAINT alojamiento_pkey PRIMARY KEY (id_alojamiento)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.alojamiento
  OWNER TO postgres;
