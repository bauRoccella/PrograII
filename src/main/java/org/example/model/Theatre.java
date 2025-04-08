package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private static Theatre instance;
    private final List<Room> rooms;

    private Theatre() {
        this.rooms = new ArrayList<>();
    }

    public static Theatre getInstance() {
        if (instance == null) {
            instance = new Theatre();
        }
        return instance;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}