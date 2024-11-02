package ru.kpfu.itis.lesson2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClientImpl();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("userId", "2");
        params.put("id", "11");
        Map<String, String> data = new HashMap<>();
        data.put("title", "new title");
        System.out.println(client.get("http://localhost:8080/classwork_oris_war_exploded/", params, headers));
        System.out.println(client.post("http://localhost:8080/classwork_oris_war_exploded/", headers, params));
        System.out.println(client.put("https://jsonplaceholder.typicode.com/posts/1", headers, data));
        System.out.println(client.delete("https://jsonplaceholder.typicode.com/posts/1", headers, data));
    }
}
