/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "ORDEN_DE_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompra.findAll", query = "SELECT o FROM OrdenDeCompra o"),
    @NamedQuery(name = "OrdenDeCompra.findByIdOrden", query = "SELECT o FROM OrdenDeCompra o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenDeCompra.findByFechaOrden", query = "SELECT o FROM OrdenDeCompra o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "OrdenDeCompra.findByEstadoOrden", query = "SELECT o FROM OrdenDeCompra o WHERE o.estadoOrden = :estadoOrden")})
public class OrdenDeCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDEN")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ORDEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_ORDEN")
    private BigInteger estadoOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrden")
    private List<DetalleDeOrdenCompra> detalleDeOrdenCompraList;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "ID_COTIZACION", referencedColumnName = "ID_COTIZACION")
    @ManyToOne(optional = false)
    private Cotizacion idCotizacion;
    @OneToMany(mappedBy = "idOrden")
    private List<Devolucion> devolucionList;
    @OneToMany(mappedBy = "idOrden")
    private List<Transaccion> transaccionList;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdenDeCompra(Integer idOrden, Date fechaOrden, BigInteger estadoOrden) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.estadoOrden = estadoOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public BigInteger getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(BigInteger estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    @XmlTransient
    public List<DetalleDeOrdenCompra> getDetalleDeOrdenCompraList() {
        return detalleDeOrdenCompraList;
    }

    public void setDetalleDeOrdenCompraList(List<DetalleDeOrdenCompra> detalleDeOrdenCompraList) {
        this.detalleDeOrdenCompraList = detalleDeOrdenCompraList;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @XmlTransient
    public List<Devolucion> getDevolucionList() {
        return devolucionList;
    }

    public void setDevolucionList(List<Devolucion> devolucionList) {
        this.devolucionList = devolucionList;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompra)) {
            return false;
        }
        OrdenDeCompra other = (OrdenDeCompra) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.OrdenDeCompra[ idOrden=" + idOrden + " ]";
    }
    
}
