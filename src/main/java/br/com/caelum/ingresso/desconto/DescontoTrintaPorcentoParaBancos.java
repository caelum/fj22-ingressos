package br.com.caelum.ingresso.desconto;

import java.math.BigDecimal;

public class DescontoTrintaPorcentoParaBancos implements Desconto {

	private BigDecimal percentualDeDesconto = new BigDecimal("0.3");

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
	}

	private BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(percentualDeDesconto);
	}

}
