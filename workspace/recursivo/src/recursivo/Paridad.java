package recursivo;

public class Paridad {

		public static boolean Impar(int numero) {
			if(numero % 2 == 0) {
				return false;	
			}else {
				return Par(numero - 1);
			}
		}
		
		public static boolean Par(int numero) {
			if(numero % 2 == 0) {
				return true;
			}else {
				return Impar(numero - 1);
			}
			
		}
}

