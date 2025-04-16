package org.example.model;

public class Reservation {
    private final int reservationId;
    private final String clientName;
    private final String clientContact;
    private final Function function;
    private final int numberOfSeats;
    private boolean isCancelled;

    public Reservation(int reservationId, String clientName, String clientContact,
                       Function function, int numberOfSeats) {
        this.reservationId = reservationId;
        this.clientName = clientName;
        this.clientContact = clientContact;
        this.function = function;
        this.numberOfSeats = numberOfSeats;
        this.isCancelled = false;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public Function getFunction() {
        return function;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override
    public String toString() {
        return "Reserva #" + reservationId + " - Cliente: " + clientName +
                " - Película: " + function.getMovieTitle() +
                " - Sala: " + function.getFunctionId() +
                " - Asientos: " + numberOfSeats;
    }
}