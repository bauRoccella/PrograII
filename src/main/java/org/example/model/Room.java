package org.example.model;

import org.example.tda.colas.ColaFunctions;

public class Room {
    private final int roomNumber;
    private final int capacity;
    private ColaFunctions functions; // implementacion nueva

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.functions = new ColaFunctions();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public ColaFunctions getFunctions() {
        return functions;
    }

    public void setFunctions(ColaFunctions functions) {
        this.functions = functions;
    }

    public void addFunction(Function function) {
        functions.Acolar(function);
    }

    public void removeFunction (){
        this.functions.Desacolar(); // se podria usar cuando ya se haya terminado la funcion
    }

    public void printCurrentMovie() {
        if (functions.ColaVacia()) {
            System.out.println("No hay funciones programadas en esta sala.");
        } else {
            Function currentFunction = functions.Primero();
            System.out.println("La funcion actual es: " + currentFunction.getMovieTitle());

            if (currentFunction.isIs3d()) {
                System.out.println("La funcion es en 3D.");
            }
            if (currentFunction.getLanguageType() == LanguageType.DUB) {
                System.out.println("La funcion es doblada.");
            } else {
                System.out.println("La funcion es subtitulada.");
            }
            System.out.println("La funcion empieza a las: " + currentFunction.getStartTime());
            System.out.println("El id de la funcion es: " + currentFunction.getFunctionId());
        }
    }


}
