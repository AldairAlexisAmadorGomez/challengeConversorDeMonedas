package com.converter;

import com.converter.api.CurrencyAPI;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener las tasas de cambio
            String urlApi = "https://v6.exchangerate-api.com/v6/dc86c7114ba35b0b7aa5d8ce/latest/USD";
            CurrencyAPI apiMonedas = new CurrencyAPI();
            JsonObject tasasCambioJson = apiMonedas.fetchRates(urlApi);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                // Mostrar el menú
                System.out.println("****************************************");
                System.out.println("**   Bienvenido/a al Conversor de Moneda =]   **");
                System.out.println("****************************************");
                System.out.println("1) Peso argentino  => Dólar");
                System.out.println("2) Dólar           => Peso argentino");
                System.out.println("3) Real brasileño  => Dólar");
                System.out.println("4) Dólar           => Real brasileño");
                System.out.println("5) Peso colombiano => Dólar");
                System.out.println("6) Dólar           => Peso colombiano");
                System.out.println("7) Salir");
                System.out.println("****************************************");
                System.out.print("Elija una opción válida: ");

                opcion = scanner.nextInt();

                // Procesar la opción seleccionada
                switch (opcion) {
                    case 1 -> convertirMoneda("ARS", "USD", tasasCambioJson, scanner);
                    case 2 -> convertirMoneda("USD", "ARS", tasasCambioJson, scanner);
                    case 3 -> convertirMoneda("BRL", "USD", tasasCambioJson, scanner);
                    case 4 -> convertirMoneda("USD", "BRL", tasasCambioJson, scanner);
                    case 5 -> convertirMoneda("COP", "USD", tasasCambioJson, scanner);
                    case 6 -> convertirMoneda("USD", "COP", tasasCambioJson, scanner);
                    case 7 -> System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                    default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
                }

            } while (opcion != 7);

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    private static void convertirMoneda(String monedaOrigen, String monedaDestino, JsonObject tasasCambioJson, Scanner scanner) {
        try {
            // Obtener la tasa de cambio
            JsonObject conversionRates = tasasCambioJson.getAsJsonObject("conversion_rates");
            if (!conversionRates.has(monedaOrigen) || !conversionRates.has(monedaDestino)) {
                System.out.println("La conversión entre estas monedas no está disponible.");
                return;
            }

            double tasaOrigen = conversionRates.get(monedaOrigen).getAsDouble();
            double tasaDestino = conversionRates.get(monedaDestino).getAsDouble();

            // Pedir al usuario el monto a convertir
            System.out.printf("Ingrese la cantidad en %s: ", monedaOrigen);
            double monto = scanner.nextDouble();

            // Calcular la conversión
            double resultado = (monto / tasaOrigen) * tasaDestino;

            // Mostrar el resultado
            System.out.printf("%.2f %s equivalen a %.2f %s\n\n", monto, monedaOrigen, resultado, monedaDestino);

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
