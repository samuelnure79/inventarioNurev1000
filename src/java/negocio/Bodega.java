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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NuRe
 */
@Entity
@Table(name = "BODEGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega"),
    @NamedQuery(name = "Bodega.findByCantidadPasillos", query = "SELECT b FROM Bodega b WHERE b.cantidadPasillos = :cantidadPasillos"),
    @NamedQuery(name = "Bodega.findByEstantesPorPasillo", query = "SELECT b FROM Bodega b WHERE b.estantesPorPasillo = :estantesPorPasillo"),
    @NamedQuery(name = "Bodega.findByNombre2", query = "SELECT b FROM Bodega b WHERE b.nombre2 = :nombre2"),
    @NamedQuery(name = "Bodega.findByCatidadEstante", query = "SELECT b FROM Bodega b WHERE b.catidadEstante = :catidadEstante"),
    @NamedQuery(name = "Bodega.findByProductoPorEstante", query = "SELECT b FROM Bodega b WHERE b.productoPorEstante = :productoPorEstante"),
    @NamedQuery(name = "Bodega.findByUbicacion", query = "SELECT b FROM Bodega b WHERE b.ubicacion = :ubicacion")})
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BODEGA")
    private Integer idBodega;
    @Column(name = "CANTIDAD_PASILLOS")
    private BigInteger cantidadPasillos;
    @Column(name = "ESTANTES_POR_PASILLO")
    private BigInteger estantesPorPasillo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE2")
    private String nombre2;
    @Column(name = "CATIDAD_ESTANTE")
    private BigInteger catidadEstante;
    @Column(name = "PRODUCTO_POR_ESTANTE")
    private BigInteger productoPorEstante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "UBICACION")
    private String ubicacion;
    @OneToMany(mappedBy = "idBodega")
    private List<Inventario> inventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBodega")
    private List<Lote> loteList;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodega(Integer idBodega, String nombre2, String ubicacion) {
        this.idBodega = idBodega;
        this.nombre2 = nombre2;
        this.ubicacion = ubicacion;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public BigInteger getCantidadPasillos() {
        return cantidadPasillos;
    }

    public void setCantidadPasillos(BigInteger cantidadPasillos) {
        this.cantidadPasillos = cantidadPasillos;
    }

    public BigInteger getEstantesPorPasillo() {
        return estantesPorPasillo;
    }

    public void setEstantesPorPasillo(BigInteger estantesPorPasillo) {
        this.estantesPorPasillo = estantesPorPasillo;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public BigInteger getCatidadEstante() {
        return catidadEstante;
    }

    public void setCatidadEstante(BigInteger catidadEstante) {
        this.catidadEstante = catidadEstante;
    }

    public BigInteger getProductoPorEstante() {
        return productoPorEstante;
    }

    public void setProductoPorEstante(BigInteger productoPorEstante) {
        this.productoPorEstante = productoPorEstante;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @XmlTransient
    public List<Lote> getLoteList() {
        return loteList;
    }

    public void setLoteList(List<Lote> loteList) {
        this.loteList = loteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
