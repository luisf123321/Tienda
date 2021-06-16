/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "detallescompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallescompra.findAll", query = "SELECT d FROM Detallescompra d"),
    @NamedQuery(name = "Detallescompra.findById", query = "SELECT d FROM Detallescompra d WHERE d.id = :id"),
    @NamedQuery(name = "Detallescompra.findByCantidad", query = "SELECT d FROM Detallescompra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallescompra.findByValor", query = "SELECT d FROM Detallescompra d WHERE d.valor = :valor")})
public class Detallescompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "idproducto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detallescompra")
    private Detallefactura detallefactura;

    public Detallescompra() {
    }

    public Detallescompra(Integer id) {
        this.id = id;
    }

    public Detallescompra(Integer id, int cantidad, double valor) {
        this.id = id;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Detallefactura getDetallefactura() {
        return detallefactura;
    }

    public void setDetallefactura(Detallefactura detallefactura) {
        this.detallefactura = detallefactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallescompra)) {
            return false;
        }
        Detallescompra other = (Detallescompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Detallescompra[ id=" + id + " ]";
    }
    
}
