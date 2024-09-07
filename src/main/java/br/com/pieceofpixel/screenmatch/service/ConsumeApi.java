package br.com.pieceofpixel.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumeApi {

    public String obterDados(String url){
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
