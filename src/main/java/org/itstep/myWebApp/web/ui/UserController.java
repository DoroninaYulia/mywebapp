package org.itstep.myWebApp.web.ui;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getAll(){
        return new ModelAndView("userList", "userList", service.getAll());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(value = "id") Integer id){
        service.delete(id);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id){
        return new ModelAndView("editUser", "user", service.getById(id));
    }

    @RequestMapping(value = "/editUser")
    public ModelAndView showForm(){
        return new ModelAndView("editUser", "user", new User());
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        service.save(user);
        return "redirect:/users";
    }

/*    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("user", new User());
        return "editUser";
    }*/

/*    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest req){
        String id = req.getParameter("id");
        User user = id.isEmpty() ? new User() : service.getById(Integer.valueOf(id));

        user.setName(req.getParameter("name"));
        user.setLastname(req.getParameter("lastname"));
        user.setCity(req.getParameter("city"));
        user.setEmail(req.getParameter("email"));
        service.save(user);

        return "redirect:/users";
    }*/

}
