package org.example.RequestsManagers;

import org.example.Entities.Category;
import org.example.Entities.Product;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.RequestsManagers.ConnectionString.*;


public class DeleteRequests {
    public static int deleteCategory(Category category){
        return deleteSample(LOCAL_URL_PRODUCT + "/" + category.getId());
    }

    public static int deleteProduct(Product product){
        return deleteSample(LOCAL_URL_PRODUCT + "/" + product.getId());
    }

    private static int deleteSample(String path){
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("accept", "application/json")
                    .header("Authorization", AUTH_TOKEN)
                    .DELETE()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response.statusCode();
    }
}
