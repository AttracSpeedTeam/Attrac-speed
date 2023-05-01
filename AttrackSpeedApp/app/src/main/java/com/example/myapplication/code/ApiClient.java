package com.example.myapplication.code;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {

    private static String API_BASE_URL = "http://localhost:9992/api/attraction/";
    private static final String HEADER_NAME = "name";

    public ApiClient(String URL){

        API_BASE_URL = URL;

    }

    public static String RecupererDonneesAttraction(String attraction) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_BASE_URL + attraction)
                .header(HEADER_NAME, attraction)
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();

    }

    public static String RecupererEmplacement(String attraction) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_BASE_URL + attraction + "/emplacement")
                .header(HEADER_NAME, attraction)
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();

    }

    public static List<String> RecupererListeAttraction() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_BASE_URL + "listeAttractions")
                .header("name", "listeAttractions")
                .build();

        Response response = client.newCall(request).execute();

        assert response.body() != null;
        String responseBody = response.body().string();
        responseBody=responseBody.substring(2,responseBody.length()-2);
        return Arrays.asList(responseBody.split("\",\""));
    }


}
