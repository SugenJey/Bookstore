/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;    

/**
 *
 * @author arian
 */
public class UserDataFileHandler 
{
    
    public static void saveAllBooks(ArrayList<Book> books) {
        try{
            FileWriter bookList = new FileWriter("books.txt");
            for (Book book: books){
                bookList.write(book.getTitle() + "\n" + book.getPrice() + "\n");
            }
            bookList.close();
        }catch(IOException e){
            System.out.println("An error occurred in saveAllBooks.");
            e.printStackTrace();
        }    
    }
    
    public static ArrayList<Book> loadAllBooks() {
            ArrayList<Book> books = new ArrayList<>();
            String bookName = "";
            double Price = 0;
        try{            
            
            File bookFile = new File(".\\books.txt");            
            Scanner read = new Scanner(bookFile);
            read.useDelimiter("\n");
            
            while (read.hasNext()) {
                bookName = read.next();
                Price = Double.parseDouble(read.next());
                Book book = new Book(bookName, Price);
                books.add(book);        
            }
            read.close();
        }
        catch(IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        
        return books;
    }   
    
    
      

    public static void saveAllUsers(ArrayList<User> users) {
        try{
            FileWriter file = new FileWriter("customers.txt");
            for (User user: BookStore.UsersList){
                file.write(user.getUsername() + "\n" + user.getPassword() + "\n" + user.getPoints() + "\n"); 
            }
            file.close();        
        }catch(IOException e){
            System.out.println("An error occurred in saveAllUsers.");
            e.printStackTrace();
        }       
    }
    public static ArrayList<User> loadAllUsers() {
                
        ArrayList<User> users = new ArrayList<>();
        String username = "";
        String password = "";  
        int points = 0;
        try{            
            
            File customerFile = new File(".\\customers.txt");
            Scanner read = new Scanner(customerFile);
            read.useDelimiter("\n");
            while (read.hasNext()) {
                username = read.next();
                password = read.next();       
                points = Integer.parseInt(read.next());
                User customer = new User(username, password);
                customer.setPoints(points);
                users.add(customer);
            }
            read.close();
        }
        catch(IOException e){
            System.out.println("An error occurred in loadAllUsers.");
            e.printStackTrace();
        }
            
        return users;
    } 
}

