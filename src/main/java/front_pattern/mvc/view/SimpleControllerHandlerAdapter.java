package front_pattern.mvc.view;

import front_pattern.mvc.HandlerAdapter;
import front_pattern.mvc.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse respons, Object handler) throws Exception {
        String viewName = ((Controller) handler).handleRequest(request, respons);
        return new ModelAndView(viewName);
    }
}
