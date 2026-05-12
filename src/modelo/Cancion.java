
package modelo;

import java.util.UUID;



public class Cancion {
    
    private String id;
    private String titulo;
    private String artista;
    private String album;
    private int duracion;
    
    public Cancion(){};
    
    public Cancion(String id, String titulo, String artista,String album, int duracion){
        this.id = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
    }
    
    public Cancion(String titulo, String artista,String album, int duracion){
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
