package CalculatorServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test_code3.Calculator;
import test_code3.PositiveNumber;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")

public class CalculatorServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    private ServletConfig servletConfig;

//    @Override // 서블릿 컨테이너가 서블릿 생성 후 초기화 작업을 수행하기에 호출하는 메서드
//    public void init(ServletConfig config) throws ServletException {
//        log.info("init");
//        this.servletConfig = servletConfig;
//    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1).toInt(), operator, new PositiveNumber(operand2).toInt());

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

//    @Override
//    public void doGet(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        log.info("service");
//        int operand1 = Integer.parseInt(request.getParameter("operand1"));
//        String operator = request.getParameter("operator");
//        int operand2 = Integer.parseInt(request.getParameter("operand2"));
//
//        int result = Calculator.calculate(new PositiveNumber(operand1).toInt(), operator, new PositiveNumber(operand2).toInt());
//
//        PrintWriter writer = response.getWriter();
//        writer.println(result);
//    }

//    @Override
//    public void destroy() {
//        // 자원의 해제시 작업
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return this.servletConfig;
//    }
//
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
}
