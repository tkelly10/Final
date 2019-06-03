/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

/**
 *Creates an in Ticket for the car when the car checks in.
 * @author tyler
 */
public class InTicket implements Ticket{
   
    private Scanner scan = new Scanner(System.in);
    private LocalTime inTime;
    private Random r = new Random();
    private int choice;

    /**
     * Constructor that sets the local time for the in ticket.
     */
    public InTicket()
    {
     setLocalTime();
    }
   
    /**
     * A menu for the options for the in ticket.
     * @return int choice
     */
    @Override
    public int menu()
    {
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=================");
        System.out.println("");
        System.out.println("1. Check/ In");
        System.out.println("");
        System.out.println("2. Special Event");
        System.out.println("");
        System.out.println("3. Close Garage");
        System.out.println("");
        System.out.print("=> ");
        
        choice = scan.nextInt();
         
        return  choice;
    }

    /**
     * Gets the current local time for the ticket
     * @return LocalTime inTime
     */
    @Override
    public LocalTime getTime()
    {
        
        return inTime;
    }

    /**
     * To set the current ticket to a random time. Uses Random but can be replaced with Math.Random.
     * Uses a switch statement to assign the time
     * @return LocalTime inTime
     */
    @Override
    public LocalTime setLocalTime() {
        int rand = r.nextInt(6);
        switch(rand)
        {
            case 0:
                inTime = LocalTime.of(7, 0);
                break;
            case 1:
                inTime = LocalTime.of(8, 0);
                break;
            case 2:
                inTime = LocalTime.of(9, 0);
                break;
            case 3:
                inTime = LocalTime.of(10, 0);
                break;
            case 4:
                inTime = LocalTime.of(11, 0);
                break;
            case 5:
                inTime = LocalTime.of(12, 0);
                break;
            default:
                inTime = LocalTime.of(7, 0);

        }
        return inTime;
    }
    
    
   

   
}
