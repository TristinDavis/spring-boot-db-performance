CREATE DATABASE users_db;
CREATE DATABASE products_db;

CREATE TABLE users (
    id        integer CONSTRAINT users_pk PRIMARY KEY,
    name      varchar(40) NOT NULL
);

CREATE TABLE products (
    id        integer CONSTRAINT products_pk PRIMARY KEY,
    name      varchar(40) NOT NULL
);