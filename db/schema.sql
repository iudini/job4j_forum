create table post (
    id bigserial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

create table comment (
    id bigserial primary key,
    author varchar(255),
    description text,
    created timestamp without time zone not null default now(),
    post_id bigserial references post(id)
);