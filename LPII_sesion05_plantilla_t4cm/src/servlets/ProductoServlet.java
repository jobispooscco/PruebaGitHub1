package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "crudprod", urlPatterns = { "/crudprod" })
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entr� al Servlet");
		// capturar el bot�n pulsado
		String opc = request.getParameter("btns");
		System.out.println("Opci�n : " + opc);
		// seg�n la opci�n seleccionada, hacer
		switch (opc) {
			case "r": registrar(request, response); break;
			case "a": actualizar(request, response); break;
			case "e": eliminar(request, response); break;
			case "l": listar(request, response); break;
			case "q": buscar(request, response); break;
		default:
			break;
		}

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
		String codigo;
		//Entradas
		codigo = request.getParameter("cod");
		//Procesos
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		
		ProductoDTO pdt = dao.buscar(codigo);
		
		//Salida
		request.setAttribute("data", pdt);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
		
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entr� al listar");
		// variables
		String mensaje;
		String url;
		ArrayList<ProductoDTO> lstProductos;
		// entradas
		
		// procesos
		// --> obtener el listado de la tabla
//		GestionProductos gp = new GestionProductos();
//		lstProductos = gp.listado();
//      lstProductos = new GestionProductos().listado();
		
		// -- llamar a la fabrica
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		
		lstProductos = dao.listado();
		
		// salidas
		// enviar el listado al jsp
		request.setAttribute("listadito", lstProductos);
		request.getRequestDispatcher("/listado.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entr� al eliminar");
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entr� al actualizar");
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entr� al registrar");
		
	}

}

