--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 9.6.9

-- Started on 2018-07-19 21:36:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 2203
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 192 (class 1259 OID 16598)
-- Name: data_source; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.data_source (
    unique_source_id integer NOT NULL,
    name character varying,
    description character varying,
    source_type integer
);


ALTER TABLE public.data_source OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 16614)
-- Name: data_source_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.data_source_group (
    id integer NOT NULL,
    data_source integer
);


ALTER TABLE public.data_source_group OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 16612)
-- Name: data_source_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.data_source_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.data_source_group_id_seq OWNER TO postgres;

--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 193
-- Name: data_source_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.data_source_group_id_seq OWNED BY public.data_source_group.id;


--
-- TOC entry 191 (class 1259 OID 16596)
-- Name: data_source_unique_source_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.data_source_unique_source_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.data_source_unique_source_id_seq OWNER TO postgres;

--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 191
-- Name: data_source_unique_source_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.data_source_unique_source_id_seq OWNED BY public.data_source.unique_source_id;


--
-- TOC entry 187 (class 1259 OID 16580)
-- Name: id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16654)
-- Name: link; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.link (
    id integer NOT NULL,
    link_type integer,
    title character varying,
    published_by character varying,
    url character varying,
    link_text integer,
    published_on date
);


ALTER TABLE public.link OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16583)
-- Name: link_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.link_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.link_id_seq OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16652)
-- Name: link_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.link_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.link_id_seq1 OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 199
-- Name: link_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.link_id_seq1 OWNED BY public.link.id;


--
-- TOC entry 198 (class 1259 OID 16643)
-- Name: link_text; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.link_text (
    id integer NOT NULL,
    date_collected timestamp with time zone,
    information text
);


ALTER TABLE public.link_text OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16641)
-- Name: link_text_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.link_text_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.link_text_id_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 197
-- Name: link_text_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.link_text_id_seq OWNED BY public.link_text.id;


--
-- TOC entry 196 (class 1259 OID 16627)
-- Name: link_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.link_type (
    id integer NOT NULL,
    name character varying,
    data_source integer
);


ALTER TABLE public.link_type OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 16625)
-- Name: link_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.link_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.link_type_id_seq OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 195
-- Name: link_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.link_type_id_seq OWNED BY public.link_type.id;


--
-- TOC entry 190 (class 1259 OID 16587)
-- Name: source_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.source_type (
    id integer NOT NULL,
    description character varying
);


ALTER TABLE public.source_type OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16585)
-- Name: source_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.source_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.source_type_id_seq OWNER TO postgres;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 189
-- Name: source_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.source_type_id_seq OWNED BY public.source_type.id;


--
-- TOC entry 186 (class 1259 OID 16577)
-- Name: unique_source_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.unique_source_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.unique_source_id OWNER TO postgres;

--
-- TOC entry 2044 (class 2604 OID 16601)
-- Name: data_source unique_source_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source ALTER COLUMN unique_source_id SET DEFAULT nextval('public.data_source_unique_source_id_seq'::regclass);


--
-- TOC entry 2045 (class 2604 OID 16617)
-- Name: data_source_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source_group ALTER COLUMN id SET DEFAULT nextval('public.data_source_group_id_seq'::regclass);


--
-- TOC entry 2048 (class 2604 OID 16657)
-- Name: link id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link ALTER COLUMN id SET DEFAULT nextval('public.link_id_seq1'::regclass);


--
-- TOC entry 2047 (class 2604 OID 16646)
-- Name: link_text id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link_text ALTER COLUMN id SET DEFAULT nextval('public.link_text_id_seq'::regclass);


--
-- TOC entry 2046 (class 2604 OID 16630)
-- Name: link_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link_type ALTER COLUMN id SET DEFAULT nextval('public.link_type_id_seq'::regclass);


--
-- TOC entry 2043 (class 2604 OID 16590)
-- Name: source_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.source_type ALTER COLUMN id SET DEFAULT nextval('public.source_type_id_seq'::regclass);


