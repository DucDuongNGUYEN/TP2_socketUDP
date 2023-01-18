import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSocketServer {
    public static void main(String[] args) throws IOException {
        // Vérification des arguments
        if (args.length != 1) {
            System.out.println("Usage: java UDPSocketServer port");
            return;
        }
        int port = Integer.parseInt(args[0]);

        // Création d'un socket UDP
        DatagramSocket socket = new DatagramSocket(port);

        while (true) {
            // Réception d'un paquet
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Décodage de la ligne reçue
            String line = new String(packet.getData());

            // Préparation de la réponse
            String response = ">" + line +"\n";
            byte[] data = response.getBytes();

            // Envoi de la réponse
            packet.setData(data);
            socket.send(packet);
        }
    }
}
