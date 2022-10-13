USE coder_dev;

INSERT INTO usuario (user_id, phone, age, name)
VALUES 
(1, '11111111', 20, 'Juan'),
(2, '22222222', 30, 'Roberto');

INSERT INTO sesion (session_id, device_uid, started_at, device_name, user_id)
VALUES 
(1, '#aaaaaa', '2022-10-11', 'Celular', 1),
(2, '#bbbbbbb', '2022-10-13', 'Laptop', 1);

SELECT * FROM usuario;
SELECT * FROM sesion;
SELECT * FROM sesion WHERE user_id=1

#LAZY LOADING
#1.
select 
	usuario0_.user_id as user_id1_2_0_, 
	usuario0_.phone as phone2_2_0_, 
	usuario0_.age as age3_2_0_, 
	usuario0_.name as name4_2_0_ 
from usuario usuario0_ where usuario0_.user_id=?;
#2
select 
	sesiones0_.user_id as user_id5_1_0_, 
	sesiones0_.session_id as session_1_1_0_, 
	sesiones0_.session_id as session_1_1_1_, 
	sesiones0_.device_uid as device_u2_1_1_, 
	sesiones0_.started_at as started_3_1_1_, 
	sesiones0_.device_name as device_n4_1_1_, 
	sesiones0_.user_id as user_id5_1_1_ 
from sesion sesiones0_ where sesiones0_.user_id=?

#EAGER LOADING
#1.
select 
	usuario0_.user_id as user_id1_2_0_, 
	usuario0_.phone as phone2_2_0_, 
	usuario0_.age as age3_2_0_, 
	usuario0_.name as name4_2_0_, 
	sesiones1_.user_id as user_id5_1_1_, 
	sesiones1_.session_id as session_1_1_1_, 
	sesiones1_.session_id as session_1_1_2_, 
	sesiones1_.device_uid as device_u2_1_2_, 
	sesiones1_.started_at as started_3_1_2_, 
	sesiones1_.device_name as device_n4_1_2_, 
	sesiones1_.user_id as user_id5_1_2_ 
from usuario usuario0_ 
left outer join sesion sesiones1_ 
	on usuario0_.user_id=sesiones1_.user_id 
    where usuario0_.user_id=?
