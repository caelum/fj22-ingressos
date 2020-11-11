<%--
  Created by IntelliJ IDEA.
  User: nando
  Date: 20/01/17
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>


        <div class=" col-md-6 col-md-offset-3">
            <c:if test="${not empty msg}">
                <div class="alert alert-info">
                        ${msg}
                </div>
            </c:if>

            <c:if test="${param.error != null}">

                <div class="alert alert-danger">
                    Login ou senha inválidos
                </div>
            </c:if>
            <form action="/login" method="post">
                <span class="text-danger">${param.error}</span>

                <div class="form-group">
                    <label for="login">E-mail:</label>
                    <input id="login" type="text" name="email" class="form-control">
                </div>

                <div class="form-group">
                    <label for="password">Senha:</label>
                    <input id="password" type="password" name="password" class="form-control">
                </div>

                <button class="btn btn-primary" type="submit">Entrar</button>

                <a href="/usuario">ou cadastrar-se</a>
            </form>
        </div>
    </jsp:body>
</ingresso:template>
