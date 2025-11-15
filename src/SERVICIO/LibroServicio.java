/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICIO;

import DAO.LibroDAO;
import DAO.impl.LibroDAOImpl;
import MODELO.Libro;
import MODELO.Autor;
import MODELO.Categoria;
import java.util.List;


/**
 *
 * @author juangaitan
 */
public class LibroServicio {
    private final LibroDAO dao = new LibroDAOImpl();
    private final AutorServicio autorService = new AutorServicio();
    private final CategoriaServicio categoriaService = new CategoriaServicio();

    public void guardarNuevo(int id, String titulo, int autorId, int categoriaId, int anio, int stock) throws Exception {

        if (titulo.isBlank()) throw new IllegalArgumentException("Título requerido");

        Autor a = autorService.obtenerPorId(autorId);
        Categoria c = categoriaService.obtenerPorId(categoriaId);

        if (a == null) throw new Exception("El autor no existe");
        if (c == null) throw new Exception("La categoría no existe");

        dao.insertar(new Libro(id, titulo, autorId, categoriaId, anio, stock));
    }

    public void actualizar(int id, String titulo, int autorId, int categoriaId, int anio, int stock) throws Exception {

        Autor a = autorService.obtenerPorId(autorId);
        Categoria c = categoriaService.obtenerPorId(categoriaId);

        if (a == null) throw new Exception("El autor no existe");
        if (c == null) throw new Exception("La categoría no existe");

        dao.actualizar(new Libro(id, titulo, autorId, categoriaId, anio, stock));
    }

    public void eliminar(int id) throws Exception {
        dao.eliminar(id);
    }

    public List<Libro> listar() throws Exception {
        return dao.listar();
    }

    public Libro obtenerPorId(int id) throws Exception {
        return dao.obtenerPorId(id);
    }

    public List<Libro> buscarPorTitulo(String texto) throws Exception {
        return dao.buscarPorTitulo(texto);
    }
}
