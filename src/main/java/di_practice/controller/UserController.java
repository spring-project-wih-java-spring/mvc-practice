package di_practice.controller;

import di_practice.annotation.Controller;
import di_practice.annotation.Inject;
import di_practice.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
