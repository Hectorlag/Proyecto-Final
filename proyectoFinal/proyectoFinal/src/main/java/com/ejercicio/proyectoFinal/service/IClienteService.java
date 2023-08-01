
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    //Alta
    public void saveCliente(Cliente cli);
    
    //Lectura
    public List<Cliente> getClientes();
    
    //Busqueda
    public Cliente findCliente(Long id_cliente);
    
    //Eliminar
    public void deleteCliente(Long id_cliente);
    
    //Editar
    public void editCliente(Long id_original, Long nuevaId, String nuevoNombre,
                            String nuevoApellido, String nuevoDni);
}
