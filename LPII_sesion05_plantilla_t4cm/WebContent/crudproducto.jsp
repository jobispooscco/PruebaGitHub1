<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- usamos estilos bootstrap -->
<%-- url y href --%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<%
		//código Java
	%>
	<div id="contenido" style="margin-left: 30%; margin-right: 30%;">
		<h1>Manteniminiento de Productos</h1>

		<form action="crudprod" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Código :</label> <input type="text"
					class="form-control" id="nombre"
					placeholder="Ingrese código del producto" name="txtCodigo">

			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Nombre del producto:</label> <input
					type="text" class="form-control" id="nombre"
					placeholder="Nombre del producto" name="txtNombre">

			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Stock :</label> <input type="number"
					class="form-control" id="apellido" placeholder="0" name="txtStock">

			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Precio :</label> <input
					type="number" class="form-control" id="exampleInputEmail1"
					placeholder="0.00" name="txtUsuario">

			</div>

			<div class="form-group">
				<label for="exampleInputPassword1">Categoria :</label> <select
					class="form-control" name="cboCategoria">
					<option value="-1">Seleccione</option>
					<option value="1">Pastilla</option>
					<option value="2">Jarabe</option>
					<option value="3">Cremas</option>
					<option value="4">Tocador</option>
					<option value="5">Cuidado</option>
					<option value="6">Otros</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Estado :</label> 
				<select
					class="form-control" name="cboEstado">
					<option value="-1">Seleccione</option>
					<option value="1">Disponible</option>
					<option value="0">Agotado</option>
				</select>
			</div>

			<button type="submit" class="btn btn-primary" name="btns" value="r">Registrar</button>
			<button type="submit" class="btn btn-info"    name="btns" value="a">Actualizar</button>
			<button type="submit" class="btn btn-danger"  name="btns" value="e">Eliminar</button>
			<button type="submit" class="btn btn-warning" name="btns" value="l">Listado</button>
		</form>
		<br>
		<%-- muestra el atributo mensaje enviado desde el servlet --%>
		<p>${mensaje }</p>
		<br>
		<p>
			Si ya tiene cuenta, ingresé <a href="login.jsp">aquí</a>
		</p>
	</div>
</body>
</html>