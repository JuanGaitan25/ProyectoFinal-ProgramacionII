/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.AcercaDe;
import java.util.List;

/**
 *
 * @author juangaitan
 */
public interface AcercaDeDAO {
    boolean insertar(AcercaDe acercaDe);
    boolean actualizar(AcercaDe acercaDe);
    List<AcercaDe> listar();
    AcercaDe obtenerPorId(int id);
    
}
