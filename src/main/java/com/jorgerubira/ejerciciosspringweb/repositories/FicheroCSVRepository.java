
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FicheroCSVRepository extends JpaRepository<Cliente, Long>{
    
}
