/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Services;
import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.DAO.UserDAO;
import com.autentification_system.Entities.Role;
import com.autentification_system.Entities.User;
import com.autentification_system.Utils.StringUtilities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        
        user = userDao.findFullUser(login);
        if (user == null || !user.getPassword().equals(StringUtilities.md5(password+user.getSalt()))){
            return null;
        }        
        return user;
    }
    
    public Map<String, List<User>> getAllUsers(){
        Map<String, List<User>> res = new HashMap<String, List<User>>();
        List<Role> roles = roleDao.findAll();
        for (Role r: roles){
            List<User> temp =  roleDao.getUsersByRole(r);
            res.put(r.getRole(), temp);
        }
        
        return res;
    }
    
}
