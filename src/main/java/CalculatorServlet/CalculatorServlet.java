package CalculatorServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test_code3.Calculator;
import test_code3.PositiveNumber;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")

public class CalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override // 서블릿 컨테이너가 서블릿 생성 후 초기화 작업을 수행하기에 호출하는 메서드
    public void init(ServletConfig config) throws ServletException {
        log.info("init");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1).toInt(), operator, new PositiveNumber(operand2).toInt());

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }
}
