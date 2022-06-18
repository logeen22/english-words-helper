create table users
(
    id          serial primary key,
    first_name varchar not null,
    last_name  varchar not null,
    email       varchar not null
);

create unique index users_id_uindex
    on users (id);

