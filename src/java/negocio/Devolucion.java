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
@Table(name = "DEVOLUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d"),
    @NamedQuery(name = "Devolucion.findByIdDevolucion", query = "SELECT d FROM Devolucion d WHERE d.idDevolucion = :idDevolucion"),
    @NamedQuery(name = "Devolucion.findByCantidad", query = "SELECT d FROM Devolucion d WHERE d.cantidad = :cantidad")})
public class Devolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEVOLUCION")
    private Integer idDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDevolucion")
    private List<DetalleDevolucion> detalleDevolucionList;
    @JoinColumn(name = "ID_TIPO_DEVOLUCION", referencedColumnName = "ID_TIPO_DEVOLUCION")
    @ManyToOne(optional = false)
    private TipoDevolucion idTipoDevolucion;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne
    private Requisicion idRequisicion;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private Proveedor idProveedor;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")
    @ManyToOne
    private OrdenDeCompra idOrden;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;
    @OneToMany(mappedBy = "idDevolucion")
    private List<Transaccion> transaccionList;

    public Devolucion() {
    }

    public Devolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Devolucion(Integer idDevolucion, BigInteger cantidad) {
        this.idDevolucion = idDevolucion;
        this.cantidad = cantidad;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<DetalleDevolucion> getDetalleDevolucionList() {
        return detalleDevolucionList;
    }

    public void setDetalleDevolucionList(List<DetalleDevolucion> detalleDevolucionList) {
        this.detalleDevolucionList = detalleDevolucionList;
    }

    public TipoDevolucion getIdTipoDevolucion() {
        return idTipoDevolucion;
    }

    public void setIdTipoDevolucion(TipoDevolucion idTipoDevolucion) {
        this.idTipoDevolucion = idTipoDevolucion;
    }

    public Requisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Requisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public OrdenDeCompra getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDeCompra idOrden) {
        this.idOrden = idOrden;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        hash += (idDevolucion != null ? idDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.idDevolucion == null && other.idDevolucion != null) || (this.idDevolucion != null && !this.idDevolucion.equals(other.idDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Devolucion[ idDevolucion=" + idDevolucion + " ]";
    }
    
}
