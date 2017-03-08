package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer id;

        if (action != null) {
            switch (action){
                case "create":
                    req.setAttribute("user", new User("name", "lastname", "city", "email"));
                    req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                    break;
                case "update":
                    id = Integer.valueOf(req.getParameter("id"));
                    User user = service.getById(id);
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                    break;
                case "delete":
                    id = Integer.valueOf(req.getParameter("id"));
                    service.delete(id);
                    resp.sendRedirect("users");
                    break;
            }
        }else{
            List<User> users = service.getAll();
            req.setAttribute("userList", users);
            req.getRequestDispatcher("userList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String city = req.getParameter("city");
        String email = req.getParameter("email");

        if(id == null || id.isEmpty()){
            service.add(new User(name, lastname, city, email));
        }else{
            service.update(Integer.valueOf(id), new User(name, lastname, city, email));
        }

        resp.sendRedirect("users");
    }
}
