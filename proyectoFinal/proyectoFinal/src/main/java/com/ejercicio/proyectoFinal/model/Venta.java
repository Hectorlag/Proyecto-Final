
package com.ejercicio.proyectoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    
    @ManyToMany
    @JoinTable (
          name = "rela_ventas_productos",
          joinColumns = @JoinColumn (name = "id_venta", nullable=false),
          inverseJoinColumns = @JoinColumn (name = "id_producto", nullable=false))
    private List<Producto> listaProductos;
    
    @ManyToOne
    @JoinColumn(name="codigo_venta_idCliente")
    @JsonIgnoreProperties("listaVentas")
    private Cliente cli;
    
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente cli) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cli = cli;
    }

   

   
    
    
    
    
    
}
