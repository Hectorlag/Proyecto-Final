
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.dto.DatosTresClasesDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoDTO;
import com.ejercicio.proyectoFinal.dto.VentaProductoFechaDTO;
import com.ejercicio.proyectoFinal.model.Cliente;
import com.ejercicio.proyectoFinal.model.Producto;
import com.ejercicio.proyectoFinal.model.Venta;
import com.ejercicio.proyectoFinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService {
    
    //Creo una instancia de la interfaz IVentaRepository(Datos)
    @Autowired
    private IVentaRepository IVentaRepo;
    
    //Alta
    @Override
    public void saveVenta(Venta v) {
         
        IVentaRepo.save(v);
    }

    @Override
    public List<Venta> getVentas() {
         
        return IVentaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
         
        return IVentaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
         
        IVentaRepo.deleteById(codigo_venta);
    }
   //Editar
    /*@Override
    public void editVenta(Long id_original, Long id_nuevo, LocalDate nuevaFecha_venta, double nuevoTotal,
                          List<Producto> nuevaListaDeProductos, Cliente nuevoCliente) {
        
        Venta ven = this.findVenta(id_original);
        ven.setCodigo_venta(id_nuevo);
        ven.setFecha_venta(nuevaFecha_venta);
        ven.setTotal(nuevoTotal);
        ven.setListaProductos(nuevaListaDeProductos);
        ven.setUnCliente(nuevoCliente);
                
        this.saveVenta(ven);
    }*/
    
    //Editar
   public void editarVenta(Venta ven){
   
      this.saveVenta(ven);
   }
    
     //Lista de productos de una venta
    @Override
    public VentaProductoDTO getProductosXventa(Long codigo_venta) {
        VentaProductoDTO vpDTO = new VentaProductoDTO();
        //Busco los datos de la venta
        Venta v = this.findVenta(codigo_venta);
        
        vpDTO.setFecha_venta(v.getFecha_venta());
        vpDTO.setListaProductos(v.getListaProductos());
        
        return vpDTO;   
    }
     //Total de ventas en una determinada fecha
    //OBTENER LA SUMATORIA DEL MONTO Y TAMBIEN CANTIDAD TOTAL VENDIDA DE VENTAS DE UN DETERMINADO DIA
    @Override
    public VentaProductoFechaDTO totalVentasXfecha(LocalDate fecha_venta) {
        System.out.println("La fecha es: " + fecha_venta); 
        double totalVentas=0;
        double cantidadVendida=0;
        LocalDate fecha = fecha_venta;
        //Obtengo la lista completa de ventas
        List<Venta> listaCompleta = this.getVentas();
        //Creo una lista para luego guardar segun su fecha
        List<Venta> listaXfecha = new ArrayList();
        
        //Recorro la lista completa
        for(Venta v: listaCompleta){
            if(v.getFecha_venta().isEqual(fecha)){
                listaXfecha.add(v);
            }
        }
        //Recorro la lista filtrada segun la fecha
        for(Venta ven: listaXfecha){
           totalVentas = totalVentas + ven.getTotal();
           cantidadVendida = listaXfecha.size();
        }
        VentaProductoFechaDTO vpFechaDTO = new VentaProductoFechaDTO();
        vpFechaDTO.setCantidadVendidad(cantidadVendida);
        vpFechaDTO.setMonto(totalVentas);
        
        return vpFechaDTO;
       
    }
     //Datos de la venta con mayor monto
    @Override
    public DatosTresClasesDTO datosVentaMayorMonto() {
        
        double max = -9999;
        long codigo_venta = -1;
        boolean ban=false;
        //Obtengo el lista completa de ventas
        List<Venta> lista = this.getVentas();
        
        //Recorro la lista
        for(int i=0; i<lista.size();i++){
               if(lista.get(i).getTotal() > max){
                 max = lista.get(i).getTotal();//Asigno el primer valor como maximo
                 codigo_venta = lista.get(i).getCodigo_venta();
               }      
        }
        double maxVenta = max;
        long posicion = codigo_venta;
        //Busco la venta 
        Venta ven = this.findVenta(codigo_venta);
        
        //Creo un objeto de la clase DatosTresClasesDTO
        DatosTresClasesDTO dtcDTO = new DatosTresClasesDTO();
        dtcDTO.setCodigo_venta(ven.getCodigo_venta());
        dtcDTO.setTotal(ven.getTotal());
        dtcDTO.setCantidad_producto(ven.getListaProductos().size());
        dtcDTO.setNombre(ven.getCli().getNombre());
        dtcDTO.setApellido(ven.getCli().getApellido());
       
        return  dtcDTO;
       
    }
 
}   
           
            