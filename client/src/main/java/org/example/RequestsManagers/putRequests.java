package org.example.RequestsManagers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Category;
import org.example.Entities.Product;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.RequestsManagers.ConnectionString.*;



public class putRequests {
    private static ObjectMapper objectMapper =  new ObjectMapper();
    public static int putProductRequest(Product product) throws URISyntaxException, IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(product);
        return putSample(LOCAL_URL_CATEGORY + "/" + product.getId(), body);
    }

    public static int putCategoryRequest(Category category) throws URISyntaxException, IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(category);
        return putSample(LOCAL_URL_CATEGORY, body);
    }

    private static int putSample(String path, String body) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(path))
                .header("accept", "application/json")
                .header("Authorization", AUTH_TOKEN)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }


}
