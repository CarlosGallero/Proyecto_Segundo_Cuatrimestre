package fp.funciones.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.funciones.Funciones;

public class TestFunciones {

	public static void testPrimo() {
		System.out.println("Probando el método primo:");
		System.out.println(Funciones.primo(7));
		System.out.println(Funciones.primo(4));
		System.out.println();
	}

	public static void testCombinatorio() {
		System.out.println("Probando el método combinatorio:");
		System.out.println(Funciones.combinatorio(5, 2));
		System.out.println(Funciones.combinatorio(4, 4));
		System.out.println();
	}

	public static void testS() {
		System.out.println("Probando el método S:");
		System.out.println(Funciones.S(3, 2));
		System.out.println(Funciones.S(4, 3));
		System.out.println();
	}

	public static void testCalcularDiferencias() {
		System.out.println("Probando el método calcularDiferencias:");
		List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 2, 3, 4, 5, 1));
		System.out.println(Funciones.calcularDiferencias(numeros));
		System.out.println();
	}

	public static void testCadenaLarga() {
		System.out.println("Probando el método cadenaLarga:");
		List<String> cadenas = new ArrayList<>(Arrays.asList("Carlos", "Alba", "Estudiantes", "Yo"));
		System.out.println(Funciones.cadenaLarga(cadenas));
		System.out.println();
	}

	public static void main(String[] args) {
		testPrimo();
		testCombinatorio();
		testS();
		testCalcularDiferencias();
		testCadenaLarga();
	}
}
