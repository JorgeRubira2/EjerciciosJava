/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Joche
 * Created: 3 sept. 2021
 */

CREATE TABLE carreras_universidad(
        curso_academico INT,
	estudio VARCHAR(200),
	localidad VARCHAR(50),
	centro VARCHAR(100),
	tipo_centro VARCHAR(50),
	tipo_estudido VARCHAR(50),
	plazas_ofertadas INT,
	plazas_matriculadas INT,
	plazas_solicitadas INT,
	indice_ocupacion DOUBLE,
	fecha_actualizacion DATE
);