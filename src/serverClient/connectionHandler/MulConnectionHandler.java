package serverClient.connectionHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: Alex
 * Date: 21.12.12
 * Time: 19:54
 */
public class MulConnectionHandler implements Runnable {

    Socket client;

    public MulConnectionHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            handleConnection(client);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static void handleConnection(Socket client) throws IOException {
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

        String factor1 = in.nextLine();
        String factor2 = in.nextLine();

        out.println(new BigInteger(factor1).multiply(new BigInteger(factor2)));
        System.out.println("Berechnung gesendet an: " + client);
    }
}
