/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author arian
 */

 public class Cart
{
    private ArrayList<Book> cartList;


    public Cart()
    {
        cartList = new ArrayList<Book>();
    }    
    
    
    public void addBookToCart(Book book) 
    {
        String name1 = book.getTitle();
        String name2 = "";
        
        for(Book books: cartList)
        {
            name2 = books.getTitle();
            if(name1.equals(name2))
            {
                System.out.println("Book already in cart");
                return;
            }
        }
        for(Book books: BookStore.BooksList)
        {
            if (books.getTitle().equals(name1)) 
            {
                cartList.add(book);
                System.out.println(book.getTitle() + " has been added to your cart.");
            }else
            {
                System.out.println(book.getTitle() + " is not available in the store.");
            }
        }
    }

    public void removeBookFromCart(Book book) 
    {
        if (cartList.contains(book)) 
        {
            cartList.remove(book);
            System.out.println(book.getTitle() + " has been removed from your cart.");
        } else {
            System.out.println(book.getTitle() + " is not in your cart.");
        }
    }
    
    public void clearCart() 
    {
        for (Book book : cartList) 
        {
            BookStore.BooksList.add(book);
        }
        cartList.clear();
    }
    
    public ArrayList<Book> getCartList() 
    {
        if(cartList.isEmpty()){
            return null;
        }
        return cartList;
    }


    public double getTotalPrice() 
    {
        double totalPrice = 0.0;
        for (Book book : cartList) 
        {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

}
