CREATE TABLE users
(
    id       int generated always as identity PRIMARY KEY,
    name     varchar(64),
    username varchar(64) UNIQUE
);

CREATE TABLE connections
(
    id       bigint generated always as identity PRIMARY KEY,
    follower bigint,
    followed bigint
);