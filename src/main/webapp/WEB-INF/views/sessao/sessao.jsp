<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.sessaoForm']}"/>

        <h3>Nova sessão para sala: ${sala.nome}</h3>

        <form action='/admin/sessao' method="post">
            <input type="hidden" name="id" value="${form.id}">
            <input type="hidden" name="salaId" value="${form.salaId}">

            <div class="form-group">
                <label for="horario">Horario:</label>
                <input id="horario" type="text" name="horario" class="form-control" value="${form.horario}">
                <c:forEach items="${bindingResult.getFieldErrors('horario')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>

            </div>

            <div class="form-group">
                <label for="filme">Filme:</label>
                <select id="filme" name="filmeId" class="form-control">
                    <option value="">Selecione um Filme</option>
                    <c:forEach var="filme" items="${filmes}">
                        <option value="${filme.id}" ${filme.id.equals(form.filmeId)? "selected": ""}>${filme.nome}</option>
                    </c:forEach>
                </select>
                <c:forEach items="${bindingResult.getFieldErrors('filmeId')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>


            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>