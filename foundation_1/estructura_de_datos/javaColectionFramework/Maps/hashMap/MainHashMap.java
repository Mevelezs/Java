package estructura_de_datos.javaColectionFramework.Maps.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainHashMap {

	public static void main(String[] args){

		String s = "Cadena de ejemplo!!\nHoy es miércoles día 29 de marzo de 2024\n\nFIN";

		// Contar apariciones de letras
		Map <Character, Integer> letters = new HashMap <>();

		for ( char letter : s.toLowerCase().toCharArray() ){
			if ( Character.isLetter(letter) ){
				letters.put(letter, letters.getOrDefault(letter, 0) + 1);
			}
		}

		System.out.println("The frequency of characters in the string is: ");
		System.out.println(letters.entrySet());
		System.out.println("--------------------- Ó -------------------------");

		for ( Map.Entry <Character, Integer> keyValue : letters.entrySet() ){
			System.out.println(keyValue.getKey() + " : " + keyValue.getValue());
		}

		System.out.println("------------------------------------------");
		//Contar apariciones de palabras
		Map <String, Integer> frequencyWords = new HashMap <>();

		String[] wordArray = s.toLowerCase()
				.replace("\n", " ")
				.replaceAll("[^a-záéíóúüñçA-Z ]", "")
				.split("\\s+");

		System.out.println(Arrays.toString(wordArray));
		for ( String word : wordArray ){
			frequencyWords.put(word, frequencyWords.getOrDefault(word, 0) + 1);
		}

		System.out.println(frequencyWords.entrySet());
		System.out.println("------------------------------------------");

		for ( Map.Entry <String, Integer> word : frequencyWords.entrySet() ){
			System.out.println(word.getKey() + " : " + word.getValue());
		}

	}


}