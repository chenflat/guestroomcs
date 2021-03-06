/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013-02-27 13:31:10                          */
/*==============================================================*/


drop table if exists address;

drop table if exists build;

drop table if exists counter;

drop table if exists department;

drop table if exists device_module;

drop table if exists device_module_properties;

drop table if exists district;

drop table if exists emailAddress;

drop table if exists eventlog;

drop table if exists eventlogtype;

drop table if exists faq;

drop table if exists faqcategory;

drop table if exists floor;

drop table if exists guest;

drop table if exists guestpreference;

drop table if exists hotel;

drop table if exists listinfo;

drop table if exists phone;

drop table if exists portal;

drop table if exists portalsettings;

drop table if exists prefsdefinedfield;

drop table if exists prefstype;

drop table if exists profilepropertydefinition;

drop table if exists resource;

drop table if exists role;

drop table if exists role_resource;

drop table if exists room;

drop table if exists room_device_properties;

drop table if exists room_devices;

drop table if exists roomassignedgrouies;

drop table if exists roomconfig;

drop table if exists roomgroup;

drop table if exists roomtype;

drop table if exists roomtypeparamters;

drop table if exists shiftwork;

drop table if exists user;

drop table if exists user_role;

drop table if exists userprofile;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   addressId            varchar(75) not null,
   user_id              varchar(75),
   createdOnDate        datetime,
   lastModifiedOnDate   datetime,
   state                varchar(75),
   city                 varchar(75),
   street               varchar(75),
   zipcode              varchar(75),
   country              varchar(75),
   primary_             bool,
   entryid              varchar(75),
   comment              varchar(50),
   keyname              varchar(50),
   primary key (addressId)
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
   primary key (build_id)
);

