package org.example.model;

import org.example.tda.colas.ColaWaitingList;
import org.example.tda.conjuntos.ConjuntoTicket;
import org.example.tda.diccionario.DiccionarioReservation;

public class Function {

    private final int functionId;
    private static int globalFuncitonId = 1;
    private final Film film; //
    private final LanguageType languageType;
    private final boolean is3d;
    private ConjuntoTicket ticketSet;
    private final int startTime;
    private ColaWaitingList waitingList;
    private int availableSeats;
    private DiccionarioReservation reservations;

    public Function(Film film,
                    LanguageType languageType,
                    Boolean is3d,
                    int startTime,
                    int roomCapacity) {
        this.film = film;
        this.functionId = globalFuncitonId++;
        this.languageType = languageType;
        this.is3d = is3d;
        this.startTime = startTime;
        this.ticketSet = new ConjuntoTicket();
        this.ticketSet.InicializarConjunto();
        this.waitingList = new ColaWaitingList();
        this.waitingList.InicializarCola();
        this.availableSeats = roomCapacity;
        this.reservations = new DiccionarioReservation();
        this.reservations.InicializarDiccionario(roomCapacity);
    }

    public int getFunctionId() {
        return functionId;
    }

    public String getMovieTitle() {
        return film.getTitle();
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public int getStartTime() {
        return startTime;
    }

    public void registerTicket(Ticket ticket) {
        if (ticket.getIsUsed()) {
            System.out.println("El ticket ya fue usado.");
        } else {
            ticket.Use();
            ticketSet.Agregar(ticket);
            availableSeats--;
            System.out.println("Ticket registrado con éxito.");
        }
    }

    public boolean addToWaitingList(String clientName, String clientContact, int numberOfSeats) {
        if (numberOfSeats <= 0) {
            return false;
        }

        int currentTime = getCurrentTime(); // métod que devuelve el tiempo actual (podría ser System.currentTimeMillis())
        WaitingListEntry entry = new WaitingListEntry(clientName, clientContact, numberOfSeats, currentTime);
        waitingList.Acolar(entry);
        return true;
    }

    private int getCurrentTime() {
        // implementación simple para obtener un timestamp actual
        return (int) (System.currentTimeMillis() / 1000);
    }

    public WaitingListEntry getNextFromWaitingList() {
        if (waitingList.ColaVacia()) {
            return null;
        }
        WaitingListEntry next = waitingList.Primero();
        waitingList.Desacolar();
        return next;
    }

    public boolean hasWaitingList() {
        return !waitingList.ColaVacia();
    }

    public boolean hasAvailableSeats(int numberOfSeats) {
        return availableSeats >= numberOfSeats;
    }

    public WaitingListEntry notifyWaitingList(int newlyAvailableSeats) {
        availableSeats += newlyAvailableSeats;

        if (waitingList.ColaVacia()) {
            return null;
        }

        WaitingListEntry next = waitingList.Primero();
        if (next.getNumberOfSeats() <= availableSeats) {
            waitingList.Desacolar();
            availableSeats -= next.getNumberOfSeats();
            return next;
        }

        return null;
    }

    public Genre getGenre() {
        return film.getGenre();
    }

    public Film getFilm() {
        return film;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean addReservation(int reservationId, Reservation reservation) {
        try {
            // chequea por disponibilidad de asientos
            if (reservation.getNumberOfSeats() <= availableSeats) {
                reservations.Agregar(reservationId, reservation);
                availableSeats -= reservation.getNumberOfSeats();
                return true;
            } else {
                // no hay suficientes asientos
                return false;
            }
        } catch (IllegalStateException e) {
            // el diccionario esta lleno
            return false;
        }
    }

    public boolean cancelReservation(int reservationId) {
        Reservation reservation = reservations.Recuperar(reservationId);
        if (reservation != null) {
            reservations.Eliminar(reservationId);
            availableSeats += reservation.getNumberOfSeats();

            // promueve gente de la waitinglist
            notifyWaitingList(0);
            return true;
        }
        return false;
    }

    public Reservation getReservation(int reservationId) {
        return reservations.Recuperar(reservationId);
    }

}
