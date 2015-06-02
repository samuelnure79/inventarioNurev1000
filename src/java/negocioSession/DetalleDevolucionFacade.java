/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.DetalleDevolucion;

/**
 *
 * @author NuRe
 */
@Stateless
public class DetalleDevolucionFacade extends AbstractFacade<DetalleDevolucion> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDevolucionFacade() {
        super(DetalleDevolucion.class);
    }
    
}
