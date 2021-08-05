DROP TABLE Productos IF EXISTS;

CREATE TABLE Productos (
  id           INTEGER PRIMARY KEY AUTO_INCREMENT,
  referencia   VARCHAR(20) NOT NULL,
  nombre       VARCHAR(200),
  precio_venta NUMERIC(18,2),
  activo       BOOLEAN
);
