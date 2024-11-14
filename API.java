import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class API {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/9ceda48e3cf669648e34918d/latest/";

    public double getExchangeRate(String from, String to) throws IOException, InterruptedException {
        String url = API_URL + from;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == HttpURLConnection.HTTP_OK) {
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            return rates.get(to).getAsDouble();
        } else {
            throw new IOException("Error al obtener la tasa de cambio de la API");
        }
    }
}
