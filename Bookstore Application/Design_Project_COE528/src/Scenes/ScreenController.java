/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenes;
import Classes.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jahmil
 */
public class ScreenController implements Initializable 
{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private DecimalFormat df = new DecimalFormat("0.00");
    private static String name;

    private ObservableList<Book> Cart;
    private static Cart UserCart = new Cart();
    
    //Scene Variables:
        //Login Screen:
        
            //Password
            @FXML private PasswordField tfPassword;

            //Username
            @FXML private TextField tfUsername;

            //Showing Password
            @FXML private TextField ViewPassword;
            
            //Show-Password CheckBox
            @FXML private CheckBox pass_toggle;

            //Incorrect Password Text
            @FXML private Text IncorPass;
        
        //Owner Book Screen

            //List of Books
            @FXML private TableView<Book> bkCatalogue;
            
                //Book name Column
                @FXML private TableColumn<Book, String> bkname;

                //Book price Column
                @FXML private TableColumn<Book, Double> bkprice;

            //New Book name 
            @FXML private TextField newbkname;
            
            //New Book price
            @FXML private TextField newbkprice;

            //Invalid Price
            @FXML private Text InvalPrice;

            //Invalid Name
            @FXML private Text Invalname;

        //Owner Customer Screen
        
            //List of Customers
            @FXML private TableView<User> UsersList;  
        
            //Customer Username
            @FXML private TableColumn<User, String> Username;  
            
            //Customer Password
            @FXML private TableColumn<User, String> UserPassword;

            //Customer Points
            @FXML private TableColumn<User, Integer> UserPoints;
            
            //New Customer Password
            @FXML private TextField newUserPassword;

            //New Customer Username
            @FXML private TextField newUsername;

            //Invalid Username
            @FXML private Text InvalUsername;

        //Customer Start Screen

            //Customer View of Book Catalogue
            @FXML private TableView<Book> CustomerbkView;
                
                @FXML private TableColumn<Book, String> CSbkname;

                @FXML private TableColumn<Book, Double> CSbkprice;

                //If it is to be added to the cart
                @FXML private TableColumn<Book, CheckBox> Select;

            //Customer points
            @FXML private Label customerpoints;

            //Customer points Rank: Silver
            @FXML private Label customerRankS;

            //Customer points Rank: Gold
            @FXML private Label customerRankG;

            //Welcome Statement (Welcome + username.)
            @FXML private Label welcomeName;
            
            //Distance to next rank
            @FXML private ProgressBar fromNextRank;

        //Customer Cart Screen

            //Total Cost of books in cart
            @FXML private Label TotalCost;

            //View books in Cart
            @FXML private TableView<Book> bkInCart;

                //Cart Book Name
                @FXML private TableColumn<Book, String> Cartbkname;

                //Cart Book Price
                @FXML private TableColumn<Book, Double> Cartbkprice;

    //Scene Openers:

