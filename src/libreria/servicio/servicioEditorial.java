/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import java.util.Scanner;
import libreria.entidad.Editorial;
import persistencia.EditorialDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioEditorial {

    private EditorialDAO editorialdao;

    public servicioEditorial() {
        editorialdao = new EditorialDAO();
    }

    Scanner leer = new Scanner(System.in);

    public Editorial crearEditorial(Integer id, Boolean alta, String nombre) throws Exception {
        Editorial nuevaEditorial = new Editorial();

        try {

            if (id == 0) {
                throw new Exception("Debe ingresar un id valido y distinto de 0");

            }
            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("Debe ingresar el nombre de la Editorial");
                
            }
            if (alta == false) {
                System.out.println("La Editorial esta dada de baja");

            }
            
            nuevaEditorial.setNombre(nombre);
            editorialdao.guardar(nuevaEditorial);
            return nuevaEditorial;
        } catch (Exception e) {
            throw e;
        }
    }

}
