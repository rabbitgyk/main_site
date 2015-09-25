insert into baseuser (userName, password, extra) values 
('rabbit', 'jfe43439iirei4irie4i3i5453343iis', 'user is a person hey'), 
('qianjin', 'jfe43439iirei4irie4i3i5453343iis', 'user is a person hey');

alter table user add salt char(8);

alter table user rename BaseUser;

update user set salt='12345678';

select userName from baseuser where userId='1';

select 1 from dual;

CREATE TABLE baseuser (userId int NOT NULL AUTO_INCREMENT, userName varchar(50), password char(32), extra varchar(100), salt char(8), PRIMARY KEY (userId)) ENGINE=MyISAM DEFAULT CHARSET=utf8;

----设置自增长的起始值
alter table baseuser AUTO_INCREMENT=10000;

INSERT INTO baseuser (userId, userName, password, extra, salt) VALUES (0, '', '', '', '');
