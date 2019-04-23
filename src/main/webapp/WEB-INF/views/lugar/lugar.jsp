<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ingresso:template>
	<jsp:body>
		<div class=" col-md-6 col-md-offset-3">
		<form action="/admin/lugar" method="post">
			<input type="hidden" name="salaId" value="${lugarDto.salaId}">

			<div class="form-group">
	            <label for="fileira">Fileira:</label>
	            <input id="fileira" type="text" name="fileira" class="form-control" value="${lugarDto.fileira}">
        	</div>
			<div class="form-group">
	            <label for="posicao">Posicao:</label>
	            <input id="posicao" type="text" name="posicao" class="form-control" value="${lugarDto.posicao}">
        	</div>


			<div class="form-group">
         		<button type="submit" class="btn btn-primary">Gravar</button>
			</div>
		</form>
		</div>

	</jsp:body>

</ingresso:template>