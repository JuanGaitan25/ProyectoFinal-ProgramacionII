/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import java.security.MessageDigest;

/**
 *
 * @author juangaitan
 */
public class HashPasword {
    
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes("UTF-8"));

            // Convertir bytes a String HEX
            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception ex) {
            throw new RuntimeException("Error al hashear contraseña", ex);
        }
    }

    public static boolean verifyPassword(String password, String hashGuardado) {
        String hashIngresado = hashPassword(password);
        return hashIngresado.equals(hashGuardado);
    }
}
