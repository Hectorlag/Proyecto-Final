
package com.ejercicio.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaProductoFechaDTO {
    
    private double monto;
    private double cantidadVendidad;

    public VentaProductoFechaDTO() {
    }

    public VentaProductoFechaDTO(double monto, double cantidadVendidad) {
        this.monto = monto;
        this.cantidadVendidad = cantidadVendidad;
    }
    
    
    
}
