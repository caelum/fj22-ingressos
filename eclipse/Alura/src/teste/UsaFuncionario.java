package teste;

public class UsaFuncionario {
	
	public static void main (String[] args) {
		
		Funcionario f = new Funcionario();
		
		f.guardaNome("Ana");
		f.guardaSalario(500);
		f.setComissao(1000);
		Funcionario.setPremio(300);
		
	
		
		System.out.println(Funcionario.getPremio());
				
	}

}