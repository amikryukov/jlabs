package javalabs.lab10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {

    protected static final int DEFAULT_PORT = 8787;
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void start() {
        System.out.println("Server started");
        while(true) {
            try {
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                String message = in.readUTF();
                System.out.println(server.getRemoteSocketAddress() + " : " + message);
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("You've just wrote : " + message);
                server.close();
            } catch(SocketTimeoutException s) {
                System.out.println("Socket timed exception");
                break;
            } catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Server(DEFAULT_PORT).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
