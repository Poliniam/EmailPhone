package servlet;

import db.Connect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "InsertServlet", value = "/Insert")
public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id_ = request.getParameter("id_");
        String name_ = request.getParameter("name_");
        String email_ = request.getParameter("email_");
        String phone_ = request.getParameter("phone_");
        int id__ = Integer.parseInt(id_);

        Connect.insert(id__, name_, email_, phone_);
        /*Connect.showAll();
        getServletContext().getRequestDispatcher("/views/allPhones.jsp").forward(request, response);*/
    }

}
