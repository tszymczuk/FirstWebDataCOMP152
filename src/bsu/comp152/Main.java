package bsu.comp152;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Main {

    public static void main(String[] args) {
        var dataGrabber = HttpClient.newHttpClient();
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create("http://universities.hipolabs.com/search?name=Young")).build();

    }
}
