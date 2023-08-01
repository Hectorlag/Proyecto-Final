
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.model.Producto;
import com.ejercicio.proyectoFinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    //Creo una instancia de la interfaz IProductoRepository(Datos)
    @Autowired
    private IProductoRepository IProductoRepo;
    
    //Alta
    @Override
    public void saveProducto(Producto pro) {
         
        IProductoRepo.save(pro);
    }
    //Lectura
    @Override
    public List<Producto> getProductos() {
         
        return IProductoRepo.findAll();
    }
    //Busqueda
    @Override
    public Producto findProducto(Long codigo_producto) {
         
        return IProductoRepo.findById(codigo_producto).orElse(null);
    }
    //Eliminar
    @Override
    public void deleteProducto(Long codigo_producto) {
         
        IProductoRepo.deleteById(codigo_producto);
    }
    //Editar
    @Override
    public void editProducto(Long codigo_producto, Long codigo_productoNuevo, String nuevoNombre, String nuevoApellido,
                             double nuevoCosto, double nuevaCantidad_disponible ) {
        
        Producto pro = this.findProducto(codigo_producto);
        pro.setCodigo_producto(codigo_productoNuevo);
        pro.setNombre(nuevoNombre);
        pro.setMarca(nuevoNombre);
        pro.setCosto(nuevoCosto);
        pro.setCantidad_disponible(nuevaCantidad_disponible);
        
        this.saveProducto(pro);
    }
    
    
    
    
    //Busqueda de los productos con cant disponible sea menor a 5
    @Override
    public List<Producto> getProductosCantMenorAcinco() {
        
        //Obtengo la lista de todos los productos
        List<Producto> listaCompleta = this.getProductos();
        //Creo un lista para luego guardar los que tienen una cantidad menor a 5
        List<Producto> listaMenorAcinco = new ArrayList();
        
        //Recorro la lista original
        for(Producto p: listaCompleta){
            if(p.getCantidad_disponible() < 5){
               //Añado a la lista
               listaMenorAcinco.add(p);
            }
        }
        return listaMenorAcinco;  
    }

    @Override
    public void editar(Producto pro) {
        
        this.saveProducto(pro);
    }

   
    
}
