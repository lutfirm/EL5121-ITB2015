/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OopLutfiThread;

/**
 *
 * @author maghfirohlutfi
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OopLutfiThreadClient {

    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static BufferedReader stdIn;

    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";
        int portNumber = 4447;


        try {
            clientSocket = new Socket(hostName, portNumber);
            out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            in =
                    new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            stdIn =
                    new BufferedReader(
                    new InputStreamReader(System.in));
            new Thread() {
                public void run() {
                    try {
                        
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Lutfi: " + inputLine);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(OopLutfiThreadClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    try {
                        String userInput;
                        while ((userInput = stdIn.readLine()) != null) {
                            if (userInput.equals("Bye.")) {
                                break;
                            }
                            out.println(userInput);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(OopLutfiThreadClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }
}
