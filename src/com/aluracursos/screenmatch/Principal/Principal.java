package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("matrixx",1999);
        miPelicula.setDuracionEnMiniutos(188);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.setDirector("tom");

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);

        miPelicula.setIncluidoEnElPlan(false);
        System.out.println();
        System.out.println(miPelicula.calculaMedia());
        System.out.println("Las evaluaciones fueron: "+miPelicula.getTotalEvaluaciones());
        System.out.println("La duracion en minutos es de: " +miPelicula.getDuracionEnMiniutos());
        System.out.println(miPelicula.isIncluidoEnElPlan());
        System.out.println("Nombre del director es: " +miPelicula.getDirector());


//        com.aluracursos.screenmatch.modelos.Pelicula otra = new com.aluracursos.screenmatch.modelos.Pelicula();
//        otra.nombrePelicula="encanto";
//        otra.fechaDeLanzamiento=2021;
//        otra.duracionEnMiniutos=178;

//        System.out.println("Mi pelicla es: " + otra.nombrePelicula + " fue lanzada: "+otra.fechaDeLanzamiento );
       // otra.muestraFichaTecnica();
//        System.out.println(miPelicula);

//        com.aluracursos.screenmatch.modelos.Pelicula otraPeli = new com.aluracursos.screenmatch.modelos.Pelicula();
//
//        otraPeli.nombrePelicula="Avengers";
//        otraPeli.fechaDeLanzamiento=2029;
//        otraPeli.duracionEnMiniutos=200;
//        otraPeli.incluidoEnElPlan=true;
//
//        otraPeli.muestraFichaTecnica();
//        otraPeli.evalua(9);
//        otraPeli.evalua(10);
////        System.out.println(otraPeli.sumaDeLasEvaluaciones);
//        System.out.println(otraPeli.calculaMedia());

        Serie casaDraon = new Serie("La casa Del Dragon", 2022);
        casaDraon.setTemporadas(1);
        casaDraon.setMinutosPorEpisodio(50);
        casaDraon.setEpisodiosPorTemporada(10);
        casaDraon.muestraFichaTecnica();
        System.out.println(casaDraon.getDuracionEnMiniutos());

        Pelicula otrapelicula = new Pelicula("Megalodon", 2029);
        otrapelicula.setDuracionEnMiniutos(100);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDraon);
        calculadora.incluye(otrapelicula);
        System.out.println("El tiempo necesario para ver:  "
                +calculadora.getTiempototal() + " minutos");


        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("No se");
        episodio.setSerie(casaDraon);
        episodio.setTotalVisualizaciones(100);

        filtroRecomendacion.filtra(episodio);

        var peliculaDeBruno = new Pelicula("el que es", 2001);
        peliculaDeBruno.setDuracionEnMiniutos(189);


        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otrapelicula);

        System.out.println("Tamanio de la lista: "+ listaDePeliculas.size());

        System.out.println(("La primera pelicula es "+listaDePeliculas.get(0).getNombrePelicula()));
        System.out.println("Tamanio de la lista: "+ listaDePeliculas);

        System.out.println(listaDePeliculas);
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());


    }
}
