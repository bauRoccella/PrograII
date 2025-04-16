package org.example.model;

public class WaitingListEntry {
    private final String clientName;
    private final String clientContact;
    private final int numberOfSeats;
    private final int entryTime; // Timestamp para priorizar por orden de llegada

    public WaitingListEntry(String clientName, String clientContact, int numberOfSeats, int entryTime) {
        this.clientName = clientName;
        this.clientContact = clientContact;
        this.numberOfSeats = numberOfSeats;
        this.entryTime = entryTime;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Cliente: " + clientName + " - Contacto: " + clientContact +
                " - Asientos solicitados: " + numberOfSeats;
    }
}