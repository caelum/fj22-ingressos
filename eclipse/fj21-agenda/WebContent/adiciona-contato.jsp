<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib	tagdir="/WEB-INF/tags" prefix="caelum"	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contatos</title>

<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<form action="adicionaContato">
		Nome: <input type="text" name="nome" /><br /> <br /> 
		E-mail: <input type="text" name="email" /><br /> <br /> 
		Endereço: <input type="text" name="endereco" /><br /> <br /> 
		Data	Nascimento:	<caelum:campoData	id="dataNascimento"	/><br	/> 
		<br	/>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>