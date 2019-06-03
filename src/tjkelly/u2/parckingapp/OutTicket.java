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
 *Creates an Out Ticket for the car when the car checks out.
 * @author tyler
 */
public class OutTicket implements Ticket{
    
    Scanner scan = new Scanner(System.in);
    
    private Random r = new Random();
    
   private  LocalTime outTime;
   
    int choice;

    
  /**
   * Constructor that sets the local time for the out ticket.
   */
    public OutTicket()
    {
         setLocalTime();
    }
    
    /**
     * Menu used to display variables needed for the out Ticket.
     * @return int choice
     */
    @Override
    public int menu()
    {
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=================");
        System.out.println("");
        System.out.println("1. Check Out");
        System.out.println("");
        System.out.println("2. Lost Ticket");
        System.out.println("");
        System.out.println("=> ");
        choice = scan.nextInt();
       
        return choice;
    }
    
    /**
     * To set the current ticket to a random time. Uses Random but can be replaced with Math.Random.
     * Uses a switch statement to assign the time
     * @return LocalTime outTime
     */
    @Override
    public LocalTime setLocalTime() {
        int rand = r.nextInt(11);
        switch(rand)
        {
            case 0:
                outTime = LocalTime.of(13, 0);
                break;
            case 1:
                outTime = LocalTime.of(14, 0);
                break;
            case 2:
                outTime = LocalTime.of(15, 0);
            break;
            case 3:
                outTime = LocalTime.of(16, 0);
                break;
            case 4:
                outTime = LocalTime.of(17, 0);
                break;
            case 5:
                outTime = LocalTime.of(18, 0);
                break;
            case 6:
                outTime = LocalTime.of(19, 0);
                break;
            case 7:
                outTime = LocalTime.of(20, 0);
                break;
            case 8:
                outTime = LocalTime.of(21, 0);
                break;
            case 9:
                outTime = LocalTime.of(22, 0);
                break;
            case 10:
                outTime = LocalTime.of(23, 0);
                break;
            default:
                outTime = LocalTime.of(13, 0);
                break;
        } 
        return outTime;
    }
    
    /**
     * Used to get the LocalTime
     * @return LocalTime outTime
     */
    @Override
    public LocalTime getTime()
    {
        return outTime;
    }

    
}
