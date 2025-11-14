/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.Categoria;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public interface CategoriaDAO {
    boolean insertar(Categoria categoria);
    boolean actualizar(Categoria categoria);
    boolean eliminar(int id);
    List<Categoria> listar();
    Categoria obtenerPorId(int id);
}
