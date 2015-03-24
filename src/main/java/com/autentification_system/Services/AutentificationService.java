/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Services;

import com.autentification_system.Entities.User;

/**
 *
 * @author Дима
 */
public interface AutentificationService {
    public User login(String login, String password);    
}
