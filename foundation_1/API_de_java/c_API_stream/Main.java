package API_de_java.c_API_stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	/**
	 * Permite el procesamineto de datos de manera funcional, eficiente y concisa. Son secuenciasde elementos que se
	 * pueden procesar en paralelo o secuencialmente. Tienen dos componentes principales: operaciones intermedias y
	 * terminales.
	 *
	 * @Operaciones Intermedias -> Son las que transforman un stream en otro stream. Estas operaciones son peresozas, lo
	 * que significa que no e ejecuta hasta que se invoca una operación terminal en el stream.
	 *
	 *   filter(Predicate<T> predicate) -> filtra elementos en función de una condición dada por el predicado
	 *   map(Function <T, R> mapper) -> Transforma los elementos del stream aplicando la función dada a cada elemento.
	 *   flatMap(Function <T, Stream<R> > mapper) -> Aplana un stream de colecciones aplicando la función dad a cada
	 *     elemnto y devolviendo un stream de elementos individuales.
	 *   distinct() -> Elimina elementos duplicados del stream.
	 *   sorted() -> Ordena según su orden natural.
	 *   sorted (Comparator<T> comparator) -> ordena seún el comparador.
	 *   takeWhile(Predicate<T> predicate) y dropWhile(Predicate<T> predicate) -> Toma y/o descarta elementos en base a
	 *     una condición, similar a un bucle while.
	 * @Operaciones Terminal -> Son aquellas que producen un resultado a partir del stream
	 *
	 *  forEach(Consumer<T> action) -> Realiza una acción dada en cada elemento.
	 *  toArray() -> Convierte el steam en un array.
	 *  reduce(BinaryOperator<T> accumulator) -> Combina elemntos del stream en un único valor utilizando un acumulador.
	 *  collect(Collecto<T, A, R> collector) -> Transforma y/o acumula elementos del stream en una colección o un
	 *     objeto utilizando un collector.
	 *  min(Comparator<T> comparator) y max(Comparator<T> comparator) -> Devueleve el minimo o maximo elemnto del
	 *     stream, segúnel comparador proporcionado.
	 *   count() -> Cuenta los elementos del stream.
	 *   anyMatch(Predicate<T> predicate), allMatch(Predicate<T> predicate) y noneMatch(Predicate<T> predicate) ->
	 *     Evalua si algún, todos o ninguno de los elementos del stream cumple con la condición dada por el predicado.
	 */
	public static void main(String[] args){

		// Ejemplo: Filtrar nombreas que tengan más de tres caracteres, convertirlos a mayusculas ordenar alfabeticamente
		// y recolectarlos en una nueva lista.

		System.out.println("---------------------- Ejemplo 1 --------------------------");
		List<String> names = Arrays.asList("Mauricio", "Ana", "María", "Sol", "Joe", "Esteban" );
		System.out.println(names);

		List<String> filteredNames = names.stream()
				.filter(name -> name.length() > 3)
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());

		System.out.println(filteredNames);


		// Ejemplo 2: Filtrar por numeros pares y obtener la suma de cada uno de ellos elevados al cuadrado.
		System.out.println("---------------------- Ejemplo 2 --------------------------");

		List<Integer> nums = Arrays.asList(3, 5, 6, 2);
		System.out.println(nums);

		int result = nums.stream().filter(n -> n % 2 == 0).map(n ->(int) Math.pow(n, 2)).reduce(0, Integer::sum);
		System.out.println(result);

	}
}
