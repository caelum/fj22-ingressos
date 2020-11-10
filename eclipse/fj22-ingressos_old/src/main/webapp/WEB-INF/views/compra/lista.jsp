<%--
  Created by IntelliJ IDEA.
  User: nando
  Date: 07/02/17
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ingresso:template>
    <jsp:body>
        <div class=" col-md-6 col-md-offset-3">
            <c:forEach items="${compras}" var="compra">
                <div>
                    <h3>${compra.id}</h3>

                    <table class="table table-hover">
                        <thead>
                            <th>Horario</th>
                            <th>Filme</th>
                            <th>Sala</th>
                            <th>Lugar</th>
                            <th>Tipo de Ingresso</th>
                            <th>Preço</th>
                        </thead>

                        <tbody>
                            <c:forEach items="${compra.ingressos}" var="ingresso">
                                <tr>
                                    <td>${ingresso.sessao.horario}</td>
                                    <td>${ingresso.sessao.filme.nome}</td>
                                    <td>${ingresso.sessao.sala.nome}</td>
                                    <td>${ingresso.lugar}</td>
                                    <td>${ingresso.tipoDeIngresso}</td>
                                    <td>${ingresso.preco}</td>
                                </tr>
                            </c:forEach>
                        </tbody>

                        <tfooter>
                            <tr>
                                <td colspan="5" class="text-right">Total</td>
                                <td>${compra.total}</td>
                            </tr>
                        </tfooter>

                    </table>

                </div>
            </c:forEach>
        </div>
    </jsp:body>
</ingresso:template>