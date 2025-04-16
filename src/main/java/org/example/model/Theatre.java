package org.example.model;

import org.example.tda.colas.ColaFunctions;
import org.example.tda.conjuntos.*;
import org.example.tda.diccionario.DiccionarioReservation;

public class Theatre {
    private static Theatre instance;
    private final Room[] rooms;
    private ConjuntoPelicula films;
    private DiccionarioReservation reservations;
    private int nextReservationId = 1;

    private Theatre(int numberOfRooms) {
        this.rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i, 210);
        }
        this.films = new ConjuntoPelicula();
        this.films.InicializarConjunto();
        this.reservations = new DiccionarioReservation();
        this.reservations.InicializarDiccionario();
    }

    public static Theatre getInstance(int numberOfRooms) {
        if (instance == null) {
            instance = new Theatre(numberOfRooms);
        }
        return instance;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void addFunctionToRoom(int roomNumber, Function function) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            Room room = rooms[roomNumber - 1];
            room.addFunction(function);
        } else {
            System.out.println("Número de sala inválido: " + roomNumber);
        }
    }

    public void setFilms(ConjuntoPelicula films) {
        this.films = films;

    }

    public int createReservation(String clientName, String clientContact,
                                 Function function, int numberOfSeats) {
        int reservationId = nextReservationId++;
        Reservation reservation = new Reservation(reservationId, clientName,
                clientContact, function, numberOfSeats);
        reservations.agregarReservation(reservationId, reservation);
        return reservationId;
    }

    public Reservation getReservation(int reservationId) {
        return reservations.Recuperar(reservationId);
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = getReservation(reservationId);
        if (reservation != null && !reservation.isCancelled()) {
            reservation.cancel();

            Function function = reservation.getFunction();

            WaitingListEntry nextClient = function.notifyWaitingList(reservation.getNumberOfSeats());

            if (nextClient != null) {
                int newReservationId = createReservation(
                        nextClient.getClientName(),
                        nextClient.getClientContact(),
                        function,
                        nextClient.getNumberOfSeats()
                );

                System.out.println("Se ha creado automáticamente una nueva reserva (ID: " +
                        newReservationId + ") para " + nextClient.getClientName() +
                        " que estaba en lista de espera.");
            }
        }
    }

    public IConjuntoTDA getAllReservationIds() {
        return reservations.Claves();
    }

    public boolean addToFunctionWaitingList(int roomNumber, String clientName,
                                            String clientContact, int numberOfSeats) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            Room room = rooms[roomNumber - 1];
            if (!room.getFunctions().ColaVacia()) {
                Function function = room.getFunctions().Primero();
                return function.addToWaitingList(clientName, clientContact, numberOfSeats);
            }
        }
        return false;
    }

    public WaitingListEntry getNextFromWaitingList(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            Room room = rooms[roomNumber - 1];
            if (!room.getFunctions().ColaVacia()) {
                Function function = room.getFunctions().Primero();
                return function.getNextFromWaitingList();
            }
        }
        return null;
    }

    public boolean checkFunctionAvailability(int roomNumber, int numberOfSeats) {
        if (roomNumber >= 1 && roomNumber <= rooms.length) {
            Room room = rooms[roomNumber - 1];
            if (!room.getFunctions().ColaVacia()) {
                Function function = room.getFunctions().Primero();
                return function.hasAvailableSeats(numberOfSeats);
            }
        }
        return false;
    }

    public void listFunctionsByGenre(String genre) {
        System.out.println("Funciones del género: " + genre);
        System.out.println("----------------------------------");

        for (Room room : rooms) {
            if (room.getFunctions().ColaVacia()) {
                continue;
            }

            // Necesitamos hacer una copia temporal de la cola para no alterarla
            ColaFunctions tempFunctions = new ColaFunctions();
            tempFunctions.InicializarCola();

            while (!room.getFunctions().ColaVacia()) {
                Function function = room.getFunctions().Primero();
                room.getFunctions().Desacolar();

                // Si coincide con el género buscado, lo mostramos
                if (function.getGenre().equalsIgnoreCase(genre)) {
                    System.out.println("Sala: " + (room.getRoomNumber() + 1));
                    System.out.println("Película: " + function.getMovieTitle());
                    System.out.println("Horario: " + function.getStartTime());
                    System.out.println("Asientos disponibles: " + function.getAvailableSeats());
                    System.out.println("----------------------------------");
                }

                // Guardamos la función en la cola temporal
                tempFunctions.Acolar(function);
            }

            // Restauramos la cola original
            while (!tempFunctions.ColaVacia()) {
                room.getFunctions().Acolar(tempFunctions.Primero());
                tempFunctions.Desacolar();
            }
        }
    }

    public void showReservationsStatus() {
        System.out.println("ESTADO DE LAS RESERVAS");
        System.out.println("==================================");

        IConjuntoTDA claves = reservations.Claves();

        if (claves.ConjuntoVacio()) {
            System.out.println("No hay reservas en el sistema.");
            return;
        }

        IConjuntoTDA clavesTemp = new ConjuntoLD();
        clavesTemp.InicializarConjunto();

        while (!claves.ConjuntoVacio()) {
            int reservationId = claves.Elegir();
            claves.Sacar(reservationId);
            clavesTemp.Agregar(reservationId);

            Reservation reservation = reservations.Recuperar(reservationId);
            if (reservation != null) {
                System.out.println("Reserva #" + reservationId);
                System.out.println("Cliente: " + reservation.getClientName());
                System.out.println("Película: " + reservation.getFunction().getFilm().getTitle());
                System.out.println("Sala: " + (reservation.getFunction().getFunctionId() + 1));
                System.out.println("Asientos: " + reservation.getNumberOfSeats());
                System.out.println("Estado: " + (reservation.isCancelled() ? "CANCELADA" : "ACTIVA"));
                System.out.println("----------------------------------");
            }
        }

        // Restaurar las claves
        while (!clavesTemp.ConjuntoVacio()) {
            int reservationId = clavesTemp.Elegir();
            claves.Agregar(reservationId);
            clavesTemp.Sacar(reservationId);
        }
    }

}