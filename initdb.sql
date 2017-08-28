--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE game  (
    id bigint NOT NULL,
    date timestamp with time zone NOT NULL,
    homeplayerid bigint NOT NULL,
    visitorplayerid bigint NOT NULL,
    homegoals integer NOT NULL,
    visitorgoals integer NOT NULL
);

ALTER TABLE game OWNER TO nhlxstats;

CREATE SEQUENCE game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE game_id_seq OWNER TO nhlxstats;

ALTER SEQUENCE game_id_seq OWNED BY game.id;

CREATE TABLE player (
    id bigint NOT NULL,
    name character varying(64)
);

ALTER TABLE player OWNER TO nhlxstats;

CREATE SEQUENCE player_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE player_id_seq OWNER TO nhlxstats;

ALTER SEQUENCE player_id_seq OWNED BY player.id;

ALTER TABLE ONLY game ALTER COLUMN id SET DEFAULT nextval('game_id_seq'::regclass);

ALTER TABLE ONLY player ALTER COLUMN id SET DEFAULT nextval('player_id_seq'::regclass);

SELECT pg_catalog.setval('player_id_seq', 5, true);

ALTER TABLE ONLY game
    ADD CONSTRAINT game_id PRIMARY KEY (id);

ALTER TABLE ONLY player
    ADD CONSTRAINT player_id PRIMARY KEY (id);


ALTER TABLE ONLY game
    ADD CONSTRAINT fk_homeplayerid FOREIGN KEY (homeplayerid) REFERENCES player(id);

ALTER TABLE ONLY game
    ADD CONSTRAINT fk_visitorplayerid FOREIGN KEY (visitorplayerid) REFERENCES player(id);