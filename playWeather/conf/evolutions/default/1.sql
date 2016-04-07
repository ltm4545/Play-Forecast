# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table weather (
  id                        bigint not null,
  title                     varchar(255),
  constraint pk_weather primary key (id))
;

create sequence weather_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists weather;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists weather_seq;

