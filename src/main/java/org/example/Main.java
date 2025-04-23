package org.example;

import org.example.model.*;
import org.example.tda.conjuntos.ConjuntoPelicula;
import org.example.tda.conjuntos.ConjuntoTicket;

public class Main {
    public static void main(String[] args) {

/*        ConjuntoTicket conjuntoTicket = new ConjuntoTicket();
        conjuntoTicket.InicializarConjunto();
        // Agregar tickets al conjunto
        Ticket ticket1 = new Ticket("Velocipastor", 1, 4, 2030);
        Ticket ticket2 = new Ticket("Jurassic Park", 2, 5, 2030);

        conjuntoTicket.Agregar(ticket1);
        System.out.println(conjuntoTicket.Pertenece(ticket1.getTicketID()));
        System.out.println(conjuntoTicket.Pertenece(ticket2.getTicketID()));*/

        Theatre theatre = Theatre.getInstance(3);

        // Create films
        Film film1 = new Film("Sinners", 120, Genre.ACTION, 5);
        Film film2 = new Film("A Minecraft Movie", 120, Genre.ADVENTURE, 5);
        Film film3 = new Film("Snow White", 129, Genre.DRAMA, 5);

        // Initialize and set films
        ConjuntoPelicula films = new ConjuntoPelicula();
        films.InicializarConjunto();
        films.Agregar(film1);
        films.Agregar(film2);
        films.Agregar(film3);
        theatre.setFilms(films);

        // Create functions in rooms
        Room room0 = theatre.getRooms()[0];
        Function function1 = new Function(film1, LanguageType.SUB, false, 1800, 10);
        room0.addFunction(function1);

        Room room1 = theatre.getRooms()[1];
        Function function2 = new Function(film2, LanguageType.DUB, true, 1500, 5);
        room1.addFunction(function2);

        System.out.println("PRUEBA RESERVA");
        System.out.println("==========================");

        int reservationId1 = 1001;
        int reservationId2 = 1002;
        Reservation reservation1 = new Reservation(reservationId1, "Ramiro", "rama@example.com", function1, 3);
        Reservation reservation2 = new Reservation(reservationId2, "Bautista", "bau@example.com", function1, 4);

        boolean added1 = function1.addReservation(reservationId1, reservation1);
        System.out.println(function1.getAvailableSeats());
        boolean added2 = function1.addReservation(reservationId2, reservation2);
        System.out.println(function1.getAvailableSeats());


        System.out.println("\nPRUEBA LISTA DE ESPERA");
        System.out.println("===================");
        boolean addedToWaitList = function1.addToWaitingList("Manuel", "manu@example.com", 5);
        System.out.println("Se agrego a la waiting list: " + addedToWaitList);

        System.out.println("\nPRUEBA CANCELACION");
        System.out.println("===============================");
        boolean canceled = function1.cancelReservation(reservationId1);
        System.out.println("Cancelando reserva 1: " + canceled);
        System.out.println("Asientos disponibles despues de cancelar: " + function1.getAvailableSeats());

        // Check if waiting list entry was promoted
        if (function1.hasWaitingList()) {
            WaitingListEntry entry = function1.getNextFromWaitingList();
            System.out.println("Siguiente persona en la lista: " + entry.getClientName() +
                    ", asientos solicitados: " + entry.getNumberOfSeats());
        } else {
            System.out.println("La lista de espera esta vacía.");
        }
    }
}
