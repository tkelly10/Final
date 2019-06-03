/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjkelly.u2.parckingapp;

/**
 * Interface to make each individual object
 * @author tyler
 */
public interface TicketFactory {
    Payment make(String ticketName);
}
