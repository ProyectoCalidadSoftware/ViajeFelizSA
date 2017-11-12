package operations;

import dao.UsuarioDAO;
import dto.UsuarioDTO;

public class UsuarioServices {
	
	private UsuarioDAO user;
	
	public UsuarioServices() {}
	
	public void register(String name, String username, String password) {
		user = new UsuarioDAO();
		user.registerUser(new UsuarioDTO(name, username, password));
	}
	
	public String getNombreUsuario(String username) {
		String nombre = "";
		UsuarioDAO usuario = new UsuarioDAO();
		UsuarioDTO usu = usuario.getUsuario(username);
		nombre = usu.getName();
		return nombre;
	}

}
