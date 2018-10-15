<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <table class="table table-hover ">
            <thead>
            <tr>
                <th class="text-center">Nome</th>
	       <th class="text-center">Preço</th>	 
                <th colspan="4" class="text-center">Ações</th>
            </thead>
            <tbody>
            <c:forEach var="sala" items="${salas}">
                <tr>
                    <td class="text-center">${sala.nome}</td>
		   <td class="text-center">${sala.preco}</td>
                    <td class="col-md-1">
                        <a href="/admin/sala/${sala.id}/sessoes/" class="btn btn-primary">
                            <span class="glyphicon glyphicon-blackboard" aria-hidden="true"></span> Sessões
                        </a>
                    </td>
                    <td class="col-md-1">
                        <a href="/admin//sala/${sala.id}/lugares/" class="btn btn-warning">
                            <span class="glyphicon glyphicon-th" aria-hidden="true"></span> Lugares
                        </a>
                    </td>
                    <td>
                        <a onclick="excluir(${sala.id})" class="btn btn-danger">Excluir</a>
                    </td>
                    <td>
                        <a href="/admin/sala/${sala.id}" class="btn btn-info">Alterar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3">
            <a href="/admin/sala" class="btn btn-block btn-info">Novo</a>
        </div>
		</div>
        <script>
            function excluir(id) {
                var url = window.location.href;
                $.ajax({
                    url: "/admin/sala/" + id,
                    type: 'DELETE',
                    success: function (result) {
                        console.log(result);

                        window.location.href = url;
                    }
                });
            }
        </script>
    </jsp:body>
</ingresso:template>
