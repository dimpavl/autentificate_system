/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Utils;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author Дима
 */
public class SpringContext {
    private static ApplicationContext context = null;
    
    public static synchronized ApplicationContext getContext(){
        if (context == null){
            context = new ClassPathXmlApplicationContext("spring.xml");
        }
        return context;        
    }
}
