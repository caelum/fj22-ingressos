<%--
  Created by IntelliJ IDEA.
  User: nando
  Date: 20/01/17
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
	<jsp:attribute name="compra_css">
		<link rel="stylesheet" href="/assets/css/compra.css" />
    </jsp:attribute>
    <jsp:body>
    	<div class="container-compra">
    	
		<div class="sidenav">
			<div class="elementsNav">
		        <h1>${sessao.filme.nome}</h1>	
		        <h2>${sessao.sala.nome}</h2>
		        <h3>${sessao.horario}</h3>
			<img class="capa" src="${imagemCapa.url}"/>
			</div>
		</div>
		<div class="main">
			<h2>Lugares</h2>
			<table class="table-compra" id="lugares">
				<tbody>
					<c:forEach var="map" items="${sessao.mapaDeLugares}">
						<tr class="fileira">
							<td class="fileira-valor">${map.key}</td>
							<td class="fileira-assentos">
							<table>
								<tr>
								<c:forEach var="lugar" items="${map.value}">
									<td class="fileira-assento"><figure>
										<svg class="assento disponivel" id="${lugar.id}"  version="1.0" id="SEAT" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
												 viewBox="0 0 318.224 305.246" enable-background="new 0 0 318.224 305.246" xml:space="preserve">
											<g id="FILL">
												<path d="M269.395,132.246h-15.02V51.414c0-11.758-9.492-21.248-21.248-21.248H85.097
													c-11.757,0-21.248,9.49-21.248,21.248v80.833H48.827c-8.535,0-15.127,7.505-14.024,15.971l11.406,87.625
													c0.462,3.538,3.476,6.187,7.045,6.187h17.958l4.629,21.843c1.385,6.536,7.155,11.209,13.833,11.209h138.845
													c6.68,0,12.448-4.672,13.833-11.209l4.648-21.933l0.009,0.09h17.959c3.569,0,6.585-2.649,7.045-6.187l11.407-87.625
													C284.522,139.751,277.931,132.246,269.395,132.246z"/>
											</g>
											<path id="STROKE" fill="#4F4F4F" d="M290.664,127.709c-5.374-6.118-13.126-9.628-21.269-9.628h-0.854V51.414
												c0-19.526-15.886-35.414-35.414-35.414H85.097c-19.528,0-35.414,15.888-35.414,35.414v66.667h-0.856
												c-8.144,0-15.896,3.51-21.271,9.628c-5.374,6.121-7.852,14.262-6.799,22.338l11.406,87.625
												c1.378,10.562,10.444,18.523,21.091,18.523h6.479l2.25,10.614c2.755,13,14.401,22.438,27.691,22.438h138.845
												c13.291,0,24.937-9.438,27.691-22.438l2.25-10.614h6.509c10.652,0,19.72-7.965,21.093-18.527l11.406-87.621
												C298.518,141.968,296.039,133.827,290.664,127.709z M266.746,235.147c-0.111,0.899-0.878,1.57-1.778,1.57h-11.43l2.404-11.337
												c1.224-5.769-0.208-11.703-3.922-16.289c-0.737-0.91-1.594-1.681-2.462-2.428V139.35c0-0.989,0.802-1.791,1.791-1.791h18.046
												c2.58,0,4.932,1.065,6.633,3.002c1.702,1.937,2.455,4.413,2.123,6.972L266.746,235.147z M66.873,137.558
												c0.989,0,1.791,0.802,1.791,1.791v67.286c-0.878,0.754-1.745,1.536-2.49,2.455c-3.714,4.586-5.146,10.52-3.922,16.289l2.404,11.337
												H53.254c-0.899,0-1.66-0.671-1.771-1.563l-11.413-87.621c-0.332-2.559,0.422-5.035,2.123-6.972s4.053-3.002,6.633-3.002H66.873z
												 M249.088,127.162c-5.767,1.069-10.154,6.114-10.154,12.187v62.766c-0.674-0.069-1.331-0.225-2.02-0.225H81.281
												c-0.678,0-1.326,0.152-1.992,0.221V139.35c0-6.056-4.361-11.094-10.105-12.18V51.431c0-8.784,7.152-15.936,15.936-15.936h148.032
												c8.784,0,15.936,7.152,15.936,15.936V127.162z M81.039,262.772l-8.397-39.591c-0.553-2.621,0.097-5.319,1.785-7.394
												c1.681-2.082,4.185-3.272,6.854-3.272h155.634c2.67,0,5.174,1.19,6.854,3.272c1.688,2.075,2.338,4.773,1.785,7.394l-8.397,39.591
											c-0.858,4.053-4.496,7-8.639,7H89.678C85.534,269.772,81.896,266.825,81.039,262.772z"/>
										</svg>
										<input type="checkbox" value="${lugar.id}" >
									    <figcaption>${lugar.posicao}</figcaption>
									</figure></td>
								</c:forEach>
								</tr>
							</table>
							<td>
						</tr>
					</c:forEach>
					<tr class="telao">
						<td id="tela">Tela</td>
					</tr>
					<tr class="legenda legenda-menu">
						<td>Legenda</td>
					</tr>
					<tr>
						<td class="legenda disponivel">
							<span class="circulo circulo-disponivel"></span>
							Disponível
						</td>
					</tr>
					<tr>
						<td class="legenda escolhido">
							<span class="circulo circulo-escolhido"></span>
							Selecionado
						</td>
					</tr>
					<tr>
						<td class="legenda ocupado">
							<span class="circulo circulo-ocupado"></span>
							Indisponível
						</td>
					</tr>
				</tbody>
			</table>
			<div class="tipoIngresso">
	        <form action="/compra/ingressos" method="post">
	            <table class="table table-hover" id="tabela-ingressos">
	                <thead>
	                    <th>Sala</th>
	                    <th>Filme</th>
	                    <th>Horario</th>
	                    <th>Lugar</th>
	                    <th>Tipo de Ingresso</th>
	                </thead>
	                <tbody>
	
	                </tbody>
	            </table>
	
	            <button type="submit" class="btn btn-primary finaliza">Finalizar Compra</button>
	        </form>
			</div>
		</div>
		</div>

        <script>

            function changeCheckbox(img) {
                var checkbox = $(img).next()[0];
                console.log(checkbox);
                console.log(checkbox.value);
            	var salaId = ${sessao.sala.id};
                var sessaoId = ${sessao.id};
                var lugarNome = img.id;
                var linhaId = "linha_" + salaId + "_" + sessaoId + "_" + lugarNome;

                console.log(linhaId);

                var tbody = document.querySelector("#tabela-ingressos>tbody");
                if (!checkbox.checked){

                    var index = tbody.rows.length;

                    var inputSessaoId = makeInputHiddenBy('ingressos['+index+'].sessao.id', sessaoId);
                    var inputLugarId = makeInputHiddenBy('ingressos['+index+'].lugar.id', checkbox.value);

                    var row =  tbody.insertRow(index);
                    row.setAttribute('id', linhaId);

                    var cellSala = row.insertCell(0);
                    var sala = document.createTextNode('${sessao.sala.nome}');
                    cellSala.appendChild(sala);

                    var cellFilme = row.insertCell(1);
                    var filme = document.createTextNode('${sessao.filme.nome}');
                    cellFilme.appendChild(filme);

                    var cellHorario = row.insertCell(2);
                    var horario = document.createTextNode('${sessao.horario}');
                    cellHorario.appendChild(horario);

                    var cellLugar = row.insertCell(3);
                    var lugar = document.createTextNode(lugarNome);
                    cellLugar.appendChild(lugar);

                    var cellTipo = row.insertCell(4);
                    var selectTipo = document.createElement('select');
                    selectTipo.setAttribute('name', 'ingressos['+index+'].tipoDeIngresso');
                    selectTipo.setAttribute('class', 'form-control input-sm');

                <c:forEach items="${tiposDeIngressos}" var="tipo" varStatus="status">
                    var option_${status.index} = document.createElement('option');
                    var text_${status.index} = document.createTextNode('${tipo.descricao}');

                    option_${status.index}.setAttribute('value', '${tipo}');
                    option_${status.index}.appendChild(text_${status.index});

                    selectTipo.appendChild(option_${status.index});
                </c:forEach>

                    cellTipo.appendChild(selectTipo);

                    row.appendChild(inputSessaoId);
                    row.appendChild(inputLugarId);
					
                    checkbox.checked = true;
					img.classList.add("escolhido");
					img.classList.remove("disponivel");
                }else{
                    var row  = document.querySelector("#"+linhaId);

                    checkbox.checked = false;
					img.classList.remove("escolhido");
					img.classList.add("disponivel");

                    console.log(row);
                    tbody.removeChild(row);
                }

            }

            function makeInputHiddenBy(name, value) {
                var input = document.createElement('input');
                input.setAttribute('type', 'hidden');
                input.setAttribute('name', name);
                input.setAttribute('value', value);

                return input;
            }

        </script>

    </jsp:body>


</ingresso:template>
