/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import persistencia.AutorDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioAutor {

    private AutorDAO autorDAO;

    public servicioAutor() {
        autorDAO = new AutorDAO();
    }

    Scanner leer = new Scanner(System.in);

    public Autor crearAutor(Integer id, Boolean alta, String nombre) throws Exception {
        Autor nuevoautor = new Autor();

        try {

            if (id == 0) {
                throw new Exception("Debe ingresar un id valido y distinto de 0");

            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar el nombre del Autor");

            }

            if (alta == false) {
                throw new Exception("El autor esta dado de baja");
            }

            nuevoautor.setNombre(nombre);

            autorDAO.guardar(nuevoautor);
            return nuevoautor;
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarAutor(String nombre) {
        try {
            return autorDAO.buscarAutor(nombre);
        } catch (Exception e) {
            return null;
        }

    }
}
