# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tweet (
  tweet_id                  bigint auto_increment not null,
  comment                   varchar(255),
  username                  varchar(255),
  creation_date             datetime,
  constraint pk_tweet primary key (tweet_id))
;

create table user (
  username                  varchar(255) not null,
  email                     varchar(255),
  password                  varchar(255) not null,
  country                   varchar(255),
  address                   varchar(255),
  age                       integer,
  constraint pk_user primary key (username))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table tweet;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

