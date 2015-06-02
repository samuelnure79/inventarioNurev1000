/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocioSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.TipoProveedor;

/**
 *
 * @author NuRe
 */
@Stateless
public class TipoProveedorFacade extends AbstractFacade<TipoProveedor> {
    @PersistenceContext(unitName = "inventarioG8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProveedorFacade() {
        super(TipoProveedor.class);
    }
    
}
