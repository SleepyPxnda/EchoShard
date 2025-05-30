CREATE SCHEMA IF NOT EXISTS  money;

create table IF NOT EXISTS  money.money
(
    player_id uuid not null,
    amount    double precision,
    id        integer generated always as identity
        primary key
);

alter table money.money
    owner to admin;

