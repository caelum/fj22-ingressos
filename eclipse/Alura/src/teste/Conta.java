package teste;

public class Conta {
	private String titular;
	
	public String getTitular() {
		return this.titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	int numero;
	String agencia;
	double saldo;
	String dataDeAbertura;
	
	/*
	 Regras para métodos (ações ou operações)
	 * Todo método precisar ter uma lista de parâmetros representada por ()
	 * Todo método tem um retorno:
	 * um dado (String ou double ou qq outro dado)
	 * quando o retorno for um valor precisamos da palavra "return"
	 *  ação vazia ----> void
	 *  No cabeçalho do método precisamos colocar o tipo de retorno q nos será dado pelo método
	"this" é uma palavra reservada que representa o "objeto da vez"
	
	 */
	
	
	 void saca(double valor) {           
	 
	 }
	
	  void deposita(double valor) {
		  saldo += valor;
	 }
	  
	 double calculaRendimento() { 
		 return saldo * 0.1;
	 }

	 String recuperaDadosParaImpressao(){
		String dados = "Titular: " + this.titular;
		dados += "/nNúmero: " + this.numero;
		return dados;
		 
	 }
}
	
	
	
	
	
