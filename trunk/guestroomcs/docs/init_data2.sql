insert into user (user_id,user_name,password,realname,description,status) values ('1','admin','admin','Chen Ping','管理员',1);
insert into user (user_id,user_name,password,realname,description,status) values ('2','test','test','Test','注册用户',1);

insert into role (role_id,role_name,role_desc,status,issys) values('1','ROLE_ADMIN','管理员角色',1,true);
insert into role (role_id,role_name,role_desc,status,issys) values('2','ROLE_NORMAL','普通用户角色',1,true);

insert into user_role(user_id,role_id) values ('1','1');
insert into user_role(user_id,role_id) values ('2','2');

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('0','所有权限',NULL,'url',0,'/**','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('1','客房服务',NULL,'url',0,'/service/requests','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('2','服务请求','1','url',0,'/service/requests','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('3','保洁','2','url',0,'/service/requests?act=housekeeping','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('4','SOS紧急事件','2','url',0,'/service/requests?act=sos','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('5','门磁报警','2','url',0,'/service/requests?act=dooralarm','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('6','窗磁报警','2','url',0,'/service/requests?act=windowalarm','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('7','HVAC','1','url',0,'/service/havc','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('8','空调','7','url',0,'/service/havc?act=opt','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('9','浴室地板电加热','7','url',0,'/service/havc?act=bathroomfloorheat','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('10','ETM参考房间','7','url',0,'/service/havc?act=etmref','',1);

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('11','客人偏好',NULL,'url',0,'/guest/prefs','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('12','编辑偏好',11,'url',0,'/guest/prefs/edit','',1);

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('13','数据与趋势','7','url',0,'/analyse/summary','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('14','数据摘要图形','13','url',0,'/analyse/summary','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('15','数据报表','13','url',0,'/analyse/report','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('16','趋势分析','13','url',0,'/analyse/chart','',1);

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('17','用户管理',NULL,'url',0,'/user/usermanage','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('18','权限组管理','17','url',0,'/user/rolemanage','',1);

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('19','账户设置',NULL,'url',0,'/account/profile','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('20','用户资料','19','url',0,'/account/profile','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('21','个性化','19','url',0,'/account/personalize','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('22','提示','19','url',0,'/account/notification','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('23','搜索','19','url',0,'/account/search','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('24','易用性','19','url',0,'/account/usability','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('25','交接班','19','url',0,'/account/shiftwork','',1);

INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('26','系统管理',NULL,'url',0,'/system/settings','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('27','系统管理','26','url',0,NULL,'',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('28','系统设置','27','url',0,'/system/settings','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('29','数据字典','27','url',0,'/system/dictionary','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('30','FAQ管理','27','url',0,'/system/faqmanage','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('31','酒店管理','26','url',0,NULL,'',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('32','酒店设置','31','url',0,'/hotel/hotelmanage','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('33','建筑管理','31','url',0,'/hotel/buildmanage','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('34','客房管理','31','url',0,'/hotel/roommanage','',1);
INSERT INTO resource(resource_id,resource_name,parent_id,resource_type,priority,resource_string,resource_desc,status) VALUES ('35','客房类型','31','url',0,'/hotel/roomtype','',1);

insert into role_resource(role_id,resource_id) values (1,0)

