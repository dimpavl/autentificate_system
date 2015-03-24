/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 *
 * @author Дима
 */
@Aspect
public class TransactionalAspect {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Around("@annotation(com.autentification_system.Aspects.TransactionMethod)")
    public Object transctionalContext(ProceedingJoinPoint proceed){        
        Session session = sessionFactory.getCurrentSession();
        Object result = null;
        try{
            session.beginTransaction();
            result = proceed.proceed();
            session.getTransaction().commit();
        }catch(Throwable e){
            session.getTransaction().rollback();
        }
        return result;        
    }
    
}
