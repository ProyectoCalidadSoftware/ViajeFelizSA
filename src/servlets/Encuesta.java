package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operations.EncuestaServices;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encuesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect("login.jsp");
		request.setAttribute("alojamiento", request.getParameter("alojamiento"));
		request.getRequestDispatcher("encuesta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ubicacion = request.getParameter("ubicacion");
		String habitaciones = request.getParameter("habitaciones");
		String servicio = request.getParameter("servicio");
		String limpieza = request.getParameter("limpieza");
		String calidad = request.getParameter("calidad");
		String comodidad = request.getParameter("comodidad");
		String comida = request.getParameter("comida");
		String mascotas = request.getParameter("mascotas");
		String idAlojamiento = request.getParameter("alojamiento");// "1";
		
		System.out.println(idAlojamiento);
		EncuestaServices encuestaServices = new EncuestaServices();
		encuestaServices.saveEncuesta(ubicacion, habitaciones, servicio, limpieza, calidad, comodidad, comida, mascotas, idAlojamiento);
		
		response.sendRedirect("login.jsp");
	}

}
