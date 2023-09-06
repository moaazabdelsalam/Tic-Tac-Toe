/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.LoginRequest;
import models.Request;

/**
 *
 * @author moaaz
 */
public class NetworkHandler extends Thread{
    static Vector<NetworkHandler> clientsList = new Vector();
    Socket socket;
    DataInputStream inputStream; //message from client
    PrintStream outputStream;   //message to client
    String userName, targetUserName;
    Request request;
    DatabaseHandler dbhandler;
    
    NetworkHandler(Socket socket){
        dbhandler = new DatabaseHandler();
        try {
            this.socket = socket;
            
            outputStream = new PrintStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            
            start();
            NetworkHandler.clientsList.add(this);
        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run(){
        while(socket.isConnected()){
            try {                 
                Gson gson = new Gson();
                request = gson.fromJson(inputStream.readLine(), Request.class);
                //userName = inputStream.readLine();
                if (request != null){
                    switch(request.getRequestCode()){
                        case LOGIN: {
                            LoginRequest login = gson.fromJson(gson.toJson(request.getRequestData()),LoginRequest.class);
                            System.out.println("login with username: " + login.getUserName()
                            + ", and password: " + login.getPassword());
                            if(dbhandler.isPlayerExist(login.getUserName())){
                                if(dbhandler.validatePlayer(login.getUserName(), login.getPassword())){
                                    dbhandler.getOnlinePlayers().stream()
                                    .filter(player -> !player.getUserName().equals(login.getUserName()))
                                    .map(player -> player.getUserName())
                                    .forEach(System.out::println);
                                } else {
                                    System.out.println("incorrect username or password");
                                }
                            } else {
                                System.out.println("user doen't exist");
                            }
                        }
                    }
                }
                    
                
            } catch (IOException ex) {
                Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//    public void sendRequestToTarget(String targetUserName){
//        for(NetworkHandler clientHandler : clientsList){
//            if(clientHandler.userName.equals(targetUserName))
//                clientHandler.outputStream.println(this.userName);
//        }
//    }
}
