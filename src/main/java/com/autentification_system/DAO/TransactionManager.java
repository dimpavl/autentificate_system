/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAO;

import com.autentification_system.Aspects.TransactionalAspect;

/**
 *
 * @author Дима
 */
public interface TransactionManager {
    public TransactionalAspect getTrmanager();
    

    public void setTrmanager(TransactionalAspect trmanager);
}
