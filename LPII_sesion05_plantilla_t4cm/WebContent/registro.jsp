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
	<div id="contenido" style="margin-left: 30%;margin-right: 30%;">
		<h1>Registro de cuenta</h1>
		
		<form  action="usu" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Nombre :</label> 
				<input type="text" class="form-control" id="nombre"
					placeholder="Ingrese su nombre" name="txtNombre" 
					required="required" pattern="[A-Za-zÑñáéÁ ]{1,15}" 
					title="Sólo 15 caracteres">
				
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Apellido :</label> 
				<input type="text" class="form-control" id="apellido"
					placeholder="Ingrese su apellido" name="txtApellido">
				
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Usuario :</label> 
				<input type="email" class="form-control" id="exampleInputEmail1"
					placeholder="Ingrese su correo" name="txtUsuario">
				
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Contraseña :</label>
				<input type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Ingrese Password" name="txtClave" 
					maxlength="5">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Fecha de Nacimiento :</label> 
				<input type="date" class="form-control" id="fecha"
					placeholder="año/mes/dia" name="txtFecha">				
			</div>
			
			<button type="submit" class="btn btn-primary" name="btns" value="r">Registrar</button>
		</form>
		<br>
		<%-- muestra el atributo mensaje enviado desde el servlet --%>
		<p>${mensaje }</p>
		<br>
		<p>Si ya tiene cuenta, ingresé <a href="login.jsp">aquí</a>  </p>
	</div>
</body>
</html>