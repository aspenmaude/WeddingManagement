/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@Entity
@Table(name = "menu_set_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuSetDetail.findAll", query = "SELECT m FROM MenuSetDetail m"),
    @NamedQuery(name = "MenuSetDetail.findById", query = "SELECT m FROM MenuSetDetail m WHERE m.id = :id")})
public class MenuSetDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "menu_set_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MenuSet menuSetId;
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product foodId;

    public MenuSetDetail() {
    }

    public MenuSetDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MenuSet getMenuSetId() {
        return menuSetId;
    }

    public void setMenuSetId(MenuSet menuSetId) {
        this.menuSetId = menuSetId;
    }

    public Product getFoodId() {
        return foodId;
    }

    public void setFoodId(Product foodId) {
        this.foodId = foodId;
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
        if (!(object instanceof MenuSetDetail)) {
            return false;
        }
        MenuSetDetail other = (MenuSetDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qltc.pojo.MenuSetDetail[ id=" + id + " ]";
    }
    
}
