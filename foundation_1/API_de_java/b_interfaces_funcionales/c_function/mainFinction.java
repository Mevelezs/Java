package API_de_java.b_interfaces_funcionales.c_function;

import java.util.function.Function;

public class mainFinction {

	/**
	 *
	 * Interfaz Function -> Interfaz genérica que acepta un argumento de tipo T y produce un resultado de tipo R -> Es
	 * util para trabajar en operaciones de transformación en flujos (streams) y colecciones. -> tiene un único método
	 * apply() que es el que retorna el resultado.
	 */
	public static void main(String[] args){

		Function<String, Integer> longitudCadena = String::length;
		System.out.println(longitudCadena.apply("Hello World!"));

		Function<Integer, Double> cuadrado = x ->  Math.pow(x, x);
		System.out.println(cuadrado.apply(3));
	}
}
