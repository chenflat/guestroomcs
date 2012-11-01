insert into user (user_id,user_name,user_password,user_realname,user_desc,enabled) values (1,'admin','admin','Chen Ping','管理员',true);
insert into user (user_id,user_name,user_password,user_realname,user_desc,enabled) values (2,'test','test','Test','注册用户',true);

insert into role (role_id,role_name,role_desc,enabled,issys) values(1,'ROLE_ADMIN','管理员角色',true,true);
insert into role (role_id,role_name,role_desc,enabled,issys) values(2,'ROLE_NORMAL','普通用户角色',true,true);

insert into user_role(user_id,role_id) values (1,1);
insert into user_role(user_id,role_id) values (2,2);