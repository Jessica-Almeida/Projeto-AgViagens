<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Cliente" import="java.util.List"%>
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
	<main class="container jumbotron bg-light my-5 shadow col-12 col-md-6">
		<h2 class="text-center pt-4">ATUALIZAÇÃO - CLIENTE</h2>
		<form action="./cliente-update" class="m-5">
			<div class="form-floating mb-3">
				<input type="number" name="id" class="form-control" placeholder="id"
					value="<%=request.getAttribute("id")%>" readonly> <label>ID</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" autocomplete="username" name="nome"
					class="form-control" placeholder="nome"
					value="<%=request.getAttribute("nome")%>" required> <label>Nome</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"
					title="Digite um CPF no formato: xxx.xxx.xxx-xx"
					class="form-control" placeholder="cpf"
					value="<%=request.getAttribute("cpf")%>" required> <label>CPF</label>
			</div>

			<div class="form-floating mb-3">
				<input type="email" autocomplete="username" name="email"
					class="form-control " placeholder="email"
					value="<%=request.getAttribute("email")%>" required> <label>Email</label>
			</div>
			<div class="form-floating mb-3">
				<input type="password" autocomplete="current-password" name="senha"
					class="form-control" placeholder="senha"
					value="<%=request.getAttribute("senha")%>" required> <label>Senha</label>
			</div>
			<div class="form-floating mb-3">
				<input type="number" name="idAcesso" class="form-control"
					placeholder="id de acesso"
					value="<%=request.getAttribute("idAcesso")%>" required> <label>ID
					Acesso</label>
			</div>


			<input class="btn btn-success my-3" type="submit" value="Atualizar">
			<a href="./cliente" class="btn btn-danger"> Cancelar </a>
		</form>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>