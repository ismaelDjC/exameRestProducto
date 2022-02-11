package ista.m5b.ExamenCondo.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.m5b.ExamenCondo.modelo.Producto;
import ista.m5b.ExamenCondo.servicio.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {



    /*
    HTTP GET -> obtener: Listar
    HTTP POST -> enviar: Crear/Insertar
    HTTP PUT -> modifica información: Actualizar
    HTTP DELETE -> elimina información: Eliminar 
    */ 
    @Autowired
    private ProductoService pdService;

    //CREAR NUEVO USUARIO
    @PostMapping("/productoCrear")
    public ResponseEntity<?> create(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pdService.save(producto));
    }

    //LISTAR-ID
    @GetMapping("/listarproducto-ID/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="id")Long pId){

        Optional<Producto> pd = pdService.findById(pId);

        if(!pd.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pd);

    }

    //lISTA -TODOS LOS USUARIOS
    @GetMapping("/listar-productos")
    public List<Producto>readAll(){

        List<Producto> users =StreamSupport
        .stream(pdService.findAll().spliterator(),false)
        .collect(Collectors.toList());
        return  users;

        
    }
    

    //ACTUALIZAR
    @PutMapping("/productoModificar/{id}")
    public ResponseEntity<?> update(@RequestBody Producto pDetails,@PathVariable(value ="id") long pId){

        Optional<Producto> prod = pdService.findById(pId);

        if(!prod.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        prod.get().setDescripcion(pDetails.getDescripcion());
        prod.get().setPrecio(pDetails.getPrecio());
        prod.get().setCantidad(pDetails.getCantidad());
       

        return ResponseEntity.status(HttpStatus.CREATED).body(pdService.save(prod.get()));

    }

    //BORRAR
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<?> delete(@PathVariable(value ="id")Long pId){

        if(!pdService.findById(pId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        pdService.deleteById(pId);
        return ResponseEntity.ok().build();

    }



    
}
