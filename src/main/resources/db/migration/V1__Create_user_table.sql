create table if not exists pg_user(
    id serial primary key,
    name varchar(15),
    last_name varchar(25),
    role varchar,
    login varchar(15),
    password varchar
)