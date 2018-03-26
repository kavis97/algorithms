package com.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {
    private URI uri;

    public HttpClient(URI uri) {
        this.uri = uri;
    }

    public String execute() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(uri);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    }
                    return null;
                }
            };
            return client.execute(get, responseHandler);
        } finally {
            client.close();
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(new HttpClient(new URIBuilder("http://localhost:8080/bubble").addParameter("items", "10,9,4,5,8,7,11").build()).execute());
    }
}