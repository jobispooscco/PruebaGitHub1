package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	// declaración de métodos - públicos
	
	// registrar los datos de un nuevo usuario
	public int registrar(UsuarioDTO u);
	
	// validar un usuario según los datos del login
	public UsuarioDTO validar(String usuario, String clave);
	
}
