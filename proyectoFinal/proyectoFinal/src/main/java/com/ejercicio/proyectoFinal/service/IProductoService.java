
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.model.Producto;
import java.util.List;


public interface IProductoService {
    
    //Alta
    public void saveProducto(Producto pro);
    
    //Lectura
    public List<Producto> getProductos();
    
    //Busqueda
    public Producto findProducto(Long codigo_producto);
    
    //Eliminar
    public void deleteProducto(Long codigo_producto);
    
    //editar
    public void editProducto(Long codigo_producto, Long codigo_productoNuevo, String nuevoNombre, String nuevaMarca,
                             double nuevoCosto, double nuevaCantidad_disponible);
    
    public void editar(Producto pro);
    
    //Lista productos con cantidad menor a 5
    public List<Producto> getProductosCantMenorAcinco();
}
