package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.UsuarioServices;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/RegistroUsuarios")
public class RegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		
		if (!fullname.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
			UsuarioServices userRegistration = new UsuarioServices();
			userRegistration.register(fullname, username, password);
			response.sendRedirect("login.jsp");
		}
		else {
			request.setAttribute("error", "Todos los campos son obligatorios!");
			RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			rd.forward(request, response);
		}
	}

}
