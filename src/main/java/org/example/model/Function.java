package org.example.model;

import org.example.tda.conjuntos.ConjuntoTicket;

public class Function {

    private final int functionId; // numero unico de esta funcion
    private static int globalFuncitonId = 1; // numero compartido entre todas las funciones que nadie puede modificar
    private final String movieTitle; // titulo de la pelicula que se va a proyectar
    private final LanguageType languageType; // si la pelicula doblada o subtitulada
    private final boolean is3d;
    private ConjuntoTicket ticketSet; // conjunto de tickets usados para esta funcion
    private final int startTime; // expresado en horario militar (ej: 14:30 = 1430)

    public Function(String movieTitle,
                    LanguageType languageType,
                    Boolean is3d,
                    int startTime){

        this.movieTitle = movieTitle;
        this.functionId = globalFuncitonId++;
        this.languageType = languageType;
        this.is3d = is3d;
        this.startTime = startTime;
        this.ticketSet = new ConjuntoTicket();
        this.ticketSet.InicializarConjunto();

    }

    public int getFunctionId() {
        return functionId;
    }

    public String getMovieTitle() {
        return movieTitle;
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

            System.out.println("Ticket registrado con exito.");
        }
    }

}
