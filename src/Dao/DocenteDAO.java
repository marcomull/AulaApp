package Dao;

import Entidades.Docente;
import Conexion.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocenteDAO {

    public boolean registrarDocente(Docente docente) {
        String sql = "INSERT INTO docentes (dni, nombre, apellido, telefono, email, direccion, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, docente.getDni());
            stmt.setString(2, docente.getNombre());
            stmt.setString(3, docente.getApellido());
            stmt.setString(4, docente.getTelefono());
            stmt.setString(5, docente.getEmail());
            stmt.setString(6, docente.getDireccion());
            stmt.setString(7, docente.getContrasena());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

