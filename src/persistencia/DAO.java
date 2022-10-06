/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Santiago D'Ippolito
 */
public class DAO<T> {
    
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    protected EntityManager em = emf.createEntityManager();

    public void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

     public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

     public void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

     public void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

     public void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
