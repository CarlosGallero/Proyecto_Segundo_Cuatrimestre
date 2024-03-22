package fp.tipos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fp.tipos.Fecha;

public record Fecha(Integer año, Integer mes, Integer dia) {

	public String nombreMes() {
		List<String> nombreMeses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
				"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
		return nombreMeses.get(mes - 1);
	}

	public String diaSemana() {
		return calcularDiaSemana(año, mes, dia);
	}

	private static String calcularDiaSemana(Integer año, Integer mes, Integer dia) {
		if (mes < 3) {
			mes += 12;
			año--;
		}
		int k = año % 100;
		int j = año / 100;
		int h = (dia + 13 * (mes + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
		List<String> nombresDias = Arrays.asList("Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves",
				"Viernes");
		return nombresDias.get(h);
	}

	public Fecha sumarDias(int dias) {
		int[] diasEnMes = { 31, esAñoBisiesto(año) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int añoActual = año;
		int mesActual = mes;
		int diaActual = dia + dias;

		while (diaActual > diasEnMes[mesActual - 1]) {
			diaActual -= diasEnMes[mesActual - 1]; // diaActual=diaActual-diasEnMes[mesActual-1]
			mesActual = mesActual + 1;
			if (mesActual > 12) {
				mesActual = 1;
				añoActual = añoActual + 1;
			}
		}

		return new Fecha(añoActual, mesActual, diaActual);
	}

	public Fecha restarDias(int dias) {
		int[] diasEnMes = { 31, esAñoBisiesto(año) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int añoActual = año;
		int mesActual = mes;
		int diaActual = dia - dias;

		while (diaActual < 1) {
			mesActual = mesActual - 1;
			if (mesActual < 1) {
				mesActual = 12;
				añoActual = añoActual - 1;
			}
			diaActual += diasEnMes[mesActual - 1];
		}

		return new Fecha(añoActual, mesActual, diaActual);
	}

	public Integer diferenciaEnDias(Fecha otraFecha) {
		int totalDias = 0;
		Fecha fechaInicial = this;
		Fecha fechaFinal = otraFecha;

		while (!fechaInicial.equals(fechaFinal)) {
			fechaInicial = fechaInicial.sumarDias(1);
			totalDias++;
		}

		return totalDias;
	}

	@Override
	public String toString() {
		return String.format("%s, %d de %s de %d", diaSemana(), dia, nombreMes(), año);
	}

	@Override
	public int hashCode() {
		return Objects.hash(año, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return Objects.equals(año, other.año) && Objects.equals(dia, other.dia) && Objects.equals(mes, other.mes);
	}

	public static Fecha of(int año, int mes, int dia) {
		return new Fecha(año, mes, dia);
	}

	public static Fecha parse(String cadenaFecha) {
		String[] partes = cadenaFecha.split("-");
		int año = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int dia = Integer.parseInt(partes[2]);
		return new Fecha(año, mes, dia);
	}

	public static boolean esAñoBisiesto(int año) {
		return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
	}
	
	//AQUI EMPIEZA LA DEFENSA
    public static List<Integer> restarDiasFechaDada(Fecha fecha, int numDias) {
        if (numDias > 999) {
            throw new IllegalArgumentException("El número de días no debe exceder los 999.");
        }

        int[] diasEnMes = { 31, esAñoBisiesto(fecha.año()) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int añoActual = fecha.año();
        int mesActual = fecha.mes();
        int diaActual = fecha.dia() - numDias;

        while (diaActual < 1) {
            mesActual = mesActual - 1;
            if (mesActual < 1) {
                mesActual = 12;
                añoActual = añoActual - 1;
            }
            diaActual += diasEnMes[mesActual - 1];
        }

        return Arrays.asList(diaActual, mesActual, añoActual);
    }
}
