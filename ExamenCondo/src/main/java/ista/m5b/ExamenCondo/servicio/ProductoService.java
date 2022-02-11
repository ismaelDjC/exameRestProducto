package ista.m5b.ExamenCondo.servicio;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ista.m5b.ExamenCondo.modelo.Producto;

public interface ProductoService {
    public Iterable<Producto> findAll();

    public Page<Producto> findAll(Pageable pageable);
    
    public Optional<Producto>findById(Long id);

    public Producto save (Producto producto);

    public void deleteById(Long id);
    
    
}
