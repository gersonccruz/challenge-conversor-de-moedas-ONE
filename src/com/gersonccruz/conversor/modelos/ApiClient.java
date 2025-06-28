package com.gersonccruz.conversor.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String API_KEY = "e5160a6fd47378102b93f5e8";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String getTaxaDeConversao(String daMoeda, String paraMoeda, double valor) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/" + daMoeda + "/" + paraMoeda + "/" + valor;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
}
