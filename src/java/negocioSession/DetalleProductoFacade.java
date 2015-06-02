/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.DetalleProducto;

/**
 *
 * @author NuRe
 */
@Stateless
public class DetalleProductoFacade extends AbstractFacade<DetalleProducto> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleProductoFacade() {
        super(DetalleProducto.class);
    }
    
}
