/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Validator;
import java.util.*;
import java.util.regex.*;
/**
 *
 * @author Дима
 */
public class Validators {
    public Map<String, String> registrationValidate(String username, String login, String email, 
                                                    String password, String password_confirm){
        Map<String, String> errors = new HashMap<String, String>();
        if (username.length() > 25) 
            errors.put("username", "Max limit for username are 25 characters!");                  
        if (!Pattern.compile("^[a-zA-Z_]{1}[a-zA-Z0-9_]{3,24}$").matcher(username).matches())
            errors.put("username", "You can use only alphanumeric characters and the underscore for username!");       
        
        if (login.length() < 4 || login.length() > 25)
            errors.put("login", "Login must be between 4 or 25 characters!");        
        if (!Pattern.compile("^[a-zA-Z_]{1}[a-zA-Z0-9_]{3,24}$").matcher(login).matches())
            errors.put("login", "You can use only alphanumeric characters and the underscore for login!");        
        
        if (!Pattern.compile("^\\w+([\\.\\w]+)*\\w@\\w((\\.\\w)*\\w+)*\\.\\w{2,3}$").matcher(email).matches())
            errors.put("email", "Email is incorrect!");
        
        if (!password.equals(password_confirm))        
            errors.put("password", "Your passwords do not match!");                
        if (!Pattern.compile("^[a-zA-Z0-9_]{1}[a-zA-Z0-9_]{5,24}$")
                .matcher(password).matches())
            errors.put("password", "You can use only alphanumeric characters and the underscore for password!");

        return errors;
    }
    
    public Map<String, String> autentificationValidate(String login, String password){
         Map<String, String> errors = new HashMap<String, String>();
         if (login.length() < 4 || login.length() > 25)
            errors.put("login", "Login must be between 4 or 25 characters!");        
         if (!Pattern.compile("^[a-zA-Z_]{1}[a-zA-Z0-9_]{3,24}$").matcher(login).matches())
            errors.put("login", "You can use only alphanumeric characters and the underscore for login!");
         if (!Pattern.compile("^[a-zA-Z0-9_]{1}[a-zA-Z0-9_]{5,24}$")
                .matcher(password).matches())
            errors.put("password", "You can use only alphanumeric characters and the underscore for password!");
         
         return errors;
    }
}
