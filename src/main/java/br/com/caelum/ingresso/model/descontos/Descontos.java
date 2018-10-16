package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public interface Descontos {
	BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);
}
