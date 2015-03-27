/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAO;

import com.autentification_system.Aspects.TransactionMethod;
import com.autentification_system.Aspects.TransactionalAspect;
import com.autentification_system.DAO.UserDAO;
import com.autentification_system.Entities.Entrance;
import com.autentification_system.Entities.Role;
import com.autentification_system.Entities.User;
import java.util.*;
import org.hibernate.Query;
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
    
    
    private List<User> _findAll(){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findAll");        
        return query.list();
    }
    
        
    private User _findByUserName(String username){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findByUsername").setString("username", username);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
    private User _findByUserId(int userId){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findByUserId").setInteger("userId", userId);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
    
    private User _findByLogin(String login){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findByLogin").setString("login", login);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
    
    private User _findByPassword(String password){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findByPassword").setString("password", password);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
    
    private User _findBySalt(String salt){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findBySalt").setString("salt", salt);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
    private User _findByEmail(String email){
        Session session = trmanager.getSession();
        Query query = session.getNamedQuery("User.findByEmail").setString("email", email);              
        return query.list().isEmpty()? null : (User)query.list().get(0);
    }
    
   
    @TransactionMethod
    public List<User> findAll(){
        return _findAll();
    }
    
    
    @TransactionMethod
    public User findByUserName(String username){
       return _findByUserName(username);
    }
    
    @TransactionMethod
    public User findByUserId(int userId){
        return _findByUserId(userId);
    }
    
    @TransactionMethod
    public User findByLogin(String login){
        return _findByLogin(login);
    }
    
    @TransactionMethod
    public User findByPassword(String password){
       return _findByPassword(password);
    }
    
    @TransactionMethod
    public User findBySalt(String salt){
        return _findBySalt(salt);
    }
    
    @TransactionMethod
    public User findByEmail(String email){
        return _findByEmail(email);
    }
        
    
    @TransactionMethod
    public User insertNewUser(User user) {
        Session session = trmanager.getSession();
        session.save(user);
        return user;
    }
    
    @TransactionMethod
    public User findFullUser(String login){
        Session session = trmanager.getSession();
        User user = _findByLogin(login);
        if (user != null){
            user.getRole().getRole(); 
            user.getEntrance().getBlocking();
        }
        return user;
    }
}
