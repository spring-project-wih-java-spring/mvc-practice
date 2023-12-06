package front_pattern.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/") // 어떤 경로로 들어와도 DispatcherServlet 실행되게끔 함.
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DispatcherServlet service");
    }
}
