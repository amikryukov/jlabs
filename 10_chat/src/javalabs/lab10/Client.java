package javalabs.lab10;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String [] args) {

        // all this variables can present as arguments of application
        String host = "localhost";
        int port = Server.DEFAULT_PORT;
        String message = "Dummy message";

        try {
            System.out.printf("Try to connect to " + host + ":" + port);
            Socket client = new Socket(host, port);
            System.out.println("Connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            System.out.println("me : " + message);

            out.writeUTF(message);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println(client.getRemoteSocketAddress() + " : " + in.readUTF());
            client.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
