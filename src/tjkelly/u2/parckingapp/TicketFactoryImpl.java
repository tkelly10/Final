/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

/**
 * Class that makes each object
 * @author tyler
 */
public class TicketFactoryImpl implements TicketFactory {

    @Override
    public Payment make(String ticketName) {
       switch(ticketName)
       {
           case "lost":
               return new LostTicket();
            case"min max":
                return new MinMax();
            case"event":
                return new SpecialEvent();
       }
       return null;
    }
    
}
