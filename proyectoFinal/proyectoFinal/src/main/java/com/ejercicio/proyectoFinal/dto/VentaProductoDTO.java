
package com.ejercicio.proyectoFinal.dto;

import com.ejercicio.proyectoFinal.model.Producto;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class VentaProductoDTO {
    
    private long codigo_venta;
    private LocalDate fecha_venta;
    private List<Producto> listaProductos;

    public VentaProductoDTO() {
    }

    public VentaProductoDTO(long codigo_venta, LocalDate fecha_venta, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.listaProductos = listaProductos;
    }
    
    
    
}
