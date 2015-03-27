/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Services;

import com.autentification_system.Entities.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Дима
 */
public interface AutentificationService {
    public User autentificate(String login, String password);
    public Map<String, List<User>> getAllUsers();
}
