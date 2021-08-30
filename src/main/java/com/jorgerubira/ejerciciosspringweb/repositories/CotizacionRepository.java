
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Cotiza;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CotizacionRepository extends JpaRepository<Cotiza, Integer> {
        public Cotiza findByTitulo(String titulo);

        public Cotiza findFirstByOrderByIdDesc();
}
