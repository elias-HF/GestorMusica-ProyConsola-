
package modelo;


public class Cancion {
    private static int contador = 1;
    
    private final int id;
    private String titulo;
    private String artista;
    private String album;
    private int duracion;
    private String genero;
    
    
    public Cancion(String titulo){
        this.titulo = titulo;
        this.id = contador++;
    };
    
    public Cancion( String titulo, String artista,String album, int duracion, String genero){
        this.id = contador++;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.genero = genero;
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
    
   
    
}
