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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@Entity
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id"),
    @NamedQuery(name = "UserRole.findByDescription", query = "SELECT u FROM UserRole u WHERE u.description = :description"),
    @NamedQuery(name = "UserRole.findByStatus", query = "SELECT u FROM UserRole u WHERE u.status = :status")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Role roleId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public UserRole() {
    }

    public UserRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qltc.pojo.UserRole[ id=" + id + " ]";
    }
    
}
