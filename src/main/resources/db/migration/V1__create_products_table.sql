create sequence pro_id_seq start with 1 increment by 50;

create table pros
(
    id bigint default nextval('pro_id_seq') not null,
    code        text not null unique,
    name        text not null,
    description text,
    image_url   text,
    price       numeric not null,
    primary key (id)
);