package Controladores;

import Dao.DocenteDAO;
import Entidades.Docente;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/RegistroDocenteServlet")
public class RegistroDocenteServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private final DocenteDAO docenteDAO = new DocenteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener los datos del formulario
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmarContrasena");

        // Validar contraseñas
        if (!contrasena.equals(confirmarContrasena)) {
            response.getWriter().println("<script>alert('Las contraseñas no coinciden');</script>");
            response.setHeader("Refresh", "0; URL=registroDocente.html");
            return;
        }

        // Crear objeto Docente
        Docente docente = new Docente(dni, nombre, apellido, telefono, email, direccion, contrasena);

        // Registrar docente en la base de datos
        boolean registroExitoso = docenteDAO.registrarDocente(docente);

        if (registroExitoso) {
            response.sendRedirect("registroExitoso.html");
        } else {
            response.getWriter().println("<script>alert('Error al registrar al docente');</script>");
            response.setHeader("Refresh", "0; URL=registroDocente.html");
        }
    }
}

