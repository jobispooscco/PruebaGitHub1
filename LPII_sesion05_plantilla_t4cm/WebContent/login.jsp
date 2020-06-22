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
		<h1>Acceso al Sistema</h1>
		
		<form action="usu" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Usuario :</label> 
				<input type="email" class="form-control" id="exampleInputEmail1"
					placeholder="Ingrese su correo" 
					name="txtUsuario">
				
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Contraseña :</label>
				<input type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Ingrese Password"
					name="txtClave">
			</div>
			
			<button type="submit" class="btn btn-primary" name="btns" value="v">Ingresar</button>
		</form>
		<br>
		<%-- muestra el atributo enviado desde el servlet --%>
		<p>${mensaje }</p>
		<br>
		<p>Para registrar su cuenta, pulse <a href="registro.jsp">aquí</a>  </p>
	</div>
</body>
</html>