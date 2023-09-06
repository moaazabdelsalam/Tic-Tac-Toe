/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public class ReceiveConnectionThread extends Thread {

    static Vector<NetworkHandler> clients = new Vector<NetworkHandler>();
    private final AtomicBoolean running = new AtomicBoolean(false);

    public void stopReceiving() {
        running.set(false);
        if (clients.size() > 0) {
            for (NetworkHandler client : clients) {
                client.closeConnection();
            }
        }
        try {
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ReceiveConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        int connections = 0;
        running.set(true);
        while (running.get() && !MainUI.serverSocket.isClosed()) {
            Socket clientConnection = null;
            try {
                //if (!MainUI.serverSocket.isClosed()) {
                clientConnection = MainUI.serverSocket.accept();
                connections++;
                NetworkHandler newClient = new NetworkHandler(clientConnection, connections);
                newClient.start();
                clients.add(newClient);
                //}

            } catch (IOException ex) {
                System.out.println("Socket Closed ReceiveConnectionThread");
            }
        }
    }
}
