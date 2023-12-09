package front_pattern.mvc.controller;

import front_pattern.mvc.annotation.Controller;
import front_pattern.mvc.annotation.RequestMapping;
import reflection.anotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }
}
