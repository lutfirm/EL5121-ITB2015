/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OopLutfi;

/**
 *
 * @author maghfirohlutfi
 */
import java.io.*;
import java.net.*;

public class OopLutfiClient {

    public static void main(String[] args) throws IOException {

//        if (args.length != 2) {
//            System.err.println(
//                "Usage: java OopLutfiClient <host name> <port number>");
//            System.exit(1);
//        }

        String hostName = "127.0.0.1";
        int portNumber = 4447;
//        String hostName = args[0];
//        int portNumber = Integer.parseInt(args[1]);

        try {
            Socket clientSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                    new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equals("Bye.")) {
                    break;
                }
                out.println(userInput);
                System.out.println("----silakan tunggu jawaban server----");
                System.out.println("server : " + in.readLine());
            }
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
