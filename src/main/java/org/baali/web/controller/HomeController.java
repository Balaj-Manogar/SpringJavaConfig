package org.baali.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Balaji on 02/11/16.
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    @ResponseBody
    public String home()
    {
        return "You are in home page!!!";
    }

    @RequestMapping("/api")
    @ResponseBody
    public String api()
    {
        return "You are in api page, Welcome Admin!!!";
    }

    @RequestMapping("/user")
    @ResponseBody
    public String userPage()
    {
        return "Welcome User!!";
    }

    @RequestMapping("/403")
    @ResponseBody
    public String deniedPage()
    {
        return "Acces Denied!!!";
    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        return "redirect:/login?logout";
    }
}
