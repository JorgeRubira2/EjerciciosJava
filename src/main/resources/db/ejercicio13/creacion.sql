/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Joche
 * Created: 3 sept. 2021
 */

CREATE TABLE Factura(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(200),
	direccion VARCHAR(200),
	nif VARCHAR(100),
	fecha DATE
	
);

CREATE TABLE DetallesFactura(
	id INT PRIMARY KEY AUTO_INCREMENT,
	descripcion VARCHAR(200),
	importe DOUBLE,
	id_factura INT REFERENCES Factura(id)	
);