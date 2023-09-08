/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eng Abdullah Hegazy
 */
public final class NetworkUtils {

    public static JsonObject loginResponseObject = null;
    private static Socket SOCKET = null;

    public static boolean connectToServer() {
        return getSocketInstance().isConnected();
    }

    //Get ome instance of socket
    public static Socket getSocketInstance() {
        if (SOCKET == null) {
            try {
                SOCKET = new Socket("127.0.0.1", 5005);
                SOCKET.setSoTimeout(0);
                return SOCKET;

            } catch (IOException ex) {
                Logger.getLogger(NetworkUtils.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return SOCKET;
    }

}
