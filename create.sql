create table profiles (id  bigserial not null, name varchar(255), primary key (id));
create table users (id  bigserial not null, password varchar(255), username varchar(255), primary key (id));
create table users_profiles (user_id int8 not null, profiles_id int8 not null);
alter table if exists users_profiles add constraint FK6ne4mp3iranee84wydua4itm9 foreign key (profiles_id) references profiles;
alter table if exists users_profiles add constraint FKgmc2q50iqwetlbaqcchgvks8t foreign key (user_id) references users;
