<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.filme']}"/>

        <form action='/admin/filme' method="post">
            <input type="hidden" name="id" value="${filme.id}">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" class="form-control" value="${filme.nome}">
                <c:forEach items="${bindingResult.getFieldErrors('nome')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="genero">Genero:</label>
                <input id="genero" type="text" name="genero" class="form-control" value="${filme.genero}">
                <c:forEach items="${bindingResult.getFieldErrors('genero')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="duracao">Duracao:</label>
                <input id="duracao" type="text" name="duracao" class="form-control"
                       value="${filme.duracao.toMinutes()}">
                <c:forEach items="${bindingResult.getFieldErrors('duracao')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>
		
		
			<div class="form-group">
				<label for="preco">Preço:</label>
				<input id="preco" type="text" name="preco" class="form-control" value="${filme.preco}">
				<c:forEach items="${bindingResult.getFieldErrors('preco')}" var="error"> 
					<span class="text-danger">${error.defaultMessage}</span>
				</c:forEach>
			</div>

            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>
