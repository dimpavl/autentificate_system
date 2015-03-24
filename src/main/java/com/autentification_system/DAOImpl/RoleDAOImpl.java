/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAOImpl;

import com.autentification_system.Aspects.TransactionMethod;
import com.autentification_system.Aspects.TransactionalAspect;
import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.Entities.Role;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.classic.Session;


/**
 *
 * @author Дима
 */
public class RoleDAOImpl implements RoleDAO{
    private TransactionalAspect trmanager;

    public TransactionalAspect getTrmanager() {
        return trmanager;
    }

    public void setTrmanager(TransactionalAspect trmanager) {
        this.trmanager = trmanager;
    }    
    
    
//    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
//    @NamedQuery(name = "Role.findByIdrole", query = "SELECT r FROM Role r WHERE r.idrole = :idrole"),
//    @NamedQuery(name = "Role.findByRole", query = "SELECT r FROM Role r WHERE r.role = :role")})
    @TransactionMethod
    public List<Role> findAll(){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Role.findAll");
        return query.list();
    }
}
