/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICIO;


import DAO.CategoriaDAO;
import DAO.impl.CategoriaDAOImpl;
import MODELO.Categoria;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public class CategoriaServicio {
    private final CategoriaDAO dao = new CategoriaDAOImpl();

    public void guardarNuevo(int id, String nombre) throws Exception {

        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre requerido");

        dao.insertar(new Categoria(id, nombre));
    }

    public void actualizar(int id, String nombre) throws Exception {
        dao.actualizar(new Categoria(id, nombre));
    }

    public void eliminar(int id) throws Exception {
        dao.eliminar(id);
    }

    public List<Categoria> listar() throws Exception {
        return dao.listar();
    }

    public Categoria obtenerPorId(int id) throws Exception {
        return dao.obtenerPorId(id);
    }
}
