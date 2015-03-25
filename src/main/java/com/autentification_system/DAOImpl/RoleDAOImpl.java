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
    
       
    private List<Role> _findAll(){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Role.findAll");
        return query.list();
    }
        
    private Role _findByIdrole(int idrole) {
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Role.findByIdrole").setInteger("idrole", idrole);
        return query.list().isEmpty() ? null: (Role)query.list().get(0);
    }
    
    
    private Role _findByRole(String role) {
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Role.findByRole").setString("role", role);
        return query.list().isEmpty() ? null: (Role)query.list().get(0);
    }
    
            
    @TransactionMethod
    public List<Role> findAll(){
        return _findAll();
    }
    
    @TransactionMethod
    public Role findByIdrole(int idrole) {
        return _findByIdrole(idrole);
    }
    
    @TransactionMethod
    public Role findByRole(String role) {
        return _findByRole(role);
    }
    
    
}
