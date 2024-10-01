package API_de_java.c_API_stream;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	/**
	 * Permite el procesamineto de datos de manera funcional, eficiente y concisa. Son secuenciasde elementos que se
	 * pueden procesar en paralelo o secuencialmente. Tienen dos componentes principales: operaciones intermedias y
	 * terminales.
	 *
	 * @Operaciones Intermedias -> Son las que transforman un stream en otro stream. Estas operaciones son peresozas, lo
	 * que significa que no e ejecuta hasta que se invoca una operación terminal en el stream.
	 *   filter(Predicate<T> predicate) -> filtra elementos en función de una condición dada por el predicado
	 *   map(Function <T, R> mapper) -> Transforma los elementos del stream aplicando la función dada a cada elemento.
	 *   flatMap(Function <T, Stream<R> > mapper) -> Aplana un stream de colecciones aplicando la función dad a cada
	 *     elemnto y devolviendo un stream de elementos individuales.
	 *   distinct() -> Elimina elementos duplicados del stream.
	 *   sorted() -> Ordena según su orden natural.
	 *   sorted (Comparator<T> comparator) -> ordena seún el comparador.
	 *   takeWhile(Predicate<T> predicate) y dropWhile(Predicate<T> predicate) -> Toma y/o descarta elementos en base a
	 *     una condición, similar a un bucle while.

	 * @Operaciones Terminales -> Son aquellas que producen un resultado a partir del stream
	 *  forEach(Consumer<T> action) -> Realiza una acción dada en cada elemento.
	 *  toArray() -> Convierte el steam en un array.
	 *  reduce(BinaryOperator<T> accumulator) -> Combina elemntos del stream en un único valor utilizando un acumulador.
	 *  collect(Collecto<T, A, R> collector) -> Transforma y/o acumula elementos del stream en una colección o un
	 *     objeto utilizando un collector.
	 *  min(Comparator<T> comparator) y max(Comparator<T> comparator) -> Devueleve el minimo o maximo elemnto del
	 *     stream, segúnel comparador proporcionado.
	 *  count() -> Cuenta los elementos del stream.
	 *  anyMatch(Predicate<T> predicate), allMatch(Predicate<T> predicate) y noneMatch(Predicate<T> predicate) ->
	 *     Evalua si algún, todos o ninguno de los elementos del stream cumple con la condición dada por el predicado.
	 */
	public static void main(String[] args){

		// Ejemplo: Filtrar nombreas que tengan más de tres caracteres, convertirlos a mayusculas ordenar alfabeticamente
		// y recolectarlos en una nueva lista.

		System.out.println("---------------------- Example 1 --------------------------");
		List<String> names = Arrays.asList("Mauricio", "Ana", "María", "Sol", "Joe", "Esteban" );
		System.out.println(names);

		List<String> filteredNames = names.stream()
				.filter(name -> name.length() > 3)
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());

		System.out.println(filteredNames);


		// Ejemplo 2: Filtrar por numeros pares y obtener la suma de cada uno de ellos elevados al cuadrado.
		System.out.println("---------------------- Example 2 --------------------------");

		List<Integer> nums = Arrays.asList(3, 5, 6, 2);
		System.out.println(nums);

		int result = nums.stream().filter(n -> n % 2 == 0).map(n ->(int) Math.pow(n, 2)).reduce(0, Integer::sum);
		System.out.println(result);


		// Ejemplo con listas de enteros combinadas.
		System.out.println("---------------------- Example 3 --------------------------");
		List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> list2 = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		List<Integer> list3 = List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
		List<Integer> list4 = List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40);

		List<List<Integer>> finalList = List.of(list1, list2, list3, list4);
		System.out.println(finalList);

		List<Integer> finalFilterList = finalList.stream()
				.flatMap(Collection ::stream)
				.filter(n -> n % 10 == 0)
				.map(n -> n/10)
				.toList();

		System.out.println( finalFilterList );

		int amount = (int) finalList.stream()
				.flatMap(Collection::stream)
				.filter(n -> n % 10 == 0)
				.count();

		System.out.println(amount);

		List<Integer> largest = finalList.stream()
				.flatMap(Collection::stream)
				.takeWhile(n -> n < 10) // se detiene cuando la condicion no se cumple, usarlos con el > no es buena opcion
				.toList();

		System.out.println(largest);

		List<Integer> minors =  finalList.stream()
				.flatMap(Collection::stream)
				.dropWhile(n -> n < 20 )
				.toList();

		System.out.println(minors);

		// Encontrar el numero de palabras únicas en una oración
		System.out.println("---------------------- Example 4 --------------------------");

		String text = "Ejemplo ejemplo texto texto texto";

		Set< String > wordsUnique = Arrays.stream(text.split("\\s+"))
				.map(String::toLowerCase)
				.collect(Collectors.toSet());

		System.out.println( wordsUnique+" : " +wordsUnique.size());

   // ordenar las palabras de una cadena de texto en orden alfabetico
		System.out.println("\nPalabras ordenadas alfabeticamente");

		String text2 = "Ejemplo de ordenamiento utilizando el API stream de Java";

		Arrays.stream(text2.split("\\s+"))
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.forEach(System.out::println);

		// ordenar las palabras de un string por cantidad de caracteres de menos a mas
		System.out.println("\nPalabras ordenadas por cantidad de caracteres");

		String text3 = "El ordenamientos de los eventos historicos es el más importante";

		List<String> orderedReverseWords = Arrays.stream(text3.split("\\s+"))
				.map(String::toLowerCase)
				.sorted(Comparator.comparingInt(String::length).reversed())
				.distinct()
				.toList();

		System.out.println(orderedReverseWords);

		// Ordenar una cadena de caracterres segun las veces que aparece ala letra "a"
		System.out.println("\nPalabras ordenadas por cantidad de veces que aparece al 'a'");

		String text4 = "La distancia rrecorrida a pie desde la cascada";

		Comparator <String> comparatorByAmountA = (world1, word2) -> {
       int amountAWorld1 = ( int ) world1.chars().filter(letter -> letter == 'a' || letter == 'A').count();
			 int amountAWorld2 = ( int ) word2.chars().filter(letter -> letter == 'a' || letter == 'A').count();
			 return Integer.compare(amountAWorld1, amountAWorld2);
		};

		List<String> orderedByAmountA = Arrays.stream(text4.split("\\s+"))
				.map(String::toLowerCase)
				.filter(world -> world.contains("a"))
				.distinct()
				.sorted(comparatorByAmountA)
				.toList();

		System.out.println(orderedByAmountA);

		//Usando metodo referenciado de una clase externa
		System.out.println("\nLista de trabajadores");
		List<String> names2 =  Arrays.asList("Muricio", "Vélez", "Solís");

		Comparator<Worker> comparatorByAge = Comparator.comparing(Worker::getAge); // Comparador con método referenciado

		List<Worker> nameWorker = names2.stream()
				.map(Worker :: new)// referncia el constructor de Workers
				.sorted(comparatorByAge)
				.toList();

		System.out.println(nameWorker);
	}
}
