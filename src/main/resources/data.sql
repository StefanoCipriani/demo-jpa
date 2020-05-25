insert into course(id,name) values (10001, 'Jpa in simple steps');
insert into course(id,name) values (10002, 'Java in simple steps');

insert into passport(id,number) values (40001, 'PS1');
insert into passport(id,number) values (40002, 'PS2');

insert into student(id,name,id_passaporto) values (20001, 'Mario',40001);
insert into student(id,name,id_passaporto) values (20002, 'Antonio',40002);



insert into review(id,stars,description, course_id) values (50001, '5', 'TOP',10001);
insert into review(id,stars,description, course_id) values (50002, '1', 'FLOP',10002);


insert into student_course (student_id, course_id) values (20001,10001);
insert into student_course (student_id, course_id) values (20002,10002);
insert into student_course (student_id, course_id) values (20002,10001);
insert into student_course (student_id, course_id) values (20001,10002);
