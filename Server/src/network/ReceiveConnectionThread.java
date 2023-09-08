/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import screen.MainUI;

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
        while (running.get() 
                && NetworkUtils.getSocketInstance() != null
                && !NetworkUtils.getSocketInstance().isClosed()) {
            try {
                Socket clientConnection = null;
                clientConnection = NetworkUtils.getSocketInstance().accept();
                connections++;
                NetworkHandler newClient = new NetworkHandler(clientConnection, connections);
                newClient.start();
                clients.add(newClient);
                }
            } catch (SocketException socketEx) {
                System.out.println("------- Server socket closed -------");
            }catch (IOException ex) {
                Logger.getLogger(ReceiveConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
