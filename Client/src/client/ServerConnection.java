/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moaaz
 */
public class ServerConnection {
    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    //DataInputStream inputStream; //message from client
    //PrintStream outputStream;   //message to client
    Request request;
    public ServerConnection(Socket socket, Request request){
        try {
            
            this.socket = socket;
            this.request = request;
            System.out.println("sending Req");
            outputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            //inputStream = new DataInputStream(socket.getInputStream());
            //outputStream = new PrintStream(socket.getOutputStream());
            System.out.println("sending request");
            //outputStream.writeObject(request);
            
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
