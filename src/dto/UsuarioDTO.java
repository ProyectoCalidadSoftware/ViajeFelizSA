package dto;

public class UsuarioDTO {
	
	private String fullname;
	private String username;
	private String password;
	
	public UsuarioDTO(String name, String username, String password) {
		this.fullname = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return fullname;
	}

	public void setName(String name) {
		this.fullname = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}