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
@Table(name = "DETALLE_DE_ORDEN_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDeOrdenCompra.findAll", query = "SELECT d FROM DetalleDeOrdenCompra d"),
    @NamedQuery(name = "DetalleDeOrdenCompra.findByIdDetalleDeOrdenCompra", query = "SELECT d FROM DetalleDeOrdenCompra d WHERE d.idDetalleDeOrdenCompra = :idDetalleDeOrdenCompra"),
    @NamedQuery(name = "DetalleDeOrdenCompra.findByCantidad", query = "SELECT d FROM DetalleDeOrdenCompra d WHERE d.cantidad = :cantidad")})
public class DetalleDeOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_DE_ORDEN_COMPRA")
    private Integer idDetalleDeOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")
    @ManyToOne(optional = false)
    private OrdenDeCompra idOrden;
    @OneToMany(mappedBy = "idDetalleDeOrdenCompra")
    private List<DetalleProducto> detalleProductoList;

    public DetalleDeOrdenCompra() {
    }

    public DetalleDeOrdenCompra(Integer idDetalleDeOrdenCompra) {
        this.idDetalleDeOrdenCompra = idDetalleDeOrdenCompra;
    }

    public DetalleDeOrdenCompra(Integer idDetalleDeOrdenCompra, BigInteger cantidad) {
        this.idDetalleDeOrdenCompra = idDetalleDeOrdenCompra;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleDeOrdenCompra() {
        return idDetalleDeOrdenCompra;
    }

    public void setIdDetalleDeOrdenCompra(Integer idDetalleDeOrdenCompra) {
        this.idDetalleDeOrdenCompra = idDetalleDeOrdenCompra;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenDeCompra getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDeCompra idOrden) {
        this.idOrden = idOrden;
    }

    @XmlTransient
    public List<DetalleProducto> getDetalleProductoList() {
        return detalleProductoList;
    }

    public void setDetalleProductoList(List<DetalleProducto> detalleProductoList) {
        this.detalleProductoList = detalleProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDeOrdenCompra != null ? idDetalleDeOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDeOrdenCompra)) {
            return false;
        }
        DetalleDeOrdenCompra other = (DetalleDeOrdenCompra) object;
        if ((this.idDetalleDeOrdenCompra == null && other.idDetalleDeOrdenCompra != null) || (this.idDetalleDeOrdenCompra != null && !this.idDetalleDeOrdenCompra.equals(other.idDetalleDeOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.DetalleDeOrdenCompra[ idDetalleDeOrdenCompra=" + idDetalleDeOrdenCompra + " ]";
    }
    
}
