
drop table if exists alumnos;
DROP TABLE if exists matriculas;

CREATE TABLE IF NOT EXISTS alumnos(
	DNI varchar(9) NOT NULL,
     Nombre varchar(50) NOT NULL,
     Apellidos varchar(70) NOT NULL,
     Direccion varchar(100) NOT NULL,
     FechaNac date NOT NULL,
PRIMARY KEY (DNI)) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS matriculas (
     DNI varchar(9) NOT NULL,
     NombreModulo varchar(60) NOT NULL,
     Curso varchar(5) NOT NULL,
     Nota double NOT NULL,
 FOREIGN KEY (DNI) references alumnos(DNI))
 ENGINE=MyISAM DEFAULT CHARSET=latin1;
 
 INSERT INTO alumnos VALUES(
 '12345678A', 'José Alberto', 'González Pérez', 'C/Albahaca, nº14, 1ºD', '1986-07-15'),
('23456789B', 'Almudena', 'Cantero Verdemar', 'Avd/ Profesor Alvarado, n27, 8ºA', '1988-11-04'),
('14785236D', 'Martín', 'Díaz Jiménez', 'C/Luis de Gongora, nº2.', '1987-03-09'),
('96385274F', 'Lucas', 'Buendia Portes', 'C/Pintor Sorolla, nº 16, 4ºB', '1988-07-10');
 
 INSERT INTO matriculas VALUES
('12345678A', 'Acceso a datos', '23-24', 5.75),
('23456789B', 'Desarrollo interfaces', '23-24', 7.0),
('14785236D', 'Programación de servicios y procesos', '23-24', 6.2),
('96385274F', 'Bases de datos', '23-24', 7.4),
('12345678A', 'Programación', '23-24', 5.75),
('14785236D', 'Desarrollo interfaces', '23-24', 8.25),
('23456789B', 'Acceso a datos', '23-24', 2.2);

