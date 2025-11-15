/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICIO;

import DAO.AcercaDeDAO;
import DAO.impl.AcercaDeDAOImpl;
import MODELO.AcercaDe;

/**
 *
 * @author juangaitan
 */
public class AcercaDeServicio {
    private final AcercaDeDAO dao = new AcercaDeDAOImpl();

    public AcercaDe obtener(int id) throws Exception {
        return dao.obtenerPorId(id);
    }

    public void guardarNuevo(int id, String carne, String nombres, String numeroCarne, String fotoPath, String proyecto, String version, String fecha) throws Exception {

        AcercaDe a = new AcercaDe(id, carne, nombres, numeroCarne, fotoPath, proyecto, version, fecha);
        dao.insertar(a);
    }

    public void actualizar(int id, String carne, String nombres, String numeroCarne, String fotoPath, String proyecto, String version, String fecha) throws Exception {

        AcercaDe a = new AcercaDe(id, carne, nombres, numeroCarne, fotoPath, proyecto, version, fecha);
        dao.actualizar(a);
    }
}
