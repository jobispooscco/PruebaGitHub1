<!DOCTYPE html>
<%@page import="java.text.DecimalFormat"%>
<%@page import="beans.ProductoDTO"%>
<%@page import="beans.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Listado de </h1>

		<a class="btn btn-primary" href="#">Ver data</a>
		<a class="btn btn-primary" href="#">Registra</a>
	</div>

	<br>
	<br>
	<div class="container">
		<table class="table">

			<tr>
				<th></th>
				<th>Id</th>
				<th>Nombre</th>
				<th>Stock</th>
				<th>Precio</th>
				<th></th>
				<th></th>
			</tr>
			
			<%	
				// código Java, para capturar el listado enviado desde el Servlet (como atributo) 
				ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>)request.getAttribute("listadito");
				// muestra los datos, si la lista tiene datos
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				if (lista != null){
					for (ProductoDTO x : lista) {  // for (int i=0; i< lista.size(); i++)
						%>
					<tr class="grilla_campo">
						<td><img alt="<%=x.getDescripcion() %>" src="img/<%=x.getIdprod() %>.png" width="100px"></td>
						<td><%=x.getIdprod() %></td>
						<td><%=x.getDescripcion() %></td>
						<td><%=x.getStock() %></td>
						<td style="color: red" >S/.<%=decimalFormat.format(x.getPrecio()) %></td>
						<td>
							<a href="crudprod?btns=q&cod=<%=x.getIdprod() %>">
								<img alt="editar" src="img/edit1.png"></td>
							</a>
						<td></td>
					</tr>
			<%		}
				}
			%>

		</table>
	</div>


</body>
</html>

