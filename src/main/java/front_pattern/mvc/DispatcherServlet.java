package front_pattern.mvc;

import front_pattern.mvc.controller.Controller;
import front_pattern.mvc.controller.HandlerKey;
import front_pattern.mvc.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.anotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/") // 어떤 경로로 들어와도 DispatcherServlet 실행되게끔 함.
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private List<HandlerAdapter> handlerAdapters;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping.init();

        handlerAdapters = Arrays.asList(new SimpleControllerHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DispatcherServlet service");

        try {
            Controller handler = requestMappingHandlerMapping.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));

            handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            ModelAndView modelAndView = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"))
                    .handle(request, response, handler);

            for (ViewResolver viewResolver: viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), request, response);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(modelAndView.getViewName());

            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
