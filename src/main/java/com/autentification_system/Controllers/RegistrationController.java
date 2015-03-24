/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentification_system.Controllers;

import com.autentification_system.Entities.User;
import com.autentification_system.Services.RegistrationService;
import com.autentification_system.Utils.SpringContext;
import com.autentification_system.Validators.RegistrationValidate;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Дима
 */
public class RegistrationController extends HttpServlet {

    private String registrateUrl = "registration.jsp";
    private String successUrl = "./login";
    private String failure = "registration.jsp";
    
    private RegistrationValidate regVal;
    private RegistrationService regServ;
    @Override
    public void init() throws ServletException {
        ApplicationContext context = SpringContext.getContext();
        regVal = (RegistrationValidate)context.getBean("registrationValidator");
        regServ = (RegistrationService)context.getBean("registrationService");
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(registrateUrl).forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("password_confirm");
        
        Map<String, String> errors = regVal.validate(username, login, email, password, password_confirm);
        if (errors.isEmpty()){
            User user = regServ.registrate(username, login, email, password, password_confirm);
            req.getSession().setAttribute("userAuth", user);
            resp.sendRedirect(successUrl);        
        }
        else{
            req.setAttribute("username", username);
            req.setAttribute("login", login);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("password_confirm", password_confirm);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher(failure).forward(req, resp);
        }
        
        
        
    }
    

}
