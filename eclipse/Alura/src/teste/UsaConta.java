package teste;

public class UsaConta {
	
	public static void main (String[] args) {
		Conta c = new Conta ();
		Conta c1 = new Conta();
		
		c.setTitular("Zé");
		c.numero = 1125;
		c.agencia = "38";
		c.saldo = 4000;
		
		System.out.println(c.getTitular() + " - " + c.saldo);
		
		
		System.out.println (c1.getTitular() + " - " + c1.saldo);
		
		System.out.println(c1);
		System.out.println(c);
	}

}
