<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Destino" import="java.util.List"%>
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


<title>JN Tour | Destino</title>

</head>
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
	<h2 class="text-center pt-4">ATUALIZAÇÃO - DESTINO</h2>
	<form action="./destino-update" class="m-5">
		<div class="form-floating mb-3">
			<input type="number" name="id" class="form-control" placeholder="id"
				value="<%=request.getAttribute("id")%>" readonly> <label>ID</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" name="pais" class="form-control"
				placeholder="nome" value="<%=request.getAttribute("pais")%>"
				required> <label for="floatingInput">País</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" name="cidade" class="form-control"
				placeholder="cpf" value="<%=request.getAttribute("cidade")%>"
				required> <label>Cidade</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" name="dataIda" pattern="\d{2}\/\d{2}/\d{4}"
				title="Digite uma data no formato: xx/xx/xxxx" class="form-control"
				placeholder="data de ida"
				value="<%=request.getAttribute("dataIda")%>" required> <label>Data
				de ida</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" name="dataVolta" pattern="\d{2}\/\d{2}/\d{4}"
				title="Digite uma data no formato: xx/xx/xxxx" class="form-control"
				placeholder="data de volta"
				value="<%=request.getAttribute("dataVolta")%>" required> <label>Data
				de volta</label>
		</div>
		<div class="form-floating mb-3">
			<input type="number" name="preco" class="form-control"
				placeholder="preco" value="<%=request.getAttribute("preco")%>"
				required> <label for="floatingInput">Preço</label>

		</div>

		<input class="btn btn-success my-3" type="submit" value="Atualizar">
		<a href="./destino" class="btn btn-danger"> Cancelar </a>
	</form>
</main>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<body>
</html>