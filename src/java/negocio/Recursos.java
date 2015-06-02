/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NuRe
 */
@Entity
@Table(name = "RECURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findByIdRecurso", query = "SELECT r FROM Recursos r WHERE r.idRecurso = :idRecurso"),
    @NamedQuery(name = "Recursos.findByUrl", query = "SELECT r FROM Recursos r WHERE r.url = :url")})
public class Recursos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECURSO")
    private BigDecimal idRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "ID_TIPO_USUARIO", referencedColumnName = "ID_TIPO_USUARIO")
    @ManyToOne
    private TipoUsuario idTipoUsuario;

    public Recursos() {
    }

    public Recursos(BigDecimal idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Recursos(BigDecimal idRecurso, String url) {
        this.idRecurso = idRecurso;
        this.url = url;
    }

    public BigDecimal getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(BigDecimal idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Recursos[ idRecurso=" + idRecurso + " ]";
    }
    
}
