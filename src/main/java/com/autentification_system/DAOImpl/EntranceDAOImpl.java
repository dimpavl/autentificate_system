/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAOImpl;

import com.autentification_system.Aspects.TransactionalAspect;
import com.autentification_system.DAO.EntranceDAO;

/**
 *
 * @author Дима
 */
public class EntranceDAOImpl implements EntranceDAO{
    private TransactionalAspect trmanager;

    public TransactionalAspect getTrmanager() {
        return trmanager;
    }

    public void setTrmanager(TransactionalAspect trmanager) {
        this.trmanager = trmanager;
    }
    
    
    
}
