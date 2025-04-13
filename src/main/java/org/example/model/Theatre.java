package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private static Theatre instance;
    private final Room[] rooms;

    private Theatre(int numberOfRooms) {
        this.rooms = new Room[numberOfRooms];
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
}