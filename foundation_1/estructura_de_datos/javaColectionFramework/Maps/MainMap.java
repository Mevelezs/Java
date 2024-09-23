package estructura_de_datos.javaColectionFramework.Maps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Map (K, V) -> Representa una estructura clave valor -> K, V deden ser clases -> K es único, V se puede repetir
 * -> Map no tiene iterator (es desligada de Collection)
 * **** Metodos Map ******
 *  => V put(K key, V value) -> Asocia un valor con una clave -> si la clave existe se reemplaza el valor antiguo
 *     sino se agrega a al tabla.
 *  => V get(K key) -> Devuelve el valor asociado con la key si no esta null.
 *  => V remove(K key) -> Elimina el par clave-valor asociado a la key si no està null.
 *  => boolean containsKey(K key) -> Verifica si existe un par clave-valor con la clave dada.
 *  => boolean containsValue(V value) -> Verifica si existe un par clave-valor con el valor dado.
 *  => clea() -> Elimina todos los pares clave-valor.
 *  => V getOrDefault(K key, V defaultValue) -> Recupera el valor asociado a una clave y si no está devuelve el valor
 *     pasado por defecto.
 *  => set(k) keySet() -> Devuelve en un objeto set(k) las claves del mapa.
 *  => Collection(v) values() -> Devuelve una coleccion de tipo Collection(v) que contiene todos los valores del mapa.
 *  => set(Map.Entry(K, V)) entrySet() -> Devueleve un objeto set(Map.Entry(K, V)) que contiene todos los pares
 *     clave-valor del mapa como un objeto Map.Entry(K, V).
 *
 *  @HashTableMap(K, V) -> Implementa Map(K, V) -> Obsoleto
 *  @HashMap(K, V) -> Implementa Map(K, V) -> tabla hash que guarda clave-valos sin orden especifico ->
 *        rendimiento constante para las operacions básicas -> permite valores nulos -> no tiene metodos exclusivos
 *     @LinkedHashMap(K, V) -> Hereda de HashMap(K, V) -> lista enlazada -> mantiene el orden de inserción.
 *
 *  @SortedMap(K, V) -> Hereda de Map(K, V)
 *    **** Metodos SortedMap ******
 *    K firstKey(): Devuelve la primera (mínima) clave del mapa ordenado
 *    K lastKey(): Devuelve la última (máxima) clave del mapa ordenado
 *    SortedMap(K, V) headMap(K key) -> Devuelve los elementos con las claves menores a la key pasada como prámetro.
 *    SortedMap(K, V) tailMap(K key) -> Devuelve los elementos con las claves mayores o iguales a la key pasada como prámetro.
 *    SortedMap(K, V) subMap(K fromkey, K toKey) -> Devuelve los elementos que estan en el rango de las dos keys.
 *
 *    @NavigableMap (K, V) -> Hereda de SortedMap(K, V)
 *    **** Metodos NaivigableMap ******
 *      K lowerKey(K key) -> Devuelve la clave mas grande que es menor que la key.
 *      K higherKey(K key) -> Devuelve la clave más pequeña, que es mayor a la clave key.
 *      K floorKey(K key) -> Devuelve la clave más grande que es menor o igual a la clave key.
 *      K ceilingKey(K key) -> Devuelve la clave más pequeña que es mayor o igual a la clave key.
 *      Map.Entry(K, V) pollFirstEntry() -> Elimina y devuelve el par con clave mínima, null si es vacio.
 *      Map.Entry(K, V) pollLastEntry() -> Elimina y devuelve el par con clave máxima, null si es vacio.
 *      NavigableMap(K, V) descendingMap() -> Devuelve una vista del Map en orden descendente.
 *      NavigableSet(K, V) navigableKeySet() -> Devuelve un NavigableSet de las claves del mapa.
 *      NavigableSet(K, V) descendingKeySet() -> Devuelve un NavigableSet de las claves del mapa en orden.
 *
 *      @TreeMap (K, V) -> Implementa NavigableMap(K, V) -> implementacion de Map en un arbol binario de busqueda
 *              (red-black-tree) -> mantiene el orden segùn el método compareTo() -> no acepta valores nulos ->
 *              rendimiento logaritmico.
 */
public class MainMap {

	public static void main(String[] args){
		Map<Integer, String> map = new HashMap <>();

		map.put(1, "Esteban");
		map.put(0, "Mauricio");
		map.put(2, "Vélez");
		map.put(4, "Esteban");
		map.put(3, "Solís");

  // no garantiza el orden de inserción
		System.out.println("Info: "+map);

		System.out.println(map.get(2));
		map.remove(4);
		System.out.println(map);
		System.out.println(map.containsKey(3));
		System.out.println(map.containsValue("Esteban"));
		System.out.println(map.getOrDefault(6, "Esteban"));
		System.out.println("------------------------------------------");
		System.out.println(map.values());

		ArrayList <String> valuesMap = new ArrayList<>(map.values());

		System.out.println(valuesMap);
		valuesMap.add("María");
		System.out.println(valuesMap);
		System.out.println("-------------------------------------------");

		System.out.println(map.keySet());

		System.out.println(map.entrySet());

		for ( Map.Entry<Integer, String> info: map.entrySet()){ // forma de recorrer un Map.Entry
			System.out.print("key: "+info.getKey());
			System.out.println(" -> value: "+info.getValue());
		}
	}


}
