/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author juangaitan
 */
public class Libro {
    private int id;
    private String titulo;
    private int autorId;
    private int categoriaId;
    private int anio;
    private int stock;
    private String autorNombre;
    private String categoriaNombre;

    public Libro() {
    }

    public Libro(int id, String titulo, int autorId, int categoriaId, int anio, int stock, String autorNombre, String categoriaNombre) {
        this.id = id;
        this.titulo = titulo;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
        this.anio = anio;
        this.stock = stock;
        this.autorNombre = autorNombre;
        this.categoriaNombre = categoriaNombre;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
