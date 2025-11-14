/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author juangaitan
 */
public class AcercaDe {
    
    private int id;
    private String carne;
    private String nombres;
    private String numeroCarne;
    private String fotoPath;
    private String proyecto;
    private String version;
    private String fecha;

    public AcercaDe() {
    }

    public AcercaDe(int id, String carne, String nombres, String numeroCarne, String fotoPath, String proyecto, String version, String fecha) {
        this.id = id;
        this.carne = carne;
        this.nombres = nombres;
        this.numeroCarne = numeroCarne;
        this.fotoPath = fotoPath;
        this.proyecto = proyecto;
        this.version = version;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroCarne() {
        return numeroCarne;
    }

    public void setNumeroCarne(String numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
