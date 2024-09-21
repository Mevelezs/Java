package estructura_de_datos.javaColectionFramework.Collections.set.treeSet;

import java.util.TreeSet;

public class MainTreeSet {

	/**
	 * @Metodos:
	 *  E first() -> Retorna el primer (más pequeño) elemento del conjunto NoSuchElementExeption si está vacío
	 *  E last() -> Retorna el último (más grande) elemento del conjunto NoSuchElementExeption si está vacío
	 *  E lower(E e) -> Retorna el elemento más grande del conjunto que es menor que el especificado o null si no hay
	 *  E floor(E e) -> Retorna el elemento más grande del conjunto que es menor o igual que el especificado o null si no hay
	 *  E ceiling(E e) -> Retorna el elemento más pequeño del conjunto que es mayor o igual que el especificado o null si no hay
	 *  E higher(E e) -> Retorna el elemento más pequeño del conjunto que es mayor que el especificado o null si no hay
	 *  E pollFirst() -> Elimina y retorna el primer (más pequeño) elemento del conjunto o null si no hay
	 *  E pollLast() -> Elimina y retorna el último (más grande) elemento del conjunto o null si no hay
	 */
	public static void main(String[] args){

		TreeSet<Integer> num = new TreeSet <>();
		num.add(3);
		num.add(1);
		num.add(4);
		num.add(4);
		num.add(4);
		num.add(5);
		num.add(2);

		System.out.println(num);

		System.out.println(num.first());
		System.out.println(num.last());
		System.out.println(num.lower(3));
		System.out.println(num.floor(3));
		System.out.println(num.ceiling(3));
		System.out.println(num);
		System.out.println(num.pollFirst());
		System.out.println(num);
		System.out.println(num.pollLast());
		System.out.println(num);
		System.out.println(num.higher(3));




	}

}
