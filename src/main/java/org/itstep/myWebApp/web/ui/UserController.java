package org.itstep.myWebApp.web.ui;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yulia on 13.03.2017.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("userList", service.getAll());
        return "userList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("user", new User());
        return "editUser";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest req){
        Integer id = Integer.valueOf(req.getParameter("id"));
        service.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest req, Model model){
        Integer id = Integer.valueOf(req.getParameter("id"));
        model.addAttribute("user", service.getById(id));
        return "editUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest req){
        String id = req.getParameter("id");
        User user = id.isEmpty() ? new User() : service.getById(Integer.valueOf(id));

        user.setName(req.getParameter("name"));
        user.setLastname(req.getParameter("lastname"));
        user.setCity(req.getParameter("city"));
        user.setEmail(req.getParameter("email"));
        service.save(user);

        return "redirect:/users";
    }


}
