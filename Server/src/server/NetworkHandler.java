/**
 *
 * @author Eng Abdullah Hegazy
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkHandler extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(false);
    DataInputStream inStream;
    PrintStream outStream;
    int clientID = 0;
    Socket clientSocket;

    public void closeConnection() {
        running.set(false);
        try {
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NetworkHandler(Socket socket, int clientID) {
        this.clientID = clientID;
        clientSocket = socket;
        try {

            inStream = new DataInputStream(socket.getInputStream());
            outStream = new PrintStream(socket.getOutputStream());

            System.out.println("------------- NetworkHandler Started -------------");
        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        System.out.println("------------- Client Connected -------------");
        //get Current client
        //NetworkHandler client = clients.get(clients.indexOf(this));
        running.set(true);
        while (running.get()) {
            if (clientSocket.isConnected()) {
                try {
                    System.out.println("ClientID:" + clientID);
                    String receivedMsg = inStream.readLine();
                    if (!receivedMsg.isEmpty()) {
                        System.out.println("Message: " + receivedMsg);
                        outStream.println("I heard You:" + clientID);
                        //sendMessageToAll("Heard you.");
                    }

                } catch (IOException ex) {
                    running.set(false);
                    try {
                        inStream.close();
                        outStream.close();
                        clientSocket.close();
                        this.join();
                    } catch (IOException ex1) {
                        Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex1);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    System.out.println("Client Socket Closed Network Handler");
                }
            }
        }
    }
}
