package com.converter.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyAPI {
    public JsonObject fetchRates(String urlApi) throws IOException, InterruptedException {
        // Crear HttpClient y HttpRequest
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlApi))
                .build();

        // Enviar solicitud y recibir respuesta
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error al obtener las tasas. Código de estado: " + respuesta.statusCode());
        }

        // Analizar la respuesta JSON usando Gson
        JsonParser analizador = new JsonParser();
        return analizador.parse(respuesta.body()).getAsJsonObject();
    }
}
