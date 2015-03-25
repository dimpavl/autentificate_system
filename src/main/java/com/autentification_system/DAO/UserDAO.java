/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAO;

import com.autentification_system.Entities.User;
import java.util.*;

/**
 *
 * @author Дима
 */
public interface UserDAO extends TransactionManager{

    public List<User> findAll();
        
    public User findByUserName(String username);
        
    public User findByUserId(int userId);
       
    public User findByLogin(String login);
       
    public User findByPassword(String password);
        
    public User findBySalt(String salt);
    
    public User findByEmail(String email);
}
