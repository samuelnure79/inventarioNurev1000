/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
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
@Table(name = "REQUISICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisicion.findAll", query = "SELECT r FROM Requisicion r"),
    @NamedQuery(name = "Requisicion.findByIdRequisicion", query = "SELECT r FROM Requisicion r WHERE r.idRequisicion = :idRequisicion"),
    @NamedQuery(name = "Requisicion.findByFechaReq", query = "SELECT r FROM Requisicion r WHERE r.fechaReq = :fechaReq")})
public class Requisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REQUISICION")
    private Integer idRequisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisicion")
    private List<DetalleRequisicion> detalleRequisicionList;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(mappedBy = "idRequisicion")
    private List<Devolucion> devolucionList;
    @OneToMany(mappedBy = "idRequisicion")
    private List<Transaccion> transaccionList;

    public Requisicion() {
    }

    public Requisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Requisicion(Integer idRequisicion, Date fechaReq) {
        this.idRequisicion = idRequisicion;
        this.fechaReq = fechaReq;
    }

    public Integer getIdRequisicion() {
        return idRequisicion;
    }

    public void setIdRequisicion(Integer idRequisicion) {
        this.idRequisicion = idRequisicion;
    }

    public Date getFechaReq() {
        return fechaReq;
    }

    public void setFechaReq(Date fechaReq) {
        this.fechaReq = fechaReq;
    }

    @XmlTransient
    public List<DetalleRequisicion> getDetalleRequisicionList() {
        return detalleRequisicionList;
    }

    public void setDetalleRequisicionList(List<DetalleRequisicion> detalleRequisicionList) {
        this.detalleRequisicionList = detalleRequisicionList;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        hash += (idRequisicion != null ? idRequisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicion)) {
            return false;
        }
        Requisicion other = (Requisicion) object;
        if ((this.idRequisicion == null && other.idRequisicion != null) || (this.idRequisicion != null && !this.idRequisicion.equals(other.idRequisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Requisicion[ idRequisicion=" + idRequisicion + " ]";
    }
    
}
