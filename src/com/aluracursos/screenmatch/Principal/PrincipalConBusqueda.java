package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Nombre de la pelicula");
        var busqueda = lectura.nextLine();

        String direccion ="https://www.omdbapi.com/?t="+busqueda.replace(" ", "+")+"&apikey=1d483c35";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(response.body());

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb miTituloOmdb= gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);


            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println(miTitulo);

        } catch (NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la direccion ");
        } catch (Exception e){
            System.out.println("Ocurrio un error inexperado ");
        }

        System.out.println("FInalizo la ejecucion del programa ");

    }
}
