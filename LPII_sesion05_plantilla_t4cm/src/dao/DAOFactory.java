package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;

// sirve para "decir" como implementar los mètodos de la interface (DAO)
public abstract class DAOFactory { // PADRE
	// constantes con las SGDB que podemos utilizar
	public static final int MYSQL = 1;
	public static final int SQL = 2;
	public static final int ACCESS = 3;
	public static final int ORACLE = 4;

	// método para tener a las interfaces (DAO)
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract ProductoDAO getProductoDAO();

	public static DAOFactory getDAOFactory(int qFactory) {
		switch (qFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		case SQL:
			return new SQLDAOFactory();
//		case ORACLE:
//			return new ORACLEDAOFactory();
		default:
			return null;
		}
	}

}
