create table if not exists Pelmeni_Order (
    id identity primary key not null,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null);
create table if not exists Pelmeni (
    id identity primary key not null,
    name varchar(50) not null,
    pelmeni_order bigint not null,
    pelmeni_order_key bigint not null,
    created_at timestamp not null);
create table if not exists Ingredient_Ref (
    ingredient varchar(10) not null,
    pelmeni bigint not null,
    pelmeni_key bigint not null);
create table if not exists Ingredient (
    id varchar(10) primary key not null,
    name varchar(25) not null,
    type varchar(10) not null);

alter table Pelmeni
    add foreign key (pelmeni_order) references Pelmeni_Order(id);
alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient(id);