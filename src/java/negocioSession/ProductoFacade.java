/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.Producto;

/**
 *
 * @author NuRe
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
}
