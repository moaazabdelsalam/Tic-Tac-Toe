/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//                Gson gson = new Gson();
//                LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);
//                String operationToDo = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
//                switch (operationToDo) {
//                    case JsonableConst.VALUE_LOGIN:
//                        LoginRequest loginRequest = new Gson().fromJson(jsonResponse, LoginRequest.class);
//                        outStream.println(loginUser(loginRequest));
//                        break;
//                    default:
//                        System.out.println("Invalid Operation");
//
//                }

            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
