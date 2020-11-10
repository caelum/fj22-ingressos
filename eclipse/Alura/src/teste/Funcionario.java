package teste;

public class Funcionario {
	
	private String nome; // private restringe o acesso
	private double salario; // variável de instância
	private double comissao; // variável de instância
	static private double premio; // variável de CLASSE; static é um modificador
	
	
	void setComissao(){   // método de instância que serve para acessar a comissão
		this.comissao += comissao;
	}
	
	static double getPremio(){    // método de CLASSE que serve para acessar a comissão
		return Funcionario.premio;
	}
	
	static void setPremio(){   // método de CLASSE que serve para acessar a comissão
		Funcionario.premio += premio;
	}
	
	double getComissao(){    // método de instância que serve para acessar a comissão
		return this.comissao;
	}
	
	
	Funcionario(String nome){ // primeira versão regras de Construtor: tem o MESMO nome da classe; tem lista de parâmetros; 
		this.nome = nome;
		
	}
	
	Funcionario (){ // segunda versão
		
	}
	
	 String pegaNome(){
		return this.nome;
	}
	 

		Funcionario(String nome, double salario){ // terceira versão
			this.nome = nome;
			this.guardaSalario(salario);
			//this.salario = salario;
		}
	 
	 
	 
	 
	 void guardaNome(String nome){ // sombreamento de tipos
		 this.nome = nome; // neste caso o uso do this é obrigatório
	 }
	 
	
	
	double pegaSalario (){
		return this.salario;
	}
	
	
	void guardaSalario(double valor){
		
		if (valor >= 1500) {	
			this.salario = valor;
			
		}else {
		this.salario = valor;
		
		
	}
		}
}




//Pilares da POO ---- > Encapsulamento: atributo privado e métodos acessores;
// Convenção Internacional em relação aos nomes dos métodos acessores;
// Overloaad ou Sobrecarga de Construtores: técnica onde existe várias versões;






