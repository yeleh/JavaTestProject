package serverClient.server;

import serverClient.connectionHandler.MulConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Alex
 * Date: 21.12.12
 * Time: 18:22
 */
public class MulServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3141);

        boolean running = true;

        ExecutorService executorService = Executors.newFixedThreadPool(15);
        while (running) {
            Socket client = null;

            try {
                client = server.accept();
                executorService.submit(new MulConnectionHandler(client));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(client != null)
                    try {client.close();} catch (IOException e) {}
            }
        }
    }
}
