/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@Entity
@Table(name = "menu_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuSet.findAll", query = "SELECT m FROM MenuSet m"),
    @NamedQuery(name = "MenuSet.findById", query = "SELECT m FROM MenuSet m WHERE m.id = :id"),
    @NamedQuery(name = "MenuSet.findByName", query = "SELECT m FROM MenuSet m WHERE m.name = :name"),
    @NamedQuery(name = "MenuSet.findByStatus", query = "SELECT m FROM MenuSet m WHERE m.status = :status"),
    @NamedQuery(name = "MenuSet.findByTotalAmount", query = "SELECT m FROM MenuSet m WHERE m.totalAmount = :totalAmount")})
public class MenuSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuSetId")
    private Collection<MenuSetDetail> menuSetDetailCollection;

    public MenuSet() {
    }

    public MenuSet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlTransient
    public Collection<MenuSetDetail> getMenuSetDetailCollection() {
        return menuSetDetailCollection;
    }

    public void setMenuSetDetailCollection(Collection<MenuSetDetail> menuSetDetailCollection) {
        this.menuSetDetailCollection = menuSetDetailCollection;
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
        if (!(object instanceof MenuSet)) {
            return false;
        }
        MenuSet other = (MenuSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qltc.pojo.MenuSet[ id=" + id + " ]";
    }
    
}
