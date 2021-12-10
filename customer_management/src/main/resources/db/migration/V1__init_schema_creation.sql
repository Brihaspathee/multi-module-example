drop table if exists customer;

create table customer (
                          customer_id varchar(36) not null,
                          first_name varchar(255),
                          last_name varchar(255),
                          date_of_birth date,
                          gender varchar(10),
                          marital_status varchar(20),
                          created_date timestamp,
                          updated_date timestamp,
                          primary key (customer_id)
);