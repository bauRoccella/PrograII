package org.example.model;

public class Theatre {
    private static Theatre instance;
    private final Room[] rooms;

    private Theatre(int numberOfRooms) {
        this.rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i, 210); // suponiendo que todas las salas tienen la misma capacidad
        }
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

}