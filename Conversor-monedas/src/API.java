import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public Json consultarApi() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6de7ec22184d96b9a301a399/latest/USD");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Json.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}