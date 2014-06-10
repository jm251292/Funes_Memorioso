
use mydb;
select * from ente;
select * from direccion;
select * from sistema;
select * from calificacion;
select * from categoriaxente;
insert into sistema values (null, 10);
call actualizardenuncia("contaminacion","esta empresa tira desechos al rio por no comprar una planta de tratamiento");
delete from denuncia where Nombrdenuncia="contaminacion";
delete from archivo;
update denuncia set activado=1 ;
alter table historial add 

call insertarLimiteReporte(10);
select * from denuncia;


drop procedure get_enteced;




DELIMITER $$

CREATE PROCEDURE `insertarLimiteReporte` (in cant int)
BEGIN
	update Sistema set ParametrizacionDenuncia= cant where idsistema=1;
END


DELIMITER $$

CREATE PROCEDURE `getbarrio` (in nom varchar(45))
BEGIN
	declare idE int;
	declare idp int;
	select idente into idE from ente where Nombre = nom;
	select barrio_idbarrio into idp from Direccion where ente_idente= idE;
	select nombre from barrio where idbarrio=idp;
END

call InsertarDenunciaEnte('esta empresa tira desechos al rio por no reparar su planta de tratamiento','Público','contaminacion','Durman Ezquivel',2);

call insertarreporte('Estaba llevando a mi abuela al hospital por eso irrespete las reglas de transito','migue');
select idPersona from Persona where cedula= '1-2345-6789' limit 1;
insert into usuarioxpersona (usuario_usuario, Persona_idPersona) values (7,1);
select idcategoria from categoria where Nombre= 'empresa' limit 1;
select * from categoriaxente;