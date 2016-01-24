package esi.dev1.janvier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScrabbleUtil {

	private static final String DICO_PATH = "chemin vers le_dico.txt";
	
	public static char[] tirerChevalet() {
		return new char[]{'S', 'S', 'Y', 'K', 'H', 'I', 'W'};
	}
		
	public static String[] lireDico() {
		Scanner clavier = null;
		try {
			clavier = new Scanner(new FileInputStream(DICO_PATH));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//init dico
		int nbMots = clavier.nextInt();
		String[] dico = new String[nbMots];
		
		// remplir le dico
		int i = 0;
		while(clavier.hasNext()) {
			dico[i] = clavier.next();
			System.out.println("dico: "+dico[i]);
			i++;
		}
		return dico;
	}
	
	public static void main(String[] args) {
		System.out.println("1 point mérité");
	}
	
	public static boolean motPossible(char[] chevalet, String mot) {
		char[] copieChevalet = chevalet.clone();
		for(int i=0; i<mot.length(); i++) {
			int indice = indiceLettre(copieChevalet, mot.charAt(i)) ;
			if(indice != -1) copieChevalet[indice] = '.';
			else return false;
		}
		return true;
	}

	public static int indiceLettre(char[] chevalet, char lettre) {
		for(int i = 0; i < chevalet.length;i++) 
			if(chevalet[i] == lettre) 
				return i;
		return -1;
	}
	



}
