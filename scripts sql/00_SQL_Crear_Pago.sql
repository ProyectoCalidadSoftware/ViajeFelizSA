-- Table: public.pago

-- DROP TABLE public.pago;

CREATE TABLE public.pago
(
  id_pago integer NOT NULL DEFAULT nextval('pago_id_pago_seq'::regclass),
  valor_pago bigint NOT NULL,
  id_pago_reserva bigint NOT NULL,
  CONSTRAINT pago_pkey PRIMARY KEY (id_pago),
  CONSTRAINT pago_id_pago_reserva_fkey FOREIGN KEY (id_pago_reserva)
      REFERENCES public.reserva (id_reserva) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pago
  OWNER TO postgres;
