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

@WebServlet(name = "ShowAllServlet", value = "/ShowAll")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<User> users = Connect.showAll();
        request.setAttribute("person", users);
        /*for(User person : users){

        }*/
        if(users.size() != 0)
        {
            System.out.println("Good");
        }
        getServletContext().getRequestDispatcher("/views/allPhones.jsp").forward(request, response);
    }
}
