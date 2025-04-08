package org.example.model;

import java.time.LocalTime;

public class Function {

    private final int functionId; // numero unico de esta funcion
    private final String movieTitle; // titulo de la pelicula que se va a proyectar
    private final LanguageType languageType; // si la pelicula doblada o subtitulada
    private final Boolean is3d;
    private static int globalFuncitonId = 1; // numero compartido entre todas las funciones que nadie puede modificar

    private LocalTime startTime; // hora a en la que arranca la funcion

    public Function(String movieTitle, LanguageType languageType, Boolean is3d, int startTimeHour, int startTimeMinute){
        this.movieTitle = movieTitle;
        this.functionId = globalFuncitonId++;
        this.languageType = languageType;
        this.is3d = is3d;

        this.startTime = LocalTime.of(startTimeHour,startTimeMinute);
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

    public Boolean getIs3d() {
        return is3d;
    }

    public static int getGlobalFuncitonId() {
        return globalFuncitonId;
    }

}
