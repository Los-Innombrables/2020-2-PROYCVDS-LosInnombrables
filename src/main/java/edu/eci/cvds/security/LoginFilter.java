package edu.eci.cvds.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

//@WebFilter("/faces/dashboard/*")
@WebFilter("/faces/index.xhtml")
public class LoginFilter implements Filter {

    public static final String LOGIN_PAGE = "/faces/login.xhtml";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        boolean ajaxRequest = "partial/ajax".equals(req.getHeader("Faces-Request"));

        boolean loggedIn = (session != null) && (session.getAttribute("user") != null);

        if (loggedIn) {
            chain.doFilter(request, response);
        } else if (ajaxRequest) {
            System.out.println("ajax");
            response.setContentType("text/xml");
            response.setCharacterEncoding("UTF-8");
            // response.getWriter().printf(AJAX_REDIRECT_XML, LOGIN_PAGE);
        } else {
            System.out.println("Filter Working");
            res.sendRedirect(LOGIN_PAGE);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

}
