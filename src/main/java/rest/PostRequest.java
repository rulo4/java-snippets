package rest;

import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PostRequest {

    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("title", "título");
        requestBody.addProperty("body", "cuerpo");
        requestBody.addProperty("userId", 1);

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody.toString(), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(response);
        System.out.println("-------------------------");


        String urlget = "https://jsonplaceholder.typicode.com/posts?userId=1";
        System.out.println(restTemplate.getForObject(urlget, String.class));
    }
}
