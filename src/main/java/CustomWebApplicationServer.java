import HttpTest.ClientRequestHandler;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CustomWebApplicationServer {

    private final int port;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

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
                executorService.execute(new ClientRequestHandler(clientSocket));
            }

        }

    }

}
