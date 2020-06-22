package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "usu", urlPatterns = { "/usu" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entr� al Servlet del usuario");
		// capturar el bot�n pulsado
		String opc = request.getParameter("btns");
		System.out.println("Opci�n : " + opc);
		opc = (opc == null?"x":opc);   // codicional ternaria -> =SI(cond;v; f)
		
		// seg�n la opci�n seleccionada, hacer
		switch (opc) {
		case "r": registrar(request, response); break;
		case "a": actualizar(request, response); break;
		case "e": eliminar(request, response); break;
		case "l": listar(request, response); break;
		case "v": validar(request, response); break;
		default:
			/*PrintWriter out = response.getWriter();			
			out.print("<h1>Error 404</h1>");
			out.print("<a href='login.jsp'>Volver al inicio</a>");*/
			request.getSession().invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	private void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// es como el actionPerformed
		System.out.println("Entr� al servlet Login");

		// variables
		String usuario, clave;
		String url; 
		String mensaje; 

		// entradas
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		System.out.println(usuario + "-" + clave);

		// procesos
		// GestionUsuarios gu = new GestionUsuarios();
		// UsuarioDTO u = gu.validar(usuario, clave);
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDAO dao = fabrica.getUsuarioDAO();
		
		UsuarioDTO u = dao.validar(usuario, clave);
		//Muestra la seccion actual
		System.out.println("Sesion ID: " + request.getSession().getId() );
		if (u != null) {
			mensaje = "datos" + u;
			//Envia el atributo datos a nivel de session
			request.getSession().setAttribute("datos",u);
			url = "principal.jsp";
		} else {
			mensaje = "Usuario o clave incorrecto";
			url = "login.jsp";
		}

		// salidas
		// -- creamos el atributo o par�metro de salida
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entr� al servlet de registro");
		// variables
		String nombre, apellido, usuario, clave, fchnacim;
		String mensaje = "";
		String url;
		// entradas
		nombre = request.getParameter("txtNombre");
		apellido = request.getParameter("txtApellido");
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		fchnacim = request.getParameter("txtFecha");
		// -- comprobamos los datos
		if (!apellido.matches("[A-Za-z����� ]{1,15}")) {
			mensaje += "Apellido no v�lido";
		}

		UsuarioDTO u = new UsuarioDTO();
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setFchnacim(fchnacim);
		System.out.println(u);

		// procesos
		// -- llamar a la clase de gestion
		// GestionUsuarios gu = new GestionUsuarios();
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDAO dao = fabrica.getUsuarioDAO();
		
		int ok = dao.registrar(u);
		if (ok == 0) {
			// mensaje = "Error al registrar";
			mensaje += "<script>alert('Error al registrar')</script>";
			url = "/registro.jsp";
		} else {
			mensaje = "Registro de usuario " + u.getNombre() + " OK";
			url = "/login.jsp";
		}
		// salidas

		request.setAttribute("mensaje", mensaje); // creando un parametro a enviar
		request.getRequestDispatcher(url).forward(request, response); // va a la p�gina

		System.out.println("Termin� el servlet");

	}

}
