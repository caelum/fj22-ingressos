package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public interface Desconto {
	
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);

}
