/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Controllers;


import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.Entities.Role;
import com.autentification_system.Services.AutentificationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.autentification_system.Utils.SpringContext;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
/**
 *
 * @author Дима
 */
public class AutentificateController extends HttpServlet {
    private AutentificationService autServ;  
    private String sequreUrl = "WEB-INF/sequre.jsp";
    private String indexUrl = "index.jsp";
    private RoleDAO roleDao;
    
    @Override
    public void init(){     
            ApplicationContext context = SpringContext.getContext();
            autServ = (AutentificationService)context.getBean("autentificationService");
            roleDao = (RoleDAO)context.getBean("roleDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("userAuth") != null){
            
            List<Role> lst = roleDao.findAll();
            req.setAttribute("roles", lst);
            req.getRequestDispatcher(sequreUrl).forward(req, resp);
            return;
        }
        Role r = roleDao.findByIdrole(0);
        req.getRequestDispatcher(indexUrl).forward(req, resp);
    }                          
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
       String login = req.getParameter("login");
       String password = req.getParameter("password");
       
       req.getRequestDispatcher(sequreUrl).forward(req, resp);
       
    }

    
    

}
