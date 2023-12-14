package test_iterateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		//TODO exo I.
		List<Character> caracteres = new ArrayList<>();
		Collections.addAll(caracteres, 'r','a','u','t');
		Iterator<Character> iter = caracteres.iterator();
		
	}
}
