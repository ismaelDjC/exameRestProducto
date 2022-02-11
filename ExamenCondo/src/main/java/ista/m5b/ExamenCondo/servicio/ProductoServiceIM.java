package ista.m5b.ExamenCondo.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.m5b.ExamenCondo.modelo.Producto;
import ista.m5b.ExamenCondo.repositorio.ProductoRepository;


@Service
public class ProductoServiceIM implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> findAll() {
        
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
       
        return productoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
        
    }
    
}
