--
-- PostgreSQL database dump
--

\restrict 4OEMJ6Vq1uVTQTD8svAcLV7ie4Xo9lcH9DXrse7YRMr02uuJDTje3AOEEuZQaVq

-- Dumped from database version 16.11 (Debian 16.11-1.pgdg13+1)
-- Dumped by pg_dump version 16.11 (Debian 16.11-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: dp_play
--

CREATE TABLE public.customer (
    id character varying(36) NOT NULL,
    address character varying(100),
    email character varying(50),
    name character varying(60) NOT NULL,
    phone_number character varying(20)
);


ALTER TABLE public.customer OWNER TO dp_play;

--
-- Name: order_item; Type: TABLE; Schema: public; Owner: dp_play
--

CREATE TABLE public.order_item (
    id character varying(36) NOT NULL,
    id_order character varying(36) NOT NULL,
    id_pizza character varying(36) NOT NULL,
    price numeric(5,2) NOT NULL,
    quantity numeric(2,1) NOT NULL
);


ALTER TABLE public.order_item OWNER TO dp_play;

--
-- Name: pizza; Type: TABLE; Schema: public; Owner: dp_play
--

CREATE TABLE public.pizza (
    id character varying(36) NOT NULL,
    available boolean NOT NULL,
    created_date timestamp(6) without time zone,
    description character varying(500) NOT NULL,
    modified_date timestamp(6) without time zone,
    name character varying(30) NOT NULL,
    price numeric(10,2) NOT NULL,
    type character varying(255),
    CONSTRAINT pizza_type_check CHECK (((type)::text = ANY ((ARRAY['VEGETARIAN'::character varying, 'VEGAN'::character varying])::text[])))
);


ALTER TABLE public.pizza OWNER TO dp_play;

--
-- Name: pizza_order; Type: TABLE; Schema: public; Owner: dp_play
--

CREATE TABLE public.pizza_order (
    id character varying(36) NOT NULL,
    additional_notes character varying(500),
    date timestamp without time zone NOT NULL,
    id_customer character varying(36) NOT NULL,
    method character(1),
    total numeric(10,2) NOT NULL
);


ALTER TABLE public.pizza_order OWNER TO dp_play;

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: dp_play
--

COPY public.customer (id, address, email, name, phone_number) FROM stdin;
99aa1b18-dd51-488f-9782-1cd691133513	Street 10 #22-11	[john@example.com](mailto:john@example.com)	John Doe	3001112233
8203a0bc-996c-41f9-be0f-cbe206110201	Avenue 5 #44-20	[jane@example.com](mailto:jane@example.com)	Jane Smith	3015557788
7d50fea6-91ff-4682-8c44-7abef0857925	Calle 80 #10-30	[carlos@example.com](mailto:carlos@example.com)	Carlos Ramirez	3024441122
84404906-20a6-4cc6-a222-cf4b6b1ba760	Carrera 12 #90-10	[laura@example.com](mailto:laura@example.com)	Laura Torres	3157778899
56c82c29-a8ab-496c-9f47-3a43cb864cf5	Street 7 #11-50	[ana@example.com](mailto:ana@example.com)	Ana Martinez	3102223344
\.


--
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: dp_play
--

COPY public.order_item (id, id_order, id_pizza, price, quantity) FROM stdin;
a3964fa5-8c0c-4025-9c67-18159eaa7cdb	90191e79-f203-40ae-ba65-5762181c5712	f300a483-fd13-4147-8332-6190c1d06fd8	25.50	2.0
6e2e28c7-8097-4149-b0f7-c9a4ccbdfb0f	90191e79-f203-40ae-ba65-5762181c5712	2c64cd5c-aba4-4b92-8bae-72724e7c16c5	32.00	1.0
428fb90f-430d-46c2-9567-9bee3ad2b745	88d9e176-17b3-4262-8ac0-9207cca653e8	f300a483-fd13-4147-8332-6190c1d06fd8	25.50	3.0
32670f1a-772e-4172-8814-8913340fd9de	88d9e176-17b3-4262-8ac0-9207cca653e8	2c64cd5c-aba4-4b92-8bae-72724e7c16c5	32.00	1.0
4b4c1c2b-7867-4be5-a8ab-4fe0a1059a1b	c7c458ad-0643-41b0-b497-4f17a87b4be0	f300a483-fd13-4147-8332-6190c1d06fd8	25.50	3.0
fe83aa5a-c102-4f06-a22c-8963ccc7975b	c7c458ad-0643-41b0-b497-4f17a87b4be0	2c64cd5c-aba4-4b92-8bae-72724e7c16c5	32.00	2.0
7863928b-ef13-45e6-a268-8c189f7ac2f5	a8f89ea5-5794-4332-b2cb-7bd11ac38b16	f300a483-fd13-4147-8332-6190c1d06fd8	25.50	1.0
e400e20b-3ec2-495d-a703-34b828a2e63c	a8f89ea5-5794-4332-b2cb-7bd11ac38b16	2c64cd5c-aba4-4b92-8bae-72724e7c16c5	32.00	3.0
5fe85efa-4750-4e2c-be91-4b2358db40dc	1a7db51b-79d4-4966-b8f1-75e3a2927e21	f300a483-fd13-4147-8332-6190c1d06fd8	25.50	2.0
ebe1b847-ca70-4f72-b488-8852731143b4	1a7db51b-79d4-4966-b8f1-75e3a2927e21	2c64cd5c-aba4-4b92-8bae-72724e7c16c5	32.00	3.0
\.


--
-- Data for Name: pizza; Type: TABLE DATA; Schema: public; Owner: dp_play
--

COPY public.pizza (id, available, created_date, description, modified_date, name, price, type) FROM stdin;
f300a483-fd13-4147-8332-6190c1d06fd8	t	\N	Tomato sauce, mozzarella, basil	\N	Margherita	25.50	VEGETARIAN
2c64cd5c-aba4-4b92-8bae-72724e7c16c5	t	\N	Mozzarella, parmesan, gorgonzola, cheddar	\N	Four Cheese	32.00	VEGETARIAN
1fdd5484-a46a-4a7d-a82b-be0db9592150	t	\N	Bell peppers, olives, onions, mushrooms	\N	Veggie Supreme	27.00	VEGETARIAN
78b3f390-8450-4f1a-bb69-759ad04d1f27	t	\N	Creamy alfredo sauce with spinach	\N	Spinach Alfredo	28.50	VEGETARIAN
f01238d5-2403-4c7c-9dcf-b07989e4c4c4	t	\N	Plant-based cheese and vegetables	\N	Vegan Delight	30.00	VEGAN
318ecc15-f40f-4e44-ab91-0b2266be122e	t	\N	BBQ sauce with vegan protein and onions	\N	Vegan BBQ	31.50	VEGAN
a5b2745b-c691-4fba-82af-8bf9f79f37f4	t	\N	Zucchini, spinach, vegan cheese	\N	Green Garden	29.00	VEGAN
\.


--
-- Data for Name: pizza_order; Type: TABLE DATA; Schema: public; Owner: dp_play
--

COPY public.pizza_order (id, additional_notes, date, id_customer, method, total) FROM stdin;
c7c458ad-0643-41b0-b497-4f17a87b4be0	No onions please	2026-03-26 04:49:46.921419	7d50fea6-91ff-4682-8c44-7abef0857925	P	140.50
90191e79-f203-40ae-ba65-5762181c5712	No onions please	2026-03-31 14:21:14.078307	99aa1b18-dd51-488f-9782-1cd691133513	D	83.00
1a7db51b-79d4-4966-b8f1-75e3a2927e21	No onions please	2026-04-01 00:46:54.941456	56c82c29-a8ab-496c-9f47-3a43cb864cf5	P	147.00
a8f89ea5-5794-4332-b2cb-7bd11ac38b16	No onions please	2026-03-26 03:57:38.614375	84404906-20a6-4cc6-a222-cf4b6b1ba760	P	121.50
88d9e176-17b3-4262-8ac0-9207cca653e8	No onions please	2026-04-04 07:08:01.259602	8203a0bc-996c-41f9-be0f-cbe206110201	D	108.50
\.


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- Name: order_item order_item_pkey; Type: CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT order_item_pkey PRIMARY KEY (id, id_order);


--
-- Name: pizza_order pizza_order_pkey; Type: CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.pizza_order
    ADD CONSTRAINT pizza_order_pkey PRIMARY KEY (id);


--
-- Name: pizza pizza_pkey; Type: CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.pizza
    ADD CONSTRAINT pizza_pkey PRIMARY KEY (id);


--
-- Name: pizza uk6n1plxa8aecur40e4q2vpcrps; Type: CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.pizza
    ADD CONSTRAINT uk6n1plxa8aecur40e4q2vpcrps UNIQUE (name);


--
-- Name: order_item fkakuoq412rnkuv4k0xsqeam5k0; Type: FK CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fkakuoq412rnkuv4k0xsqeam5k0 FOREIGN KEY (id_order) REFERENCES public.pizza_order(id);


--
-- Name: order_item fkgy49avjjdhl48p67qplglv6sr; Type: FK CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT fkgy49avjjdhl48p67qplglv6sr FOREIGN KEY (id_pizza) REFERENCES public.pizza(id);


--
-- Name: pizza_order fknlayechpuwervvwn2ius58ney; Type: FK CONSTRAINT; Schema: public; Owner: dp_play
--

ALTER TABLE ONLY public.pizza_order
    ADD CONSTRAINT fknlayechpuwervvwn2ius58ney FOREIGN KEY (id_customer) REFERENCES public.customer(id);


--
-- PostgreSQL database dump complete
--

\unrestrict 4OEMJ6Vq1uVTQTD8svAcLV7ie4Xo9lcH9DXrse7YRMr02uuJDTje3AOEEuZQaVq

