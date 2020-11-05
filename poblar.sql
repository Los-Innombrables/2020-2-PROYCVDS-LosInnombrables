-- Roles: --
INSERT INTO rol(id, nombre, descripcion)
VALUES(1, 'Administrador', 'Este rol sera el encargado de administrar la plataforma');

INSERT INTO rol(id, nombre, descripcion)
VALUES(2, 'Profesor', 'Este rol sera el encargado de realizar todos los procesos de la plataforma exceptuando el de ingresar usuarios');

INSERT INTO rol (id, nombre, descripcion)
VALUES(3, 'Estudiante', 'Este rol sera el encargado de entrar a la plataforma y tener privilegios de usuario');

-- Usuarios: --
-- Admin - "andagui"
INSERT INTO usuario(carnet, nombre, apellido, correo, username, passwd, activo, rol)
VALUES(2144211, 'Homero', 'simpson', 'homero.simpson@mail.escuelaing.edu.co', 'homie.simpson', 'a4e5c1418bdae16978bb91c2cffac2dd972ec15bb99f501e8788dde940cb0235', true, 1);
-- Profesor - "oscar.ospina"
INSERT INTO usuario(carnet, nombre, apellido, correo, username, passwd, activo, rol)
VALUES(2144801, 'Oscar', 'Ospina', 'oscar.ospina@mail.escuelaing.edu.co', 'oscar.ospina', '565e8e58e644ce8473aa4548b3cf52bff8a87a5c5b05d2d2c087c9cb2bb8e410', true, 2);
-- Estudiantes - "estudiantes"
INSERT INTO usuario(carnet, nombre, apellido, correo, username, passwd, activo, rol)
VALUES(2144123, 'Daniel', 'Rincon', 'daniel.rincon-r@mail.escuelaing.edu.co', 'daniel.rincon-r', 'f9b4a37722d6b48c61d8e38be9241cd53549e86c491c0c23ff0fcb5e0f32ae3c', true, 3);

INSERT INTO usuario(carnet, nombre, apellido, correo, username, passwd, activo, rol)
VALUES(2144456, 'Guillermo', 'Castro', 'guillermo.castro@mail.escuelaing.edu.co', 'guillermo.castro', 'f9b4a37722d6b48c61d8e38be9241cd53549e86c491c0c23ff0fcb5e0f32ae3c', true, 3);

INSERT INTO usuario(carnet, nombre, apellido, correo, username, passwd, activo, rol)
VALUES(2144828, 'Andres', 'Calderon', 'andres.calderon-o@mail.escuelaing.edu.co', 'andres.calderon-o', 'f9b4a37722d6b48c61d8e38be9241cd53549e86c491c0c23ff0fcb5e0f32ae3c', true, 3);

-- Laboratorios: --
INSERT INTO laboratorio(id, nombre, fechadecreacion, fechadecierre, activo)
VALUES(0, '--------------------------------', '2020-10-31', '2020-10-31', true);

INSERT INTO laboratorio(id, nombre, fechadecreacion, fechadecierre, activo)
VALUES(1, 'Plataformas Computacionales', '2012-09-12', null, true);

INSERT INTO laboratorio(id, nombre, fechadecreacion, fechadecierre, activo)
VALUES(2, 'Multimedia y Moviles', '2014-06-29', null, true);

-- TipoElemento: --
INSERT INTO tipoelemento(nombre, descripcion)
VALUES('Torre', 'Caja donde se montan y conectan todos los dispositivos que componen la unidad central de la computadora personal.');

INSERT INTO tipoelemento(nombre, descripcion)
VALUES('Pantalla', 'Dispositivo que permite la visualizaci�n de datos');

INSERT INTO tipoelemento(nombre, descripcion)
VALUES('Mouse', 'Dispositivo apuntador utilizado para facilitar el manejo de un entorno gr�fico en una computadora.');

INSERT INTO tipoelemento(nombre, descripcion)
VALUES('Teclado', 'Dispositivo que presenta el conjunto de las teclas de diversos aparatos, m�quinas e instrumentos.');

-- Equipos:
INSERT INTO equipo(id, nombre, laboratorio, activo)
VALUES(0, '----------------', 0, true);

INSERT INTO equipo(id, nombre, laboratorio, activo)
VALUES(1,'PC_Lab1', 1, true);

INSERT INTO equipo(id, nombre, laboratorio, activo)
VALUES(2,'PC_Lab2', 2, true);

INSERT INTO equipo(id, nombre, laboratorio, activo)
VALUES(3,'PC_Lab3', 2, true);


-- Elemento: --
INSERT INTO elemento(id, tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES(0, 'Torre', 1, 'Null', 'Null', '11-01-2020', false);
-- Torres
INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Torre', 1, 'Asus', '13121', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Torre', 2, 'Asus', '32432', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Torre', 3, 'Asus', '87654', '11-01-2020', true);

-- Pantallas
INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Pantalla', 1, 'Samsung', 'fa43', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Pantalla', 2, 'Samsung', 'dsf123', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Pantalla', 3, 'Samsung', 'hgg321', '11-01-2020', true);

-- Mouse
INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Mouse', 1, 'LogiTech', 'g261', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Mouse', 2, 'LogiTech', 'g84d', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Mouse', 3, 'LogiTech', 'g923', '11-01-2020', true);

-- Teclado
INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Teclado', 1, 'Genius', 'd432', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Teclado', 2, 'Genius', 'd431', '11-01-2020', true);

INSERT INTO elemento(tipo, equipo, marca, referencia, fechaderegistro, activo)
VALUES('Teclado', 3, 'Genius', 'd462', '11-01-2020', true);

-- Novedades: --
INSERT INTO novedad(responsable, equipo, elemento, fecha, titulo, novedad)
VALUES(2144211, 1, null, '11-01-2020', 'RegistroPC', 'Se registro un Nuevo Computador');

INSERT INTO novedad(responsable, equipo, elemento, fecha, titulo, novedad)
VALUES(2144211, 2, null, '11-01-2020', 'RegistroPC', 'Se registro un Nuevo Computador');

INSERT INTO novedad(responsable, equipo, elemento, fecha, titulo, novedad)
VALUES(2144211, 3, null, '11-01-2020', 'RegistroPC', 'Se registro un Nuevo Computador');