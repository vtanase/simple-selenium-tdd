package com.vlad.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vlad.error.Errors;

public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 9095249028907503301L;
  private static final String HOME_VIEW = "/WEB-INF/jsp/home.jsp";
  private static final String LOGIN_VIEW = "/WEB-INF/jsp/login.jsp";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    System.out.println("attempting login with [" + username + "," + password + "]");
    if (username.equals(password)) {
      req.getRequestDispatcher(HOME_VIEW).forward(req, resp);
    }
    else {
      req.setAttribute("error", Errors.LOGIN_FAILED);
      req.getRequestDispatcher(LOGIN_VIEW).forward(req, resp);
    }
  }

}
