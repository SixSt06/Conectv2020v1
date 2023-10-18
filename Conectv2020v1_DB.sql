-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS aoddbr;

-- Usar la base de datos
USE aoddbr;

-- Crear la tabla Administrativos
CREATE TABLE Administrativos (
    idAdministrativo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellidoP VARCHAR(50),
    apellidoM VARCHAR(50),
    edad INT,
    departamento VARCHAR(50)
);

-- Crear la tabla Clases
CREATE TABLE Clases (
    idClase INT AUTO_INCREMENT PRIMARY KEY,
    materia VARCHAR(50),
    salon VARCHAR(50),
    profesor VARCHAR(50),
    duracion INT
);

-- Crear la tabla Salones
CREATE TABLE Salones (
    idSalon INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    ubicacion VARCHAR(50),
    cantidadMax INT,
    canon VARCHAR(50),
    pintarron VARCHAR(50),
    ventanas VARCHAR(50),
    idClase INT,
    FOREIGN KEY (idClase) REFERENCES Clases(idClase)
);

-- Crear la tabla Edificios
CREATE TABLE Edificios (
    idEdificio INT AUTO_INCREMENT PRIMARY KEY,
    noSalones INT,
    ubicacion VARCHAR(50),
    pisos INT,
    idSalon INT,
    FOREIGN KEY (idSalon) REFERENCES Salones(idSalon)
);

-- Crear la tabla Usuarios
CREATE TABLE Usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    usuario VARCHAR(50),
    password VARCHAR(50)
);
