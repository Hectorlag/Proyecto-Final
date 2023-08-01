
package com.ejercicio.proyectoFinal.service;

import com.ejercicio.proyectoFinal.model.Cliente;
import com.ejercicio.proyectoFinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    //Creo un objeto de la interfaz IClienteRepository(Datos)
    @Autowired
    private IClienteRepository IClienteRepo;
    
    //Alta
    @Override
    public void saveCliente(Cliente cli) {
         
        IClienteRepo.save(cli);
    }
    //Lectura
    @Override
    public List<Cliente> getClientes() {
         
        return IClienteRepo.findAll();
    }
    //Busqueda
    @Override
    public Cliente findCliente(Long id_cliente) {
        
         return IClienteRepo.findById(id_cliente).orElse(null);
    }
    //Eliminar
    @Override
    public void deleteCliente(Long id_cliente) {
         
        IClienteRepo.deleteById(id_cliente);
    }
    
    //Editar
    @Override
    public void editCliente(Long id_original, Long nuevaId, String nuevoNombre,
                            String nuevoApellido, String nuevoDni) {
        
        
        //Busco el objeto original
        Cliente cli = this.findCliente(id_original);
        cli.setId_cliente(nuevaId);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);
        
        //Guardo los cambios
        this.saveCliente(cli);
    }
    
}
