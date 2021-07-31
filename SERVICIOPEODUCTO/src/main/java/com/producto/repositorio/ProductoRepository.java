package com.producto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.producto.modelo.producto;

public interface ProductoRepository extends JpaRepository<producto, Long>{

	
}
