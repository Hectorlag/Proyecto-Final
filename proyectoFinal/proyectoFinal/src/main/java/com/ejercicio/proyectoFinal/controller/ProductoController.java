
package com.ejercicio.proyectoFinal.controller;

import com.ejercicio.proyectoFinal.model.Producto;
import com.ejercicio.proyectoFinal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    //Creo una instancia de la interfaz IProductoService
    @Autowired 
    private IProductoService IProd;
    
    //Alta
    @PostMapping ("/productos/crear")
    public String crearProducto(@RequestBody Producto pro){
     
        IProd.saveProducto(pro);
      return "Producto creado correctamente";
    }
    
    //Lectura
    @GetMapping ("/productos/traer")
    public List<Producto> traerProducto(){
    
      return IProd.getProductos();
    }
    
    //Baja
    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
    
       IProd.deleteProducto(codigo_producto);
       return "Producto eliminado correctamente";
    }
    
    //Modificación
    /*@PutMapping ("/productos/editar/{codigo_producto}")
    public Producto editarProducto(@PathVariable Long codigo_producto,
            
            @RequestParam(required = false, name = "id_nuevo") Long codigo_productoNuevo,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "costo") double nuevoCosto,
            @RequestParam(required = false, name = "cantidad_disponible") double nuevaCantidad_disponible){
        
        //Envío el id original (para buscar)
       //Envio nuevos datos para modificar
        IProd.editProducto(codigo_producto, codigo_productoNuevo, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad_disponible);
        
        //Busco el producto editado para mostrarlo en la response
        Producto pro = IProd.findProducto(codigo_producto);
        
        //Retorna el nuevo producto
        return pro;  
    }
    
    //Lista de productos con cantidad menor a 5
    @GetMapping ("/productos/falta_stock")
    public List<Producto> traerLista(){
        
        return IProd.getProductosCantMenorAcinco();
    }*/
    @PutMapping ("/productos/editar")
    public Producto edit(@RequestBody Producto pro){
    
      IProd.editar(pro);
      
      return IProd.findProducto(pro.getCodigo_producto());
      
    }

    
    
}
