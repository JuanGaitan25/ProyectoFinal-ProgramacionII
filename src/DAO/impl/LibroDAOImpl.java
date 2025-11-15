/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.LibroDAO;
import DB.Conexion;
import MODELO.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juangaitan
 */
public class LibroDAOImpl implements LibroDAO {

    @Override
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor_id, categoria_id, anio, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAutorId());
            ps.setInt(3, libro.getCategoriaId());
            ps.setInt(4, libro.getAnio());
            ps.setInt(5, libro.getStock());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertando libro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Libro libro) {
        String sql = "UPDATE libros SET titulo=?, autor_id=?, categoria_id=?, anio=?, stock=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAutorId());
            ps.setInt(3, libro.getCategoriaId());
            ps.setInt(4, libro.getAnio());
            ps.setInt(5, libro.getStock());
            ps.setInt(6, libro.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizando libro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM libros WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error eliminando libro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = """
                SELECT l.id, l.titulo, a.nombre AS autor, c.nombre AS categoria, l.anio, l.stock,
                       l.autor_id, l.categoria_id
                FROM libros l
                INNER JOIN autores a ON l.autor_id = a.id
                INNER JOIN categorias c ON l.categoria_id = c.id
                """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutorId(rs.getInt("autor_id"));
                libro.setCategoriaId(rs.getInt("categoria_id"));
                libro.setAnio(rs.getInt("anio"));
                libro.setStock(rs.getInt("stock"));
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error listando libros: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Libro obtenerPorId(int id) {
        String sql = "SELECT * FROM libros WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutorId(rs.getInt("autor_id"));
                libro.setCategoriaId(rs.getInt("categoria_id"));
                libro.setAnio(rs.getInt("anio"));
                libro.setStock(rs.getInt("stock"));
                return libro;
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo libro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> lista = new ArrayList<>();
        String sql = """
                SELECT l.id, l.titulo, a.nombre AS autor, c.nombre AS categoria, l.anio, l.stock,
                       l.autor_id, l.categoria_id
                FROM libros l
                INNER JOIN autores a ON l.autor_id = a.id
                INNER JOIN categorias c ON l.categoria_id = c.id
                WHERE l.titulo LIKE ?
                """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + titulo + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutorId(rs.getInt("autor_id"));
                libro.setCategoriaId(rs.getInt("categoria_id"));
                libro.setAnio(rs.getInt("anio"));
                libro.setStock(rs.getInt("stock"));
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error buscando libros: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public void marcarFavorito(int idLibro, boolean favorito) throws Exception {
        String sql = "UPDATE libros SET favorito = ? WHERE id = ?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setBoolean(1, favorito);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
        }
    }
    
    @Override
    public List<Libro> listarFavoritos() throws Exception {
        List<Libro> lista = new ArrayList<>();
        String sql = """
                SELECT l.id, l.titulo, a.nombre AS autor, c.nombre AS categoria, l.anio, l.stock,
                       l.autor_id, l.categoria_id
                FROM libros l
                INNER JOIN autores a ON l.autor_id = a.id
                INNER JOIN categorias c ON l.categoria_id = c.id
                WHERE favorito = 1
                """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutorId(rs.getInt("autor_id"));
                libro.setCategoriaId(rs.getInt("categoria_id"));
                libro.setAnio(rs.getInt("anio"));
                libro.setStock(rs.getInt("stock"));
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error listando libros: " + e.getMessage());
        }
        return lista;
    }
    
    
}
