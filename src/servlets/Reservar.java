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
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer precioMinimo = (int) (Integer.parseInt(request.getParameter("precio")) * 0.20);
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("fechainicio", request.getParameter("fechainicio"));
		request.setAttribute("fechafin", request.getParameter("fechafin"));
		request.setAttribute("precio", request.getParameter("precio"));
		request.setAttribute("preciomin", precioMinimo.toString());
		
		RequestDispatcher rd = request.getRequestDispatcher("reservar.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id").replaceAll("\\s","");
		String user = request.getParameter("user").replaceAll("\\s","");
		String fechaIni = request.getParameter("fecIni");
		String fechaFin = request.getParameter("fecFin");
		
		String nombre = request.getParameter("fullname");
		String nIdentificacion = request.getParameter("identificacion");
		String direccion = request.getParameter("residencia");
		String telefono = request.getParameter("telefono");
		String celular = request.getParameter("celular");
		String nTarjeta = request.getParameter("numerotarjeta");
		String fechaExp = request.getParameter("fechaexp");
		String nomTarjeta = request.getParameter("nombretarjeta");
		String precio = request.getParameter("precio");
		String precioMin = request.getParameter("preciominimo");
		String pagoRestante = String.valueOf(Integer.parseInt(precio) - Integer.parseInt(precioMin));
		
		if (nombre.isEmpty() || nIdentificacion.isEmpty() || direccion.isEmpty() || celular.isEmpty()
				|| nTarjeta.isEmpty() || fechaExp.isEmpty() || nomTarjeta.isEmpty() || precioMin.isEmpty()) {
			request.setAttribute("error", "Los campos marcados con (*) son obligatorios!");
			request.setAttribute("precio", precio);
			request.setAttribute("preciomin", precioMin);
			RequestDispatcher rd = request.getRequestDispatcher("reservar.jsp");
			rd.forward(request, response);
		}
		else {			
			AlojamientoServices alojamientoServices = new AlojamientoServices();
			alojamientoServices.reservarAlojamiento(id, user, precio, pagoRestante, fechaIni, fechaFin);
			request.setAttribute("exito", "La reservación se ha realizado con éxito!!");
			RequestDispatcher rd = request.getRequestDispatcher("reservar.jsp");
			rd.forward(request, response);
		}
		
	}

}
