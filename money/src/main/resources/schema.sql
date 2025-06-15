CREATE SCHEMA IF NOT EXISTS  money;

create table IF NOT EXISTS  money.money
(
    id        integer generated always as identity primary key,
    player_id uuid not null,
    amount    double precision

);

alter table money.money
    owner to admin;

create table IF NOT EXISTS money.transaction
(
    id        integer generated always as identity primary key,
    source_id uuid not null,
    target_id uuid not null,
    amount    double precision
);

alter table money.transaction
    owner to admin;