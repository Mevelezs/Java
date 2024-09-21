package estructura_de_datos.javaColectionFramework.Collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Set(E) hereda de la interfaz Collection -> No introduce métodos propios -> No admite duplicados (toma como
 * referencia la dirección en memotia del la instancia del objeto dado)
 * -> para que tome un atributao particular hay que reescribir los metodos hashCode() y equals()
 * @HashSet<E) implementa Set(E) -> usa una tabla hash para guardar los elementos -> no garantiza orden enpecifico ->
 * garantiza un rendimiento constante -> permite valores nulos (optima para colecciones grandes)
 * @LinkedHashSet(E) hereda de HasSet(E) -> extension del HashSet pero mantiene el orden de los elementos -> menor
 * rendimiento
 * que el padre por la sobrecarga para mantener el orden pero tambien en buena
 * @SortedSed<E) hereda de Set(E)
 * @NavigalbleSet(E) hereda de SortedSet(E)
 * @TreeSet<E> implementa NavigableSet(E) -> Es una implemetacion del Set basada en en arbol binario de busqueda
 * balanceado
 * -> mantiene los elementos ordenados segun el metodo compareTo() o un comparador proporcionado -> no permite valores nulos
 * -> ofrece un rendimiento logaritmico
 */

public class MainSet {

	public static void main(String[] args){
		Set <Integer> nums = new HashSet <>();
		nums.add(1);
		nums.add(2);
		nums.add(2);
		nums.add(3);
		nums.add(4);

		System.out.println(nums);
		System.out.println(nums.contains(5));

		List <Integer> nums2 = new ArrayList <>();
		nums2.add(1);
		nums2.add(2);
		nums2.add(2);
		nums2.add(3);
		nums2.add(4);

		Set <Integer> nums3 = new HashSet <>(nums2);
		System.out.println(nums2);
		System.out.println(nums3);
	}


}
