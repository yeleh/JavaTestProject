package serverClient.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

/**
 * User: Alex
 * Date: 21.12.12
 * Time: 18:50
 */
public class MulClient {
    public static void main(String[] args) throws IOException {
        Socket server = null;
        Random random = new Random();
        try {
            for (int i = 0; i < 30; i++) {
                server = new Socket("localhost", 3141+i);
                Scanner in = new Scanner(server.getInputStream());
                PrintWriter out = new PrintWriter(server.getOutputStream(), true);

                out.println(random.nextInt(i+3));
                out.println(random.nextInt(i+3));
                System.out.println(in.nextLine());
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(server != null)
                try{ server.close(); } catch (IOException e) {}
        }

    }
}
