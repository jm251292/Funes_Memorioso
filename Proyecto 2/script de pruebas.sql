
use mydb;
select * from mydb.archivo;
select * from denuncia;
select * from archivo;
select * from usuarioxdenuncia;
select * from categoriaxente;
insert into sistema values (null, 10);
call actualizardenuncia("contaminacion","esta empresa tira desechos al rio por no comprar una planta de tratamiento");
delete from denuncia where Nombrdenuncia="contaminacion";
delete from archivo;
update denuncia set activado=1 ;


call retornarDenunciasUsuario("admin");

call InsertarDenunciaEnte('esta empresa tira desechos al rio por no reparar su planta de tratamiento','Público','contaminacion','Durman Ezquivel',2);

call login('deby','terminales','Usuario');
select idPersona from Persona where cedula= '1-2345-6789' limit 1;
insert into usuarioxpersona (usuario_usuario, Persona_idPersona) values (7,1);
select idcategoria from categoria where Nombre= 'empresa' limit 1;
select * from categoriaxente;



drop procedure retornarDenunciasUsuario;

DELIMITER $$

CREATE PROCEDURE `actualizardenuncia` (in nom varchar(45), in texto varchar(300))
BEGIN
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;
	
	update Denuncia set denuncia=texto where nombrdenuncia=nom;
	
	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END