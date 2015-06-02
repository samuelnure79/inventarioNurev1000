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
@Table(name = "DETALLE_DEVOLUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDevolucion.findAll", query = "SELECT d FROM DetalleDevolucion d"),
    @NamedQuery(name = "DetalleDevolucion.findByIdDetalleDevolucion", query = "SELECT d FROM DetalleDevolucion d WHERE d.idDetalleDevolucion = :idDetalleDevolucion"),
    @NamedQuery(name = "DetalleDevolucion.findByCantidad", query = "SELECT d FROM DetalleDevolucion d WHERE d.cantidad = :cantidad")})
public class DetalleDevolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_DEVOLUCION")
    private Integer idDetalleDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @OneToMany(mappedBy = "idDetalleDevolucion")
    private List<DetalleProducto> detalleProductoList;
    @JoinColumn(name = "ID_DEVOLUCION", referencedColumnName = "ID_DEVOLUCION")
    @ManyToOne(optional = false)
    private Devolucion idDevolucion;

    public DetalleDevolucion() {
    }

    public DetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public DetalleDevolucion(Integer idDetalleDevolucion, BigInteger cantidad) {
        this.idDetalleDevolucion = idDetalleDevolucion;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<DetalleProducto> getDetalleProductoList() {
        return detalleProductoList;
    }

    public void setDetalleProductoList(List<DetalleProducto> detalleProductoList) {
        this.detalleProductoList = detalleProductoList;
    }

    public Devolucion getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Devolucion idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDevolucion != null ? idDetalleDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDevolucion)) {
            return false;
        }
        DetalleDevolucion other = (DetalleDevolucion) object;
        if ((this.idDetalleDevolucion == null && other.idDetalleDevolucion != null) || (this.idDetalleDevolucion != null && !this.idDetalleDevolucion.equals(other.idDetalleDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.DetalleDevolucion[ idDetalleDevolucion=" + idDetalleDevolucion + " ]";
    }
    
}
