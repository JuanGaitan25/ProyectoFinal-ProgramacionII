/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICIO;

import DAO.AutorDao;
import DAO.impl.AutorDAOImpl;
import MODELO.Autor;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public class AutorServicio {
    private final AutorDao dao = new AutorDAOImpl();

    public void guardarNuevo(int id, String nombre, String nacionalidad) throws Exception {

        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre requerido");

        dao.insertar(new Autor(id, nombre, nacionalidad));
    }

    public void actualizar(int id, String nombre, String nacionalidad) throws Exception {
        dao.actualizar(new Autor(id, nombre, nacionalidad));
    }

    public void eliminar(int id) throws Exception {
        dao.eliminar(id);
    }

    public List<Autor> listar() throws Exception {
        return dao.listar();
    }

    public Autor obtenerPorId(int id) throws Exception {
        return dao.obtenerPorId(id);
    }
}
