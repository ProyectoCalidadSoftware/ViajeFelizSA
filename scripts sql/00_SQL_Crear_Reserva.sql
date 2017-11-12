-- Table: public.reserva

-- DROP TABLE public.reserva;

CREATE TABLE public.reserva
(
  id_reserva integer NOT NULL DEFAULT nextval('reserva_id_reserva_seq'::regclass),
  id_alojamiento_reserva integer NOT NULL DEFAULT nextval('reserva_id_alojamiento_reserva_seq'::regclass),
  id_usuario_alojamiento integer NOT NULL DEFAULT nextval('reserva_id_usuario_alojamiento_seq'::regclass),
  pago_reserva bigint NOT NULL,
  pago_pendiente_reserva bigint NOT NULL,
  fecha_inicio_reserva date NOT NULL,
  fecha_fin_reserva date NOT NULL,
  CONSTRAINT reserva_pkey PRIMARY KEY (id_reserva),
  CONSTRAINT reserva_id_alojamiento_reserva_fkey FOREIGN KEY (id_alojamiento_reserva)
      REFERENCES public.alojamiento (id_alojamiento) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT reserva_id_usuario_alojamiento_fkey FOREIGN KEY (id_usuario_alojamiento)
      REFERENCES public.usuario (usu_codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.reserva
  OWNER TO postgres;
