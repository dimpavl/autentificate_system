/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Controllers;


import com.autentification_system.DAO.EntranceDAO;
import com.autentification_system.DAO.RoleDAO;
import com.autentification_system.DAO.UserDAO;
import com.autentification_system.Entities.*;
import com.autentification_system.Services.AutentificationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.autentification_system.Utils.SpringContext;
import com.autentification_system.Validator.Validators;
import java.util.*;
import org.springframework.context.ApplicationContext;
/**
 *
 * @author Дима
 */
public class AutentificateController extends HttpServlet {
     
    private String sequreUrl = "WEB-INF/sequre.jsp";
    private String indexUrl = "index.jsp";
        
    private Validators validator;
    private AutentificationService authServ; 
    
    @Override
    public void init(){     
            ApplicationContext context = SpringContext.getContext();
            authServ = context.getBean("autentificationService", AutentificationService.class);            
            validator = context.getBean("validator", Validators.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("userAuth");
        if (user != null){
            if (user.getEntrance().getBlocking()){
                req.getRequestDispatcher(indexUrl).forward(req, resp);
                return;
            }
            if (user.getRole().getRole().equals("admin")){
                Map<String, List<User>> allUsers = authServ.getAllUsers();
                req.setAttribute("allUsers", allUsers);
            }
            req.getRequestDispatcher(sequreUrl).forward(req, resp);
            return;
        }       
        req.getRequestDispatcher(indexUrl).forward(req, resp);
    }                          
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {        
       String login = req.getParameter("login");
       String password = req.getParameter("password");
       Map<String, String> errors = validator.autentificationValidate(login, password);
       if (errors.isEmpty()){
            User user = authServ.autentificate(login, password);
            if (user == null) {
                errors.put("autentificationFailed", "Incorrect login or password");
                req.setAttribute("errors", errors);
                req.getRequestDispatcher(indexUrl).forward(req, resp);
                return;
            }
            if (user.getEntrance().getBlocking()){
                errors.put("autentificationFailed", "You are blocked");
                req.setAttribute("errors", errors);
                req.getRequestDispatcher(indexUrl).forward(req, resp);
                return;
            }
            req.getSession().setAttribute("userAuth", user);
            if (user.getRole().getRole().equals("admin")){
                Map<String, List<User>> allUsers = authServ.getAllUsers();
                req.setAttribute("allUsers", allUsers);
            }
            req.getRequestDispatcher(sequreUrl).forward(req, resp);            
        }else{            
            req.setAttribute("login", login);            
            req.setAttribute("password", password);            
            req.setAttribute("errors", errors);
            req.getRequestDispatcher(indexUrl).forward(req, resp);
        }
       
       
    }

    
    

}
