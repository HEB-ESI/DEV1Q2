package util.mahé;

import static evaluations.janvier.Mahé.*;

public class UtilMahé{
	
	/** crée une pioche de n paquets d'oeufs pondus
	 * @param n lenombre de paquets d'oeufs à créer
	 * @return la pioche de n paquets d'oeufs
	 */
	private static int[] créerPiocheOeufs(int n){
		int [] pioche = new int[n];
		for(int i=0; i<pioche.length; i++){
			pioche[i] = (int)(Math.random()*6+1);
		}
		return pioche;
	}

	private static int indiceMax(int[] entiers){
		int indice;
		indice = 0;
		for(int i=1; i<entiers.length; i++){
			if(entiers[i]>entiers[indice]){
				indice = i;
			}
		}
		return indice;
	}

	/** joue une partie
	 * @param nbTortues le nombre de tortues qui jouent
	 */
	
	public static void jouerPartie(int nbTortues){
		int[] tortues = getTortues(nbTortues) ;
		int[] oeufs = getTortues(nbTortues);
		int nbOeufsRestant = 2;
		int[] oeufsAGagner = créerPiocheOeufs(nbOeufsRestant);

		while(nbOeufsRestant > 0){
			tortues = getTortues(nbTortues);
			jouerTour(tortues, oeufs, oeufsAGagner[nbOeufsRestant-1]);
			nbOeufsRestant = nbOeufsRestant - 1;
		}
		System.out.println("La tortue " + indiceMax(tortues) + " a gagné");
	}

}
