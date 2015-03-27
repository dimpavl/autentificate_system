/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAO;

import com.autentification_system.Entities.Role;
import com.autentification_system.Entities.User;
import java.util.*;

/**
 *
 * @author Дима
 */
public interface RoleDAO extends TransactionManager{
     
    public List<Role> findAll();        
    public Role findByIdrole(int idrole);        
    public Role findByRole(String role) ;
    public List<User> getUsersByRole(Role role);
    
}
