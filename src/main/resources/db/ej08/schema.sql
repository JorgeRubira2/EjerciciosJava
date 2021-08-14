CREATE TABLE cotizacion (
    id                      INTEGER PRIMARY KEY AUTO_INCREMENT,
    titulo                  VARCHAR(200),
    tipo_operacion          VARCHAR(200),
    cantidad                INTEGER,
    fecha_operacion_inicio  DATETIME,
    precio_inicial          DECIMAL(20,2),
    fecha_operacion_final   DATETIME,
    precio_final            DECIMAL(20,2)
);


