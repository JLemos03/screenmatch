package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("matrixx",1999);
        miPelicula.evalua(9);
        Pelicula otrapelicula = new Pelicula("Megalodon", 2029);
        otrapelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("el que es", 2001);
        peliculaDeBruno.evalua(10);
        Serie casaDraon = new Serie("La casa Del Dragon", 2022);



        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otrapelicula);
        lista.add(peliculaDeBruno);
        lista.add(casaDraon);

        for (Titulo item: lista){
            System.out.println(item.getNombrePelicula());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion()>2){
            System.out.println(pelicula.getClasificacion());
            }
        }

        List<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Jaime Lemos");
        listaDeArtistas.add("Antonio banderas");
        listaDeArtistas.add("Kurt cobaain");

        System.out.println(listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println(listaDeArtistas);

        Collections.sort(lista);

        System.out.println("Peliculas lista ordenada "+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: "+lista);
    }
}

