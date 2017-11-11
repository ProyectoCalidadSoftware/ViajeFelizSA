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

}
