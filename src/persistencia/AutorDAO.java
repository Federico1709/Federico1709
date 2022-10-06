/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;

/**
 *
 * @author Santiago D'Ippolito
 */
public class AutorDAO extends DAO<Autor> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    protected EntityManager em = emf.createEntityManager();

    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void desconectar() {
        super.desconectar();
    }

    @Override
    public void conectar() {
        super.conectar();
    }

    public Autor buscarAutor(String nombre) {
        conectar();
        em.getTransaction().begin();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre like :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        System.out.println(autor);
        desconectar();
        return autor;
    }

}
