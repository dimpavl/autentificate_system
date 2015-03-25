/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAOImpl;

import com.autentification_system.Aspects.TransactionMethod;
import com.autentification_system.Aspects.TransactionalAspect;
import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.Entities.Entrance;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import java.util.*;

/**
 *
 * @author ����
 */
public class EntranceDAOImpl implements EntranceDAO{
    private TransactionalAspect trmanager;

    public TransactionalAspect getTrmanager() {
        return trmanager;
    }

    public void setTrmanager(TransactionalAspect trmanager) {
        this.trmanager = trmanager;
    }
    
        
    private List<Entrance> _findAll(){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Entrance.findAll");
        return query.list();
    }
    
    private Entrance _findById(int id){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Entrance.findById").setInteger("id", id);              
        return query.list().isEmpty()? null : (Entrance)query.list().get(0);
    }
    
    private List<Entrance> _findByFailedAttempts(int failedAttempts){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Entrance.findByFailedAttempts").setInteger("failedAttempts", failedAttempts);              
        return query.list();
    }
    
    private List<Entrance> _findByBlocking(boolean blocking){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("Entrance.findByBlocking").setBoolean("blocking", blocking);              
        return query.list();
    }
    
    @TransactionMethod
    public List<Entrance> findAll(){
        return _findAll();
    }
    
    @TransactionMethod
    public Entrance findById(int id){
        return _findById(id);
    }
    
    @TransactionMethod
    public List<Entrance> findByFailedAttempts(int failedAttempts){
        return _findByFailedAttempts(failedAttempts);
    }
    
    @TransactionMethod
    public List<Entrance> findByBlocking(boolean blocking){
        return _findByBlocking(blocking);
    }    
}
