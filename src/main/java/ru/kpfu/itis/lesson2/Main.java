package ru.kpfu.itis.lesson2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        //get
        try {
            HttpClientImpl client = new HttpClientImpl();
            String url = "https://jsonplaceholder.typicode.com/posts?";

            Map<String, String> params = new HashMap<>();
            params.put("userId", "2");
            params.put("id", "11");

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");

            System.out.println(client.get(url, params, headers));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //post
        try {
            HttpClientImpl client = new HttpClientImpl();
            String url = "https://jsonplaceholder.typicode.com/posts";

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");

            Map<String, String> data = new HashMap<>();
            data.put("userId", "78");
            data.put("id", "78");
            data.put("title", "title");
            data.put("body", "body");

            System.out.println(client.post(url, headers, data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //put в пут ошибка пока потом надо исправить
        try {
            HttpClientImpl client = new HttpClientImpl();
            String url = "https://jsonplaceholder.typicode.com/posts/1";

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            headers.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");

            Map<String, String> data = new HashMap<>();
//            data.put("userId", "78");
//            data.put("id", "78");
            data.put("title", "new title");
 //           data.put("body", "new body");

            System.out.println(client.put(url, headers, data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            HttpClientImpl client = new HttpClientImpl();
            String url = "https://jsonplaceholder.typicode.com/posts/1";

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");

            Map<String, String> data = new HashMap<>();

            System.out.println(client.delete(url, headers, data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
