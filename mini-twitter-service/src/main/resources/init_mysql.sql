CREATE TABLE USERS
(
    id      int generated always as identity PRIMARY KEY,
    name    varchar,
    surname varchar
);

CREATE TABLE CONNECTIONS
(
    id       int generated always as identity PRIMARY KEY,
    follower integer,
    followed integer
);