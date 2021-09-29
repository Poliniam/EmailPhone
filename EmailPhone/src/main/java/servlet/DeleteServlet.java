package servlet;

import db.Connect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DeleteServlet", value = "/Delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("id");
        Connect.delete(name);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
