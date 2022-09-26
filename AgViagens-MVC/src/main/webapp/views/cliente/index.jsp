<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Cliente" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Cliente> clientes = (List<Cliente>) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<!-- Css - Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Css -->
<link rel="stylesheet" href="./css/style.css">

<title>JN Tour | Cliente</title>

</head>

<body>
	<!-- Início da Nav -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="./index.html">JN Tour</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span>Menu</span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="./acesso">Acessos</a></li>
						<li class="nav-item"><a class="nav-link" href="./cliente">Clientes</a></li>
						<li class="nav-item"><a class="nav-link" href="./compra">Compras</a></li>
						<li class="nav-item"><a class="nav-link" href="./destino">Destinos</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main class="my-5">
		<div
			class="container bg-light shadow col-12  table-responsive-sm my-3">
			<a href="./views/cliente/create.html" class="btn btn-primary mb-2">
				Novo </a>
			<table class="table table-hover align-middle">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome</th>
						<th scope="col">CPF</th>
						<th scope="col">Email</th>
						<th scope="col">Senha</th>
						<th scope="col">Acesso</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>


				<tbody>

					<%
					for (Cliente c : clientes) {
					%>
					<tr>
						<td><%=c.getId()%></td>
						<td><%=c.getNome()%></td>
						<td><%=c.getCpf()%></td>
						<td><%=c.getEmail()%></td>
						<td><%=c.getSenha()%></td>
						<td><%=c.getAcesso().getTipo()%></td>

						<td class="d-flex"><a href="./cliente-edit?id=<%=c.getId()%>"
							class="btn btn-success "> Editar </a> <a
							href="./cliente-delet?id=<%=c.getId()%>"
							onclick="return confirm('Tem certeza que deseja excluir?')"
							class="btn btn-danger"> Excluir </a></td>
					</tr>
					<%
					}
					%>

				</tbody>

			</table>
		</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>