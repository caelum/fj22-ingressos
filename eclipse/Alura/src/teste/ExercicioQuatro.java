package teste;

public class ExercicioQuatro {
	
	public static void main (String[] args) {
	
		int fatorial = 1;
        for (int n = 1; n <= 10; n++) {

            while (n >= 2){
                fatorial = fatorial * n;
                break;            
            }System.out.println("Fatorial de "+n+" = "+fatorial);
        }
    }
		
	}
	


