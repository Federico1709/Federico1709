/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import persistencia.LibroDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioLibro {

    private servicioAutor sa;
    private servicioEditorial se;
    private LibroDAO libroDAO;

    public servicioLibro() {
        this.sa = new servicioAutor();
        this.se = new servicioEditorial();
        this.libroDAO = new LibroDAO();
    }

    public void setServicios(servicioAutor sa, servicioEditorial se) {
        this.sa = sa;
        this.se = se;
    }

    public Libro crearLibro(Integer id, Boolean alta, Long isbn, String titulo, String anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws Exception {
            Libro nuevolibro = new Libro();

        try {

            if (isbn == null || isbn == 0) {
                throw new Exception("Debe ingresar el ISBN del libro o ingresar un ISBN valido");
            }
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe ingresar el titulo del libro");
            }
            if (alta == false) {
                throw new Exception("El libro esta dado de baja");
            }
            
            nuevolibro.setId(id);
            nuevolibro.setIsbn(isbn);
            nuevolibro.setTitulo(titulo);
            nuevolibro.setAnio(anio);
            nuevolibro.setEjemplares(ejemplares);
            nuevolibro.setEjemplaresPrestados(ejemplaresPrestados);
            nuevolibro.setEjemplaresRestantes(ejemplaresRestantes);
            nuevolibro.setAutor(autor);
            nuevolibro.setEditorial(editorial);
            libroDAO.guardar(nuevolibro);
            return nuevolibro;

        } catch (Exception e) {
            throw e;
        }
    }

    public Libro buscarLibroPorIsbn(Long isbn) {
        try {
            return libroDAO.buscarLibroPorIsbn(isbn);
        } catch (Exception e) {
            return null;
        }

    }

    public Libro buscarLibroPorTitulo(String titulo) {
        try {
            return libroDAO.buscarLibroPorTitulo(titulo);
        } catch (Exception e) {
            return null;
        }

    }

    public Libro buscarLibroPorAutor(String nombre) {
        try {
            return libroDAO.buscarLibroPorAutor(nombre);
        } catch (Exception e) {
            return null;
        }
    }

    public Libro buscarLibroPorEditorial(String nombre) {
        try {
            return libroDAO.buscarLibroPorEditorial(nombre);
        } catch (Exception e) {
            return null;
        }
    }
}
