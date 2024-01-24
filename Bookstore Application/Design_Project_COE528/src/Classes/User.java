/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author arian
 */
public class User implements Serializable
{
    
    //non-static variables
    private String username;
    private String password;
    

    private int points;

    
    
    private Cart userCart;
    private transient Status status;
    
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.points=0;
        status = new SilverStatus();
        userCart = new Cart();
    
    }
    
    public void updateStatus(){
        if(points > 1000){
            status = new GoldStatus();
        } else if(points < 1000){
            status = new SilverStatus();
        }
    }
    
    public double buy(Cart cart, int points, boolean isPurchasingWithPoints){
        double arr[] = new double[2];
        arr = status.buy(cart, points, isPurchasingWithPoints);
        this.points += arr[1];
        double a = arr[0];
        userCart.clearCart();
        updateStatus();
        return a; 
    }
    
    public void addBookToCart(Book book) {
        userCart.addBookToCart(book);
    }

    public void removeBookFromCart(Book book) {
        userCart.removeBookFromCart(book);
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
