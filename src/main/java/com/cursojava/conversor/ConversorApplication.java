package com.cursojava.conversor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ConversorApplication {

    public static void main(String[] args) {
        final String API_KEY = System.getenv("EXCHANGE_RATE_API_KEY");
        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("Error: La API Key no está configurada como variable de entorno.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("**********************");
            System.out.println("Sea Bienvenido/a al Conversor de Moneda");
            System.out.println("1) Dólar >> Euro");
            System.out.println("2) Euro >> Dólar");
            System.out.println("3) Colón Costa Rica >> Dólar");
            System.out.println("4) Dólar >> Colón Costa Rica");
            System.out.println("5) Colón Costa Rica >> Euro");
            System.out.println("6) Euro >> Colón Costa Rica");
            System.out.println("7) Salir del programa");
            System.out.println("**********************");

            System.out.print("Digite la opción de menú: ");
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }

            System.out.print("Digite el monto a convertir: ");
            double monto = scanner.nextDouble();

            String baseCurrency = "";
            String targetCurrency = "";

            switch (opcion) {
                case 1:
                    baseCurrency = "USD";
                    targetCurrency = "EUR";
                    break;
                case 2:
                    baseCurrency = "EUR";
                    targetCurrency = "USD";
                    break;
                case 3:
                    baseCurrency = "CRC";
                    targetCurrency = "USD";
                    break;
                case 4:
                    baseCurrency = "USD";
                    targetCurrency = "CRC";
                    break;
                case 5:
                    baseCurrency = "CRC";
                    targetCurrency = "EUR";
                    break;
                case 6:
                    baseCurrency = "EUR";
                    targetCurrency = "CRC";
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            try {
                double rate = getExchangeRate(API_KEY, baseCurrency, targetCurrency);
                double resultado = monto * rate;
                System.out.printf("El resultado de la conversión es: %.2f%n", resultado);
            } catch (IOException e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            }
        } while (true); // Loop continues until user selects exit option (7)

        scanner.close(); // Close scanner after exiting the loop
    }

    private static double getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) throws IOException {
        String urlString = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                apiKey, baseCurrency, targetCurrency
        );

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new IOException("Error en la respuesta de la API: " + connection.getResponseMessage());
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> response = mapper.readValue(connection.getInputStream(), Map.class);

        if (!response.containsKey("conversion_rate")) {
            throw new IOException("La respuesta de la API no contiene la tasa de conversión.");
        }

        return (double) response.get("conversion_rate");
    }

}
