package HttpTest;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {

        this.requestLine = new RequestLine(br.readLine());
    }
}
