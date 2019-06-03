/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

import java.time.LocalTime;

/**
 *
 * @author tyler
 */
public class MinMax implements Payment {
    
    
    InTicket in = new InTicket();
    OutTicket out = new OutTicket();
    
    String name = "min max";
    int total = 0;
    final int MIN_FEE = 5;
    final int HOUR_FEE = 1;
    final int MAX_ONE_DAY = 15;
    LocalTime outTime;
    LocalTime inTime;
/**
 * Calculates the total for this object
 * @return integer total
 */
    @Override
    public int CalculateTotal() {

        
         LocalTime outTime = out.getTime();
        int out = outTime.getHour();
        LocalTime inTicketTime = in.getTime();
       int in = inTicketTime.getHour();
       int timeTotal = out - in;

       if(timeTotal <= 3)
       {
           total = MIN_FEE;
       }

       else if(timeTotal > 3)
       {
           total = (timeTotal * HOUR_FEE);
       }

       else if(timeTotal >= 24)
       {
           total = MAX_ONE_DAY;
       }

       return total;
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
