use  colegio;
CREATE TABLE alumnos (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    grado VARCHAR(20),
    seccion VARCHAR(5),
    id_apoderado INT,
    FOREIGN KEY (id_apoderado) REFERENCES apoderados(id_apoderado)
);
CREATE TABLE apoderados (
    id_apoderado INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    email VARCHAR(50)
);
CREATE TABLE docentes (
    id_docente INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    grado_asignado VARCHAR(20),
    curso VARCHAR(50)
);
CREATE TABLE notas (
    id_nota INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT,
    curso VARCHAR(50),
    nota_practica1 DECIMAL(5,2),
    nota_practica2 DECIMAL(5,2),
    nota_final DECIMAL(5,2),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id_alumno)
);
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Encriptar con bcrypt en backend
    rol ENUM('alumno', 'docente', 'administrador') NOT NULL,
    id_relacionado INT -- ID de la tabla correspondiente (alumno, docente, etc.)
);
select*from docentes


