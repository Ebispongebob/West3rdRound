package WestTwo2020.thirdRound;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class httpComponents {
    private String body;

    //请求API时利用condition挑选数据（中国，美国，英国，日本）
    public void getFile(String condition) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://covid-api.mmediagroup.fr/v1/cases" + condition)).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, responseBodyHandler);
        body = httpResponse.body();//获取的数据

    }
    //getBody从外部获取数据
    public String getBody() {
        return body;
    }


}
