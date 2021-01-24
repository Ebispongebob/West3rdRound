package WestTwo2020.thirdRound;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class httpComponents {
    private  String body;

    public void getFile ()throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://covid-api.mmediagroup.fr/v1/cases")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest,responseBodyHandler);
        body = httpResponse.body();

    }

    public  String getBody() {
        return body;
    }


}
