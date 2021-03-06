package hu.dpc.rt.psp.util;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpHeaders;

public class RestTemplateHeaderModifierInterceptor
        implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException
    {
        HttpHeaders headers = request.getHeaders();
        headers.remove("Accept-Encoding");
        headers.remove("Accept-Charset");
        headers.remove("Accept");

        return execution.execute(request, body);
    }
}