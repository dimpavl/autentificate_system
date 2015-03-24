/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAOImpl;

import com.autentification_system.Aspects.TransactionalAspect;
import com.autentification_system.DAO.UserDAO;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 *
 * @author Дима
 */
public class UserDAOImpl implements UserDAO{
    private TransactionalAspect trmanager;

    public TransactionalAspect getTrmanager() {
        return trmanager;
    }

    public void setTrmanager(TransactionalAspect trmanager) {
        this.trmanager = trmanager;
    }
    
    
    
    
    
        
}
