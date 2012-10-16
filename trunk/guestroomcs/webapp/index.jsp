<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- HTML START -->
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-11 下午04:42:46
	LastModified Date:
	Description:
 -->

logtypekey
logtypefriendlyname
logtypedescription
logtypeowner
logtypecssclass




name	code	data type	length	precision	primary	foreign key	mandatory
logguid	logguid	varchar(36)	36		false	false	true
logtypekey	logtypekey	nvarchar(35)	35		false	true	true
logconfigid	logconfigid	int			false	true	false
loguserid	loguserid	int			false	false	false
logusername	logusername	nvarchar(50)	50		false	false	false
logportalid	logportalid	int			false	false	false
logportalname	logportalname	nvarchar(100)	100		false	false	false
logcreatedate	logcreatedate	datetime			false	false	true
logservername	logservername	nvarchar(50)	50		false	false	true
logproperties	logproperties	ntext			false	false	true
lognotificationpending	lognotificationpending	bit			false	false	false
logeventid	logeventid	bigint			true	false	true




name	code	data type	length	precision	primary	foreign key	mandatory
portalid	portalid	int			true	false	true
expirydate	expirydate	datetime			false	false	false
userregistration	userregistration	int			false	false	true
banneradvertising	banneradvertising	int			false	false	true
administratorid	administratorid	int			false	false	false
currency	currency	char(3)	3		false	false	false
hostfee	hostfee	money			false	false	true
hostspace	hostspace	int			false	false	true
administratorroleid	administratorroleid	int			false	false	false
registeredroleid	registeredroleid	int			false	false	false
guid	guid	uniqueidentifier			false	false	true
paymentprocessor	paymentprocessor	nvarchar(50)	50		false	false	false
processoruserid	processoruserid	nvarchar(50)	50		false	false	false
processorpassword	processorpassword	nvarchar(50)	50		false	false	false
siteloghistory	siteloghistory	int			false	false	false
defaultlanguage	defaultlanguage	nvarchar(10)	10		false	false	true
timezoneoffset	timezoneoffset	int			false	false	true
homedirectory	homedirectory	varchar(100)	100		false	false	true
pagequota	pagequota	int			false	false	true
userquota	userquota	int			false	false	true
createdbyuserid	createdbyuserid	int			false	false	false
createdondate	createdondate	datetime			false	false	false
lastmodifiedbyuserid	lastmodifiedbyuserid	int			false	false	false
lastmodifiedondate	lastmodifiedondate	datetime			false	false	false




name	code	data type	length	precision	primary	foreign key	mandatory
portalid	portalid	int			true	true	true
settingname	settingname	nvarchar(50)	50		true	false	true
settingvalue	settingvalue	nvarchar(2000)	2000		false	false	false
createdbyuserid	createdbyuserid	int			false	false	false
createdondate	createdondate	datetime			false	false	false
lastmodifiedbyuserid	lastmodifiedbyuserid	int			false	false	false
lastmodifiedondate	lastmodifiedondate	datetime			false	false	false
culturecode	culturecode	nvarchar(10)	10		true	false	true







name	code	data type	length	precision	primary	foreign key	mandatory
userdefinedfieldid	userdefinedfieldid	int			true	false	true
moduleid	moduleid	int			false	true	true
fieldtitle	fieldtitle	nvarchar(50)	50		false	false	false
visible	visible	bit			false	false	true
fieldorder	fieldorder	int			false	false	true
fieldtype	fieldtype	varchar(20)	20		false	false	true
required	required	bit			false	false	true
default	default	nvarchar(2000)	2000		false	false	false
outputsettings	outputsettings	nvarchar(2000)	2000		false	false	false
inputsettings	inputsettings	nvarchar(2000)	2000		false	false	false
validationrule	validationrule	nvarchar(512)	512		false	false	false
validationmessage	validationmessage	nvarchar(512)	512		false	false	false
normalizeflag	normalizeflag	bit			false	false	true
helptext	helptext	nvarchar(512)	512		false	false	false
searchable	searchable	bit			false	false	true
showonedit	showonedit	bit			false	false	true
privatefield	privatefield	bit			false	false	true
editstyle	editstyle	nvarchar(512)	512		false	false	false