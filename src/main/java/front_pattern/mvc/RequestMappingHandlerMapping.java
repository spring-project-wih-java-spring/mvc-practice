package front_pattern.mvc;

import front_pattern.mvc.controller.*;
import reflection.anotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }

}
