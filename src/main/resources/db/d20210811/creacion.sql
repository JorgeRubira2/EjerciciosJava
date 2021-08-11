CREATE TABLE Canciones (
	id INT PRIMARY KEY AUTO_INCREMENT,
	autor VARCHAR(200),
	titulo VARCHAR(200),
	fecha_publicacion DATE,
	fecha_hora_ultima_reproduccion DATETIME,
	activa BOOLEAN,
	precio_reproduccion DECIMAL(18,2)
);

Create table Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(100) not null,
    last_name       varchar(200),
    title           varchar(60),
    primary_account VARCHAR(60),
    office_phone    VARCHAR(40),
    email           VARCHAR(100),
    description     VARCHAR(1000),
    direction       VARCHAR(1000),
    city            VARCHAR(200)
    
);
