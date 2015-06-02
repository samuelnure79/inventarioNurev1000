/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NuRe
 */
@Entity
@Table(name = "TIPO_DEVOLUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDevolucion.findAll", query = "SELECT t FROM TipoDevolucion t"),
    @NamedQuery(name = "TipoDevolucion.findByIdTipoDevolucion", query = "SELECT t FROM TipoDevolucion t WHERE t.idTipoDevolucion = :idTipoDevolucion"),
    @NamedQuery(name = "TipoDevolucion.findByNombre", query = "SELECT t FROM TipoDevolucion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoDevolucion.findByDescripcion", query = "SELECT t FROM TipoDevolucion t WHERE t.descripcion = :descripcion")})
public class TipoDevolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DEVOLUCION")
    private Integer idTipoDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDevolucion")
    private List<Devolucion> devolucionList;

    public TipoDevolucion() {
    }

    public TipoDevolucion(Integer idTipoDevolucion) {
        this.idTipoDevolucion = idTipoDevolucion;
    }

    public TipoDevolucion(Integer idTipoDevolucion, String nombre) {
        this.idTipoDevolucion = idTipoDevolucion;
        this.nombre = nombre;
    }

    public Integer getIdTipoDevolucion() {
        return idTipoDevolucion;
    }

    public void setIdTipoDevolucion(Integer idTipoDevolucion) {
        this.idTipoDevolucion = idTipoDevolucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Devolucion> getDevolucionList() {
        return devolucionList;
    }

    public void setDevolucionList(List<Devolucion> devolucionList) {
        this.devolucionList = devolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDevolucion != null ? idTipoDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDevolucion)) {
            return false;
        }
        TipoDevolucion other = (TipoDevolucion) object;
        if ((this.idTipoDevolucion == null && other.idTipoDevolucion != null) || (this.idTipoDevolucion != null && !this.idTipoDevolucion.equals(other.idTipoDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.TipoDevolucion[ idTipoDevolucion=" + idTipoDevolucion + " ]";
    }
    
}
