package bsu.comp152;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        var dataGrabber = HttpClient.newHttpClient();
        var requestBuilder = HttpRequest.newBuilder();
        var webRequest = requestBuilder.uri(URI.create("http://universities.hipolabs.com/search?name=Young")).build();

        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(webRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exceptionObject){
            System.out.println("Error connecting to network or site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to site broken");
        }
        if(response == null){
            System.out.println("Something went wrong getting data from the network");
            System.exit(-1);
        }
        var usefulData = response.body();
        var dataParser = new Gson();
        UniversityDataType[] uniList = dataParser.fromJson(usefulData, UniversityDataType[].class); //these [] mean array

        //This will loop through the University Data and print each toString on a separate line
        for (var currentUniv : uniList){
            System.out.println(currentUniv);
        }
    }
}
