/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

/**
 * Interface to set up the Payment objects
 * @author tyler
 */
public interface Payment {
 
    public abstract int CalculateTotal();
    
    public abstract String GetName();
    
    
}
