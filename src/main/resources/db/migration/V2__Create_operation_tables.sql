create table operation
(
    id               serial primary key,
    sum              numeric   not null,
    transaction_date timestamp not null
);

create table income
(
    id           serial primary key,
    type         varchar
);

create table spending
(
    id   serial primary key,
    type varchar
)