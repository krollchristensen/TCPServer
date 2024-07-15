import java.io.*; // Importerer nødvendige klasser til input og output
import java.net.*; // Importerer netværksklasser

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Definerer serverens hostname
        int port = 5000; // Definerer serverens portnummer

        // Opretter en socket og opretter forbindelse til serveren
        try (Socket socket = new Socket(hostname, port)) {
            // Opretter output stream til at sende data til serveren
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Opretter input stream til at modtage data fra serveren
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Sender en besked til serveren
            writer.println("Hello Server");

            // Modtager og udskriver responsen fra serveren
            String response = reader.readLine();
            System.out.println("Server response: " + response);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
