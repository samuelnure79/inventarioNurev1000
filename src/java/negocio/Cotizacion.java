/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NuRe
 */
@Entity
@Table(name = "COTIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByIdCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idCotizacion = :idCotizacion"),
    @NamedQuery(name = "Cotizacion.findByEstadoCot", query = "SELECT c FROM Cotizacion c WHERE c.estadoCot = :estadoCot")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COTIZACION")
    private Integer idCotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_COT")
    private BigInteger estadoCot;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotizacion")
    private List<OrdenDeCompra> ordenDeCompraList;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cotizacion(Integer idCotizacion, BigInteger estadoCot) {
        this.idCotizacion = idCotizacion;
        this.estadoCot = estadoCot;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public BigInteger getEstadoCot() {
        return estadoCot;
    }

    public void setEstadoCot(BigInteger estadoCot) {
        this.estadoCot = estadoCot;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @XmlTransient
    public List<OrdenDeCompra> getOrdenDeCompraList() {
        return ordenDeCompraList;
    }

    public void setOrdenDeCompraList(List<OrdenDeCompra> ordenDeCompraList) {
        this.ordenDeCompraList = ordenDeCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Cotizacion[ idCotizacion=" + idCotizacion + " ]";
    }
    
}
