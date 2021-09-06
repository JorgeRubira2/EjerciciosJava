
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Cliente;
import com.jorgerubira.ejerciciosspringweb.entities.FicheroCSV;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FicheroCSVRepository extends JpaRepository<FicheroCSV, Long>{
    
}
