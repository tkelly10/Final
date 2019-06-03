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
public class TjkellyU2ParckingApp {

   /**
    * 
    * The collection used in this application was a List, more specifically an ArrayList. Simply because an ArrayList is
    * easier to use overall and allows the collection to shrink and grow as the list is added to and removed from. 
    */
    
    public static void main(String[] args) throws Exception{
     
        TicketFactory tf = new TicketFactoryImpl();
        Garage garage = Garage.getInstance(tf);
        garage.run();
        
    }
}
