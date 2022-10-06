/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import java.util.Date;
import libreria.entidad.Cliente;
import libreria.entidad.Libro;
import libreria.entidad.Prestamo;
import persistencia.PrestamoDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioPrestamo {

    private PrestamoDAO prestamoDAO;

    public servicioPrestamo() {
        this.prestamoDAO = new PrestamoDAO();
    }

    public Prestamo registrarPrestamos(Boolean alta, Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) throws Exception {
        Prestamo nuevoPrestamo = new Prestamo();
        try {

            if (fechaPrestamo == null) {
                throw new Exception("Debe ingresar la fecha del prestamo");
            }
            if (fechaDevolucion == null) {
                throw new Exception("Debe ingresar la fecha de devolución");
            }
            if (alta == false) {
                throw new Exception("El cliente está dado de baja");
            }
                nuevoPrestamo.setAlta(true);
                nuevoPrestamo.setFechaPrestamo(fechaPrestamo);
                nuevoPrestamo.setFechaDevolucion(fechaDevolucion);
                nuevoPrestamo.setLibro(libro);
                nuevoPrestamo.setCliente(cliente);
                prestamoDAO.guardar(nuevoPrestamo);
                return nuevoPrestamo;
            }catch (Exception e) {
            e.getMessage();
            return null;
        }
        
    }
    public Prestamo buscarPrestamoPorCliente(String apellido){
        try {
            return prestamoDAO.buscarPrestamoPorCliente(apellido);
        } catch (Exception e) {
            return null;
        }
        
    }
}

