/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.AcercaDeDAO;
import DB.Conexion;
import MODELO.AcercaDe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public class AcercaDeDAOImpl implements AcercaDeDAO {

    @Override
    public boolean insertar(AcercaDe info) {
        String sql = "INSERT INTO acerca_de (carne, nombres, numero_carne, foto_path, proyecto, version, fecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, info.getCarne());
            ps.setString(2, info.getNombres());
            ps.setString(3, info.getNumeroCarne());
            ps.setString(4, info.getFotoPath());
            ps.setString(5, info.getProyecto());
            ps.setString(6, info.getVersion());
            ps.setString(7, info.getFecha()); // ahora String
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error insertando información: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(AcercaDe info) {
        String sql = "UPDATE acerca_de SET carne=?, nombres=?, numero_carne=?, foto_path=?, proyecto=?, version=?, fecha=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, info.getCarne());
            ps.setString(2, info.getNombres());
            ps.setString(3, info.getNumeroCarne());
            ps.setString(4, info.getFotoPath());
            ps.setString(5, info.getProyecto());
            ps.setString(6, info.getVersion());
            ps.setString(7, info.getFecha()); // String
            ps.setInt(8, info.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizando información: " + e.getMessage());
            return false;
        }
    }

    @Override
    public AcercaDe obtenerPorId(int id) {
        String sql = "SELECT * FROM acerca_de WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AcercaDe info = new AcercaDe();
                info.setId(rs.getInt("id"));
                info.setCarne(rs.getString("carne"));
                info.setNombres(rs.getString("nombres"));
                info.setNumeroCarne(rs.getString("numero_carne"));
                info.setFotoPath(rs.getString("foto_path"));
                info.setProyecto(rs.getString("proyecto"));
                info.setVersion(rs.getString("version"));
                info.setFecha(rs.getString("fecha")); // String
                return info;
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo información: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AcercaDe> listar() {
        List<AcercaDe> lista = new ArrayList<>();
        String sql = "SELECT * FROM acerca_de";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AcercaDe info = new AcercaDe();
                info.setId(rs.getInt("id"));
                info.setCarne(rs.getString("carne"));
                info.setNombres(rs.getString("nombres"));
                info.setNumeroCarne(rs.getString("numero_carne"));
                info.setFotoPath(rs.getString("foto_path"));
                info.setProyecto(rs.getString("proyecto"));
                info.setVersion(rs.getString("version"));
                info.setFecha(rs.getString("fecha")); // String
                lista.add(info);
            }
        } catch (SQLException e) {
            System.out.println("Error listando información: " + e.getMessage());
        }
        return lista;
    }
}
