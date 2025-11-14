/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.AutorDao;
import DB.Conexion;
import MODELO.Autor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public class AutorDAOImpl implements AutorDao {

    @Override
    public boolean insertar(Autor autor) {
        String sql = "INSERT INTO autores (nombre, nacionalidad) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertando autor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Autor autor) {
        String sql = "UPDATE autores SET nombre=?, nacionalidad=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.setInt(3, autor.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizando autor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM autores WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error eliminando autor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Autor> listar() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setNacionalidad(rs.getString("nacionalidad"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error listando autores: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Autor obtenerPorId(int id) {
        String sql = "SELECT * FROM autores WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setNacionalidad(rs.getString("nacionalidad"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo autor: " + e.getMessage());
        }
        return null;
    }
}




