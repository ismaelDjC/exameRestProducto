package ista.m5b.ExamenCondo.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import ista.m5b.ExamenCondo.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
    
}
