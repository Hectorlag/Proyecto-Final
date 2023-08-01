
package com.ejercicio.proyectoFinal.controller;

import com.ejercicio.proyectoFinal.dto.DatosTresClasesDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoFechaDTO;
import com.ejercicio.proyectoFinal.model.Producto;
import com.ejercicio.proyectoFinal.model.Venta;
import com.ejercicio.proyectoFinal.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    //Creo una instancia de la interfaz IVentaService
    @Autowired
    private IVentaService IVenta;
    
    //Alta
    @PostMapping ("/ventas/crear")
    public String crearVenta(@RequestBody Venta ven){
     
        IVenta.saveVenta(ven); 
        return "Venta creada correctamente";
    }
    
    //Lectura
    @GetMapping ("/ventas/traer")
    public List<Venta> traerVentas(){
       
        return IVenta.getVentas();
    }
    
    //Baja
    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
    
       IVenta.deleteVenta(codigo_venta);
       return "Venta eliminada correctamente";
    }
    
    //Editar
    @PutMapping ("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta ven){
    
      IVenta.editarVenta(ven);
      
      return IVenta.findVenta(ven.getCodigo_venta());
    }
    
    //Lista de productos de una determinada venta
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public VentaProductoDTO getProductosXventa(@PathVariable Long codigo_venta){
    
              VentaProductoDTO vpDTO = (VentaProductoDTO) IVenta.getProductosXventa(codigo_venta);
              
              return vpDTO;
    }
    
    //Total de ventas en una determinada fecha
    //OBTENER LA SUMATORIA DEL MONTO Y TAMBIEN CANTIDAD TOTAL VENDIDA DE VENTAS DE UN DETERMINADO DIA
    @GetMapping("/ventas/{fecha_venta}")
    public VentaProductoFechaDTO getVentasXfecha(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)@PathVariable LocalDate fecha_venta){
      
        VentaProductoFechaDTO vpfDTO = IVenta.totalVentasXfecha(fecha_venta);
        
      return vpfDTO;
    }
    
    //Datos de la venta con mayor monto
    @GetMapping ("/ventas/mayor_venta")
    public DatosTresClasesDTO getVentasMayor(){
    
      return IVenta.datosVentaMayorMonto();
    }

    
}
