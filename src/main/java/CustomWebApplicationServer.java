import HttpTest.HttpRequest;
import HttpTest.QueryStrings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test_code3.Calculator;
import test_code3.PositiveNumber;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class CustomWebApplicationServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] start {} port", port);

            Socket clientSocket;

            logger.info("[CustomWebApplicationServer] wating for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream();) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    HttpRequest httpRequest = new HttpRequest(br);

                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryString();

                        int operand1 = Integer.valueOf(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");;
                        int operand2 = Integer.valueOf(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new PositiveNumber(operand1).toInt(), operator, new PositiveNumber(operand2).toInt());
                    }
                }
            }

        }

    }

}
