package org.itstep.myWebApp.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yulia on 14.03.2017.
 */

@Controller
@RequestMapping(value = "/")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public String root(){
        return "index";
    }
}
