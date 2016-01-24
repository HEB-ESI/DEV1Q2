package util.blanche;

public class UtilBlancheNeige{
	
	/** retourne vrai si le jeu est fini et faux sinon
	 * @param positions le tableau des positions de la sorcière et des nains
	 * @return vrai si le jeu est fini et faux sinon
	 */
	public static boolean isOver(int[] positions){
		boolean gagné = false;
		int i = 0;
		while(!gagné && i<positions.length){
			gagné = positions[i]>=90;
			i++;
		}
		return gagné;
	}
}
