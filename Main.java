package src;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido al Conversor de Moneda");
        System.out.println("El link de la API es: https://app.exchangerate-api.com/");
        System.out.println("Ingresar API Key:");
        Scanner scanner = new Scanner(System.in);

        // Usuario ingresa su API Key para hacer la consulta a la API.
        String API_KEY = scanner.nextLine();
        // Dirección o URL con la que se hace la consulta a la API.
        String direccion = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

        // Cliente, petición y respuesta a la API.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Respuesta de la API en JSON (string).
        String json = response.body();
        //System.out.println(json);

        // Se interpreta la información recibida de la API.
        Gson gson = new Gson();
        TarifasJson tarifasJson = gson.fromJson(json, TarifasJson.class);
        //System.out.println("Resultado de la consulta:");
        //System.out.println(tarifasJson);

        if (tarifasJson.consultaExitosa()) {
            new Menu(tarifasJson.tarifas());
        } else {
            System.out.println("Error en la consulta.");
        }

        System.out.println("\nTerminando...");
    }
}
