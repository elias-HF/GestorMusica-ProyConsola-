
package modelo;

public class Cancion implements Comparable<Cancion> {

    private static int contador = 1;

    private final int id;
    private String titulo;
    private String artista;
    private String album;
    private int duracion;
    private String genero;

    public Cancion(String titulo) {
        this.id = contador++;
        this.titulo = titulo;
        this.artista = "Desconocido";
        this.album = "Sin álbum";
        this.duracion = 0;
        this.genero = "Sin género";
    }

    public Cancion(String titulo,
                   String artista,
                   String album,
                   int duracion,
                   String genero) {

        this.id = contador++;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.genero = genero;

    }

    @Override
    public String toString() {

        return "[" + id + "] "
                + titulo
                + " - "
                + artista;

    }

    @Override
    public int compareTo(Cancion otra) {

        return this.titulo.compareToIgnoreCase(otra.titulo);

    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
