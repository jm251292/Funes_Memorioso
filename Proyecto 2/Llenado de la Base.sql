insert into usuario values (null, 'admin', md5('root'), 'Administrador',0);
insert into usuario values (null, 'migue', md5('asd'), 'Administrador',0);
insert into usuario values (null, 'natalia', md5('1234'), 'Usuario',0);
insert into usuario values (null, 'adriana', md5('asd123'), 'Usuario',0);
select * from usuario;

-- -------------------------------------------------
insert into tipoPersona values (null, 'Doctor');
insert into tipoPersona values (null, 'Abogado');
insert into tipoPersona values (null, 'Taxista');
insert into tipoPersona values (null, 'Profesor');
select * from tipoPersona;

-- ----------------------------------------------------

insert into persona values (null, 'Miguel', 'Vargas', 'Arias', '2-0707-0731', 'Masculino', '1992-12-25');
insert into persona values (null, 'Natalia', 'Vargas', 'Arias', '2-4562-7654', 'Femenino', '1994-04-26');
insert into persona values (null, 'Adriana', 'Martinez', '', '1-0245-8664', 'Femenino', '1987-08-27');
select * from persona;

-- -----------------------------------------------------

insert into usuarioxpersona values (null, 5, 1);
insert into usuarioxpersona values (null, 6, 2);
insert into usuarioxpersona values (null, 7, 3);
select * from usuarioxpersona;

-- -----------------------------------------------------

insert into categoria values (null, 'Ministerios');
insert into categoria values (null, 'Empresas');
insert into categoria values (null, 'Condominios');
insert into categoria values (null, 'Restaurantes');
select * from categoria;

-- -----------------------------------------------------

insert into ente values (null, 'TEC', '');
insert into ente values (null, 'MOPT', '123456789021');
insert into ente values (null, 'Pizza Hut', '');
select * from ente;

-- --------------------------------------------------------

