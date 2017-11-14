package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AlojamientoDTO;
import operations.AlojamientoServices;

/**
 * Servlet implementation class BuscarAlojamiento
 */
@WebServlet("/BuscarAlojamiento")
public class BuscarAlojamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarAlojamiento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		String id = request.getParameter("id");
		String fechaInicio = request.getParameter("fechainicio");
		String fechaFin = request.getParameter("fechafin");
		AlojamientoServices alojamientoServices = new AlojamientoServices();
		AlojamientoDTO alojamiento = alojamientoServices.getAlojamientoById(id);
		request.setAttribute("id", alojamiento.getId());
		request.setAttribute("alojamiento", alojamiento);
		request.setAttribute("inicio", fechaInicio);
		request.setAttribute("fin", fechaFin);
		request.setAttribute("precio", alojamiento.getPrecio().toString());
		RequestDispatcher rd = request.getRequestDispatcher("verAlojamiento.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String tipo = request.getParameter("alojamiento");
		String numHabitaciones = request.getParameter("habitaciones");
		String ciudad = request.getParameter("ciudad");
		if (!ciudad.isEmpty()) {
			AlojamientoServices alojamientoServices = new AlojamientoServices();
			ArrayList<AlojamientoDTO> alojamientos = alojamientoServices.searchReservarByParameters(fechaInicio, fechaFin, tipo, numHabitaciones, ciudad);
			
			if (alojamientos.size() != 0) {
				request.setAttribute("fechaini", fechaInicio);
				request.setAttribute("fechafin", fechaFin);
				request.setAttribute("alojamientos", alojamientos);
				RequestDispatcher rd = request.getRequestDispatcher("listaalojamientos.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("notfound", "No se encontró alojamientos con esas características!");
				RequestDispatcher rd = request.getRequestDispatcher("buscar.jsp");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("error", "El campo ciudad es obligatorio!");
			RequestDispatcher rd = request.getRequestDispatcher("buscar.jsp");
			rd.forward(request, response);
		}
		
	}

}
