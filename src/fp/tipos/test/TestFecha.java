package fp.tipos.test;

import fp.tipos.Fecha;

public class TestFecha {

	public static void testNombreMes() {
		System.out.println("Test para nombreMes:");
		Fecha fecha = Fecha.of(2024, 3, 6);
		System.out.println("Nombre del mes: " + fecha.nombreMes()); // Debería imprimir "Marzo"
	}

	public static void testDiaSemana() {
		System.out.println("Test para diaSemana:");
		Fecha fecha = Fecha.of(2024, 3, 6);
		System.out.println("Día de la semana: " + fecha.diaSemana()); // Debería imprimir "Miércoles"
	}

	public static void testSumarDias() {
		System.out.println("Test para sumarDias:");
		Fecha fecha = Fecha.of(2024, 3, 6);
		Fecha fechaSumada = fecha.sumarDias(5);
		System.out.println("Fecha sumada: " + fechaSumada); // Debería imprimir "Lunes, 11 de Marzo de 2024"
	}

	public static void testRestarDias() {
		System.out.println("Test para restarDias:");
		Fecha fecha = Fecha.of(2024, 3, 6);
		Fecha fechaRestada = fecha.restarDias(3);
		System.out.println("Fecha restada: " + fechaRestada); // Debería imprimir "Domingo, 3 de Marzo de 2024"
	}

	public static void testDiferenciaEnDias() {
		System.out.println("Test para diferenciaEnDias:");
		Fecha fecha1 = Fecha.of(2024, 3, 6);
		Fecha fecha2 = Fecha.of(2024, 3, 10);
		int diferencia = fecha1.diferenciaEnDias(fecha2);
		System.out.println("Diferencia en días: " + diferencia); // Debería imprimir "4"
	}

	public static void main(String[] args) {
		testNombreMes();
		testDiaSemana();
		testSumarDias();
		testRestarDias();
		testDiferenciaEnDias();
	}
}