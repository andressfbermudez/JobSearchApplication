package com.jobsearch.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import java.lang.reflect.Type;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JobSearchRequest {

    public static List<Job> search() {
        String url = "https://remotive.com/api/remote-jobs?search=software%20engineer";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir la respuesta a un JsonObject usando Gson
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            // Obtener la lista de trabajos del JsonObject
            JsonArray jobsArray = jsonResponse.getAsJsonArray("jobs");

            // Convertir el JSON a una lista de objetos Job
            Gson gson = new Gson();
            Type jobsList = new TypeToken<List<Job>>() {}.getType();

            return gson.fromJson(jobsArray, jobsList);

        } catch (Exception e) {
            System.out.println("Failed to get data from API");
            e.printStackTrace();
            return null;
        }
    }
}
