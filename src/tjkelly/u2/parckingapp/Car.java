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
public class Car  {
    
    private static int ID = 100;

    /**
     * Constructor for the Car class that increments and sets the ID.
     */
    public Car() 
    {
        ID++;
        this.ID = ID;
              
    }
    
    public int getID()
    {
        return ID;
    }
    
    /**
     * Decrements the ID when the car is removed from the program.
     * @return 
     */
    public int removeID()
    {
        ID--;
        return ID;
    }

     
   
 
   
    
    
}
