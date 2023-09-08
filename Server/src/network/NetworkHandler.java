
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkHandler extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(true);
    DataInputStream inStream;
    PrintStream outStream;
    int clientID = 0;
    Socket clientSocket;

    public void closeConnection() {
        System.out.println("Closing Socket #" + clientID);
        try {
            clientSocket.close();
            inStream.close();
            outStream.close();

        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        running.set(false);

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
        while (running.get() && NetworkUtils.getServerStatus()) {
            if (clientSocket.isConnected()) {
                String receivedMsg;
                try {
                    receivedMsg = inStream.readLine();
                    System.out.println("ClientID:" + clientID);
                    if (!receivedMsg.isEmpty()) {
                        System.out.println("Message: " + receivedMsg);
                        outStream.println("I heard You:" + clientID);
                    }
                } catch (IOException ex) {
                    break;
                }

            }

        }
    }
}
