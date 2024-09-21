package estructura_de_datos.javaColectionFramework.Collections;

import java.util.LinkedList;

/**
 * @ LinkedList hereda de las interfaces List<E>, Queue<E> y Deque<E>, estas a su vez heredan de la interfaz
 * Collection <E>;
 * esto quiere decir que tiene los métodos de las cuatro interfaces anteriores.
 * @ ArryList solo hereda de List<E>
 * <p>
 * @ MÉTODOS
 * <p>
 * @ Collection <E>
 * add(Object o) -> Agrega un elmento a la coleccíon
 * remove(Object o) -> Elimina una instancia del objeto especificado de la colección
 * clear() -> Elimina todos los elementos de la colección
 * containsObject(Object o) -> Verifica si la conlección tiene una instancia especificada del objeto
 * isEmpy() -> Retorna true si la colección está vacía
 * size() -> Retorna el tamaño de la colección
 * toArray() -> Retorna un arreglo con los elementos de la colección
 * iterator() -> Retorna un iterador sobre los elementos de la colección
 * equals(Object o) -> Compara la collección actual con el objeto especificado para ver si son iguales
 * hashCode() -> Retorna un valor hash de la colección.
 * <p>
 * @ List<E>
 * E get(int index) -> Retorna el elemento en la posición especifica de la lista
 * E set(int index, E element) -> Reemplaza en la posición dada de la liste el elmento pasado como parámetro
 * void add(int index, E element) -> Sobrecarga del add de Collection que permite insertar un elemento en una posición especifica
 * E remove(int index) -> elinima y retorna el elemento en la posición dada
 * int indexOf(E o) -> Retorna el indice de la primera aparicíon del elemento ó -1 si no está
 * int lastIndexOf(E o) -> Retorna el indice de la últim aparicíon del elemento ó -1 si no está
 * ListIterator<E> listIterator() -> (ampliación del iteratoe) Permite racorrer la lista en cualquier dirección y modificarla en el proceso.
 * <p>
 * @ Queue<E>
 * => FILO
 * boolean offer(E e) -> agregaun elemento al final de la lista
 * E poll() -> Elimina y retorna el promer elemento de la lista o null si está vacía
 * E peek() -> Retorna el primer elemnto sin eliminarlo ó null si está vacía
 * <p>
 * @ Deque<E>
 * => Puede insertar y eliminar por ambos lados (Cola de doble extremo) FIFO & FILO
 * boolean offerFirst(E e) -> Inserta elementos al inicio de la lista
 * boolean offerLast(E e) -> Inserta elementos al final de la lista
 * E pollFist() -> Elimina y retorna el primenr elemento o null si está vacía
 * E pollLast() -> Elimina y retorna el último elemento o null si está vacía
 * E peekFirst() -> Retorna el primer elemnto sin eliminarlo ó null si está vacía
 * E peekLast() -> Retorna el último elemnto sin eliminarlo ó null si está vacía
 * E getFirst -> Retorna el primer elemnto sin eliminarlo ó NoSuchElementException si está vacía
 * E getLast() -> Retorna el último elemnto sin eliminarlo ó NoSuchElementException si está vacía
 * E removeFist() -> Elimina y retorna el primenr elemento o NoSuchElementException si está vacía
 * E removeLast() -> Elimina y retorna el último elemento o NoSuchElementException si está vacía
 */
public class MainLinkedList {

	public static void main(String[] args){
		LinkedList <Alum> alum = new LinkedList <>();

		// métodos de la interfaz Collection
		alum.add(new Alum("Mauricio", 39, 3));
		alum.add(new Alum("Joe", 23, 5));
		alum.add(new Alum("Gerson", 25, 6));
		alum.add(new Alum("Julián", 30, 7));
		alum.add(new Alum("María", 28, 4));
		alum.add(new Alum("Brayan", 24, 3));

		System.out.println("\n"+alum);

		// metodos de la interfaz List
		System.out.println(alum.get(3));
		alum.set(3, new Alum ("Carlos", 18, 4));
		System.out.println(alum);

		//metodos de queue y deque
		System.out.println(alum.pollFirst());
		System.out.println(alum);
		System.out.println(alum.pollLast());
		System.out.println(alum);

	}

}
