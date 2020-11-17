package teste;

public class BalacoTrimestral {
	
	public static void main(String[] args) {
		int gastosJaneiro = 1500;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		int mediaMensal = gastosTrimestre / 3;
		
		System.out.println (gastosTrimestre);
		System.out.println (mediaMensal);
		
	}
}
