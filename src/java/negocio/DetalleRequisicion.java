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
@Table(name = "DETALLE_REQUISICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleRequisicion.findAll", query = "SELECT d FROM DetalleRequisicion d"),
    @NamedQuery(name = "DetalleRequisicion.findByIdDeastalleRequisicion", query = "SELECT d FROM DetalleRequisicion d WHERE d.idDeastalleRequisicion = :idDeastalleRequisicion"),
    @NamedQuery(name = "DetalleRequisicion.findByCantidad", query = "SELECT d FROM DetalleRequisicion d WHERE d.cantidad = :cantidad")})
public class DetalleRequisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEASTALLE_REQUISICION")
    private Integer idDeastalleRequisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_REQUISICION", referencedColumnName = "ID_REQUISICION")
    @ManyToOne(optional = false)
    private Requisicion idRequisicion;
    @OneToMany(mappedBy = "idDetalleRequisicion")
    private List<DetalleProducto> detalleProductoList;

    public DetalleRequisicion() {
    }

    public DetalleRequisicion(Integer idDeastalleRequisicion) {
        this.idDeastalleRequisicion = idDeastalleRequisicion;
    }

    public DetalleRequisicion(Integer idDeastalleRequisicion, BigInteger cantidad) {
        this.idDeastalleRequisicion = idDeastalleRequisicion;
        this.cantidad = cantidad;
    }

    public Integer getIdDeastalleRequisicion() {
        return idDeastalleRequisicion;
    }

    public void setIdDeastalleRequisicion(Integer idDeastalleRequisicion) {
        this.idDeastalleRequisicion = idDeastalleRequisicion;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Requisicion getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Requisicion idRequisicion) {
        this.idRequisicion = idRequisicion;
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
        hash += (idDeastalleRequisicion != null ? idDeastalleRequisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleRequisicion)) {
            return false;
        }
        DetalleRequisicion other = (DetalleRequisicion) object;
        if ((this.idDeastalleRequisicion == null && other.idDeastalleRequisicion != null) || (this.idDeastalleRequisicion != null && !this.idDeastalleRequisicion.equals(other.idDeastalleRequisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.DetalleRequisicion[ idDeastalleRequisicion=" + idDeastalleRequisicion + " ]";
    }
    
}
