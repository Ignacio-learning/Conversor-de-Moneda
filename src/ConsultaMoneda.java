import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarMoneda(String codigoMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/06ec404e2fd61f5d2003f439/latest/" + codigoMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        }catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversion");
        }
    }


}

