/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import javafx.scene.control.CheckBox;


/**
 *
 * @author arian & Jahmil
 */
public class Book implements Cloneable
{

    
    private String title;
    private double price;
    private CheckBox selected= new CheckBox();

    public Book(String title, double price)
    {
        this.title = title;
        this.price = price;
        selected.setSelected(false);
    }
    
    public String getTitle() 
    {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public CheckBox isSelected() 
    {
        return selected;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public Book clone() {
        Book clonedBook;
        try {
            clonedBook = (Book) super.clone();
            clonedBook.selected = new CheckBox();
            clonedBook.selected.setSelected(this.selected.isSelected());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedBook;
    }
}
