/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICIO;

import DAO.UsuarioDAO;
import DAO.impl.UsuarioDAOImpl;
import MODELO.Usuario;
import UTIL.HashPasword;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public class UsuarioServicio {
    private final UsuarioDAO dao = new UsuarioDAOImpl();

    public Usuario login(String username, String password) throws Exception {

        if (username == null || username.isBlank()) 
            throw new IllegalArgumentException("Usuario requerido");
        if (password == null || password.isBlank()) 
            throw new IllegalArgumentException("Contraseña requerida");

        Usuario u = dao.obtenerPorUsername(username);

        if (u == null) return null;

        if (HashPasword.verifyPassword(password, u.getPasswordHash())) {
            return u;
        }

        return null;
    }

    public void actualizar(Usuario user) throws Exception {
        dao.actualizar(user);
    }

    public void eliminar(int id) throws Exception {
        dao.eliminar(id);
    }

    public List<Usuario> listar() throws Exception {
        return dao.listar();
    }

    public Usuario obtenerPorId(int id) throws Exception {
        return dao.obtenerPorId(id);
    }
}
