/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.ServicesImpl;
import com.autentification_system.Entities.User;
import com.autentification_system.Services.AutentificationService;
/**
 *
 * @author Дима
 */
public class AutentificationServiceImpl implements AutentificationService{    
    public User login(String login, String password) {        
        User user = new User(0, "", login, password, "", "");
        return user;
    }
    
}
