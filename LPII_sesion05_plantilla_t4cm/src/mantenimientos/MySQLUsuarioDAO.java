package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion;


public class MySQLUsuarioDAO implements UsuarioDAO {

	@Override
	public int registrar(UsuarioDTO u) {
		int rs = 0;   // valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			//              (null,'Zoila', 'Baca','U002@gmail.com', '10002', curdate(),2,1)
			String sql= "insert into tb_usuarios values (null,?,?,?,?,?,2,1)";
			pst = con.prepareStatement(sql);
			// seteamos los valores de ?
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFchnacim());
			// ejecutamos la sentencia y guardamos el resultado
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar usuario : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public UsuarioDTO validar(String usuario, String clave) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		UsuarioDTO usu = null;
		try {
			con = MySQLConexion.getConexion();
			//(null,'Tito', 'Ciber','U001@gmail.com', '10001', curdate(),1,1);
//			String sql = "select tb_usuarios where usuario='correo@gmail.com' and clave = '12345'";
			String sql = "select * from tb_usuarios where usuario=? and clave = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);			
			rst = pst.executeQuery();
			
			 while(rst.next()) {
				 usu = new UsuarioDTO();
				 usu.setCodigo(rst.getInt(1));
				 usu.setNombre(rst.getString(2));
				 usu.setApellido(rst.getString(3));
				 usu.setUsuario(rst.getString(4));
				 usu.setClave(rst.getString(5));
				 usu.setFchnacim(rst.getString(6));
				 usu.setTipo(rst.getInt(7));
				 usu.setEstado(rst.getInt(8));				 				
			 }									
			
		} catch (SQLException e) {
			System.out.println("Error al conectar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usu;
	}

}
