
package com.ejercicio.proyectoFinal.repository;

import com.ejercicio.proyectoFinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long> {
    
}
