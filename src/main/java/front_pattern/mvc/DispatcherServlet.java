package front_pattern.mvc;

import front_pattern.mvc.controller.Controller;
import front_pattern.mvc.controller.HandlerKey;
import front_pattern.mvc.view.JspViewResolver;
import front_pattern.mvc.view.View;
import front_pattern.mvc.view.ViewResolver;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/") // 어떤 경로로 들어와도 DispatcherServlet 실행되게끔 함.
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping.init();

        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DispatcherServlet service");

        try {
            Controller handler = requestMappingHandlerMapping.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            String viewName = handler.handleRequest(request, response);

            for (ViewResolver viewResolver: viewResolvers) {
                View view = viewResolver.resolveView(viewName);
                view.render(new HashMap<>(), request, response);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);

            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
