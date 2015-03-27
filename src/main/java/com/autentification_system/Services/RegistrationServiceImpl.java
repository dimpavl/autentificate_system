/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Services;

import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.DAO.UserDAO;
import com.autentification_system.Entities.Entrance;
import com.autentification_system.Entities.Role;
import com.autentification_system.Entities.User;
import com.autentification_system.Utils.StringUtilities;
import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author Дима
 */
public class RegistrationServiceImpl implements RegistrationService{    
    private UserDAO userDao;
    private RoleDAO roleDao;
    private EntranceDAO entranceDao;

    public EntranceDAO getEntranceDao() {
        return entranceDao;
    }

    public void setEntranceDao(EntranceDAO entranceDao) {
        this.entranceDao = entranceDao;
    }
    
    public RoleDAO getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }
    
    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }
    
    

    public User registrate(String username, String login, String email, String password, String password_confirm) {
        String salt = StringUtilities.randomStringGenerator(20);
        String pass = StringUtilities.md5(password + salt);        
        
        User user = userDao.findByUserName(username);
        if (user != null) return null;
        
        user = userDao.findByLogin(login);
        if (user !=null) return null;
        
        user = userDao.findByEmail(email);
        if (user != null) return null;
        
        user = new User(0, username, login, pass, salt, email);
        Role role = roleDao.findByIdrole(0);        
        Entrance entrance = new Entrance(0, false);                        
        
        user.setRole(role);        
        entrance.setIduser(user);
        user.setEntrance(entrance);
        user = userDao.insertNewUser(user);
        entranceDao.insertNewEntrance(entrance);
        
        return user;
    }
            
}
