create table dish_type(
    id integer primary key,
    type varchar(20) not null unique
);

create table dish(
                         id bigint not null auto_increment primary key,
                         name varchar(255) not null,
vegetarian boolean not null,
                         calories varchar(255) not null,
                         type integer not null default 1,
                         constraint fk_dish_type foreign key (type) references dish_type (id)
);

