package com.converter.filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyFilter {
    private JsonObject tasasJson;
    private Map<String, Double> monedasFiltradas;

    public CurrencyFilter(JsonObject ratesJson) {
        this.tasasJson = ratesJson; // Mantener la variable para que el constructor sea compatible con el `main`
        this.monedasFiltradas = new HashMap<>();
    }

    public void displayAvailableCurrencies() {
        JsonObject tasas = tasasJson.getAsJsonObject("conversion_rates");
        tasas.entrySet().forEach(entry -> System.out.println(entry.getKey()));
    }

    public void filterCurrencies(List<String> currencies) throws IllegalArgumentException {
        JsonObject tasas = tasasJson.getAsJsonObject("conversion_rates");

        // Verificar si todas las monedas son válidas
        boolean todasValidas = currencies.stream().allMatch(tasas::has);

        if (!todasValidas) {
            throw new IllegalArgumentException("Todas las monedas deben ser válidas. Por favor, verifica tu entrada.");
        }

        // Proceder a filtrar monedas si todas son válidas
        monedasFiltradas = currencies.stream()
                .collect(Collectors.toMap(moneda -> moneda, moneda -> tasas.get(moneda).getAsDouble()));

        System.out.println("Monedas filtradas:");
        monedasFiltradas.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }

    public void saveFilteredResults(String filename) throws IOException {
        // Usar GsonBuilder para habilitar el formato legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject resultadoJson = new JsonObject();

        // Crear un nuevo objeto JSON para las tasas
        JsonObject objetoTasas = new JsonObject();

        // Agregar las monedas filtradas al objeto de tasas
        monedasFiltradas.forEach(objetoTasas::addProperty);

        // Agregar el objeto de tasas y campos adicionales al resultado JSON
        resultadoJson.add("rates", objetoTasas);
        resultadoJson.addProperty("result", "success");
        resultadoJson.addProperty("base", "USD");

        // Escribir el resultado en un archivo JSON
        try (Writer escritor = new FileWriter(filename)) {
            gson.toJson(resultadoJson, escritor);
        }
    }
}
