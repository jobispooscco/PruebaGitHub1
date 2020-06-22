<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 30%;
	height: 300px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>
<body>
	<header>
		<h2>Ciberfarma - ActualizarDatos</h2>
	</header>

	<section>
		<p>${mensaje}</p>
		<p>${datos.nombre}${datos.apellido}</p>
		<nav>
			<ul>
				<li><a href="actualizaDatos.jsp">Actualizar datos</a></li>
				<li><a href="#">Mantenimiento de productos</a></li>
				<li><a href="#">Listado de productos</a></li>
				<li><a href="usu">Cerrar sesion</a></li>
			</ul>
		</nav>

		<article>
			<div id="contenido" style="margin-left: 30%; margin-right: 30%;">
				<h1>Actualiza datos</h1>

				<form action="usu" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Código :</label> <input
							type="text" class="form-control" id="codigo"
							placeholder="Ingrese su codigo" name="txtCodigo"
							required="required" pattern="[A-Za-zÑñáéÁ ]{1,15}"
							title="Sólo 15 caracteres" value="${datos.codigo}">

					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Nombre :</label> <input
							type="text" class="form-control" id="nombre"
							placeholder="Ingrese su nombre" name="txtNombre"
							required="required" pattern="[A-Za-zÑñáéÁ ]{1,15}"
							title="Sólo 15 caracteres" value="${datos.nombre}">

					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Apellido :</label> <input
							type="text" class="form-control" id="apellido"
							placeholder="Ingrese su apellido" name="txtApellido" value="${datos.apellido}">

					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Usuario :</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Ingrese su correo" name="txtUsuario" value="${datos.usuario}">

					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Contraseña :</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Ingrese Password" name="txtClave" maxlength="5" value="${datos.clave}">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Fecha de Nacimiento :</label> <input
							type="date" class="form-control" id="fecha"
							placeholder="año/mes/dia" name="txtFecha" value="${datos.fchnacim}">
					</div>

					<button type="submit" class="btn btn-primary" name="btns" value="a">Actualizar</button>
				</form>
				<br>
				<%-- muestra el atributo mensaje enviado desde el servlet --%>
				<p>${mensaje }</p>
				<br>

			</div>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>
