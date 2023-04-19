CREATE TABLE USERS
(
    id      UUID UNIQUE PRIMARY KEY,
    name    VARCHAR NOT NULL,
    surname VARCHAR NOT NULL
);

CREATE TABLE CONNECTIONS
(
    id       UUID UNIQUE PRIMARY KEY,
    follower UUID NOT NULL,
    followed UUID NOT NULL
);

INSERT INTO USERS (id, name, surname)
VALUES ('7fb54d02-de1c-11ed-b5ea-0242ac120002', 'Evans', 'Innocentius'),
       ('7fb55400-de1c-11ed-b5ea-0242ac120002', 'Manas', 'Ruf'),
       ('7fb55608-de1c-11ed-b5ea-0242ac120002', 'Sandhy', 'Björne'),
       ('7fb5578e-de1c-11ed-b5ea-0242ac120002', 'Danijel', 'Madelynn'),
       ('7fb55900-de1c-11ed-b5ea-0242ac120002', 'Tuva', 'Gruffudd'),
       ('7fb55bc6-de1c-11ed-b5ea-0242ac120002', 'Pitambara', 'Themba'),
       ('7fb55d24-de1c-11ed-b5ea-0242ac120002', 'Nnenna', 'Mirko');

INSERT INTO CONNECTIONS (id, follower, followed)
VALUES ('cab10b1a-dedb-11ed-b5ea-0242ac120002', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb55400-de1c-11ed-b5ea-0242ac120002'),
       ('cab10b1a-dedb-11ed-b5ea-0242ac120003', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb55608-de1c-11ed-b5ea-0242ac120002'),
       ('cab10b1a-dedb-11ed-b5ea-0242ac120004', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb5578e-de1c-11ed-b5ea-0242ac120002'),
       ('cab10b1a-dedb-11ed-b5ea-0242ac120005', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb55900-de1c-11ed-b5ea-0242ac120002'),
       ('cab10b1a-dedb-11ed-b5ea-0242ac120006', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb55bc6-de1c-11ed-b5ea-0242ac120002'),
       ('cab10b1a-dedb-11ed-b5ea-0242ac120008', '7fb54d02-de1c-11ed-b5ea-0242ac120002','7fb55d24-de1c-11ed-b5ea-0242ac120002');