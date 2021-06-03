package com.juan.recicle_view;

import java.util.ArrayList;
import java.util.Calendar;

public class Anime {

    private String nombre;
    private int imagen;
    private String descripcion;
    private Calendar fecha;


    public Anime(String nombre, int imagen, String descripcion,Calendar fecha) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.fecha = fecha;


    }

    public Anime(String nombre, int imagen, String descripcion) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;

    }

    public String nombre(){

        return nombre;

    }

    public int imagen(){

        return imagen;
    }

   public String getDescripcion(){

        return descripcion;
}
   public Calendar getFecha(){

        return fecha;
}





}
