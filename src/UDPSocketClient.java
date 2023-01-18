import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSocketClient {
    public static void main(String[] args) throws IOException {
        // Vérification des arguments
        if (args.length != 2) {
            System.out.println("Usage: java UDPSocketClient server port");
            return;
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);

        // Création d'un socket UDP
        DatagramSocket socket = new DatagramSocket();

        // Boucle de lecture de lignes au clavier
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = ">" + in.nextLine() +"\n";

            // Conversion de la ligne en tableau d'octets
            byte[] data = line.getBytes();

            // Création d'un paquet avec les données à envoyer, l'adresse de destination et le port
            InetAddress address = InetAddress.getByName(server);
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

            // Envoi du paquet
            socket.send(packet);
        }

        // Fermeture du socket
        //socket.close();
    }
}