        //Login Screen
        public void OpenLS(ActionEvent event)throws Exception
        {
            Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        //Owner Start Screen 
            public void OpenOSS(ActionEvent event)throws Exception
            {
                Parent root = FXMLLoader.load(getClass().getResource("OwnerSS.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();          
            }

        //Owner Book Screen
            public void OpenOBS (ActionEvent event)throws Exception
            {
                Parent root = FXMLLoader.load(getClass().getResource("OwnerBS.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        //Owner Customer Screen
            public void OpenOCS (ActionEvent event)throws Exception
            {
                Parent root = FXMLLoader.load(getClass().getResource("OwnerCS.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        
        //Customer Start Screen
            public void OpenCSS (ActionEvent event)throws Exception
            {
                Parent root = FXMLLoader.load(getClass().getResource("CustomerSS.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        
        //Customer Cart Screen
            public void OpenCCS (ActionEvent event)throws Exception
            {
                for(Book book:CustomerbkView.getItems())
                {
                    if (book.isSelected().isSelected())
                    {
                        UserCart.addBookToCart(book);
                    }
                }

                Parent root = FXMLLoader.load(getClass().getResource("CustomerCS.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

    //Scene Methods:
        //Login Screen:

            //Show-Password Method
            @FXML void ShowPassword(ActionEvent event) 
            {
                if (pass_toggle.isSelected()) 
                {
                    ViewPassword.setText(tfPassword.getText());
                    ViewPassword.setVisible(true);
                    tfPassword.setVisible(false);

                    return;
                }
                tfPassword.setText(ViewPassword.getText());
                tfPassword.setVisible(true);
                ViewPassword.setVisible(false);

            }
            
            //Login Method
            @FXML public void VerifyUser(ActionEvent event) throws Exception
            {
                //Admin Check
                if (tfUsername.getText().equals("admin"))
                {
                    if((tfPassword.getText().equals("admin")||ViewPassword.getText().equals("admin")))
                    {
                        OpenOSS(event);
                        return;
                    } else 
                    {
                        IncorPass.setText("Incorrect Password. Try Again.");
                    }

                } else 
                {
                    for(User user: BookStore.UsersList){
                        if (tfUsername.getText().equals(user.getUsername()))
                        {
                            if(tfPassword.getText().equals(user.getPassword()))
                            {
                                name=String.valueOf(tfUsername.getText());
                                OpenCSS(event);
                                return;
                            } else 
                            {
                                IncorPass.setText("Incorrect Password. Try Again.");
                            }
                        } else 
                        {
                            IncorPass.setText("User not found. Try Again.");
                        }
                    }
                }
                


                //Customer Check
                /*else if (tfUsername.getText().equals("jon")&& (tfPassword.getText().equals("snow")||ViewPassword.getText().equals("snow")))
                {
                    this.name=String.valueOf(tfUsername.getText());
                    OpenCSS(event);

                //Wrong Password
                }else
                {
                IncorPass.setText("Incorrect Password. Try Again.");
                }*/
            }
        //Owner Start Screen:
            
            //Logout Method (returns to login screen)
            @FXML public void Logout(ActionEvent event) throws Exception
            {
                UserCart.clearCart();
                OpenLS(event);
            }

            //View Owner-Books Screen Method
            @FXML public void ViewOBS(ActionEvent event) throws Exception
            {
                OpenOBS(event);
            }

            //View Owner Customers Screen
            @FXML void ViewOCS(ActionEvent event) throws Exception
            {
                OpenOCS(event);
            }

        //Owner Book Screen

            //Get Books into Observable List
            public ObservableList<Book> getBooks()
            {
                ObservableList<Book> Library = FXCollections.observableArrayList();
                for(Book book: BookStore.BooksList)
                {

                    Library.add(book);
                }
                
                return Library;
            }
        
            //Method to add new book to list
            @FXML void addnewbook(ActionEvent event) throws Exception
            {
                try
                {
                    if (newbkname.getText().isEmpty()) 
                    {
                        throw new NullPointerException("Book name cannot be null");
                    }
                    Book book = new Book(newbkname.getText(),Double.parseDouble(newbkprice.getText()));
                    BookStore.BooksList.add(book);
                    OpenOBS(event);    
                } catch (NumberFormatException e) 
                {
                    InvalPrice.setText("Error: Invalid price format");
                    // Handle the exception or show an error message to the user
                } catch (NullPointerException e) 
                {
                    Invalname.setText("Error: Book name cannot be null");
                    // Handle the exception or show an error message to the user
                }
  
            }
        
            //Method to remove book from list
            @FXML void removebook(ActionEvent event) throws Exception
            {
                for (Book book:BookStore.BooksList)
                {
                    if(book.equals(bkCatalogue.getSelectionModel().getSelectedItem()))
                    {
                        BookStore.BooksList.remove(book);
                        bkCatalogue.getItems().removeAll(bkCatalogue.getSelectionModel().getSelectedItem());       
                    }
                }
                OpenOBS(event);
            }

            //Back Button (returns to Owner Start Screen)
            @FXML void returnToOSS(ActionEvent event) throws Exception
            {
                OpenOSS(event);
            }
        //Owner Customer Screen
        
            //Get Users into Observable List
            public ObservableList<User> getUsers()
            {
                ObservableList<User> Users = FXCollections.observableArrayList();
                for(User user: BookStore.UsersList)
                {
                    Users.add(user);
                }
                
                return Users;
            }

            public double getProgress(int points)
            {
                double Gold=1000.00;
                double prg= (double)points/Gold;
                if(points > 1000)
                {
                    fromNextRank.setStyle("-fx-accent: gold;");
                    return 1;
                }else
                {
                    fromNextRank.setStyle("-fx-accent: silver;");
                    return(prg);
                }
            }




            //Method to Create a new Customer User
            @FXML void newUser(ActionEvent event) throws Exception
            {
                try
                {
                    if (newUsername.getText().isEmpty() || newUserPassword.getText().isEmpty()) 
                    {
                        throw new NullPointerException("Fields cannot be Empty");
                    }
                    for (User user: BookStore.UsersList)
                    {
                        if (user.getUsername().equals(newUsername.getText()))
                        {
                            InvalUsername.setText("Error: Username Taken");
                            return;
                        }
                    }
                   
                    User newUser = new User(newUsername.getText(),newUserPassword.getText());
                    BookStore.UsersList.add(newUser);
                    OpenOCS(event);    
                    
                } catch (NullPointerException e) 
                {
                    InvalUsername.setText("Error: Fields cannot be Empty");
                    // Handle the exception or show an error message to the user
                }
  
            }

            //Method to remove a Customer User
            @FXML void removeUser(ActionEvent event) throws Exception
            {
                for (User user:BookStore.UsersList)
                {
                    if(user.equals(UsersList.getSelectionModel().getSelectedItem()))
                    {
                        BookStore.UsersList.remove(user);
                        UsersList.getItems().removeAll(UsersList.getSelectionModel().getSelectedItem()); 
                    }
                }
                OpenOCS(event);
            }

        //Customer Start Screen


            //Get Customer View of Books into Observable List
            public ObservableList<Book> getCustomerBooks()
            {
                ObservableList<Book> Library = FXCollections.observableArrayList();
                for(Book book: BookStore.BooksList)
                {

                    Library.add(book.clone());
                }
                
                return Library;
            }
        

            //Buy books
            @FXML void Buy(ActionEvent event) throws Exception
            {
                OpenCCS(event);
            }
            
            //Redeem Points then Buy Books
            @FXML void RedeemBuy(ActionEvent event) throws Exception
            {
                OpenCCS(event);
            }

        //Customer Cart Screen
        
            //Get Books into Observable List
            public ObservableList<Book> getCartBooks()
            {
                ObservableList<Book> Library = FXCollections.observableArrayList();
                for(Book book: UserCart.getCartList())
                {
                    Library.add(book.clone());
                }
                return Library;
            }

            //Checkout cart
            @FXML
            void Checkout(ActionEvent event) 
            {
            
                
            }

            //Back Button (returns to Customer Start Screen)
            @FXML
            void returnToCSS(ActionEvent event) throws Exception
            {
                bkInCart.setItems(null);
                UserCart.clearCart();
                OpenCSS(event);
            }

            public void initialize(URL url, ResourceBundle rb) 
    {  
        try
        { //Owner-Books Catalogue
            
            bkname.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
            bkprice.setCellValueFactory((new PropertyValueFactory<Book,Double>("price")));
            bkCatalogue.setItems(getBooks());

        }catch(NullPointerException e)
        {
            System.out.println("Some Screen Elements are Hidden: 1");
        }
        try 
        { //Owner-Users List
            
            Username.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
            UserPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
            UserPoints.setCellValueFactory(new PropertyValueFactory<User, Integer>("points"));
            UsersList.setItems(getUsers());

        }catch(NullPointerException e)
        {
            System.out.println("Some Screen Elements are Hidden: 2");
        } 
        
        try
        { //Customer-Start Screen

            Select.setCellValueFactory(new PropertyValueFactory<Book, CheckBox>("selected"));
            Select.setEditable(true);
            CSbkname.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
            CSbkprice.setCellValueFactory(new PropertyValueFactory<Book,Double>("price"));
            welcomeName.setText(name);
            if(CustomerbkView.getItems().isEmpty())
            {
                CustomerbkView.setItems(getCustomerBooks());
            }
            

        }catch(NullPointerException e)
        {
            System.out.println("Some Screen Elements are Hidden: 3");
        } 
        try            
        { //Display Customer Rank and Points
            for (User user: BookStore.UsersList)
            {
                if(user.getUsername().equals(name))
                {
                    customerpoints.setText("" + user.getPoints());
                    fromNextRank.setProgress(getProgress(user.getPoints()));
                
                    if (user.getPoints()>=1000)
                    {
                        customerRankS.setStyle("-fx-accent: gold;");
                        customerRankG.setText("Gold");
                    }else
                    {
                        customerRankS.setStyle("-fx-accent: silver;");
                        customerRankS.setText("Silver");
                    }

                }
            }
        }catch(NullPointerException e)
        {
            System.out.println("Some Screen Elements are Hidden: 4");
        } 
        try            
        { //Customer-Cart Screen
            
            Cartbkname.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
            Cartbkprice.setCellValueFactory(new PropertyValueFactory<Book,Double>("price"));
            TotalCost.setText("Total Cost: $" + Double.toString(UserCart.getTotalPrice()));
            bkInCart.setItems(getCartBooks());
        
        }catch(NullPointerException e)
        {
            System.out.println("Some Screen Elements are Hidden: 5");
        } 
    }    
}
