/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
import MODELO.Autor;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public interface AutorDao {
    boolean insertar(Autor autor);
    boolean actualizar(Autor autor);
    boolean eliminar(int id);
    List<Autor> listar();
    Autor obtenerPorId(int id);
}
