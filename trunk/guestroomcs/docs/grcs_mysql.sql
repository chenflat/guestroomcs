/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012-11-01 11:16:26                          */
/*==============================================================*/


drop table if exists authorities;

drop table if exists authorities_resources;

drop table if exists build;

drop table if exists department;

drop table if exists dictgroup;

drop table if exists dictitem;

drop table if exists district;

drop table if exists eventlog;

drop table if exists eventlogtype;

drop table if exists faq;

drop table if exists faqcategory;

drop table if exists floor;

drop table if exists guest;

drop table if exists guestpreference;

drop table if exists handover;

drop table if exists hotel;

drop table if exists lists;

drop table if exists prefsdefinedfield;

drop table if exists prefstype;

drop table if exists resources;

drop table if exists role;

drop table if exists roles_authorities;

drop table if exists room;

drop table if exists roomassignedgrouies;

drop table if exists roomconfig;

drop table if exists roomgroup;

drop table if exists roomtype;

drop table if exists roomtypeparamters;

drop table if exists system;

drop table if exists systemsetting;

drop table if exists user;

drop table if exists user_role;

/*==============================================================*/
/* Table: authorities                                           */
/*==============================================================*/
create table authorities
(
   authority_id         varchar(75) not null,
   authority_name       varchar(50),
   authority_desc       varchar(255),
   enabled              bool,
   issys                bool,
   primary key (authority_id)
);

/*==============================================================*/
/* Table: authorities_resources                                 */
/*==============================================================*/
create table authorities_resources
(
   authority_id         varchar(75) not null,
   resource_id          varchar(75) not null,
   primary key (authority_id, resource_id)
);

/*==============================================================*/
/* Table: build                                                 */
/*==============================================================*/
create table build
(
   build_id             varchar(75) not null,
   build_name           varchar(60),
   build_address        varchar(255),
   hotel_id             varchar(75),
   build_comment        varchar(255),
   status               int,
   primary key (build_id)
);

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   dept_id              varchar(75) not null,
   hotel_id             varchar(75),
   dept_code            varchar(50),
   dept_shortname       varchar(20),
   dept_name            varchar(40),
   parentid             varchar(75),
   priority             int,
   dept_manager         varchar(75),
   dept_photo           varchar(50),
   dept_fax             varchar(50),
   dept_comment         varchar(255),
   primary key (dept_id)
);

/*==============================================================*/
/* Table: dictgroup                                             */
/*==============================================================*/
create table dictgroup
(
   group_code           varchar(20) not null,
   group_name           varchar(50),
   primary key (group_code)
);

/*==============================================================*/
/* Table: dictitem                                              */
/*==============================================================*/
create table dictitem
(
   item_id              varchar(75) not null,
   group_code           varchar(20) not null,
   item_code            varchar(20) not null,
   item_name            varchar(50) not null,
   item_shortname       varchar(20),
   item_value           varchar(20),
   item_color           varchar(10),
   item_icon            varchar(200),
   item_remark          varchar(200),
   item_order           int default 0,
   primary key (item_id)
);

/*==============================================================*/
/* Table: district                                              */
/*==============================================================*/
create table district
(
   district_id          varchar(10) not null,
   parent_id            varchar(10),
   district_name        varchar(50),
   district_pinyi       varchar(50),
   district_postcode    varchar(6),
   district_areacode    varchar(10),
   district_woeid       varchar(10),
   district_comment     varchar(200),
   primary key (district_id)
);

/*==============================================================*/
/* Table: eventlog                                              */
/*==============================================================*/
create table eventlog
(
   log_uuid             varchar(75) not null,
   user_id              varchar(75),
   user_name            varchar(50),
   logtype_key          varchar(75),
   log_createdate       datetime,
   log_servername       varchar(50),
   log_properties       text,
   log_notificationpending bool,
   primary key (log_uuid)
);

/*==============================================================*/
/* Table: eventlogtype                                          */
/*==============================================================*/
create table eventlogtype
(
   logtype_key          varchar(75) not null,
   logtype_friendlyname varchar(50),
   logtype_description  varchar(255),
   logtype_owner        varchar(100),
   logtype_cssclass     varchar(40),
   primary key (logtype_key)
);

