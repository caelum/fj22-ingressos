<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>
   		<div class=" col-md-6 col-md-offset-3">
        <form action="/compra/comprar" method="post">
            <table class="table table-hover ">
                <thead>
                <th>Sala</th>
                <th>Lugar</th>
                <th>Filme</th>
                <th>Horario</th>
                <th>Tipo do Ingresso</th>
                <th>Preço</th>
                </thead>

                <tbody>
                <c:forEach items="${carrinho.ingressos}" var="ingresso" varStatus="status">

                    <input type="hidden" name="ingressos[${status.index}].sessao.id" value="${ingresso.sessao.id}">
                    <input type="hidden" name="ingressos[${status.index}].lugar.id" value="${ingresso.lugar.id}">
                    <input type="hidden" name="ingressos[${status.index}].tipoDeIngresso" value="${ingresso.tipoDeIngresso}">
                    <tr>
                        <td>${ingresso.sessao.sala.nome}</td>
                        <td>${ingresso.lugar.fileira}${ingresso.lugar.posicao}</td>
                        <td>${ingresso.sessao.filme.nome }</td>
                        <td>${ingresso.sessao.horario}</td>
                        <td>${ingresso.tipoDeIngresso.descricao}</td>
                        <td>${ingresso.preco}</td>
                    </tr>
                </c:forEach>
                </tbody>

                <tfoot>
                <td colspan="5" class="text-right"><strong>TOTAL</strong></td>
                <td><strong>${carrinho.total}</strong></td>
                </tfoot>

            </table>

            <div class="form-group">
                <div class="col-md-6">
                    <label for="nome">Nome:</label>
                    <input id="nome" type="text" name="nome" class="form-control">
                </div>

                <div class="col-md-6">
                    <label for="sobrenome">Sobrenome:</label>
                    <input id="sobrenome" type="text" name="sobrenome" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-6">
                    <label for="cpf">CPF:</label>
                    <input id="cpf" type="text" name="cpf" class="form-control">
                </div>
            </div>


            <div class="form-group">
                <div class="col-md-8">
                    <label for="cartaoDeCredito">Cartão de Crédito:</label>
                    <input id="cartaoDeCredito" type="text" name="cartaoDeCredito" class="form-control">
                </div>

                <div class="col-md-4">
                    <label for="cvv">CVV:</label>
                    <input id="cvv" type="text" name="cvv" class="form-control">
                </div>
            </div>


            <div class="form-group">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary">Comprar</button>
                </div>
            </div>

        </form>
		</div>
    </jsp:body>
</ingresso:template>