import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // AWS Elastic Beanstalk nutzt standardmäßig Port 5000
        int port = 5000; 
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // Wenn jemand die API aufruft, antworten wir mit Text
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hallo Welt! Meine allererste Java-API laeuft live auf AWS!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        
        server.setExecutor(null);
        server.start();
        System.out.println("Server gestartet auf Port " + port);
    }
}
