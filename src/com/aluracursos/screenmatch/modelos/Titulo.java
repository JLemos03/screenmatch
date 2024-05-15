package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.Exception.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")
    private String nombrePelicula;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    protected int duracionEnMiniutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(String nombrePelicula, int fechaDeLanzamiento) {
        this.nombrePelicula = nombrePelicula;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMiniutos() {
        return duracionEnMiniutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMiniutos(int duracionEnMiniutos) {
        this.duracionEnMiniutos = duracionEnMiniutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre dl titulo que quieres ver es: " + nombrePelicula + " fue lanzada: "+ fechaDeLanzamiento );
        System.out.println("Duracion en minutos: " + getDuracionEnMiniutos());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalEvaluaciones++;
    }
    public double calculaMedia(){

        return sumaDeLasEvaluaciones / totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombrePelicula().compareTo(otroTitulo.getNombrePelicula());
    }

    public Titulo(TituloOmdb miTituloOmdb){
        this.nombrePelicula = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
    if (miTituloOmdb.runtime().contains("N/A")){
        throw new ErrorEnConversionDeDuracionException("no se puede convertir la duracion en minutos, por que contiene un N/A");
    }
        this.duracionEnMiniutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    @Override
    public String toString() {
        return
                "Nombre='" + nombrePelicula + '\'' +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duracionEnMiniutos=" + duracionEnMiniutos;
    }
}
