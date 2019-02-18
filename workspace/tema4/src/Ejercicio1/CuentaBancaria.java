package Ejercicio1;

import java.util.Scanner;

public class CuentaBancaria {
	
	private String titular;
	private double cantidad;
	private int numeroCuenta;
	Scanner sc =  new Scanner(System.in);
	
//constructor
public CuentaBancaria(String titular, double cantidad, int numeroCuenta) {
	
	this.titular = titular;
	this.cantidad = cantidad;
	this.numeroCuenta = numeroCuenta;
}
	
public String getTitular() {
	return titular;
}

public int getNumeroCuenta() {
	return numeroCuenta;
}

public void setTitular(String titular) {
	this.titular = titular;
}

public void setNumeroCuenta(int numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
}

	//metodo para introducir dinero en la cuenta
	public void ingresarCantidad() {
		
		System.out.println("Introduce la cantidad a ingresar");
		//Scanner sc = new Scanner(System.in);
		double dinero = sc.nextDouble();
		if(dinero > 0) {
			cantidad += dinero;
		}else
			System.out.println("La cantidad de dinero no puede ser negativa");
		//sc.close();
	}
	//metodo para sacar dinero de la cuenta
	public void sacarCantidad() {
		
		System.out.println("introduce la canidad de dinero a retirar");
		//Scanner sc = new Scanner(System.in);
		double dinero = sc.nextDouble();
		if(dinero > 0) {
			cantidad -=dinero;
		}else
			System.out.println("la cantidad de dinero debe ser positiva");
	}
	
	public String toString() {
		
		return titular + " cantidad de dinero en la cuenta " + cantidad + " En la cuenta " + numeroCuenta;
	}
}
