package holamundo;

import java.util.Scanner;

public class Gui {

	public static void main(String[] args) {
	//crear objeto cafetera
	Cafetera cafetera = new Cafetera(10,5,5,Cafetera.pruebaRecarga(4));
	//iniciamos la variable que controla la repeticion del menu 
	int apagar = 0;
	//bucle que controla el menu
	do {
	//llamamos al menu inicial y recogemos la opcion seleccionada
	int opcion = Cafetera.menuInicial();
	//bucle que usa la opcion recogida para la siguiente pantalla	
	switch(opcion) {
	case 1:
		//llama al procedimiento que enseña los cafes y las opciones
		Cafetera.menuEnselarCafes();
		
		break;
	
	case 2:
		//llamamos a sacar cafe y en la variable dinero metemos el precio de la bebida extraida
		double dinero = Cafetera.sacarCafe();
		//sumamos a la variable recuento del objeto cafetera el dinero para llevar un contador
		cafetera.recuento += dinero; 
		break;
	case 3:
		//entrada al menu administrador
		System.out.println("Bienvenido al modo administrador");
		//comprobamos si sabe el usuario y la contraseña para entrar al modo administrador
		System.out.println("Introducir usuario");
		Scanner sc2 = new Scanner(System.in);
		String Usuario = sc2.nextLine();
		//si sabe el usuario y la contraseña se llama al menu de administrador
		if(Usuario.equals("pepe")) {
			System.out.println("Introducir contraseña");
			Scanner sc3 = new Scanner(System.in);
			String pass = sc3.nextLine();
				if(pass.equals("1234")) {
					
					//llamada menu administrador 
					apagar = Cafetera.menuAdministrador();
					System.out.println(apagar);
				}else {
					//si no sabe o el usuario o la contraseña vuelve al menu inicial
					System.out.println("Contraseña incorrecta");
					Cafetera.menuInicial();
				}
		}else {
			System.out.println("Usuario incorrecto");
			Cafetera.menuInicial();
		}
		break;
	default:
		//si introduce un valor que no esta en el menu 
		System.out.println("Introduce un valor comprendido entre 1 y 3");
		Cafetera.menuInicial();
	}
	
	}while(apagar != 123456789);
	
	


	
	
		
		
	}
	
}
