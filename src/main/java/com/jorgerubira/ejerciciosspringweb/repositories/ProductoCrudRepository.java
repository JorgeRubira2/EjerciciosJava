
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaces de repository: CrudRepository: Algoritmos básicos para lecturas y
 * modificaciones. Devuelve IEnumerable y Optional PagingAndSortingRepository:
 * Permite el paginado de las tablas. Devuelve IEnumerable JpaRepository:
 * Permite gran cantidad de operaciones. Devuelve List.
 *
 * Cuando utilizar uno u otro: IEnumerable: Para gran cantidad de datos o muchos
 * usuarios. No es necesario hacer búsquedas ni tratar los datos. Unicamente
 * devolverlos o copiarlos a otro sitio. List: Para menor volumen de datos.
 * Permite hacer búsquedas, conversiones o tratarlos con stream().
 */

public interface ProductoCrudRepository extends JpaRepository<Producto, Long> {
}
