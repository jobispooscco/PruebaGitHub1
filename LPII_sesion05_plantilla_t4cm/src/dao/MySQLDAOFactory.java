package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import mantenimientos.MySQLProductoDAO;
import mantenimientos.MySQLUsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		// return new GestionUsuarios();
		return new MySQLUsuarioDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		// return new GestionProductos();
		return new MySQLProductoDAO();
	}

}
