package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConexion {
	
	public static Connection getConexion(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");  // MySQL v5.x 
					
		String url= "jdbc:mysql://localhost:3306/ciberfarma";		
		String usr= "root";
		String psw= "??Mysql1991";
		con = DriverManager.getConnection(url,usr,psw);
		
		} catch(ClassNotFoundException e) {
		System.out.println("Error >> Driver no Instalado!!");
		} catch(SQLException e) {
		System.out.println("Error >> de conexi�n con la BD");
		}
		return con;
		}
	
	public static void closeConexion(Connection con){
		
		try {
			con.close();//Sentencia para cerrar la conexi�n
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar la conexion");
		}
	}
	
	public static void closeStatement(Statement stmt){
		
		try {
			stmt.close();// sentencia para cerrar el statement
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar el statement");
		}
	}
	

}
