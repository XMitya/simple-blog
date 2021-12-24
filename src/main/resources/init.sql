drop table if exists users;
drop table if exists posts;
drop table if exists comments;

create table if not exists users(
    id bigserial primary key,
    name varchar(128),
    login varchar(128),
    password varchar(256),
    created_at timestamp not null default current_timestamp,
    age int
    );

create table if not exists posts (
    id bigserial primary key,
    author_id bigint,
    created_at timestamp not null default current_timestamp,
    title varchar(1024),
    content text
    );

create table if not exists comments (
    id bigserial primary key,
    author_id bigint,
    post_id bigint,
    created_at timestamp not null default current_timestamp,
    content text
)