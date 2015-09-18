/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OopLutfiThread;

/**
 *
 * @author maghfirohlutfi
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OopLutfiThreadServer {

    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static BufferedReader stdIn;

    public static void main(String[] args) throws IOException {

        int portNumber = 4447;

        try {
            ServerSocket serverSocket =
                    new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            stdIn =
                    new BufferedReader(
                    new InputStreamReader(System.in));

//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println("client: " + inputLine);
//                out.println(stdIn.readLine());
//                System.out.println("----silakan tunggu jawaban client----");
//            }

            new Thread() {
                @Override
                public void run() {
                    try {
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Febri: " + inputLine);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(OopLutfiThreadServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    String userInput;
                    try {
                        while ((userInput = stdIn.readLine()) != null) {
                            out.println(userInput);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(OopLutfiThreadServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
