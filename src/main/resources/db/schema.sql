create table authorities (
    id bigserial primary key,
    authority varchar(50) unique not null
);

create table users (
    id bigserial primary key,
    username varchar(50) not null unique,
    password varchar(100) not null,
    enabled boolean default true,
    authority_id bigint not null references authorities(id)
);

create table post (
    id bigserial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now(),
    user_id bigint not null references users(id)
);

create table comment (
    id bigserial primary key,
    author varchar(255),
    description text,
    created timestamp without time zone not null default now(),
    post_id bigserial references post(id)
);
