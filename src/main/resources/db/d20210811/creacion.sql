CREATE TABLE Canciones (
	id INT PRIMARY KEY AUTO_INCREMENT,
	autor VARCHAR(200),
	titulo VARCHAR(200),
	fecha_publicacion DATE,
	fecha_hora_ultima_reproduccion DATETIME,
	activa BOOLEAN,
	precio_reproduccion DECIMAL(18,2)
);
