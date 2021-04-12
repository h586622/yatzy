package test;


import org.junit.Before;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class LoggInnUtTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setup() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }


}
