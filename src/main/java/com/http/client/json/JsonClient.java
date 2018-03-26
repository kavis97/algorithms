package com.http.client.json;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import com.http.client.HttpClient;
import com.http.model.Employee;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class JsonClient {

    private URI uri;

    public JsonClient(URI uri) {
        this.uri = uri;
    }

    public Employee execute() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(uri);
            ResponseHandler<Employee> responseHandler = new ResponseHandler<Employee>() {
                @Override
                public Employee handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? getEmployee(entity) : null;
                    }
                    return null;
                }
            };
            return client.execute(get, responseHandler);
        } finally {
            client.close();
        }
    }

    private Employee getEmployee(HttpEntity entity) {
        Employee emp = new Employee();
        emp.setId(123);
        emp.setName("Howards");
        emp.setSomething("nothing so far");
        return emp;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(new JsonClient(new URIBuilder("http://localhost:8080/json/employee").build()).execute());
    }

}
