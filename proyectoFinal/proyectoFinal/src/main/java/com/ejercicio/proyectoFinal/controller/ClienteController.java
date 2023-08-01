
package com.ejercicio.proyectoFinal.controller;

import com.ejercicio.proyectoFinal.model.Cliente;
import com.ejercicio.proyectoFinal.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
     //return new ResponseEntity<> ("Esta es una prueba de response", HttpStatus.NOT_FOUND);
    //Creo un objeto de la interfaz IClienteService
    @Autowired
    private IClienteService ICli;
    
    //Alta
    @PostMapping ("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cli){
      
        ICli.saveCliente(cli);
        return "Cliente creado correctamente";
    }
    
    //Lectura
    @GetMapping ("/clientes/traer")
    public List<Cliente> traerClientes(){
    
      return ICli.getClientes();
    }
    
    //Baja
    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
    
        ICli.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }
    
    //Editar
    @PutMapping ("/clientes/editar/{id_original}")
    public Cliente editarCliente(@PathVariable Long id_original,
            @RequestParam(required = false, name = "id_cliente") Long nuevaId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni){
      
       //Envío el id original (para buscar)
       //Envio nuevos datos para modificar
       ICli.editCliente(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevoDni);
       
       //Busco el cliente editado para mostrarlo en la response
       Cliente cli = ICli.findCliente(id_original);
       
       //Retorna el nuevo cliente
       return cli;
     }
    
}
