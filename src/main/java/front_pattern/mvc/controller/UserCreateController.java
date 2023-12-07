package front_pattern.mvc.controller;

import front_pattern.mvc.model.User;
import front_pattern.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserRepository.save(new User(request.getParameter("userID"), request.getParameter("name")));
        return "redirect:/users";
    }
}
