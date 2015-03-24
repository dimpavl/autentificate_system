/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.ServicesImpl;

import com.autentification_system.Entities.User;
import com.autentification_system.Services.RegistrationService;
import com.autentification_system.Utils.StringUtilities;

/**
 *
 * @author Дима
 */
public class RegistrationServiceImpl implements RegistrationService{

    

    public User registrate(String username, String login, String email, String password, String password_confirm) {
        String salt = StringUtilities.randomStringGenerator(20);
        String pass = StringUtilities.md5(password + salt);
        User user = new User(0, username, login, pass, salt, email);
        
        return user;
    }
    
}
