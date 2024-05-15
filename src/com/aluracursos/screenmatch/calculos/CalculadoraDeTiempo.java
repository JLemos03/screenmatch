package com.aluracursos.screenmatch.calculos;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempototal;

    public int getTiempototal() {
        return tiempototal;
    }

    public void incluye(Titulo titulo){
        System.out.println("Agregando diracion en minutos de "+ titulo);
        this.tiempototal += titulo.getDuracionEnMiniutos();

    }

}
