DROP table Cliente IF exists;

CREATE TABLE Cliente (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre          	VARCHAR(200),
    apellidos           VARCHAR(200),
    titulo              VARCHAR(200),
    email               VARCHAR(200),
    telefono            VARCHAR(200),
    cuenta    	 		VARCHAR(200),
    descripcion         VARCHAR(200),
    calle               VARCHAR(200),
    ciudad              VARCHAR(200),
    estado              VARCHAR(200),
    pais                VARCHAR(200),
    postal              INTEGER(5)
);
