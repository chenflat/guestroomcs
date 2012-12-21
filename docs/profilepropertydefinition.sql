/* user profile property definition */
/* datatype:  1=text  2=switch 3=language  4=timezone 5=dictionary 6=uploadfile  7=requestlist 8=music 9=KeywordNumber 10=SwitchDevice */

/* account picture */
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,6,'','picture','userPhoto',100,false,'',1,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,6,'','picture','userPhoto2',100,false,'',1,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,6,'','picture','userPhoto3',100,false,'',1,true,0);

	/* account personalize */
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,7,'','personalize','defRequest',50,false,'',2,true,0);
		
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,5,'','personalize','season',20,false,'',3,true,0);
	
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,5,'','personalize','synCycle',10,false,'',4,true,0);
	
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','personalize','isSynTime',10,false,'',5,true,0);

insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,3,'','personalize','langCode',10,false,'',6,true,0);

insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,4,'','personalize','timeZone',10,false,'',7,true,0);



insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','notification','showAllNotification',10,false,'',1,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','notification','showHvacNotification',10,false,'',2,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,8,'','notification','notificationMusic',10,false,'',3,true,0);


insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','search','autoComplete',10,false,'',1,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','search','autoCompleteOrder',10,false,'',2,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,9,'','search','showKeywords',10,false,'',3,true,0);


insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,10,'','usability','switchDevice',10,false,'',1,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','usability','isHintSound',10,false,'',2,true,0);
insert into profilepropertydefinition(propertydefinitionid,deleted,datatype,defaultvalue,propertycategory,propertyname,length,required,validationexpression,vieworder,visible,defaultvisibility)
	values(uuid(),0,2,'','usability','isDdlClickConfirm',10,false,'',3,true,0);






	
	