/*==============================================================*/
/* Table: faq                                                   */
/*==============================================================*/
create table faq
(
   faq_id               varchar(75) not null,
   cat_id               varchar(75),
   question             varchar(200),
   answer               varchar(2000),
   priority             int comment '数字越大，排列越靠前',
   comment              varchar(200),
   primary key (faq_id)
);

/*==============================================================*/
/* Table: faqcategory                                           */
/*==============================================================*/
create table faqcategory
(
   cat_id               varchar(75) not null,
   cat_name             varchar(50),
   cat_order            int,
   cat_desc             varchar(255),
   primary key (cat_id)
);

/*==============================================================*/
/* Table: floor                                                 */
/*==============================================================*/
create table floor
(
   floor_id             varchar(75) not null comment 'uuid',
   floor_no             varchar(10),
   floor_name           varchar(20),
   build_id             varchar(75),
   floor_comment        varchar(255),
   primary key (floor_id)
);

/*==============================================================*/
/* Table: guest                                                 */
/*==============================================================*/
create table guest
(
   guest_id             varchar(75) not null,
   profileid            varchar(50),
   profiletype          varchar(20),
   lanaguage            varchar(20),
   currency             varchar(3),
   createdondate        datetime,
   firststay            datetime,
   laststay             datetime,
   firstname            varchar(20),
   lastname             varchar(20),
   salutation           varchar(10),
   room_no              varchar(10),
   gender               varchar(10),
   inactive             bool,
   company              varchar(100),
   address              varchar(100),
   country              varchar(50),
   state                varchar(50),
   city                 varchar(50),
   zip                  varchar(10),
   phone_home           varchar(20),
   fax                  varchar(20),
   phone_mobile         varchar(20),
   phone_bus            varchar(20),
   phone_busext         varchar(10),
   phone_other          varchar(20),
   email                varchar(50),
   url                  varchar(50),
   isprompt             bool,
   comment              varchar(255),
   primary key (guest_id)
);

/*==============================================================*/
/* Table: guestpreference                                       */
/*==============================================================*/
create table guestpreference
(
   guest_id             varchar(75) not null,
   definedfieldid       varchar(75) not null,
   prefs_value          text,
   primary key (guest_id, definedfieldid)
);

/*==============================================================*/
/* Table: handover                                              */
/*==============================================================*/
create table handover
(
   handover_id          bigint not null,
   user_id              varchar(75),
   handover_starttime   datetime,
   handover_endtime     datetime,
   createdOnDate        datetime,
   primary key (handover_id)
);

/*==============================================================*/
/* Table: hotel                                                 */
/*==============================================================*/
create table hotel
(
   hotel_id             varchar(75) not null,
   hotel_name           varchar(50),
   hotel_enname         varchar(100),
   hotel_address        varchar(200),
   district_id          varchar(200),
   hotel_phone          varchar(20),
   hotel_fax            varchar(20),
   hotel_desc           varchar(1000),
   hotel_photo          varchar(200),
   hotel_long           varchar(50),
   hotel_lat            varchar(50),
   hotel_comment        varchar(255),
   primary key (hotel_id)
);

/*==============================================================*/
/* Table: lists                                                 */
/*==============================================================*/
create table lists
(
   entryid              varchar(75) not null,
   listname             varchar(50) not null,
   text                 varchar(150) not null,
   value                varchar(100) not null,
   parentid             varchar(75),
   level                int,
   sortorder            int,
   definitionid         varchar(75),
   description          varchar(500),
   systemlist           bool,
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserId varchar(75),
   lastmodifiedondate   datetime,
   primary key (entryid)
);

/*==============================================================*/
/* Table: prefsdefinedfield                                     */
/*==============================================================*/
create table prefsdefinedfield
(
   definedfieldid       varchar(75) not null,
   prefstype_id         varchar(75),
   fieldtitle           varchar(50),
   visible              bool,
   fieldorder           int,
   fieldtype            varchar(20),
   required             bool,
   defvalue             varchar(2000),
   outputsettings       varchar(2000),
   inputsettings        varchar(2000),
   validationrule       varchar(512),
   validationmessage    varchar(512),
   helptext             varchar(512),
   searchable           bool,
   showonedit           bool,
   privatefield         bool,
   editstyle            varchar(512),
   primary key (definedfieldid)
);

