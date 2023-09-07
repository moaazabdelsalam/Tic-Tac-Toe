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
import screens.LoginRegisterScreenUI;
import client.Client;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public class RequestHandler extends Thread {

    PrintStream outStream;
    DataInputStream inStream;
    String request;

    //String response;
    public RequestHandler(Socket socket, String request) {
        try {
            this.request = request;
            outStream = new PrintStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        String response;
        if (Client.socket.isConnected()) {
            outStream.println(request);
            try {
                response = inStream.readLine();

                //LoginRegisterScreenUI.loginResponse = response;
                System.out.println("Response:" + response);
                //System.out.println("LoginResponse:" + LoginRegisterScreenUI.loginResponse);
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
