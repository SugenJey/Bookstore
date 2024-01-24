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
public class GoldStatus extends Status
{
    public double[] buy(Cart cart, int points, boolean isPurchasingWithPoints)
    {
        double totalPrice = cart.getTotalPrice();
        double deltaPoints = 0.0;
        double finalPrice = totalPrice;

        if (isPurchasingWithPoints) {
            deltaPoints -= Math.min(points, totalPrice * 10) / 10.0;
            finalPrice = Math.max(totalPrice - (points / 100.0), 0);
        } else {
            deltaPoints += totalPrice / 10.0;
            finalPrice = totalPrice;
        }

        return new double[] {finalPrice, deltaPoints};
    }
}
