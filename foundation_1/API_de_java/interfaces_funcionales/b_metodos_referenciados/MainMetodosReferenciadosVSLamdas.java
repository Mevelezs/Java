package API_de_java.interfaces_funcionales.b_metodos_referenciados;

import java.util.Arrays;
import java.util.List;

public class MainMetodosReferenciadosVSLamdas {

	public static void main(String[] args){
		List<String> names = Arrays.asList("Pep", "Tom", "Kal");

		// Usando Lamdas
		names.forEach(name -> System.out.println(name));

		System.out.println("::::::::::::::::::::::::::::::::::::::::");

		// Usando método referenciado
		//          de la clase  :: invoca el método
		names.forEach(System.out :: println); // (soutc)

		System.out.println("::::::::::::::::::::::::::::::::::::::::");

		Calculator suma = EjemplosParaMetodosReferenciados::suma;
		System.out.println(suma.operation(3 ,5));

		Calculator subtraction = EjemplosParaMetodosReferenciados::subtraction;
		System.out.println(subtraction.operation(43, 78));

		Calculator division = EjemplosParaMetodosReferenciados::division;
		System.out.println(division.operation(43,6));

		Calculator multiply = EjemplosParaMetodosReferenciados::multiply;
		System.out.println(multiply.operation(43,50));

	}

}
