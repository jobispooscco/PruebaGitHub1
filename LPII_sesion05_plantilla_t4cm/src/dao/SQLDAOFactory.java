package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import mantenimientos.SQLProductoDAO;
import mantenimientos.SQLUsuarioDAO;

public class SQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new SQLUsuarioDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new SQLProductoDAO();
	}

}