/*==============================================================*/
/* Table: counter                                               */
/*==============================================================*/
create table counter
(
   currentid            bigint default 0
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
/* Table: device_module                                         */
/*==============================================================*/
create table device_module
(
   module_id            varchar(75) not null,
   module_name          varchar(75),
   description          varchar(100),
   comment              varchar(100),
   internal             bool,
   primary key (module_id)
);

/*==============================================================*/
/* Table: device_module_properties                              */
/*==============================================================*/
create table device_module_properties
(
   property_id          varchar(75) not null,
   module_id            varchar(75),
   property_name        varchar(75),
   property_description varchar(75),
   property_value       varchar(75),
   property_unit        varchar(75),
   property_type        varchar(75) comment 'information,dynamicValue,defaultValue',
   primary key (property_id)
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
/* Table: emailAddress                                          */
/*==============================================================*/
create table emailAddress
(
   emailAddressId       varchar(75) not null,
   user_id              varchar(75),
   createdOnDate        datetime,
   lastModifiedOnDate   datetime,
   address              varchar(75),
   primary_             bool,
   entryid              varchar(75),
   comment              varchar(50),
   keyname              varchar(50),
   primary key (emailAddressId)
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
/* Table: hotel                                                 */
/*==============================================================*/
create table hotel
(
   hotel_id             varchar(75) not null,
   hotel_name           varchar(50),
   hotel_enname         varchar(100),
   hotel_desc           varchar(1000),
   currency             varchar(10),
   hotel_address        varchar(200),
   hotel_district       varchar(50),
   hotel_city           varchar(50),
   hotel_state          varchar(50),
   hotel_country        varchar(50),
   hotel_zip            varchar(10),
   hotel_phone          varchar(20),
   hotel_fax            varchar(20),
   hotel_email          varchar(50),
   hotel_photo          varchar(200),
   hotel_comment        varchar(255),
   hotel_long           varchar(50),
   hotel_lat            varchar(50),
   primary key (hotel_id)
);

/*==============================================================*/
/* Table: listinfo                                              */
/*==============================================================*/
create table listinfo
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
   langcode             varchar(20),
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserId varchar(75),
   lastmodifiedondate   datetime,
   primary key (entryid)
);

/*==============================================================*/
/* Table: phone                                                 */
/*==============================================================*/
create table phone
(
   phoneId              varchar(75) not null,
   user_id              varchar(75),
   createdOnDate        datetime,
   lastModifiedOnDate   datetime,
   number               varchar(75),
   extension            varchar(75),
   primary_             bool,
   entryid              varchar(75),
   comment              varchar(50),
   keyname              varchar(50),
   primary key (phoneId)
);

/*==============================================================*/
/* Table: portal                                                */
/*==============================================================*/
create table portal
(
   portal_id            varchar(75) not null,
   portal_name          varchar(40),
   portal_enname        varchar(100),
   portal_desc          varchar(200),
   copyright            varchar(100),
   expirydate           datetime,
   administratorid      varchar(75),
   administratorroleid  varchar(75),
   registeredroleid     varchar(75),
   timezoneoffset       int,
   defaultlanguage      varchar(10),
   currency             varchar(10),
   hosturl              varchar(100),
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserid varchar(75),
   lastmodifiedondate   datetime,
   primary key (portal_id)
);

/*==============================================================*/
/* Table: portalsettings                                        */
/*==============================================================*/
create table portalsettings
(
   portal_id            varchar(75) not null,
   setting_name         varchar(50) not null,
   setting_value        varchar(2000),
   culture_code         varchar(10),
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserid varchar(75),
   lastmodifiedondate   datetime,
   primary key (portal_id, setting_name)
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
/* Table: profilepropertydefinition                             */
/*==============================================================*/
create table profilepropertydefinition
(
   propertydefinitionid varchar(75) not null,
   deleted              bool,
   datatype             int comment 'datatype:  1=text  2=switch 3=language  4=timezone 5=dictionary 6=uploadfile  7=requestlist 8=music 9=KeywordNumber 10=SwitchDevice',
   defaultvalue         text,
   propertycategory     varchar(50),
   propertyname         varchar(50),
   length               int,
   required             bool,
   validationexpression varchar(1000),
   vieworder            int,
   visible              bool,
   defaultvisibility    int comment '0=AllUsers 2=AdminOnly',
   createdbyuserid      varchar(75),
   createdondate        datetime,
   lastmodifiedbyuserid varchar(75),
   lastmodifiedondate   datetime,
   primary key (propertydefinitionid)
);

/*==============================================================*/
/* Table: resource                                              */
/*==============================================================*/
create table resource
(
   resource_id          varchar(75) not null,
   resource_name        varchar(100),
   parent_id            varchar(75),
   resource_type        varchar(20) comment 'url、method',
   priority             int,
   resource_string      varchar(255),
   resource_desc        varchar(255),
   status               int comment '0禁用 1启用',
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
   status               int comment '0禁用 1启用',
   issys                bool,
   primary key (role_id)
);

/*==============================================================*/
/* Table: role_resource                                         */
/*==============================================================*/
create table role_resource
(
   role_id              varchar(75) not null,
   resource_id          varchar(75) not null,
   primary key (role_id, resource_id)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   room_id              int not null,
   room_no              varchar(75) not null,
   room_name            varchar(40),
   floor_id             varchar(75),
   roomtype_id          varchar(75),
   room_towards         varchar(20),
   room_phone           varchar(20),
   room_fax             varchar(20),
   room_photo           varchar(200),
   room_comment         varchar(200),
   handicappedroom      bool,
   koshersabbath        bool,
   status               int comment '0=未启用 1=空闲 2=checkin 21=已出租/出售 22=占用的 23=已出租/已占用  3=checkout',
   primary key (room_id)
);

/*==============================================================*/
/* Table: room_device_properties                                */
/*==============================================================*/
create table room_device_properties
(
   device_id            varchar(75) not null,
   property_id          varchar(75) not null,
   property_value       varchar(75),
   primary key (device_id, property_id)
);

/*==============================================================*/
/* Table: room_devices                                          */
/*==============================================================*/
create table room_devices
(
   device_id            varchar(75) not null,
   room_id              int not null,
   module_id            varchar(75) not null,
   device_no            varchar(75),
   device_name          varchar(75) not null,
   description          varchar(255),
   actived              bool,
   primary key (device_id)
);

/*==============================================================*/
/* Table: roomassignedgrouies                                   */
/*==============================================================*/
create table roomassignedgrouies
(
   itemid               varchar(75) not null,
   room_id              int,
   roomgroup_id         varchar(75),
   primary key (itemid)
);

/*==============================================================*/
/* Table: roomconfig                                            */
/*==============================================================*/
create table roomconfig
(
   room_id              int not null,
   room_ip              varchar(20),
   room_port            int,
   primary key (room_id)
);

/*==============================================================*/
/* Table: roomgroup                                             */
/*==============================================================*/
create table roomgroup
(
   roomgroup_id         varchar(75) not null,
   roomgroup_name       varchar(40),
   roomgroup_desc       varchar(255),
   sort_order           int,
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
/* Table: shiftwork                                             */
/*==============================================================*/
create table shiftwork
(
   shiftwork_id         bigint not null,
   user_id              varchar(75),
   backlog              varchar(1000),
   shiftitems           varchar(1000),
   work_starttime       datetime,
   work_endtime         datetime,
   shiftworker          varchar(75),
   shiftworker_name     varchar(50),
   floor_no             varchar(10),
   comment              varchar(500),
   createdOnDate        datetime,
   primary key (shiftwork_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(75) not null,
   username             varchar(50),
   createDate           datetime,
   modifiedDate         datetime,
   password             varchar(100),
   passwordEncrypted    int,
   passwordModifiedDate datetime,
   firstName            varchar(45),
   middleName           varchar(45),
   lastName             varchar(45),
   displayname          varchar(30),
   digest               varchar(255),
   emailAddress         varchar(100),
   reminderQueryQuestion varchar(75),
   reminderQueryAnswer  varchar(75),
   timeZone             varchar(75),
   language             varchar(75),
   greeting             varchar(255),
   website              varchar(75),
   comments             longtext,
   significantOther     varchar(100),
   birthday             date,
   anniversary          date,
   jobTitle             varchar(100),
   loginDate            datetime,
   loginIP              varchar(75),
   lastLoginDate        datetime,
   lastLoginIP          varchar(75),
   status               int comment '0禁用 1启用',
   isSuperUser          bool,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   ur_id                varchar(75) not null,
   user_id              varchar(75) not null,
   role_id              varchar(75) not null,
   primary key (ur_id)
);

/*==============================================================*/
/* Table: userprofile                                           */
/*==============================================================*/
create table userprofile
(
   profileid            varchar(75) not null,
   user_id              varchar(75),
   propertydefinitionid varchar(75),
   propertyvalue        varchar(2000),
   propertytext         varchar(2000),
   visibility           int,
   lastupdateddate      datetime,
   primary key (profileid)
);

alter table address add constraint FK_user_address foreign key (user_id)
      references user (user_id) on delete cascade;

alter table build add constraint FK_hotelinfo_buildinfo foreign key (hotel_id)
      references hotel (hotel_id) on delete cascade;

alter table department add constraint FK_department_department foreign key (parentid)
      references department (dept_id) on delete cascade;

alter table department add constraint FK_hotel_department foreign key (hotel_id)
      references hotel (hotel_id) on delete restrict on update restrict;

alter table device_module_properties add constraint FK_device_type_properties foreign key (module_id)
      references device_module (module_id) on delete cascade;

alter table district add constraint FK_district_district foreign key (parent_id)
      references district (district_id) on delete cascade;

alter table emailAddress add constraint FK_user_emailAddress foreign key (user_id)
      references user (user_id) on delete cascade;

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

alter table listinfo add constraint FK_lists_lists foreign key (parentid)
      references listinfo (entryid) on delete cascade;

alter table phone add constraint FK_user_phone foreign key (user_id)
      references user (user_id) on delete cascade;

alter table portalsettings add constraint FK_portal_portalsettings foreign key (portal_id)
      references portal (portal_id) on delete cascade;

alter table prefsdefinedfield add constraint FK_prefstype_prefsdefinedfield foreign key (prefstype_id)
      references prefstype (prefstype_id) on delete cascade;

alter table resource add constraint FK_resource_resource foreign key (parent_id)
      references resource (resource_id) on delete cascade;

alter table role_resource add constraint FK_resource_roles foreign key (resource_id)
      references resource (resource_id) on delete cascade;

alter table role_resource add constraint FK_role_resources foreign key (role_id)
      references role (role_id) on delete cascade;

alter table room add constraint FK_floor_room foreign key (floor_id)
      references floor (floor_id) on delete cascade;

alter table room add constraint FK_roomtype_room foreign key (roomtype_id)
      references roomtype (roomtype_id) on delete set null;

alter table room_device_properties add constraint FK_room_device_module_properties foreign key (property_id)
      references device_module_properties (property_id) on delete cascade;

alter table room_device_properties add constraint FK_room_devices_properties foreign key (device_id)
      references room_devices (device_id) on delete cascade;

alter table room_devices add constraint FK_room_devices foreign key (room_id)
      references room (room_id) on delete cascade;

alter table roomassignedgrouies add constraint FK_room_roomassignedgrouies foreign key (room_id)
      references room (room_id) on delete cascade;

alter table roomassignedgrouies add constraint FK_roomgroup_roomassignedgrouies foreign key (roomgroup_id)
      references roomgroup (roomgroup_id) on delete cascade;

alter table roomconfig add constraint FK_room_roomconfig foreign key (room_id)
      references room (room_id) on delete cascade;

alter table roomtype add constraint FK_hotel_roomtype foreign key (hotel_id)
      references hotel (hotel_id) on delete restrict on update restrict;

alter table roomtypeparamters add constraint FK_roomtype_roomtypeparamters foreign key (roomtype_id)
      references roomtype (roomtype_id) on delete cascade;

alter table shiftwork add constraint FK_user_shiftwork foreign key (user_id)
      references user (user_id) on delete cascade;

alter table user_role add constraint FK_role_userrole foreign key (role_id)
      references role (role_id) on delete cascade;

alter table user_role add constraint FK_user_userrole foreign key (user_id)
      references user (user_id) on delete cascade;

alter table userprofile add constraint FK_profilepropertydefinition_userprofile foreign key (propertydefinitionid)
      references profilepropertydefinition (propertydefinitionid) on delete cascade;

alter table userprofile add constraint FK_user_userprofile foreign key (user_id)
      references user (user_id) on delete cascade;

