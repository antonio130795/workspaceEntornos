package Ejercicio1;

import java.util.Scanner;


public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre");
		String nombre = sc.next();
		System.out.println("Introduce edad");
		int edad = sc.nextInt();
		System.out.println("Introduce sexo h o m");
		char sexo = sc.next().charAt(0);
		System.out.println("Introduce peso");
		float peso = sc.nextFloat();
		System.out.println("introduce altura");
		float altura = sc.nextFloat();
		
		
		Cliente cliente1 = new Cliente(nombre,sexo, edad, peso, altura);
		System.out.println(cliente1.esMayorDeEdad(edad));
		System.out.println(cliente1.calcularIMC(peso, altura));
		System.out.println(cliente1);
		if(cliente1.comprobarSexo(sexo) == true) {
			if(sexo == 'h') {
				System.out.println("Es Hombre");
			}else if(sexo == 'm') {
				System.out.println("Es Mujer");
			
		}else
			System.out.println("Es Hombre");
			
		Cliente cliente2 = new Cliente("Antonio",'m', 23);
		System.out.println(cliente2);
		
	}
	}
}
