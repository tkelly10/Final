
package tjkelly.u2.parckingapp;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


/**
 *The driver class that puts everything together. 
 * @author tyler
 */
public class Garage {

    TicketFactory tf;
    private static Garage instance = null;
    
     //Objects used
    InTicket in;
    LocalTime inTime;
    OutTicket out;
    LocalTime outTime;
    Car car;
    List<Car> carList = new ArrayList<Car>();
    List<Car>eventList = new ArrayList<Car>();
    File gar = new File("garage.txt");
  
    //Variables used
    
   private int countIn = 0;
   int total = 0;
   private int GarageTotal = 0;
   private int totalLost = 0;
   private int lostCount = 0;
   private int totalEvent = 0;
   private int eventCount = 0;
   private boolean sEvent = false;
   
   /**
    * Constructor that pulls everything together. 
    */
   private Garage(TicketFactory tf) 
    {
        this.tf = tf;
    }
   
   public void run() throws FileNotFoundException
   {
        this.in = new InTicket();
        this.out = new OutTicket();
        Scanner scan = new Scanner(System.in);
        int choice = 0;
       
        
       do{

               menu();
             choice = scan.nextInt();

               switch(choice)
               {
                   case 1:
                       in = new InTicket();
                      
                           int inPick = in.menu();
                         
                           if(inPick == 1)
                                {
                                    checkIn();
                                    System.out.println("Car number " + car.getID()+" has checked in.");
                                }
                                else if(inPick == 2)
                                {
                                    arrivingSpecialEvent();
                                    setSpecialEvent();
                                    System.out.println("Car number " + car.getID() + " has checked for the event");
                                }
                                else if(inPick == 3)
                                {
                                    closeErUp();
                                }
                           
                     
                       break;
                   case 2:
                        out = new OutTicket();
                    
                       int  outPick = out.menu();

                        if(outPick ==1 )
                           {
                               checkOut();
                               car.removeID();
                           }
                           else if(outPick == 2)
                           {
                               lostTicket();
                               car.removeID();
                           }
                       
                   break;
               }
              
         } while(true);
       
    }
    /**
     * Menu to figure out if the car is arriving or leaving.
     */
   public static void menu()
   {
       
       System.out.println("");
       System.out.println("Arriving 1)");
       System.out.println("");
       System.out.println("Leaving 2)");
       System.out.print("=> ");
   }
   /**
    * Closes up the program and displays the totals under each category of ticket.
    */
    public void closeErUp() throws FileNotFoundException
    {
        out = new OutTicket();
        int sum = GarageTotal + totalLost + totalEvent;
        int allTotal = readFile();
        allTotal += sum;
        writeFile(gar, allTotal);
        System.out.println("Activity to date\t\t");
        System.out.println("$"+GarageTotal+ " was collected over "+countIn+" Check Ins\t");
        System.out.println("$"+totalEvent+ " was collected over "+eventCount+" Special Events\t");
        System.out.println("$"+ totalLost +" was collected over "+ lostCount+" Lost Tickets\t\t\t");
        System.out.println("$"+ allTotal +" was collected overall");
        System.exit(0);
        
    }
    /**
     * Checks in the car and adds it to an array list.
     */
    public void checkIn() 
    {
         car = new Car();
         carList.add(car);
         countIn++;
    }

    /**
     * Check outs the car and brings other methods to calculate the amount owed and displays the receipt. Also
     * removes the car from the garage.
     */
    public void checkOut()
    {
        Payment mm = tf.make("min max");

        sEvent = false;
        
        if(carList.size() > 0)
        {
           checkIDs();
            
            if(sEvent)
            {
                leavingSpecialEvent();
            }
            else if(!sEvent)
            {
                
                System.out.println("Receipt for vehicle id " + carList.get(0).getID()+"\t\t");
                System.out.println("Checked in at " +in.getTime() + " and checked out at " + out.getTime());
                System.out.println("\t\t");
                System.out.println("$"+mm.CalculateTotal());
                removeCar();
            }
        }
        else
        {
            System.out.println("The garage is empty ");
        }
         GarageTotal += mm.CalculateTotal();
    }

