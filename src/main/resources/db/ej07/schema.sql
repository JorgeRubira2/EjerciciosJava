CREATE TABLE Clientes (
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(100),
    last_name       VARCHAR(150),
    title           VARCHAR(150),
    descripcion     VARCHAR(1000),
    primary_account VARCHAR(100),
    telefono        VARCHAR(20),
    email           VARCHAR(100),
    direccion       VARCHAR(200),
    city            VARCHAR(50),
    estado          VARCHAR(50),
    country         VARCHAR(50),
    codigo_postal   INTEGER(5)
);
