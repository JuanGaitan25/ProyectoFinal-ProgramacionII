/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.Usuario;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public interface UsuarioDAO {
    boolean insertar(Usuario usuario);
    boolean actualizar(Usuario usuario);
    boolean eliminar(int id);
    List<Usuario> listar();
    Usuario obtenerPorId(int id);
    Usuario obtenerPorUsername(String username);
}
