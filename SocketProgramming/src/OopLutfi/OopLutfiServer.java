/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OopLutfi;

/**
 *
 * @author maghfirohlutfi
 */
import java.net.*;
import java.io.*;

public class OopLutfiServer {

    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.err.println("Usage: java OopLutfiServer <port number>");
//            System.exit(1);
//        }

//        int portNumber = Integer.parseInt(args[0]);
        int portNumber = 4447;

        try {
            ServerSocket serverSocket =
                    new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                    new InputStreamReader(System.in));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("client: " + inputLine);
                out.println(stdIn.readLine());
                System.out.println("----silakan tunggu jawaban client----");
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
