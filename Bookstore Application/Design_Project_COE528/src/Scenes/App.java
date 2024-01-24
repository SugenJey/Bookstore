/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenes;

import Classes.*;
import static Classes.UserDataFileHandler.loadAllBooks;
import static Classes.UserDataFileHandler.loadAllUsers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Jahmil
 */
public class App extends Application 
{
    Stage Window;

    @Override
    public void start(Stage stage) throws Exception
    {
        BookStore.BooksList = loadAllBooks();
        BookStore.UsersList = loadAllUsers();
        //fx shit
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Window=stage;

        //Closing with OS (x)
        Window.setOnCloseRequest(e -> closeProgram());
           
        Scene scene = new Scene(root);
        Window.setTitle("Bookstore App");
        Window.setScene(scene);
        Window.setResizable(false);
        Window.show();
    }

    //Close Program Routine
    private void closeProgram()
    {
        UserDataFileHandler.saveAllBooks(BookStore.BooksList);
        UserDataFileHandler.saveAllUsers(BookStore.UsersList);
        System.out.println("Data is Saved");
        Window.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
