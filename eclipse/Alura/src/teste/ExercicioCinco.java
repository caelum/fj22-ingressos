package teste;

public class ExercicioCinco {
		
		public static void main (String[] args) {
		
			long fatorial = 1;
	        for (long n = 1; n <= 40; n++) {

	            while (n >= 2){
	                fatorial = fatorial * n;
	                break;            
	            }System.out.println("Fatorial de "+n+" = "+fatorial);
	        }
	    }
			
		}
