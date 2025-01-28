insert into user_details(id, username,birth_date)
values(1002,'Sravya1',current_date());
insert into user_details(id, username,birth_date)
values(1001,'Sravya',current_date());
insert into user_details(id, username,birth_date)
values(1003,'Sravya3',current_date());

insert into posts(id, user_id, description)
values(2001,1002,'Java');
insert into posts(id, user_id, description)
values(2002, 1002, 'Spring Boot');
insert into posts(id, user_id, description)
values(2003,1003, 'Python');
insert into posts(id, user_id, description)
values(2004, 1001, 'MySQL');
