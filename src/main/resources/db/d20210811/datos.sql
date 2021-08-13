INSERT INTO canciones (
	autor,titulo,fecha_publicacion,
	fecha_hora_ultima_reproduccion, activa,precio_reproduccion
)  values
( 'Juan', 'Cantar feliz', '2021-12-31','2021-02-28 03:12:11', TRUE, 2.2), 
( 'Ana', 'Salta', '2021-12-31', '2021-02-28 03:12:11', TRUE, 3.2),
( 'Pepe', 'Canciones', '2021-12-31', '2021-02-28 03:12:11', TRUE, 1.2);

INSERT INTO cliente ( id, first_name, last_name, title, primary_account, office_phone, email, description, direction, city) 
              VALUES (1,'Juan','Valdes','Cafetero','Cafes de Colombia','555 73 24 53','cafelitos@gmail.com','company of cafes and asociados','calle calor judia','Bogotá'),
                     (2,'Feliciana','kayle','joyas de segunda mano','Joyas para todos','555 87 87 54','telopillo@gmail.com','diamonds are best girls friends','plaza bendome','Milán');
    
