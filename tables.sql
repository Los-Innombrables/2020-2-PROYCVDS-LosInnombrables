create table if not exists Laboratorio (
	id serial primary key,
	nombre varchar(50) not null,
	fechaDeCreacion date not null,
	fechaDeCierre date null,
	activo boolean not null
);

create table if not exists TipoElemento (
	nombre varchar(50) primary key,
	descripcion varchar(500) null
);

create table if not exists Rol (
	id serial primary key,
	nombre varchar(50) unique not null,
	descripcion varchar(500) not null
);

create table if not exists Usuario (
	carnet int primary key,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	correo varchar(50) unique not null,
	username varchar(50) unique not null,
	passwd varchar(260) not null,
	activo boolean not null,
	rol int not null,
	constraint fk_Usuario_Rol foreign key (rol) references Rol(id)
);

create table if not exists Equipo (
	id serial primary key,
	nombre varchar(50) not null,
	laboratorio int null,
	activo boolean not null,
	constraint fk_Equipo_Laboratorio foreign key (laboratorio) references Laboratorio(id)
);

create table if not exists Elemento (
	id serial primary key,
	tipo varchar(50) not null,
	equipo int null,
	marca varchar(50) not null,
	referencia varchar(50) not null,
	fechaDeRegistro date not null,
	activo boolean not null,
	constraint fk_Elemento_TipoElemento foreign key(tipo) references TipoElemento(nombre),
	constraint fk_Elemento_Equipo foreign key(equipo) references Equipo(id)
);

create table if not exists Novedad (
	id serial primary key,
	responsable int not null,
	equipo int null,
	elemento int null,
	fecha date not null,
	titulo varchar(50) not null,
	novedad varchar(500) not null,
	constraint fk_Novedad_Usuario foreign key(responsable) references Usuario(carnet),
	constraint fk_Novedad_Equipo foreign key(equipo) references Equipo(id),
	constraint fk_Novedad_Elemento foreign key(elemento) references Elemento(id)
);
