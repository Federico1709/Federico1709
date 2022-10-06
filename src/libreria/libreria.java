/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import libreria.entidad.Cliente;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.servicio.servicioAutor;
import libreria.servicio.servicioCliente;
import libreria.servicio.servicioEditorial;
import libreria.servicio.servicioLibro;
import libreria.servicio.servicioPrestamo;
import persistencia.LibroDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner (System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();
        servicioAutor sa = new servicioAutor();
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        servicioLibro sl = new servicioLibro();
        Editorial editorial1 = new Editorial();
        Editorial editorial2 = new Editorial();
        servicioEditorial se = new servicioEditorial();
      
        
        
        String nombreA1 = "Cortazar";
        String nombreA2 = "Borges";
        
        String nombreE1 = "Minotauro";
        String nombreE2 = "Siruela";
        
        Long isbn1 = 9788437622156L;
        Long isbn2 = 8788437622156L;
        String titulo1= "Don Quijote de la Mancha";
        String titulo2= "El Señor De Los Anillos";
        String anio1 = "1605";
        String anio2 = "1993";
        Integer ejemplares1 = (int)Math.floor(Math.random()*(10-1000+1)+1000);
        Integer ejemplares2 = (int)Math.floor(Math.random()*(10-1000+1)+1000);
        Integer ejemplaresP1= ejemplares1 - (int)Math.floor(Math.random()*(10-500+1)+500);
        Integer ejemplaresP2= ejemplares2 - (int)Math.floor(Math.random()*(10-500+1)+500);
        Integer ejemplaresR1 = ejemplares1;
        Integer ejemplaresR2 = ejemplares2;
        
        autor1 = sa.crearAutor(Integer.SIZE, Boolean.TRUE, nombreA1);
        autor2 = sa.crearAutor(Integer.SIZE, Boolean.TRUE, nombreA2);
        
        editorial1 =se.crearEditorial(Integer.SIZE, Boolean.TRUE, nombreE1);
        editorial2 =se.crearEditorial(Integer.SIZE, Boolean.TRUE, nombreE2);
        
        libro1 = sl.crearLibro(Integer.SIZE, Boolean.TRUE, isbn1, titulo1, anio1, ejemplares1, ejemplaresP1, ejemplaresR1, autor1, editorial1);
        libro2 = sl.crearLibro(Integer.SIZE, Boolean.TRUE, isbn2, titulo2, anio2, ejemplares2, ejemplaresP2, ejemplaresR2, autor2, editorial2);
        
        System.out.println("Elija el autor que desea buscar");
        sa.buscarAutor(leer.nextLine());
        
        System.err.println("Elija libro por ISBN");
        sl.buscarLibroPorIsbn(8788437622156L);
        
        System.out.println("Elija el titulo del libro que desea buscar");
        sl.buscarLibroPorTitulo(titulo1);
        
        System.out.println("Elija el autor del libro que desee");
        sl.buscarLibroPorAutor(nombreA1);
        
        System.out.println("Elija la editorial del libro que desea");
        sl.buscarLibroPorEditorial(nombreE2);
          servicioCliente sc=new servicioCliente();
          Cliente c1=new Cliente();
          Cliente c2=new Cliente();
          String C1="PEPE";
          String C2="CARLOS";
          Date d1=new Date(2022-1900,10+1,5);
          Date d2=new Date(2022-1900,10+1,10);
          Date d3=new Date(2022-1900,10+1,5);
          Date d4=new Date(2022-1900,10+1,25);
         c1=sc.crearCliente(Boolean.TRUE, 36417598L, C1, "SANCHEZ", "4323540");
          c2=sc.crearCliente(Boolean.TRUE, 35488674L, C2, "ELESCAMOSO", "4313189");
          servicioPrestamo sp=new servicioPrestamo();
          sp.registrarPrestamos(Boolean.TRUE, d1, d2,libro1,c1);
          sp.registrarPrestamos(Boolean.TRUE, d3, d4,libro2,c2);
          sp.buscarPrestamoPorCliente("SANCHEZ");
    }
}