/*==============================================================*/
/* Table: prefstype                                             */
/*==============================================================*/
create table prefstype
(
   prefstype_id         varchar(75) not null,
   prefstype_name       varchar(50),
   prefstype_comment    varchar(255),
   primary key (prefstype_id)
);

/*==============================================================*/
/* Table: resources                                             */
/*==============================================================*/
create table resources
(
   resource_id          varchar(75) not null,
   resource_name        varchar(100),
   resource_type        varchar(20) comment 'url、method',
   priority             int,
   resource_string      varchar(255),
   resource_desc        varchar(255),
   enabled              bool,
   issys                bool,
   primary key (resource_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              varchar(75) not null comment '角色代码',
   role_name            varchar(50),
   role_desc            varchar(100),
   enabled              bool,
   issys                bool,
   primary key (role_id)
);

/*==============================================================*/
/* Table: roles_authorities                                     */
/*==============================================================*/
create table roles_authorities
(
   role_id              varchar(75) not null,
   authority_id         varchar(75) not null,
   primary key (role_id, authority_id)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   room_no              varchar(75) not null,
   room_name            varchar(40),
   floor_id             varchar(75),
   roomtype_id          varchar(75),
   room_towards         varchar(20),
   room_phone           varchar(20),
   room_fax             varchar(20),
   room_photo           varchar(200),
   room_comment         varchar(200),
   primary key (room_no)
);

/*==============================================================*/
/* Table: roomassignedgrouies                                   */
/*==============================================================*/
create table roomassignedgrouies
(
   itemid               varchar(75) not null,
   room_no              varchar(75),
   roomgroup_id         varchar(75),
   primary key (itemid)
);

/*==============================================================*/
/* Table: roomconfig                                            */
/*==============================================================*/
create table roomconfig
(
   room_no              varchar(75) not null,
   room_ip              varchar(20),
   room_port            int,
   primary key (room_no)
);

/*==============================================================*/
/* Table: roomgroup                                             */
/*==============================================================*/
create table roomgroup
(
   roomgroup_id         varchar(75) not null,
   roomgroup_name       varchar(40),
   roomgroup_desc       varchar(255),
   primary key (roomgroup_id)
);

/*==============================================================*/
/* Table: roomtype                                              */
/*==============================================================*/
create table roomtype
(
   roomtype_id          varchar(75) not null,
   hotel_id             varchar(75),
   roomtype_name        varchar(50),
   roomtype_template    varchar(200),
   roomtype_minguests   int,
   roomtype_maxguests   int,
   roomtype_photo       varchar(200),
   roomtype_issmoking   bool,
   roomtype_comment     varchar(255),
   primary key (roomtype_id)
);

/*==============================================================*/
/* Table: roomtypeparamters                                     */
/*==============================================================*/
create table roomtypeparamters
(
   paramter_id          varchar(75) not null,
   roomtype_id          varchar(75),
   paramter_key         varchar(50),
   paramter_name        varchar(50),
   paramter_comment     varchar(200),
   paramter_location    varchar(100),
   primary key (paramter_id)
);

/*==============================================================*/
/* Table: system                                                */
/*==============================================================*/
create table system
(
   system_uuid          varchar(75) not null,
   system_name          varchar(40),
   system_enname        varchar(100),
   system_desc          varchar(200),
   copyright            varchar(100),
   expirydate           datetime,
   administratorid      varchar(75),
   administratorroleid  varchar(75),
   registeredroleid     varchar(75),
   timezoneoffset       int,
   defaultlanguage      varchar(10),
   currency             varchar(10),
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserid varchar(75),
   lastmodifiedondate   datetime,
   primary key (system_uuid)
);

/*==============================================================*/
/* Table: systemsetting                                         */
/*==============================================================*/
create table systemsetting
(
   setting_name         varchar(50) not null,
   system_uuid          varchar(75) not null,
   setting_value        varchar(2000),
   culture_code         varchar(10),
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserid varchar(75),
   lastmodifiedondate   datetime,
   primary key (setting_name)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(75) not null,
   user_name            varchar(50),
   user_password        varchar(100),
   user_realname        varchar(30),
   user_desc            varchar(255),
   enabled              bool comment '0禁用 1正常',
   issuperuser          bool comment '0非 1是 ',
   lastipaddress        varchar(50),
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_id              varchar(75) not null,
   role_id              varchar(75) not null,
   primary key (user_id, role_id)
);

alter table authorities_resources add constraint FK_authorities_authoritiesresources foreign key (authority_id)
      references authorities (authority_id) on delete cascade;

alter table authorities_resources add constraint FK_resources_authoritiesresources foreign key (resource_id)
      references resources (resource_id) on delete cascade;

alter table build add constraint FK_hotelinfo_buildinfo foreign key (hotel_id)
      references hotel (hotel_id) on delete cascade;

alter table department add constraint FK_department_department foreign key (parentid)
      references department (dept_id) on delete cascade;

alter table department add constraint FK_hotel_department foreign key (hotel_id)
      references hotel (hotel_id) on delete cascade;

alter table dictitem add constraint FK_dictigroup_dictitem foreign key (group_code)
      references dictgroup (group_code) on delete restrict on update restrict;

alter table district add constraint FK_district_district foreign key (parent_id)
      references district (district_id) on delete cascade;

alter table eventlog add constraint FK_eventlogtype_eventlog foreign key (logtype_key)
      references eventlogtype (logtype_key) on delete cascade;

alter table faq add constraint FK_faqcategory_faq foreign key (cat_id)
      references faqcategory (cat_id) on delete cascade;

alter table floor add constraint FK_buildinfo_floorinfo foreign key (build_id)
      references build (build_id) on delete cascade;

alter table guestpreference add constraint FK_guest_guestpreference foreign key (guest_id)
      references guest (guest_id) on delete cascade;

alter table guestpreference add constraint FK_prefsdefinedfield_guestpreference foreign key (definedfieldid)
      references prefsdefinedfield (definedfieldid) on delete cascade;

alter table handover add constraint FK_user_handover foreign key (user_id)
      references user (user_id) on delete cascade;

alter table hotel add constraint FK_district_hotel foreign key (district_id)
      references district (district_id);

alter table lists add constraint FK_lists_lists foreign key (parentid)
      references lists (entryid) on delete cascade;

alter table prefsdefinedfield add constraint FK_prefstype_prefsdefinedfield foreign key (prefstype_id)
      references prefstype (prefstype_id) on delete cascade;

alter table roles_authorities add constraint FK_authorities_rolesauthorities foreign key (authority_id)
      references authorities (authority_id) on delete cascade;

alter table roles_authorities add constraint FK_role_rolesauthorities foreign key (role_id)
      references role (role_id) on delete cascade;

alter table room add constraint FK_floor_room foreign key (floor_id)
      references floor (floor_id) on delete cascade;

alter table room add constraint FK_roomtype_room foreign key (roomtype_id)
      references roomtype (roomtype_id) on delete cascade;

alter table roomassignedgrouies add constraint FK_room_roomassignedgrouies foreign key (room_no)
      references room (room_no) on delete cascade;

alter table roomassignedgrouies add constraint FK_roomgroup_roomassignedgrouies foreign key (roomgroup_id)
      references roomgroup (roomgroup_id) on delete cascade;

alter table roomconfig add constraint FK_room_roomconfig foreign key (room_no)
      references room (room_no) on delete cascade;

alter table roomtype add constraint FK_hotel_roomtype foreign key (hotel_id)
      references hotel (hotel_id) on delete restrict on update restrict;

alter table roomtypeparamters add constraint FK_roomtype_roomtypeparamters foreign key (roomtype_id)
      references roomtype (roomtype_id) on delete cascade;

alter table systemsetting add constraint FK_system_systemsetting foreign key (system_uuid)
      references system (system_uuid) on delete restrict on update restrict;

alter table user_role add constraint FK_role_userrole foreign key (role_id)
      references role (role_id) on delete cascade;

alter table user_role add constraint FK_user_userrole foreign key (user_id)
      references user (user_id) on delete cascade;

