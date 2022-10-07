CREATE TABLE coffes (
    id varchar(255) not null primary key,
    name varchar(30) not null,
    description varchar(255) not null,
    price bigint not null check (price > 0),
    created_at timestamp not null default CURRENT_TIMESTAMP,
    updated_at timestamp
);