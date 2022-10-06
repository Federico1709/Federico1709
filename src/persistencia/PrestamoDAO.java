/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import libreria.entidad.Prestamo;

/**
 *
 * @author Santiago D'Ippolito
 */
public class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void eliminar(Prestamo prestamo) {
        super.eliminar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Prestamo prestamo) {
        super.editar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desconectar() {
        super.desconectar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void conectar() {
        super.conectar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Prestamo prestamo) {
        super.guardar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }

    public Prestamo buscarPrestamoPorCliente(String apellido) {
        conectar();
        em.getTransaction().begin();
        Prestamo prestamo = (Prestamo) em.createQuery("SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.apellido like :apellido")
                .setParameter("apellido", apellido).getSingleResult();
        System.out.println(prestamo);
        desconectar();
        return prestamo;
    }

}
