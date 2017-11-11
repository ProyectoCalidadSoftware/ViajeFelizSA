package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operations.AlojamientoServices;

/**
 * Servlet implementation class Publicar
 */
@WebServlet("/Publicar")
public class Publicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publicar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("alojamiento");
		String cantidadPersonas = request.getParameter("personas");
		String cantidadHabitaciones = request.getParameter("habitaciones");
		String cantidadBanos = request.getParameter("baños");
		String calefaccion = request.getParameter("calefaccion");
		String aireAcondicionado = request.getParameter("aire");
		String mascotas = request.getParameter("mascotas");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String barrio = request.getParameter("barrio");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		
		if (nombre.isEmpty() || cantidadHabitaciones.isEmpty() || cantidadBanos.isEmpty() || direccion.isEmpty() ||
				ciudad.isEmpty() || barrio.isEmpty() || precio.isEmpty()) {
			request.setAttribute("error", "Todos los campos son obligatorios!");
			RequestDispatcher rd = request.getRequestDispatcher("postular.jsp");
			rd.forward(request, response);
		}
		else {
		
			if (calefaccion == null) {
				calefaccion = "";
			}
			
			if (aireAcondicionado == null) {
				aireAcondicionado = "";
			}
			
			if (mascotas == null) {
				mascotas = "";
			}
					
			AlojamientoServices alojamientoServices = new AlojamientoServices();
			alojamientoServices.postular(nombre, tipo, cantidadPersonas, cantidadHabitaciones, cantidadBanos, calefaccion, aireAcondicionado, mascotas, ciudad, direccion, barrio, descripcion, precio);
			
			response.sendRedirect("login.jsp");
		}
	}

}
