import java.io.*; // Importerer nødvendige klasser til input og output
import java.net.*; // Importerer netværksklasser

public class TCPServer {
    public static void main(String[] args) {
        // Opretter en ServerSocket, der lytter på port 5000
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000");

            // Accepterer en indgående klientforbindelse
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Opretter input stream til at modtage data fra klienten
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Opretter output stream til at sende data til klienten
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;

            // Læser data fra klienten og sender en echo-respons
            while ((text = reader.readLine()) != null) {
                System.out.println("Message from client: " + text);
                writer.println("Echo: " + text);
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
