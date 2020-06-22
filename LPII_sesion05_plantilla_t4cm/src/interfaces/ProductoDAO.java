package interfaces;

import java.util.ArrayList;

import beans.ProductoDTO;

public interface ProductoDAO {
	// registrar, actualiza, eliminar
	
	// listar todos los productos
	public ArrayList<ProductoDTO> listado();
	
	//buscar un producto según su codigo
	public ProductoDTO buscar(String codigo);
}
