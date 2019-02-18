package Ejercicio1;

import java.util.Scanner;

public class Gui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaBancaria Cuenta1 = new CuentaBancaria("Antonio", 1000, 00001);
		int apagar = 1;
		
		do {
			
		System.out.println("Pulsa 1 para ver el estado de la cuenta");
		System.out.println("Pulsa 2 para ingresar dinero");
		System.out.println("Pulsa 3 para retirar dinero");
		System.out.println("Pulsa 4 para salir");
		
		Scanner sc =  new Scanner(System.in);
		int seleccion = sc.nextInt();
		
		
		switch (seleccion) {
		case 1:
			System.out.println(Cuenta1.toString());
			break;
		case 2:		
			Cuenta1.ingresarCantidad();
			break;
		case 3:
			Cuenta1.sacarCantidad();
			break;
		case 4:
			apagar = 0;
			break;
		default:
			System.out.println("Introduce un valor correcto");
			break;
		}
		
		}while(apagar != 0);
		
		
		
	
	}

}
