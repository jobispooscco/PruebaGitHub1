package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySQLConexion;
import utils.SQLConexion;

public class SQLProductoDAO implements ProductoDAO {

	@Override
	public ArrayList<ProductoDTO> listado() {
		ArrayList<ProductoDTO> lista = null;  // valor x default en caso de una lista vac�a
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = SQLConexion.getConexion();			
			String sql= "select * from tb_productos";
			pst = con.prepareStatement(sql);
			
			// ejecutamos la sentencia y guardamos el resultado
			rs = pst.executeQuery();
			
			// pasar los datos del rs, a la lista
			lista = new ArrayList<ProductoDTO>();
			while (rs.next()) {
				ProductoDTO p = new ProductoDTO();
				p.setIdprod(rs.getString(1));
				p.setDescripcion(rs.getString(2));
				p.setStock(rs.getInt(3));
				p.setPrecio(rs.getDouble(4));
				p.setIdcategoria(rs.getInt(5));
				p.setEstado(rs.getInt(6));
				lista.add(p);
			}			
		} catch (Exception e) {
			System.out.println("Error en registrar usuario : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ProductoDTO buscar(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
