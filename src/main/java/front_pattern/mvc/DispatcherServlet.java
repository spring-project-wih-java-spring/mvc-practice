package front_pattern.mvc;

import front_pattern.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/") // 어떤 경로로 들어와도 DispatcherServlet 실행되게끔 함.
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DispatcherServlet service");
        Controller handler = requestMappingHandlerMapping.findHandler(request.getRequestURI());
        try {
            String viewName = handler.handleRequest(request, response);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);

            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
