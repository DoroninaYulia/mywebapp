package org.itstep.myWebApp.web.ui;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mails")
public class MailController {

    @Autowired
    private MailService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(){
        return new ModelAndView("mailList");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getAll(@RequestParam(value = "userId") Integer userId) {
        return new ModelAndView("mailList", "mailList", service.getAll(userId));
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public String deleteAll(@RequestParam(value = "userId") Integer userId) {
        service.deleteAll(userId);
        return "redirect:/mails";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id, @RequestParam(value = "userId") Integer userId) {
        service.delete(id, userId);
        return "redirect:/mails";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute (value = "mail")Mail mail){
        service.save(mail);
        return new ModelAndView("redirect:/mails");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute(value = "user") Mail mail){
        return new ModelAndView("editMail", "mail", new Mail());
    }


}
