/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moaaz
 */
public class ServerConnection {
    ServerSocket serverSocket;
    public ServerConnection(){
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void startServer(){
        new Thread(() -> {
            try {
                while(!serverSocket.isClosed()){
                    System.out.println("server opened");
                    Socket socket = serverSocket.accept();
                    System.out.println("got new client");
                    new NetworkHandler(socket);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        
    }
    public void stopServer(){
        if(serverSocket != null)
            try {
                serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
