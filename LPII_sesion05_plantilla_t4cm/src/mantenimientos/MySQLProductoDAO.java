package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySQLConexion;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public ArrayList<ProductoDTO> listado() {
		ArrayList<ProductoDTO> lista = null;  // valor x default en caso de una lista vac�a
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();			
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
		ProductoDTO pdt = null;
		
//		for(ProductoDTO p : listado()) {
//			if(p.getIdprod().equals(codigo)) {
//				pdt = p;
//			}
//		}
		
		Predicate<ProductoDTO> buscar = x -> x.getIdprod().equals(codigo);
		Optional<ProductoDTO>  op = listado().stream().filter(buscar).findFirst();
		
		pdt = op.isPresent()?op.get():new ProductoDTO();		
		
		return pdt;
	}
		
//		Predicate<ProductoDTO> buscar = x -> x.getIdprod().equals(codigo);
//		Function<List, ProductoDTO>  b =  
//		return listado().stream().filter(buscar).findAny();
	

}
