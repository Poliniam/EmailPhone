package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.LogRecord;

@WebFilter(filterName = "CheckEmail")
public class FilterServlet implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String email = httpRequest.getParameter("email_");
        String name = httpRequest.getParameter("name_");

        if (!email.matches("[\\w&&[^_]]{6,12}"))

        {
            System.out.println("оп");
            ServletContext ctx = filterConfig.getServletContext();
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/views/error.jsp");
            dispatcher.forward(request, response);
        }

        //chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

}
