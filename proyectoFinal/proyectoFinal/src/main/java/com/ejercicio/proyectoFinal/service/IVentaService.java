
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.dto.DatosTresClasesDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoFechaDTO;
import com.ejercicio.proyectoFinal.model.Cliente;
import com.ejercicio.proyectoFinal.model.Producto;
import com.ejercicio.proyectoFinal.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    //Alta
    public void saveVenta(Venta v);
    
    //Lectura
    public List<Venta> getVentas();
    
    //Busqueda
    public Venta findVenta(Long codigo_venta);
    
    //Eliminar
    public void deleteVenta(Long codigo_venta);
    
    //Edicion
   // public void editVenta(Long id_original, Long id_nueva, LocalDate nuevaFecha_venta, double nuevoTotal,
                         //List<Producto> nuevaListaDeProductos, Cliente nuevoCliente);
    
    //Edicion
    public void editarVenta(Venta ven);
    
    //Lista de productos de una venta
    public VentaProductoDTO getProductosXventa(Long codigo_venta);
    
    //Total de ventas en una determinada fecha
    public VentaProductoFechaDTO totalVentasXfecha(LocalDate fecha_venta);
    
    //Datos de la venta con mayor monto
    public DatosTresClasesDTO datosVentaMayorMonto();
}