    /**
     * Removes the car from the List
     * @return carList
     */
    public List removeCar()
    {
        if(carList.size() > 0)
        {
            carList.remove(carList.get(0));
        }
        return carList;
    }
    
    /**
     * Removes the car from the Event List
     * @return eventList
     */
    public List removeEventCar()
    {
        if(eventList.size() > 0)
        {
            eventList.remove(eventList.get(0));
        }
        return eventList;
    }
    
    /**
     * A lot like checkOut() this gives the receipt, but for a lost ticket
     * @return integer totalLost
     */
    public int lostTicket()
    {
        Payment lost = tf.make("lost");
        if(carList.size() > 0)
        {
        System.out.println("Reciept for vehicle id " + carList.get(0).getID()+"\t\t");
        lostCount++;
        totalLost += lost.CalculateTotal();
        System.out.println("Lost Ticket\t");
        System.out.println("$" + lost.CalculateTotal());
        removeCar();
        }
        else
        {
            System.out.println("Garage is empty");
        }
        return lost.CalculateTotal();
    }
    
    /**
     * A lot like checkOut() and lostTicket() this gives the receipt for the special event
     * @return integer totalEvent
     */
    public int leavingSpecialEvent()
    {
        Payment event = tf.make("event");
        
        if(eventList.size() > 0)
        {
            System.out.println("Reciept for vehicle id " + eventList.get(0).getID()+"\t\t");
            eventCount++;
            totalEvent += event.CalculateTotal();
            System.out.println("Special Event\t");
            System.out.println("$" + event.CalculateTotal());
            removeEventCar();
        }
        else
        {
            System.out.println("Garage is empty");
        }
        return event.CalculateTotal();
    }
    
    /**
     * Set a car into the special event list. 
     */
    public void arrivingSpecialEvent()
    {
        car = new Car();
        eventList.add(car);
        eventCount++;
        
    }
    
    /**
     * Sets a boolean that if true will allow tickets to bypass all other tickets for the special event.
     * @return 
     */
     public boolean setSpecialEvent()
    {
        return sEvent = true;
    }
     
     /**
      * Checks the IDs of all tickets and if the ticket matches one with a special event and will allow that ticket 
      * to be used as a special event.
      */
     public int checkIDs()
     {
         int currentID = 0;
         if(carList.size() > 0)
         {
            for(Car cID : carList )
            {
                currentID = cID.getID();
                
                for(Car eID : eventList)
                {
                    if(currentID == eID.getID())
                    {
                        setSpecialEvent();
                    }
                }
            }
         }
         return currentID;
    }
     /**
      * Creates or writes a file.
      * @param gar File
      * @param a integer 
      * @throws FileNotFoundException 
      */
     
    public static void writeFile(File gar, int a) throws FileNotFoundException
     {
         PrintWriter fw = null;
         try
         {
             fw = new PrintWriter(new BufferedWriter(new FileWriter(gar)));
             fw.println(a);
             
         }catch(IOException e)
         {
             System.out.println(e.getStackTrace());
         }
         finally
         {
             if(fw != null)
             {
                fw.close();
             }
         }
     }
     /**
      * Reads from a file and converts the number within the file to an integer.
      * @return integer gTotal
      * @throws FileNotFoundException 
      */
     public static int readFile() throws FileNotFoundException
     {
         int gTotal = 0;
         Scanner s = null;
         try
         {
              s = new Scanner(new File("garage.txt"));
              gTotal = s.nextInt();
             
         }catch(Exception e)
         {
             System.out.println(e.getStackTrace());
         }
         finally
         {
             if(s != null)
             {
                  s.close();
             }
         }
         return gTotal;
     }
     /**
      * Used for Singleton checks if instance is set to null, if so then set up Garage.
      * @param tf TicketFactory
      * @return instance
      */
     public static Garage getInstance(TicketFactory tf)
     {
         if(instance == null)
         {
             instance = new Garage(tf);
         }
         return instance;
     }
     

}
