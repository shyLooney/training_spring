delete from Ingredient_Ref;
delete from Pelmeni;
delete from Pelmeni_Order;
delete from Ingredient;

insert into Ingredient (id, name, type)
values ('CHICKEN', 'Chicken', 'MEAT');
insert into Ingredient (id, name, type)
values ('BEEF', 'Ground Beef', 'MEAT');
insert into Ingredient (id, name, type)
values ('PORK', 'Pork', 'MEAT');
insert into Ingredient (id, name, type)
values ('SALT', 'Salt', 'SPICE');
insert into Ingredient (id, name, type)
values ('ONION', 'Red onion', 'SPICE');
insert into Ingredient (id, name, type)
values ('PEPPER', 'Black pepper', 'SPICE');
insert into Ingredient (id, name, type)
values ('DOUGH', 'Dough', 'DOUGH');