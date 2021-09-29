package servlet;

import db.Connect;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/PutName")
public class Servlet extends HttpServlet {

    private Cookie getCookie(HttpServletRequest request, String name)
    {
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    if(cookies !=null) {
        for(Cookie c: cookies) {
            if(name.equals(c.getName())) {
                cookie = c;
                break;
            }
        }
    }

    return cookie;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     String name = request.getParameter("namme");
     Cookie nameCookie = new Cookie("name", name);
     response.addCookie(nameCookie);
     ArrayList<User> users = Connect.select(name);
        User user = users
                .stream()
                .findFirst().orElse(null);
        if (user != null) {
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/views/phones.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        Cookie _name = getCookie(request, "name");
        request.setAttribute("namee", _name.getValue());
        getServletContext().getRequestDispatcher("/views/phones.jsp").forward(request, response);

    }
}

