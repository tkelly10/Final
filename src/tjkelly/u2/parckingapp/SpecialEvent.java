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
public class SpecialEvent implements Payment {
    
    final int EVENT = 20;
    int total = 0;
    String name = "event";
    /**
     * Calculates the total for this object
     * @return total
     */
    @Override
    public int CalculateTotal() {

        return total = EVENT;
    }
/**
 * Gets the name for this object
 * @return String name
 */
    @Override
    public String GetName() {
        return this.name = name;
    }
}
