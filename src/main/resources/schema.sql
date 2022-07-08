create table employee(
                         id bigint not null auto_increment primary key,
                         name varchar(255) not null,
                         vegetarian boolean not null,
                         calories varchar(255) not null,
                         type text not null,
                         created date not null
);