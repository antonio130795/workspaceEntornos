package recursivo;
/**
 * @author Antonio Jiménez Arias
 *
 *
 */

import java.util.Scanner;

public class Factoriales {
	
	Scanner teclado = null;
	
	public Factoriales() {
		
		teclado = new Scanner(System.in);
	}
	
	public int dameEntero() {return teclado.nextInt();}
	
	public int factorialRec(int numero) {
		
		if(numero <= 1) {
			return 1;
		}else {
			return numero*factorialRec(numero-1);
		}
	}
	//se le pasa a la funcion el numero que introduces
	//en el bucle while se controla el calculo del factorial
	//devuelve el resultado 
	public int factorial(int numero){
		int resultado = 1;
		while(numero > 0) {
			resultado = resultado*numero;
			numero--;
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		
		int valor;
		Factoriales fact;
		fact = new Factoriales();
		System.out.println("Dame un numero entero positivo");
		valor = fact.dameEntero();
		System.out.println("El factorial de "+ valor+" es " + fact.factorial(valor));
		System.out.println("El factorial de "+ valor+" es " + fact.factorialRec(valor));
		System.out.println("llamar par " + Paridad.Par(5));
		System.out.println("llamar impar " + Paridad.Impar(5));
	}
	
	
}