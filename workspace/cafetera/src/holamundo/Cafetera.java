package holamundo;

import java.util.Scanner;
//objeto cafetera
public class Cafetera{
	
	private static int vasos;
	private static float nivel_agua;
	private static float consumibles[][]; //nºcapsulas, agua, temperatura, tiempo
	private static float max_consumibles;
	public static double recuento = 0;

//constructor de cafetera
public Cafetera(int max_vasos, float max_nivel_agua, float numero_maximo_consumibles, float[][] rec){
	
	vasos = max_vasos;
	nivel_agua=max_nivel_agua;
	consumibles=new float[5][4];
	max_consumibles=numero_maximo_consumibles;
	recargaCafeteraInicial(rec); //metodo para cargar datos en la matriz rec 
								 //que luego van a ser los datos por defecto de nuestra
								 //matriz consumibles
	
	
	
	
}
//metodo para recargar consumibles con los datos que tiene la matriz recarga

public void recargaCafeteraInicial(float recarga[][]) {
	
	for(int i=0; i < max_consumibles; i++) {
		for(int j=0; j<4;j++){
			this.consumibles[i][j] = recarga[i][j];
		}
	}
}

//vamos a crear el metodo que introduce los valores por defecto de la matriz recarga 

public static float[][] pruebaRecarga(float m){
	
	float recarga[][] = new float[5][4];
	//capsulas
	for(int i=0; i<5; i++){
		recarga[i][0]= m;//no deberia ser igual al numero max de consumibles
	}
	
	//agua por capsula
	recarga[0][1]=0.15f;
	recarga[1][1]=0.2f;
	recarga[2][1]=0.25f;
	recarga[3][1]=0.3f;
	recarga[4][1]=0.25f;
	
	//temperatura
	recarga[0][2]=80f;
	recarga[1][2]=90f;
	recarga[2][2]=70f;
	recarga[3][2]=90f;
	recarga[4][2]=95f;
	
	//tiempo
	recarga[0][3]=8f;
	recarga[1][3]=9f;
	recarga[2][3]=7f;
	recarga[3][3]=9f;
	recarga[4][3]=9f;
	return recarga;
	
}

//metodo toString
//devuelve una cadena con la informacion de los consumibles

public String toString() {
	String aux = "Vasos " + vasos + " agua " + nivel_agua + "\n";
	
	for(int i=0; i < max_consumibles; i++) {
		aux= aux + "Capsula " + i + " tiene  " + consumibles[i][0] + "\n";
	}
	for(int i=0; i < max_consumibles; i++) {
		aux= aux + "nivel de agua necesario para la capsula es " + i + " es de " + consumibles[i][1] + "\n";
	}
	for(int i=0; i < max_consumibles; i++) {
		aux= aux + "Temperatura de la capsula " + i + " es de " + consumibles[i][2] + "\n";
	}
	for(int i=0; i < max_consumibles; i++) {
		aux= aux + "Tiempo de preparado de la capsula " + i + " es de " + consumibles[i][3] + "\n";
	}
	return aux;
}
//funcion que devuelve los consumubles de la cafetera unicamente
public static String devCafetera() {
String aux = "Vasos " + vasos + " agua " + nivel_agua + "\n";
	
	for(int i=0; i < max_consumibles; i++) {
		aux= aux + "Capsula " + i + " tiene  " + consumibles[i][0] + "\n";
	}
	return aux;
}
//funcion que da el estado de los vasos
public int estadoVasos() {
	return vasos;
}
//funcion metodo que da el estado del agua
public float estadoAgua() {
	return nivel_agua;	
}
//funcion que devuelve el numero de las capsulas
public float estadoCapsula(int capsula) {
	
	return consumibles[capsula][0];
}

//comprobar si hay agua
public static boolean hayAguaCafetito(int cafe) {
	if(nivel_agua >= consumibles[cafe][1]) {
		return true;
	}else
		return false;
}
//comprobar si hay capsulas
public static boolean hayCapsula(int capsula) {
	if(consumibles[capsula][0] > 0) {
		return true;
	}else
		return false;
}
//comprobar si hay vasos
public static boolean hayVasos() {
	if(vasos > 0) {
		return true;
	}else
		return false;
}

//EMPIEZA EL MENU 
//menu inicial
public static int menuInicial() {
	
	System.out.println("Introducir opcion --------------------");
	System.out.println("---------------(1)Visualizar Productos");
	System.out.println("-----------(2)Sacar te/cafe de maquina");	
	System.out.println("----------------(3)Administrar maquina");	
	
	Scanner sc = new Scanner(System.in);
	int opcion = sc.nextInt();

	return opcion;
}
//menu enseñar cafes
public static void menuEnselarCafes() {
	
	System.out.println("ha elegido la opcion 1");
	System.out.println("---------------codigo (1)cafe solo 1.5€");
	System.out.println("---------------codigo (2)cafe manchado 1.1€");
	System.out.println("---------------codigo (3)cafe con leche 1.30€");
	System.out.println("---------------codigo (4)te rojo 1€");
	System.out.println("---------------codigo (5)te verde 1.2€");
	System.out.println("---------------pulse (6)Volver al menu anterior");
	
	Scanner sc = new Scanner(System.in);
	int opcion = sc.nextInt();
	if(opcion == 6) {
		//Cafetera.menuInicial();
		return;
	}else
		Cafetera.menuEnselarCafes();
}
//funcion sacar cafe
public static double sacarCafe() {
	
	System.out.println("ha elegido la opcion 2");
	System.out.println("Introduzca el codigo de la bebida");
	Scanner sc = new Scanner(System.in);
	int eleccion = sc.nextInt();
	//comprobamos si hay consumibles para sacar el cafe si no sacamos mensaje de error
	if(hayAguaCafetito(eleccion) == false) {
		System.out.println("error 1");
	}else if(hayVasos() == false) {
		System.out.println("error 2");
	}else if(hayCapsula(eleccion) == false) {
		System.out.println("error 3");
		//si hay consumibles llamamos a la funcion para coger el dinero
	}else if(Cafetera.comprobarDinero(eleccion) == true) {
	
		System.out.println("Bebida procesandose");
		//devuelve la eleccion luego habra que acumular el dinero con este return
		vasos--;
		//restar 1 en la matriz
		nivel_agua = nivel_agua - consumibles[eleccion][1] ;
		consumibles[eleccion][0] = consumibles[eleccion][0] - 1; 
		//devolvemos el dinero que vale el consumible para sumarlo en el main
		return getPrecio(eleccion);
	}else {
		System.out.println("False");
		System.out.println("Proceso cancelado");
		
	}
	return 0;
}

//funcion para devolver el precio y luego sumarlo
public static double getPrecio(int eleccion) {
	double precio = 0;
	switch(eleccion) {
	case 1:
		precio = 1.50;
		//System.out.println("El precio es de 1.5€");
		break;
	case 2:
		precio = 1.10;
		//System.out.println("El precio es de 1.10€");
		break;
	case 3:
		precio = 1.30;
		//System.out.println("El precio es de 1.30€");
		break;
	case 4:
		precio = 1;
		//System.out.println("El precio es de 1€");
		break;
	case 5:
		precio = 1.2;
		//System.out.println("El precio es de 1.2€");
		break;
	default :
		break;
		
	
	}
	return precio;
	
}
//funcion para recaudar el dinero
public static boolean comprobarDinero(int eleccion) {
	double precio = 0;
	double monedas = 0;
	switch(eleccion) {
	case 1:
		precio = 1.50;
		System.out.println("El precio es de 1.5€");
		break;
	case 2:
		precio = 1.10;
		System.out.println("El precio es de 1.10€");
		break;
	case 3:
		precio = 1.30;
		System.out.println("El precio es de 1.30€");
		break;
	case 4:
		precio = 1;
		System.out.println("El precio es de 1€");
		break;
	case 5:
		precio = 1.2;
		System.out.println("El precio es de 1.2€");
		break;
	default :
		System.out.println("No existe bebida con ese codigo ");
		return false;
	
	}
	//mostramos el menu de las monedas
	System.out.println("Introduzca monedas de 5cnt, 10cnt, 20cnt, 50cnt y 1€");
	System.out.println("---------------(1)0,05cnt");
	System.out.println("---------------(2)0,10cnt");
	System.out.println("---------------(3)0,20cnt");
	System.out.println("---------------(4)0,50cnt");
	System.out.println("---------------(5)1,0€");
	System.out.println("---------------(6)cancelar");
	//controlamos que las monedas son correctas
	while(precio > monedas) {
		System.out.println("Introcuzca el dinero");
		System.out.println("la suma total es de " + monedas);
		Scanner sc = new Scanner(System.in);
		int comprobar = sc.nextInt();
		if(comprobar > 5) {
			return false;
		
		}else {
			switch(comprobar) {
			case 1:
				monedas += 0.05;
				break;
			case 2:
				monedas += 0.10;
				break;
			case 3:
				monedas += 0.20;
				break;
			case 4:
				monedas += 0.5;
				break;
			case 5:
				monedas += 1.0;
				break;
			default:
			}
		}
	}
	
	return true;
}
//para rellenar esto necesito hacer bien la resta de materiales cuando hago un cafe
public static int menuAdministrador() {
	
	System.out.println("Bienvenido administrador");
	System.out.println("-----------------(1)Ver recaudacion diaria");
	System.out.println("-----------------(2)Ver disponibles(vasos, agua y capsulas)");
	System.out.println("-----------------(3)Añadir vasos");
	System.out.println("-----------------(4)Añadir agua");
	System.out.println("-----------------(5)Añadir capsulas");
	System.out.println("-----------------(6)Recoger recaudacion");
	System.out.println("-----------------(7)Salir menu principal");
	System.out.println("-----------------(8)Apagar maquina");
	
	Scanner sc4 = new Scanner(System.in);
	int opcion2 = sc4.nextInt();
	
	switch(opcion2) {
	case 1:
		//muestra dinero total recaudado
		System.out.println(recuento);
		menuAdministrador();
		break;
	case 2:
		//comprobar consumibles
		
		System.out.println(devCafetera());
		menuAdministrador();
		break;
	case 3:
		//añadir vasos
		vasos = 10;
		menuAdministrador();
		break;
	case 4:
		//añadir agua
		nivel_agua = 5;
		menuAdministrador();
		break;
	case 5:
		//añadir capsulas
		for(int i=0; i<5; i++){
			consumibles[i][0]= max_consumibles;//no deberia ser igual al numero max de consumibles
		}
		menuAdministrador();
		break;
	case 6:
		//poner la variable que recauda a 0
		recuento = 0;
		menuAdministrador();
		break;
	case 7:
		//volver al menu inicial
		//Cafetera.menuInicial();
		break;
	case 8:
		//apagar maquina
		return 123456789;
	default:
		System.out.println("opcion invalida");
		Cafetera.menuAdministrador();
	}
	return 0;
}



}//fin clase