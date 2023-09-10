/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author moaaz
 */
public class Navigation {
    public static Stack<Scene> backStack = new Stack();
    Stage stage;
    
    public Navigation(Stage stage) {
        this.stage = stage;
    }
    
    public void goTo(String screenPath){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(screenPath));
            Scene scene = new Scene(root);
            //Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            
            
            backStack.push(scene);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Navigation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void goBack(){
        if(backStack.size() > 1){
            backStack.pop();
            stage.setScene(backStack.peek());
        }
    }
    
    public void goHome(){
        while(backStack.size()>1){
            backStack.pop();
        }
        stage.setScene(backStack.peek());
    }
}
