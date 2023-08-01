
package com.ejercicio.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DatosTresClasesDTO {
    
    private long codigo_venta;
    private double total;
    private double cantidad_producto;
    private String nombre;
    private String apellido;

    public DatosTresClasesDTO() {
    }

    public DatosTresClasesDTO(long codigo_venta, double total, double cantidad_producto, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_producto = cantidad_producto;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    
}
