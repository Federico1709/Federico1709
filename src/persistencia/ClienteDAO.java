/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import libreria.entidad.Cliente;

/**
 *
 * @author Santiago D'Ippolito
 */
public class ClienteDAO extends DAO<Cliente>{

    @Override
    public void eliminar(Cliente cliente) {
        super.eliminar(cliente); 
    }

    @Override
    public void editar(Cliente cliente) {
        super.editar(cliente); 
    }

    @Override
    public void guardar(Cliente cliente) {
        super.guardar(cliente); 
    }

    @Override
    public void desconectar() {
        super.desconectar(); 
    }

    @Override
    public void conectar() {
        super.conectar(); 
    }

    
}
