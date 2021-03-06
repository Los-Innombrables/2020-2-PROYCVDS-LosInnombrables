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
import edu.eci.cvds.view.LoginBean;

@WebFilter("/faces/login.xhtml")
// @WebFilter("/faces/index.xhtml")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null) && (session.getAttribute("user") != null);

        if (loggedIn) {
            Usuario user = (Usuario) session.getAttribute("user");
            String dashboardPage = LoginBean.redirectPage(user.getRol());
            res.sendRedirect(dashboardPage);
        } else {
            // System.out.println("Filter Working");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
