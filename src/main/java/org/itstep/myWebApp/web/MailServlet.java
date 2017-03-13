package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.service.MailService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {
    private MailService service;
    private WebApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        service = context.getBean(MailService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("mailList.jsp").forward(req, resp);

        String action = req.getParameter("action");
        switch (action){
            case "create":

                break;
            case "delete":

                break;
            case "deleteAll":

                break;
            case "update":

                break;
            case "getAll":

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer someId = Integer.valueOf(req.getParameter("someId"));
        List<Mail> mails = service.getAll(someId);
        req.setAttribute("mailList", mails);
        req.getRequestDispatcher("mailList.jsp").forward(req, resp);

    }
}
