/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

import java.time.LocalTime;

/**
 *Interface that controls all the ticket types 
 * @author tyler
 */
public interface Ticket {
    
    
    public abstract int menu();
    
    public abstract LocalTime setLocalTime();
    
    public abstract LocalTime getTime();
}
