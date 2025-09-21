import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

import com.example.demo.Movie;
import com.google.gson.Gson;

public class Main{
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Movies"))
                .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            Movie[] movies = gson.fromJson(response.body(), Movie[].class);
            System.out.println(Arrays.toString(movies));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}