/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.TipoTransaccion;

/**
 *
 * @author NuRe
 */
@Stateless
public class TipoTransaccionFacade extends AbstractFacade<TipoTransaccion> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTransaccionFacade() {
        super(TipoTransaccion.class);
    }
    
}
