create database if not exists `jing_dong_web` default character set `utf8`;

use  `jing_dong_web`;

create table if not exists `user` (
  id int primary key auto_increment  comment '用户id',
  username varchar(20) unique not null comment '用户名',
  password varchar(30) not null comment '用户密码'
)

