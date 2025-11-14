/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.Libro;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public interface LibroDAO {
    boolean insertar(Libro libro);
    boolean actualizar(Libro libro);
    boolean eliminar(int id);
    List<Libro> listar();
    Libro obtenerPorId(int id);
    List<Libro> buscarPorTitulo(String titulo);
}
