/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

/**
 *
 * @author tyler
 */
public class LostTicket implements Payment {

    final int COST = 25;
    int total = 0;
    String name = "lost";
/**
 * Calculates the total for this object
 * @return integer total
 */
    @Override
    public int CalculateTotal() {
        
       return  total = COST;
        
    }
/**
 * Gets the name of this object
 * @return String name
 */
    @Override
    public String GetName() {
       return this.name = name;
    }
    
    
    
}
