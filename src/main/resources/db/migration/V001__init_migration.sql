create schema if not exists my_shop;

create sequence if not exists my_shop.my_shop_id_seq;

create table if not exists my_shop.product(
    id integer not null default nextval('my_shop.my_shop_id_seq') primary key,
    name text not null,
    cost float not null
    );

create table if not exists my_shop.order(
    id integer not null default nextval('my_shop.my_shop_id_seq') primary key,
    creation_date date not null,
    cost float not null
    );

create table if not exists my_shop.ordered_product(
    id integer not null default nextval('my_shop.my_shop_id_seq') primary key,
    fk_product_id integer constraint fk_product_primary_key references my_shop.product,
    fk_order_id integer constraint fk_order_primary_key references my_shop.order
    );

