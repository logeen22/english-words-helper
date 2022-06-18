create table words
(
    id            serial primary key,
    original_word varchar not null,
    translate     varchar not null,
    group_id      int     not null
);

create unique index words_id_uindex
    on words (id);

