CREATE TABLE groups
(
    id   serial PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

create unique index groups_id_uindex
    on groups (id);

