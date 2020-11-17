package teste;

public class Compra {
	public static void main (String[] args) {
		double valorCompra = 2000;
		double valorPagto = valorCompra;
		int quantidade = 3;
		
		if (valorCompra > 1000 && quantidade > 3) {
			valorPagto = valorCompra * 0.90;
		}else if (valorCompra > 500) {
		valorPagto = valorCompra * 0.95;		
				}
				
		
		System.out.println("Valor a pagar:" + valorPagto);
		
		
	}

}

/*
13/10

Erros de Compilação -----> javac NomeDaClasse.java
Erros de Execução   -----> java NomeDaClasse
Erros de Lógica    ------> o usuário final



Cenários:

1. Compras com valor acima de 1.000,00 e quantidade acima de 3 terão 10% de desconto
2. Caso a compra seja superior a R$ 500,00, dar desconto de 5%




*/