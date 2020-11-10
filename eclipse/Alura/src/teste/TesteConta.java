package teste;

public class TesteConta {
	public static void main (String[] args) {
		Conta c1 = new Conta();
		
		c1.titular = "Hugo";
		c1.numero = 123;
		c1.agencia = "45678-9";
		c1.saldo = 50.0;
		c1.dataDeAbertura = "04/06/2015";
		
		Conta c2 = new Conta();
		c2.titular = "Danilo";
		c2.saldo = 100;
		
		if (c1 == c2) {
			
		}
		
		
		c1.deposita (100.0); 
		System.out.println("saldo atual: " + c1.saldo);
		System.out.println ("rendimento mensal: " +c1.calculaRendimento());
		
		
	}
}
