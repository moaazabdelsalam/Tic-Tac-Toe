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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public final class RequestHandler extends Thread {

    private PrintStream outStream;
    private DataInputStream inStream;
    private JsonObject request;

    //String response;
    public RequestHandler(JsonObject request) {
        try {
            this.request = request;
            outStream = new PrintStream(NetworkUtils.getSocketInstance().getOutputStream());
            inStream = new DataInputStream(NetworkUtils.getSocketInstance().getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        String response = null;
        if (NetworkUtils.connectToServer()) {
            outStream.println(request);
            try {
                response = inStream.readLine();
                System.out.println("Response:" + response);
                NetworkUtils.loginResponseObject = new Gson().fromJson(response, JsonObject.class);
                System.out.println(NetworkUtils.loginResponseObject.toString());
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
