package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	// declaraci�n de m�todos - p�blicos
	
	// registrar los datos de un nuevo usuario
	public int registrar(UsuarioDTO u);
	
	// validar un usuario seg�n los datos del login
	public UsuarioDTO validar(String usuario, String clave);
	
}
