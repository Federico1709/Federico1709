/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioCliente {

    private ClienteDAO clienteDAO;

    public servicioCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente crearCliente(Boolean alta, Long documento, String nombre, String apellido, String telefono) throws Exception {
        Cliente nuevocliente = new Cliente();

        try {

            if (documento == null || documento == 0) {
                throw new Exception("Debe ingresar un documento valido");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe ingresar un apellido");
            }
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new Exception("Debe ingresar un telefono");
            }

            if (alta == false) {
                throw new Exception("El cliente esta dado de baja");
            }
            nuevocliente.setDocumento(documento);
            nuevocliente.setNombre(nombre);
            nuevocliente.setApellido(apellido);
            nuevocliente.setTelefono(telefono);
            clienteDAO.guardar(nuevocliente);
            return nuevocliente;

        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
