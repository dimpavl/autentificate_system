/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Дима
 */
@Entity
@Table(name = "entrance")
@NamedQueries({
    @NamedQuery(name = "Entrance.findAll", query = "SELECT e FROM Entrance e"),
    @NamedQuery(name = "Entrance.findById", query = "SELECT e FROM Entrance e WHERE e.id = :id"),
    @NamedQuery(name = "Entrance.findByFailedAttempts", query = "SELECT e FROM Entrance e WHERE e.failedAttempts = :failedAttempts"),
    @NamedQuery(name = "Entrance.findByBlocking", query = "SELECT e FROM Entrance e WHERE e.blocking = :blocking")})
public class Entrance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "failed_attempts")
    private int failedAttempts;
    @Basic(optional = false)
    @Column(name = "blocking")
    private short blocking;
    @JoinColumn(name = "iduser", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User iduser;

    public Entrance() {
    }

    public Entrance(Integer id) {
        this.id = id;
    }

    public Entrance(Integer id, int failedAttempts, short blocking) {
        this.id = id;
        this.failedAttempts = failedAttempts;
        this.blocking = blocking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public short getBlocking() {
        return blocking;
    }

    public void setBlocking(short blocking) {
        this.blocking = blocking;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
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
        if (!(object instanceof Entrance)) {
            return false;
        }
        Entrance other = (Entrance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autentification_system.Entities.Entrance[ id=" + id + " ]";
    }
    
}
