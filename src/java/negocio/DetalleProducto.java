/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NuRe
 */
@Entity
@Table(name = "DETALLE_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProducto.findAll", query = "SELECT d FROM DetalleProducto d"),
    @NamedQuery(name = "DetalleProducto.findByIdDetalleProducto", query = "SELECT d FROM DetalleProducto d WHERE d.idDetalleProducto = :idDetalleProducto"),
    @NamedQuery(name = "DetalleProducto.findByNombre", query = "SELECT d FROM DetalleProducto d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DetalleProducto.findByCantidad", query = "SELECT d FROM DetalleProducto d WHERE d.cantidad = :cantidad")})
public class DetalleProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_PRODUCTO")
    private Integer idDetalleProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_DETALLE_REQUISICION", referencedColumnName = "ID_DEASTALLE_REQUISICION")
    @ManyToOne
    private DetalleRequisicion idDetalleRequisicion;
    @JoinColumn(name = "ID_DETALLE_DEVOLUCION", referencedColumnName = "ID_DETALLE_DEVOLUCION")
    @ManyToOne
    private DetalleDevolucion idDetalleDevolucion;
    @JoinColumn(name = "ID_DETALLE_DE_ORDEN_COMPRA", referencedColumnName = "ID_DETALLE_DE_ORDEN_COMPRA")
    @ManyToOne
    private DetalleDeOrdenCompra idDetalleDeOrdenCompra;

    public DetalleProducto() {
    }

    public DetalleProducto(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public DetalleProducto(Integer idDetalleProducto, String nombre, BigInteger cantidad) {
        this.idDetalleProducto = idDetalleProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public DetalleRequisicion getIdDetalleRequisicion() {
        return idDetalleRequisicion;
    }

    public void setIdDetalleRequisicion(DetalleRequisicion idDetalleRequisicion) {
        this.idDetalleRequisicion = idDetalleRequisicion;
    }

    public DetalleDevolucion getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(DetalleDevolucion idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public DetalleDeOrdenCompra getIdDetalleDeOrdenCompra() {
        return idDetalleDeOrdenCompra;
    }

    public void setIdDetalleDeOrdenCompra(DetalleDeOrdenCompra idDetalleDeOrdenCompra) {
        this.idDetalleDeOrdenCompra = idDetalleDeOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProducto != null ? idDetalleProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProducto)) {
            return false;
        }
        DetalleProducto other = (DetalleProducto) object;
        if ((this.idDetalleProducto == null && other.idDetalleProducto != null) || (this.idDetalleProducto != null && !this.idDetalleProducto.equals(other.idDetalleProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.DetalleProducto[ idDetalleProducto=" + idDetalleProducto + " ]";
    }
    
}
