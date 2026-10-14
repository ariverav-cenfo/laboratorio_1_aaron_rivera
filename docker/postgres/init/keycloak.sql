--Setup de la BD segun tutorial de keycloak para postrgres

CREATE USER keycloak WITH PASSWORD 'keycloak';
CREATE DATABASE keycloak OWNER keycloak ENCODING 'UTF8';