/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Utils;

import java.util.Random;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Дима
 */
public class StringUtilities {
    public static String randomStringGenerator(int length)
    {
        char[] chars = new char[length];
        String validChars = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++){            
            Random rnd = new Random();
            chars[i] = validChars.charAt(rnd.nextInt(validChars.length()));
        }
        return (new String(chars));
    } 
    
    public static String md5(String str){        
       return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    
    
}
