/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.OrdenDeCompra;

/**
 *
 * @author NuRe
 */
@Stateless
public class OrdenDeCompraFacade extends AbstractFacade<OrdenDeCompra> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenDeCompraFacade() {
        super(OrdenDeCompra.class);
    }
    
}
