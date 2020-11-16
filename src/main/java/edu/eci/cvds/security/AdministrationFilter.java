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

import edu.eci.cvds.entities.Usuario;

@WebFilter("/faces/dashboard/administrar/*")
public class AdministrationFilter implements Filter {

    public static final String LOGIN_PAGE = "/faces/login.xhtml";
    private static final String MAIN_PAGE = "/faces/dashboard/main.xhtml";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        // boolean ajaxRequest = "partial/ajax".equals(req.getHeader("Faces-Request"));
        Usuario user = (Usuario) session.getAttribute("user");

        boolean loggedIn = (session != null) && (user != null);

        if (loggedIn) {
            if (user.getRol() == 1) {
                chain.doFilter(request, response);
            } else {
                // System.out.println("Admin 1 Filter Working");
                res.sendRedirect(MAIN_PAGE);
            }
        } else {
            // System.out.println("Admin Filter Working");
            res.sendRedirect(LOGIN_PAGE);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
