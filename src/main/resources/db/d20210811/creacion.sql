CREATE TABLE Canciones (
	id INT PRIMARY KEY AUTO_INCREMENT,
	autor VARCHAR(200),
	titulo VARCHAR(200),
	fecha_publicacion DATE,
	fecha_hora_ultima_reproduccion DATETIME,
	activa BOOLEAN,
	precio_reproduccion DECIMAL(18,2)
);
INSERT INTO Canciones (
	autor,titulo,fecha_publicacion,
	fecha_hora_ultima_reproduccion, activa,precio_reproduccion
)  values
( 'Juan', 'Cantar feliz', '2021-12-31','2021-02-28 03:12:11', TRUE, 2.2), 
( 'Ana', 'Salta', '2021-12-31', '2021-02-28 03:12:11', TRUE, 3.2),
( 'Pepe', 'Canciones', '2021-12-31', '2021-02-28 03:12:11', TRUE, 1.2);

