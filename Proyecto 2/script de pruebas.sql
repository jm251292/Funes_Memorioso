select * from persona;

delete from tipopersona where idtipopersona =1;

call ins_persona('Natalia','Vargas','Arias','2-9483-5824','Femenino','1994-04-26','Estudiante universitario');

call login('deby','terminales','Usuario');
select idPersona from Persona where cedula= '1-2345-6789' limit 1;
insert into usuarioxpersona (usuario_usuario, Persona_idPersona) values (7,1);
drop procedure ins_persona;
DELIMITER $$

CREATE PROCEDURE `ins_persona` (IN nom VARCHAR(45), IN ape1 VARCHAR(45), IN ape2 VARCHAR(45), 
IN Ced VARCHAR(45), IN Gen VARCHAR(45), IN fecha DATE, in nombretipopersona VARCHAR(50))

BEGIN

	declare idtipopers varchar(45);
	declare idpers varchar(45);	
	declare existe INT;

	insert into persona( nombre, apellido1, apellido2, Cedula, genero, FechaNacimiento) 
	values (nom, ape1, ape2, ced, gen, fecha); 
	select count(*) into existe from tipoPersona where Nombre= nombretipopersona;

	if (existe=0)
	THEN
		insert INTO tipoPersona values (null, nombretipopersona);
	else 
		select idpersona into idpers from Persona where Cedula= ced limit 1;
		select idtipopersona into idtipopers from tipoPersona where Nombre= nombretipopersona limit 1;
		insert into tipoxpersona values (null, idpers, idtipopers);
	end if;
END;

delete Persona on cascade;
show

select * from ente;
select * from tipoPersona;
select * from TipoxPersona;
select * from usuario;
select * from categoria;
select * from categoriaxente;

