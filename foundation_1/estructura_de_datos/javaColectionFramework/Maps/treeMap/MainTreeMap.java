package estructura_de_datos.javaColectionFramework.Maps.treeMap;

import java.util.Map;
import java.util.TreeMap;

public class MainTreeMap {

	public static void main(String[] args){
		TreeMap<String, Double> notes = new TreeMap<>();

		notes.put("Pol", 9.4);
		notes.put("Pep", 6.7);
		notes.put("Tom", 0.0);
		notes.put("Sam", 7.5);
		notes.put("Kal", 8.7);

		System.out.println(notes);
		System.out.println("First key: "+ notes.firstKey());
		System.out.println("Last key: "+ notes.lastKey());
		System.out.println("Before Sam "+ notes.headMap("Sam"));
		System.out.println("After o equal Pol: "+ notes.tailMap("Pol"));
		System.out.println("Between Kal and Sam: "+ notes.subMap("Kal", "Sam"));

		Map.Entry<String, Double> min = notes.pollFirstEntry();
		System.out.println("First element of tree: "+min);
		Map.Entry<String, Double> max = notes.pollLastEntry();
		System.out.println("Last element of tree: "+ max.getKey()+ " = "+ max.getValue());
		System.out.println(notes);
	}
}