--
-- TOC entry 2189 (class 0 OID 16598)
-- Dependencies: 192
-- Data for Name: data_source; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.data_source (unique_source_id, name, description, source_type) FROM stdin;
\.


--
-- TOC entry 2191 (class 0 OID 16614)
-- Dependencies: 194
-- Data for Name: data_source_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.data_source_group (id, data_source) FROM stdin;
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 193
-- Name: data_source_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.data_source_group_id_seq', 1, false);


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 191
-- Name: data_source_unique_source_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.data_source_unique_source_id_seq', 1, false);


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 187
-- Name: id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id', 1, false);


--
-- TOC entry 2197 (class 0 OID 16654)
-- Dependencies: 200
-- Data for Name: link; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.link (id, link_type, title, published_by, url, link_text, published_on) FROM stdin;
\.


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 188
-- Name: link_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.link_id_seq', 1, false);


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 199
-- Name: link_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.link_id_seq1', 1, false);


--
-- TOC entry 2195 (class 0 OID 16643)
-- Dependencies: 198
-- Data for Name: link_text; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.link_text (id, date_collected, information) FROM stdin;
\.


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 197
-- Name: link_text_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.link_text_id_seq', 1, false);


--
-- TOC entry 2193 (class 0 OID 16627)
-- Dependencies: 196
-- Data for Name: link_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.link_type (id, name, data_source) FROM stdin;
\.


--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 195
-- Name: link_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.link_type_id_seq', 1, false);


--
-- TOC entry 2187 (class 0 OID 16587)
-- Dependencies: 190
-- Data for Name: source_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.source_type (id, description) FROM stdin;
\.


--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 189
-- Name: source_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.source_type_id_seq', 1, false);


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 186
-- Name: unique_source_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.unique_source_id', 1, true);


--
-- TOC entry 2054 (class 2606 OID 16619)
-- Name: data_source_group data_source_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source_group
    ADD CONSTRAINT data_source_group_pkey PRIMARY KEY (id);


--
-- TOC entry 2052 (class 2606 OID 16606)
-- Name: data_source data_source_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source
    ADD CONSTRAINT data_source_pkey PRIMARY KEY (unique_source_id);


--
-- TOC entry 2060 (class 2606 OID 16662)
-- Name: link link_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_pkey PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 16651)
-- Name: link_text link_text_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link_text
    ADD CONSTRAINT link_text_pkey PRIMARY KEY (id);


--
-- TOC entry 2056 (class 2606 OID 16635)
-- Name: link_type link_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link_type
    ADD CONSTRAINT link_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2050 (class 2606 OID 16595)
-- Name: source_type source_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.source_type
    ADD CONSTRAINT source_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 16620)
-- Name: data_source_group data_source_group_data_source_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source_group
    ADD CONSTRAINT data_source_group_data_source_fkey FOREIGN KEY (data_source) REFERENCES public.data_source(unique_source_id);


--
-- TOC entry 2061 (class 2606 OID 16607)
-- Name: data_source data_source_source_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_source
    ADD CONSTRAINT data_source_source_type_fkey FOREIGN KEY (source_type) REFERENCES public.source_type(id);


--
-- TOC entry 2065 (class 2606 OID 16668)
-- Name: link link_link_text_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_link_text_fkey FOREIGN KEY (link_text) REFERENCES public.link_text(id);


--
-- TOC entry 2064 (class 2606 OID 16663)
-- Name: link link_link_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_link_type_fkey FOREIGN KEY (link_type) REFERENCES public.link_type(id);


--
-- TOC entry 2063 (class 2606 OID 16636)
-- Name: link_type link_type_data_source_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link_type
    ADD CONSTRAINT link_type_data_source_fkey FOREIGN KEY (data_source) REFERENCES public.data_source(unique_source_id);


-- Completed on 2018-07-19 21:36:08

--
-- PostgreSQL database dump complete
--

