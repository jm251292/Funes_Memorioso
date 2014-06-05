SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ente` (
  `idente` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `CedulaJur` VARCHAR(45) NULL,
  PRIMARY KEY (`idente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sistema` (
  `idSistema` INT NOT NULL AUTO_INCREMENT,
  `ParametrizacionDenuncia` INT NOT NULL,
  PRIMARY KEY (`idSistema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Denuncia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Denuncia` (
  `idDenuncia` INT NOT NULL AUTO_INCREMENT,
  `Denuncia` VARCHAR(300) NOT NULL,
  `Privacidad` VARCHAR(45) NOT NULL,
  `Nombrdenuncia` VARCHAR(100) NOT NULL,
  `activado` BIT NULL DEFAULT 1,
  `Sistema_idSistema` INT NOT NULL,
  PRIMARY KEY (`idDenuncia`),
  INDEX `fk_Denuncia_Sistema1_idx` (`Sistema_idSistema` ASC),
  CONSTRAINT `fk_Denuncia_Sistema1`
    FOREIGN KEY (`Sistema_idSistema`)
    REFERENCES `mydb`.`Sistema` (`idSistema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`denunciaxente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`denunciaxente` (
  `idCalificacion` INT NOT NULL AUTO_INCREMENT,
  `Calificacion` INT NOT NULL,
  `ente_idente` INT NOT NULL,
  `Denuncia_idDenuncia` INT NOT NULL,
  PRIMARY KEY (`idCalificacion`),
  INDEX `fk_Calificacion_ente1_idx` (`ente_idente` ASC),
  INDEX `fk_denunciaxente_Denuncia1_idx` (`Denuncia_idDenuncia` ASC),
  CONSTRAINT `fk_Calificacion_ente1`
    FOREIGN KEY (`ente_idente`)
    REFERENCES `mydb`.`ente` (`idente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_denunciaxente_Denuncia1`
    FOREIGN KEY (`Denuncia_idDenuncia`)
    REFERENCES `mydb`.`Denuncia` (`idDenuncia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Provincia` (
  `idProvincia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProvincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pais` (
  `idPais` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPais`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Canton`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Canton` (
  `idCanton` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCanton`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Distrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Distrito` (
  `idDistrito` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDistrito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Barrio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Barrio` (
  `idBarrio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBarrio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`direccion` (
  `iddireccion` INT NOT NULL AUTO_INCREMENT,
  `DireccionGeneral` VARCHAR(400) NOT NULL,
  `ente_idente` INT NOT NULL,
  `Provincia_idProvincia` INT NOT NULL,
  `Pais_idPais` INT NOT NULL,
  `Canton_idCanton` INT NOT NULL,
  `Distrito_idDistrito` INT NOT NULL,
  `Barrio_idBarrio` INT NOT NULL,
  PRIMARY KEY (`iddireccion`),
  INDEX `fk_direccion_ente1_idx` (`ente_idente` ASC),
  INDEX `fk_direccion_Provincia1_idx` (`Provincia_idProvincia` ASC),
  INDEX `fk_direccion_Pais1_idx` (`Pais_idPais` ASC),
  INDEX `fk_direccion_Canton1_idx` (`Canton_idCanton` ASC),
  INDEX `fk_direccion_Distrito1_idx` (`Distrito_idDistrito` ASC),
  INDEX `fk_direccion_Barrio1_idx` (`Barrio_idBarrio` ASC),
  CONSTRAINT `fk_direccion_ente1`
    FOREIGN KEY (`ente_idente`)
    REFERENCES `mydb`.`ente` (`idente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_Provincia1`
    FOREIGN KEY (`Provincia_idProvincia`)
    REFERENCES `mydb`.`Provincia` (`idProvincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_Pais1`
    FOREIGN KEY (`Pais_idPais`)
    REFERENCES `mydb`.`Pais` (`idPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_Canton1`
    FOREIGN KEY (`Canton_idCanton`)
    REFERENCES `mydb`.`Canton` (`idCanton`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_Distrito1`
    FOREIGN KEY (`Distrito_idDistrito`)
    REFERENCES `mydb`.`Distrito` (`idDistrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direccion_Barrio1`
    FOREIGN KEY (`Barrio_idBarrio`)
    REFERENCES `mydb`.`Barrio` (`idBarrio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LugarTrabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LugarTrabajo` (
  `idLugarTrabajo` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLugarTrabajo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NULL,
  `Cedula` VARCHAR(45) NOT NULL,
  `Genero` VARCHAR(45) NOT NULL,
  `FechaNacimiento` DATE NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TipoPersona` (
  `idTipoPersona` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `Usuario` INT NOT NULL AUTO_INCREMENT,
  `Nick` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `Rol` VARCHAR(45) NOT NULL DEFAULT 'Usuario',
  `Bloqueado` BINARY NOT NULL DEFAULT 0,
  PRIMARY KEY (`Usuario`),
  UNIQUE INDEX `Nick_UNIQUE` (`Nick` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoxPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TipoxPersona` (
  `idTipoxPersona` INT NOT NULL AUTO_INCREMENT,
  `Persona_idPersona` INT NOT NULL,
  `TipoPersona_idTipoPersona` INT NOT NULL,
  PRIMARY KEY (`idTipoxPersona`),
  INDEX `fk_TipoxPersona_Persona1_idx` (`Persona_idPersona` ASC),
  INDEX `fk_TipoxPersona_TipoPersona1_idx` (`TipoPersona_idTipoPersona` ASC),
  CONSTRAINT `fk_TipoxPersona_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TipoxPersona_TipoPersona1`
    FOREIGN KEY (`TipoPersona_idTipoPersona`)
    REFERENCES `mydb`.`TipoPersona` (`idTipoPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoriaxente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoriaxente` (
  `idCategoriaxente` INT NOT NULL AUTO_INCREMENT,
  `ente_idente` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idCategoriaxente`),
  INDEX `fk_Categoriaxente_ente1_idx` (`ente_idente` ASC),
  INDEX `fk_Categoriaxente_Categoria1_idx` (`Categoria_idCategoria` ASC),
  CONSTRAINT `fk_Categoriaxente_ente1`
    FOREIGN KEY (`ente_idente`)
    REFERENCES `mydb`.`ente` (`idente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categoriaxente_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `mydb`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarioxDenuncia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuarioxDenuncia` (
  `idusuarioxDenuncia` INT NOT NULL AUTO_INCREMENT,
  `Usuario_Usuario` INT NOT NULL,
  `Denuncia_idDenuncia` INT NOT NULL,
  PRIMARY KEY (`idusuarioxDenuncia`),
  INDEX `fk_usuarioxDenuncia_Usuario1_idx` (`Usuario_Usuario` ASC),
  INDEX `fk_usuarioxDenuncia_Denuncia1_idx` (`Denuncia_idDenuncia` ASC),
  CONSTRAINT `fk_usuarioxDenuncia_Usuario1`
    FOREIGN KEY (`Usuario_Usuario`)
    REFERENCES `mydb`.`Usuario` (`Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarioxDenuncia_Denuncia1`
    FOREIGN KEY (`Denuncia_idDenuncia`)
    REFERENCES `mydb`.`Denuncia` (`idDenuncia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Archivo` (
  `idArchivo` INT NOT NULL AUTO_INCREMENT,
  `Fuente` VARCHAR(100) NOT NULL,
  `Denuncia_idDenuncia` INT NOT NULL,
  PRIMARY KEY (`idArchivo`),
  INDEX `fk_Archivos_Denuncia1_idx` (`Denuncia_idDenuncia` ASC),
  CONSTRAINT `fk_Archivos_Denuncia1`
    FOREIGN KEY (`Denuncia_idDenuncia`)
    REFERENCES `mydb`.`Denuncia` (`idDenuncia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DenunciaxPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DenunciaxPersona` (
  `idDenunciaxPersona` INT NOT NULL AUTO_INCREMENT,
  `Calificacion` INT NOT NULL,
  `Denuncia_idDenuncia` INT NOT NULL,
  `Persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idDenunciaxPersona`),
  INDEX `fk_DenunciaxPersona_Denuncia1_idx` (`Denuncia_idDenuncia` ASC),
  INDEX `fk_DenunciaxPersona_Persona1_idx` (`Persona_idPersona` ASC),
  CONSTRAINT `fk_DenunciaxPersona_Denuncia1`
    FOREIGN KEY (`Denuncia_idDenuncia`)
    REFERENCES `mydb`.`Denuncia` (`idDenuncia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DenunciaxPersona_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UsuarioxPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UsuarioxPersona` (
  `idUsuarioxPersona` INT NOT NULL AUTO_INCREMENT,
  `Usuario_Usuario` INT NOT NULL,
  `Persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idUsuarioxPersona`),
  INDEX `fk_UsuarioxPersona_Usuario1_idx` (`Usuario_Usuario` ASC),
  INDEX `fk_UsuarioxPersona_Persona1_idx` (`Persona_idPersona` ASC),
  CONSTRAINT `fk_UsuarioxPersona_Usuario1`
    FOREIGN KEY (`Usuario_Usuario`)
    REFERENCES `mydb`.`Usuario` (`Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioxPersona_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PersonaxTrabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PersonaxTrabajo` (
  `idPersonaxTrabajo` INT NOT NULL,
  `Persona_idPersona1` INT NOT NULL,
  `LugarTrabajo_idLugarTrabajo` INT NOT NULL,
  PRIMARY KEY (`idPersonaxTrabajo`),
  INDEX `fk_PersonaxTrabajo_Persona1_idx` (`Persona_idPersona1` ASC),
  INDEX `fk_PersonaxTrabajo_LugarTrabajo1_idx` (`LugarTrabajo_idLugarTrabajo` ASC),
  CONSTRAINT `fk_PersonaxTrabajo_Persona1`
    FOREIGN KEY (`Persona_idPersona1`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaxTrabajo_LugarTrabajo1`
    FOREIGN KEY (`LugarTrabajo_idLugarTrabajo`)
    REFERENCES `mydb`.`LugarTrabajo` (`idLugarTrabajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reporte` (
  `idreporte` INT NOT NULL AUTO_INCREMENT,
  `razon` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idreporte`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`historial` (
  `idhistorial` INT NOT NULL AUTO_INCREMENT,
  `Usuario_Usuario` INT NOT NULL,
  `reporte_idreporte` INT NOT NULL,
  PRIMARY KEY (`idhistorial`),
  INDEX `fk_historial_Usuario1_idx` (`Usuario_Usuario` ASC),
  INDEX `fk_historial_reporte1_idx` (`reporte_idreporte` ASC),
  CONSTRAINT `fk_historial_Usuario1`
    FOREIGN KEY (`Usuario_Usuario`)
    REFERENCES `mydb`.`Usuario` (`Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historial_reporte1`
    FOREIGN KEY (`reporte_idreporte`)
    REFERENCES `mydb`.`reporte` (`idreporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;

-- -----------------------------------------------------
-- procedure proyeccion
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `proyeccion` ()
BEGIN
	select * from usuarios;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ins_persona
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `ins_persona` (IN nom VARCHAR(45), IN ape1 VARCHAR(45), IN ape2 VARCHAR(45), 
IN Ced VARCHAR(45), IN Gen VARCHAR(45), IN fecha DATE, in nombretipopersona VARCHAR(50))

BEGIN

	declare idtipopers varchar(45);
	declare idpers varchar(45);	
	declare existe INT;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	
	insert into persona( nombre, apellido1, apellido2, Cedula, genero, FechaNacimiento) 
	values (nom, ape1, ape2, ced, gen, fecha); 
	select count(*) into existe from tipoPersona where Nombre= nombretipopersona;

	BEGIN
		SET error=1;
	END;

	if (existe=0)
	THEN
		insert INTO tipoPersona values (null, nombretipopersona);
	else 
		select idpersona into idpers from Persona where Cedula= ced limit 1;
		select idtipopersona into idtipopers from tipoPersona where Nombre= nombretipopersona limit 1;
		insert into tipoxpersona values (null, idpers, idtipopers);
	end if;
	
	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	end if;
	
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ins_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `ins_categoria` (in nom varchar(100))
BEGIN
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;
	insert into categoria(idCategoria, Nombre) values (NULL, nom); 

	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	end if;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_personaNom
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_personaNom` (IN nom VARCHAR(45))
BEGIN
select nombre, apellido1, apellido2 from persona 
	WHERE nombre = nom order by Nombre; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_personaApe1
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_personaApe1` (IN apellido VARCHAR(45))
BEGIN
	select nombre, apellido1, apellido2 from persona 
	WHERE apellido1 = apellido order by apellido1, apellido2; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_personaApe2
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_personaApe2` (IN apellido VARCHAR(45))
BEGIN
select nombre, apellido1, apellido2 from persona 
	WHERE apellido2 = apellido order by apellido2, apellido1; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_personaCed
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_personaCed` (IN ced VARCHAR(45))
BEGIN
select nombre, apellido1, apellido2 from persona 
	WHERE Cedula = ced order by apellido1; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_enteNom
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_enteNom` (IN nom VARCHAR(45))
BEGIN
select * from ente 
	WHERE Nombre = nom order by nombre; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_enteCed
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_enteCed` (IN ced VARCHAR(45))
BEGIN
select nombre, cedula from ente 
	WHERE Cedula = ced order by nombre; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure get_TipoPersonaGEN
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `get_TipoPersonaGEN` ()
BEGIN
select Nombre from tipopersona order by nombre; END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure registrarUsuarios
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `registrarUsuarios` (in nic varchar(100), in pass varchar(100), in roll varchar(100), in ID varchar(50))
BEGIN
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	insert into Usuario (nick, contraseña, rol, bloqueado) values (nic, md5(pass), roll, false);	
	insert into UsuarioxPersona (Usuario_Usuario,Persona_idPersona) values ((select max(Usuario) from Usuario limit 1), (select idPersona from Persona where cedula= ID limit 1));
	
	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure retornarPersonasSinCuenta
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `retornarPersonasSinCuenta` ()
BEGIN
	select * from persona where persona.idPersona not in ( select Persona_idPersona from UsuarioxPersona) order by Apellido1;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure login
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `login` (in nic varchar(100), in pass varchar(100), in roll varchar(100))
BEGIN
	select count(*) from usuario where nick = nic and contraseña = md5(pass) and rol = roll and bloqueado = false;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure retornarEntidad
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `retornarEntidad` (in nom varchar(100))
BEGIN
select * from ente where (nombre = nom);
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getCategoriaGEN
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `getCategoriaGEN` ()
BEGIN
	select * from categoria ORDER by Nombre;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ins_Ente
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `ins_Ente` (in nom varchar(50), in ced varchar(50), in nombreCategoria varchar(50), in Country varchar(50), 
in prov varchar(50), in can varchar(50), in dist varchar(50), in bar varchar(50), in direccion VARCHAR(400))

BEGIN
	
	declare idcat varchar(45);
	declare idpai varchar(45);
	declare idpro varchar(45);
	declare idcan varchar(45);
	declare idbar varchar(45);
	declare iddis varchar(45);
	declare idinstitucion varchar(45);	
	declare existe INT;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	insert into ente values (null, nom, cedula);
	select idente into idinstitucion from ente where Nombre= nom limit 1;
	select idcategoria into idcat from categoria where Nombre= nombreCategoria limit 1;
	insert into categoriaxente values (null, idinstitucion, idcat);
	
	if (country not in (select nombre from pais)) THEN
		insert into pais values (null, country);
	end if;

	select idpais into idpai from pais where Nombre= country limit 1;

	if (prov not in (select nombre from provincia)) THEN
		insert into provincia values (null, prov);
	end if;

	select idprovincia into idpro from provincia where Nombre= prov limit 1;

	if (dist not in (select nombre from distrito)) THEN
		insert into distrito values (null, dist);
	end if;

	select iddistrito into iddis from distrito where Nombre= dist limit 1;

	if (can not in (select nombre from canton)) THEN
		insert into canton values (null, can);
	end if;

	select idcanton into idcan from canton where Nombre= can limit 1;

	if (bar not in (select nombre from barrio)) THEN
		insert into barrio values (null, bar);
	end if;

	select idbarrio into idbar from barrio where Nombre= bar limit 1;

	insert into direccion values (null, direccion,idinstitucion,idpro,idpai ,idcan,iddis,idbar);

	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure retornarCategoria
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `retornarCategoria` (in nom varchar(100))
BEGIN
	select nombre from categoria where nombre = nom;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ins_tipoPersona
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `ins_tipoPersona` (in nom varchar(100))
BEGIN
	declare existe int;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	select count(*) from tipopersona where NOMBRE = nom;

	IF(existe=0) then
		insert into tipoPersona(idTipoPersona, Nombre) values (NULL, nom);
		select nombre from tipopersona where nombre=nom;	
	end if;
	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getTipoPersonas
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `getTipoPersonas` (in nom varchar(100))
BEGIN
	select * from tipopersona where nombre = nom;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure retornarUsuario
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `retornarUsuario` (in Nombre varchar(100))
BEGIN
select * from usuario where Nick = Nombre;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure agregarArchivoDenuncia
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `agregarArchivoDenuncia` (in FileName varchar(100), in nom varchar(100))
BEGIN
	declare idDen int;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	select idDenuncia into idDen from denuncia where Nombre= nom limit 1;
	insert into archivo values (null, fileName, idDen);

	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure agregarPersonaDenuncia
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `agregarPersonaDenuncia` (in ced varchar(50), in nom varchar(100))
BEGIN
	declare idPer int;
	declare idDen int;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	select idPersona into idPer from persona where cedula = ced;
	select idDenuncia into idDen from denuncia where nombre = nom ;
	insert into denunciaxpersona values(null, idDen, idPer);

	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure InsertarDenunciaPersona
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `InsertarDenunciaPersona` (in texto varchar(300), in privacidad varchar(45), in nomden varchar(45), in ced varchar(50), in nota int)
BEGIN
	declare idPer int;
	declare idDen int;
	DECLARE error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		SET error=1;
	END;

	select idPersona into idPer from persona where cedula = ced;
	select idDenuncia into idDen from denuncia where nombre = nom ;
	insert into denunciaxpersona values(null,nota, idDen, idPer);
	insert into denuncia values (null, texto, privacidad, nomden);
	
	IF error=1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getAllDenuncias
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `getAllDenuncias` ()
BEGIN
	select * from Denuncia;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getArchivosxDenuncia
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `getArchivosxDenuncia` (in nom varchar(45), in filaName varchar(45))
BEGIN
	declare idDen int;
	select iddenuncia into idDen from denuncia where nombre = nom;
	select * from archivos where denuncia_idDenuncia = idDen;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure getDenunciaxPersona
-- -----------------------------------------------------

DELIMITER $$
USE `mydb`$$
CREATE PROCEDURE `getDenunciaxPersona` (in nom varchar(45))
BEGIN
	declare idDen int;
	select iddenuncia into idDen from denuncia where nombre = nom;
	select nombre, cedula, apellido1 from Persona inner join denunciaxPersona on Persona.idPersona=DenunciaxPersona.Persona_idPersona where DenunciaxPersona.denuncia_idDenuncia = idDen;
	
END;$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
