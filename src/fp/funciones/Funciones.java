package fp.funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import us.lsi.tools.Preconditions;

public class Funciones {

	public static Boolean primo(Integer a) {
		Preconditions.checkArgument(a > 1, "El numero tiene que ser mayor que 1");
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static Double factorial(Integer a) {
		Double res = 1.;
		for (int i = 2; i <= a; i++) {
			res *= i;
		}
		return res;
	}

	public static Double combinatorio(Integer n, Integer k) {
		if (k > n || k < 0) {
			return 0.;
		} else {
			return factorial(n) / (factorial(k) * factorial(n - k));
		}
	}

	public static Double S(Integer n, Integer k) {
		Double res = 0.;
		for (int i = 0; i <= k; i++) {
			res += Math.pow(-1, i) * combinatorio(k, i) * Math.pow(k - i, n);
		}
		return res / factorial(k);
	}

	public static List<Integer> calcularDiferencias(List<Integer> numeros) {
		List<Integer> diferencias = new ArrayList<>();
		for (int i = 1; i < numeros.size(); i++) {
			diferencias.add(numeros.get(i) - numeros.get(i - 1));
		}
		return diferencias;
	}

	public static String cadenaLarga(List<String> cadenas) {
		String masLarga = cadenas.get(0);
		for (String cadena : cadenas) {
			if (cadena.length() > masLarga.length()) {
				masLarga = cadena;
			}
		}
		return masLarga;
	}
	//AQUI EMPIEZA LA DEFENSA
	
	public static Integer P2(Integer n, Integer k, Integer i) {
	    Preconditions.checkArgument(n >= k, "n debe ser mayor o igual que k");
	    Preconditions.checkArgument(i < k + 1, "i debe ser menor que k + 1");
	    if (i == 0) {
	        i = 0; // Valor por defecto
	    }
	    
	    Integer resultado = 1;
	    for (int j = 0; j <= k - 2; j++) {
	        resultado *= (n - i);
	        i++;
	    }
	    return resultado;
	}
    
	public static Double C2(Integer n, Integer k) {
	    Preconditions.checkArgument(n > k, "n debe ser mayor que k");
	    
	    if (k < 0 || k >= n) {
	        return 0.0;
	    }
	    
	    return combinatorio(n, k + 1);
	}
	
    public static Double S2(Integer n, Integer k) {
		Double res = 0.;
		for (int i = 0; i <= k; i++) {
			res += Math.pow(-1, i) * combinatorio(k, i) * Math.pow(k - i, n);
		}
		return res / factorial(k+2);
	}
    
    
    
}

