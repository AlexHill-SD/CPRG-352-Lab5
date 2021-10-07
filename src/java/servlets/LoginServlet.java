/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.AccountService;
import managers.User;

/**
 *
 * @author BritishWaldo
 */
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        if(request.getParameterMap().containsKey("logout"))
        {
            session.invalidate();
            
            session = request.getSession();
            
            request.setAttribute("server_message", "You have been successfully logged out, have a good day.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        else if (session.getAttribute("username") != null)
        {
            response.sendRedirect("home");
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        try
        {
            String inputUsername = request.getParameter("username");
            String inputPassword = request.getParameter("password");
            
            if (inputUsername.equals(""))
            {
                request.setAttribute("server_message", "Please don't leave the username field blank");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            else if (inputPassword.equals(""))
            {
                request.setAttribute("server_message", "Please don't leave the password field blank");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            else
            {
                AccountService accountServices = new AccountService();

                User loginResult = accountServices.login(inputUsername, inputPassword);

                if (loginResult != null)
                {
                    session.setAttribute("username", loginResult.getUsername());

                    response.sendRedirect("home");
                }
                else
                {
                    request.setAttribute("username", inputUsername);
                    request.setAttribute("password", inputPassword);
                    request.setAttribute("server_message", "Incorrect login details, please try again");

                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }
            }
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
            
            if (request.getParameter("username") == null)
            {
                request.setAttribute("server_message", "Please don't leave the username field blank");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            else if (request.getParameter("password") == null)
            {
                request.setAttribute("server_message", "Please don't leave the password field blank");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }        
    }
}
