package HttpTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET / HTTP/1.1");
        Assertions.assertThat(requestLine).isNotNull();
        Assertions.assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=*&operator2=55"));
    }
}
