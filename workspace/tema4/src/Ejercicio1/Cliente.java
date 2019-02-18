package Ejercicio1;

import java.util.Random;

public class Cliente {

	private String nombre;
	private char sexo;
	private String dni = "";
	int edad;
	float peso;
	float altura;

	public Cliente(String nombre, char sexo, int edad, float peso, float altura) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.dni = generaDNI();
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
	}

	public Cliente(String nombre, char sexo, int edad) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.dni = generaDNI();
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public static int calcularIMC(float peso, float altura) {
		
		float IMC = peso/(altura * altura);
		if(IMC < 20) {
			return -1;
		}else if(IMC >= 20 && IMC <= 25) {
			return 0;
		}else {
			return 1;
		}
			
	}
	
	public static boolean esMayorDeEdad(int edad) {
		
		if (edad >= 18)
			return true;
		else
			return false;
	}
	
	public static boolean comprobarSexo(char sexo) {
		
		if(sexo == 'h' || sexo == 'm')
			return true;
		else 
			return false;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", sexo=" + sexo + ", dni=" + dni + ", edad=" + edad + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	public String generaDNI() {
		
		Random numero = new Random();
		for (int i = 0; i < 8; i++) {
			dni = dni + numero.nextInt(9);
		}
		
		
		String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
	    int dniInt = Integer.parseInt(dni);
		int modulo= dniInt % 23;
	    char letra = juegoCaracteres.charAt(modulo);
	    dni = dni + letra;
		return dni;
	} 
}

