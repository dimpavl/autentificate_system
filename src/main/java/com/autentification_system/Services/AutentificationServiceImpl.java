/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Services;
import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.DAO.UserDAO;
import com.autentification_system.Entities.User;
import com.autentification_system.Utils.StringUtilities;
/**
 *
 * @author Дима
 */
public class AutentificationServiceImpl implements AutentificationService{    
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
    
    public User autentificate(String login, String password) {        
        User user = null;
        
        user = userDao.findByLogin(login);
        if (user == null || !user.getPassword().equals(StringUtilities.md5(password+user.getSalt()))){
            return null;
        }
        return user;
    }
    
}
