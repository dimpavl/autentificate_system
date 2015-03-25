/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.DAO;

import com.autentification_system.Entities.Entrance;
import java.util.*;
/**
 *
 * @author Дима
 */
public interface EntranceDAO extends TransactionManager{    
    public List<Entrance> findAll();
        
    public Entrance findById(int id);
       
    public List<Entrance> findByFailedAttempts(int failedAttempts);
        
    public List<Entrance> findByBlocking(boolean blocking);
}
