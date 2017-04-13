package ua.skillsup.betandlose.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class AuthFilter implements Filter {

    public final static String AUTH_ATTR_DATE = "Date";
    public final static String AUTH_ATTR_LOGIN = "Login";
    public final static String AUTH_ATTR_ROLE = "Role";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        LocalDateTime logInTime = (LocalDateTime) session.getAttribute(AUTH_ATTR_DATE);
        if (Objects.isNull(logInTime)
                || logInTime.plusMinutes(10).isBefore(LocalDateTime.now())) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        }

        String role = (String) session.getAttribute(AUTH_ATTR_ROLE);
        if (role.equals("A")) {
            ((HttpServletResponse) servletResponse).sendRedirect("/adminprofile");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
