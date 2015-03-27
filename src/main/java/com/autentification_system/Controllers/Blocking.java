/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Controllers;

import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.Entities.Entrance;
import com.autentification_system.Entities.User;
import com.autentification_system.Services.AutentificationService;
import com.autentification_system.Utils.SpringContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Дима
 */
public class Blocking extends HttpServlet {
    private String sequreUrl = "WEB-INF/sequre.jsp";
    private String indexUrl = "index.jsp";
    
    private EntranceDAO entranceDao; 
    @Override
    public void init(){     
            ApplicationContext context = SpringContext.getContext();
            entranceDao = context.getBean("entranceDao", EntranceDAO.class);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         User user = (User)req.getSession().getAttribute("userAuth");
         if (user != null){
            if (user.getEntrance().getBlocking()){                
                return;
            }
            if (user.getRole().getRole().equals("admin")){
                int id = Integer.parseInt(req.getParameter("id"));
                Entrance ent = entranceDao.findById(id);
                boolean checked = Boolean.parseBoolean(req.getParameter("checked"));
                ent.setBlocking(checked);
                entranceDao.updateEntrance(ent);
            }            
        }               
    }    
   

}
