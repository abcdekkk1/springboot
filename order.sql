use milkorder;
create table User(
user_id bigint not null,
user_name varchar(36) not null,
Encryted_Password varchar(128) not null,
ENabled bit not null
);
alter table User
add constraint user_pk primary key(user_id);
alter table user
add constraint user_uk unique (user_name);

create table role(
role_id bigint not null,
role_name varchar(30) not null
);
alter table role
add constraint role_pk primary key(role_id);
alter table role
add constraint role_uk unique(role_name);
create table table_role(
id bigint not null,
user_id bigint not null,
role_id bigint not null
);
rename table table_role to user_role;
alter table user_role
add constraint user_role_pk primary key(id);
alter table user_role
add  constraint user_role_uk unique(user_id, role_id);
alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (USER_ID)
  references USER (USER_ID);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (ROLE_ID)
  references ROLE (ROLE_ID);
CREATE TABLE Persistent_Logins (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
     
);
insert into User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
---
 
insert into role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');
 
insert into role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');
 
---
 
insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);
 
insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);
 
insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);

create table Account(
user_name varchar(20) not null,
active BIT not null,
encryted_password varchar(128) not null,
user_role varchar(20) not null
);
alter table ACCOUNT
add primary key (user_name);
create table products(
Id varchar(50) not null,
Amount double precision not null,
customer_address varchar(255) not null,
cuastomer_email varchar(128) not null,
cuastomer_name varchar(255) not null,
customer_phone varchar(128) not null,
oder_date datetime not null,
oder_num integer not null
);
rename table products to orders;
alter table orders
add primary key(ID);
alter table orders
add constraint order_uk unique (oder_num);
create table prosucts(
code varchar(20) not null,
image longblob,
name varchar(255) not null,
price double precision not null,
create_date datetime not null
);
rename table prosucts to products;
alter table products
add primary key (code);
create table order_details
(
id varchar(50) not null,
amount double precision not null,
price double precision not null,
quanity integer not null,
order_id varchar(50) not null,
product_id varchar(20) not null
);
alter table order_details
add primary key (id);
alter table order_details
add constraint order_details_ord_fk foreign key(order_id)
references orders(id);
alter table order_details
add constraint order_detail_prod_fk foreign key(product_id)
references products(code);

insert into Account (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('employee1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE');
 
insert into Account (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('manager1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');
 
----------------
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S001', 'Core Java', 100, sysdate());
 
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S002', 'Spring for Beginners', 50, sysdate());
 
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S003', 'Swift for Beginners', 120, sysdate());
 
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S004', 'Oracle XML Parser', 120, sysdate());
 
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S005', 'CSharp Tutorial for Beginers', 110, sysdate);
