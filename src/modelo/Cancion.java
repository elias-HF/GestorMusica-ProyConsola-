/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Cancion implements Comparable<Cancion>{
    private static int contador = 1;
    
    private final int id;
    private String titulo;
    private String artista;
    private String album;
    private int duracion;
    private String genero;
    
    // para la prioriadad de la cola de prioridad
    private int prioridad;
    //en caso de que solo se inserte el titulo
    public Cancion(String titulo){
        this.titulo = titulo;
        this.id = contador++;
        this.artista = "Desconocido";
        this.album = "sin album";
        this.duracion = 0;
        this.genero = "sin genero";
        this.prioridad = 3;
    };
    //opcion de perzonalizacionr completa de la cancion
    public Cancion( String titulo, String artista,String album, int duracion, String genero, int prioridad){
        this.id = contador++;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.genero = genero;
        this.prioridad = prioridad;
    }
    
    
    
    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " - " + artista + " - " + genero + " (" + album + ", " + duracion + "s)";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    @Override
    public int compareTo(Cancion otra) {
        return Integer.compare(otra.getPrioridad(), this.prioridad);
    }
}
