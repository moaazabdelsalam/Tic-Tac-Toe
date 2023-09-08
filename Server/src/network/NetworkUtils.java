/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public final class NetworkUtils {

    private static ServerSocket SERVER_SOCKET = null;
    private static ReceiveConnectionThread CONNECTIONS_THREAD = null;
    private static boolean SERVER_STATUS = false;
    public static boolean startServer() {
        if(getSocketInstance().isBound())
            SERVER_STATUS = true;
        return false;
    }
    
    public static boolean getServerStatus(){
        return SERVER_STATUS;
    }

    public static boolean stopServer(){
        getConnectionsThread().stopReceiving();
        while (getConnectionsThread().isAlive());
        System.out.println("--- All connections Closed ---------------");
        try {
            getSocketInstance().close();
            System.out.println("--- Server socket Closed ---------------");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (!CONNECTIONS_THREAD.isAlive() && SERVER_SOCKET.isClosed()) {
            CONNECTIONS_THREAD = null;
            SERVER_SOCKET = null;
            SERVER_STATUS = false;
            System.out.println("--- Server Closed ---------------");
            return true;
        }

        return false;
    }

    public static boolean receiveConnections() {
        getConnectionsThread().start();
        return getConnectionsThread().isAlive();
    }

    public static ReceiveConnectionThread getConnectionsThread() {
        if (CONNECTIONS_THREAD == null || !CONNECTIONS_THREAD.isAlive()) {
            CONNECTIONS_THREAD = new ReceiveConnectionThread();
            return CONNECTIONS_THREAD;
        }

        return CONNECTIONS_THREAD;
    }

    //Get ome instance of socket
    public static ServerSocket getSocketInstance() {
        if (SERVER_SOCKET == null) {
            try {
                SERVER_SOCKET = new ServerSocket(5005);
                SERVER_SOCKET.setSoTimeout(0);
                return SERVER_SOCKET;

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return SERVER_SOCKET;
    }

}
