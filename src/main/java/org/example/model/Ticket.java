package org.example.model;

import java.time.LocalTime;

public class Ticket {

    private int seat; // numero de asiento
    private int room; // numero de sala
    private int startTime; // hora a en la que arranca la funcion
    private Boolean isUsed = false; // indica si ya se uso la entrada

    private static int globalTicketId = 1; // numero compartido entre todos los tickets que nadie puede modificar
    private int ticketId; // numero unico de este ticket

    // podriamos agregarle fecha, numero de funcion, precio, si tuvo o no un descuento, etc.

    public Ticket (String movieTitle, int seat, int room, int startTime) {

        this.seat = seat;
        this.room = room;
        this.startTime = startTime;

        this.ticketId = globalTicketId++;
        // asigna el valor actual de globalTicketID y despues lo incrementa para que no se repitan

    }

    public int getSeat() {
        return seat;
    }

    public int getRoom() {
        return room;
    }

    public int getStartTime() {
        return startTime;
    }

    public Boolean getIsUsed(){
        return isUsed;
    }

    public int getTicketID(){
        return ticketId;
    }

    public void Use(){
        this.isUsed = true;
    }

}
