/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Editorial;

/**
 *
 * @author Santiago D'Ippolito
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }

    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
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
