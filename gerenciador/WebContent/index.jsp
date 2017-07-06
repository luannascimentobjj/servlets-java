<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<c:if test="${usuarioLogado}">
	Logado como ${usuarioLogado.email}<br />
	</c:if>
	<form action="novaEmpresa" method="POST">
		Nome: <input type="text" name="nome"> <input type="submit"
			value="Enviar">
	</form>
	<form action="login" method="POST">
		Email: <input type="email" name="email"> Senha: <input
			type="password" name="senha"> <input type="submit"
			value="Enviar">
	</form>
	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="Logout>
		<input type="submit" value="Deslogar">

	</form>
</body>
</html>