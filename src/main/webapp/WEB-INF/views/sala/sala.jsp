<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.sala']}"/>

        <form action='/admin/sala' method="post">
            <div class="form-group">
                <input type="hidden" name="id" value="${sala.id}">

                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" class="form-control" value="${sala.nome}">

                <c:forEach items="${bindingResult.getFieldErrors('nome')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>

            </div>

         
<!--              <div class="form-group"> -->
<!--                 <label for="preco">Preço:</label> -->
<!--                 <input id="preco" type="text" name="preco" -->
<%-- 						class="form-control" value="${sala.preco}" /> --%>
<%--                 <c:forEach items="${bindingResult.getFieldErrors('preco')}" var="error"> --%>
<%-- 					<span class="text-danger">${error.defaultMessage}</span> --%>
<%-- 				</c:forEach> --%>
<!--             </div> -->
            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>
