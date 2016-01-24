package g12345.dev1.janvier;

import java.util.Arrays;

/**
 * Classe utilitaires du jeu Star Wars.
 */
public class StarWarsUtils {

    /**
     * Indique si la position est occup\u00e9e par un ennemi du tableau
     * pass\u00e9 en param\u00e8tre.
     * <p>
     * @param ennemis  tableau des positions des ennemis
     * @param position position \u00e0 v\u00e9rifier
     * <p>
     * @return si la position est occup\u00e9e par un ennemis du tableau
     * pass\u00e9 en param\u00e8tre
     */
    public static boolean estLibre(int[] ennemis, int position) {
        if (ennemis == null) {
            throw new IllegalArgumentException("Table is null");
        }

        //error sizeField <= 0
        if (position <= 0) {
            throw new IllegalArgumentException("position is lesser than 0. sizeField value is " +
                                               position);
        }

        int i = 0;
        boolean fill = false;
        while (!fill && i < ennemis.length) {
            if (ennemis[i] == position) {
                fill = true;
            }
            i++;
        }
        return fill;
    }

    /**
     * Mets \u00e0 jour le tableau de n entiers en mettant \u00e0 0 la position
 du personnage
 qui occupe le position donn\u00e9e en param\u00e8tre.
     * <p>
     * @param ennemis un tableau de n entiers repr\u00e9sentant les positions
     *                d'un
     *                groupe de personnages
     * @param position    un entier pr\u00e9cisant la position actuelle du joueur
     *                ayant la
     *                main
     * <p>
     * @return le nombre de case mise \u00e0 jour
     */
    public static int securiseZone(int[] ennemis, int position) {
        int i = 0;
        boolean occupe = false;
        int nb = 0;
        while (!occupe && i < ennemis.length) {
            if (ennemis[i] == position) {
                ennemis[i] = 0;
                occupe = true;
                nb++;
            }
            i++;
        }
        return nb;
    }

    /**
     * Affiche le plateau de jeu sur base des diff\u00e9rentes donn\u00e9es de
     * la partie. Luke est repr\u00e9sent\u00e9 par le caract\u00e8re L, Yoda
     * par le caract\u00e8re
     * Y et un ennemi par le caract\u00e8re E. Si Luke
     * et Yoda occupe la m\u00eame position ils sont repr\u00e9sent\u00e9s par
     * le
     * caract\u00e8re 2.
     * <p>
     * @param jedis   position des deux jedis
     * @param force   force des deux jedis
     * @param ennemis position des ennemis
     * @param taille  taille du plateau de jeu
     * @param joueur  joueur courant
     * <p>
     * @throws IllegalArgumentException un des tableaux entr\u00e9s en
     * param\u00e8tre est null
     * @throws IllegalArgumentException la taille est inf\u00e9rieure ou
     * \u00e9gale \u00e0 0
     * @throws IllegalArgumentException les tableaux jedis et force ont une
     * taille diff\u00e9rentes de deux
     * @throws IllegalArgumentException une valeur strictement inf\u00e9rieure
     * \u00e0
     * 0 ou strictement sup\u00e9rieur \u00e0 taille est pr\u00e9sente dans un
     * des
     * tableaux jedis, ennemis.
     */
    public static void affichePlateau(int[] jedis, int[] force,
                                      int[] ennemis,
                                      int taille, int joueur) {

        checkError(jedis, force, ennemis, taille);
        String[][] displayTab = new String[3][taille];
        fillJedi(jedis, displayTab[0]);
        fillPeople(ennemis, displayTab[1], "E");
        display(force, displayTab, ennemis, joueur);
    }

    private static void checkError(int[] jediPosition, int[] jediPower,
                                   int[] ennemiPosition,
                                   int sizeField) {
        //error if tab null
        if (jediPosition == null) {
            throw new IllegalArgumentException("Table jediPosition is null");
        }

        if (jediPower == null) {
            throw new IllegalArgumentException("Table jediPower is null");
        }

        if (ennemiPosition == null) {
            throw new IllegalArgumentException("Table ennemiPosition is null");
        }

        //error sizeField <= 0
        if (sizeField <= 0) {
            throw new IllegalArgumentException("sizeField is lesser than 0. sizeField value is " +
                                               sizeField);
        }
        //jediPosition or jediPower isn't size 2
        if (jediPosition.length != 2) {
            throw new IllegalArgumentException("Table jediPosition need to be size 2." +
                                               " jediPosition size is " +
                                               jediPosition.length);
        }

        if (jediPower.length != 2) {
            throw new IllegalArgumentException("Table jediPower need to be size 2." +
                                               " jediPower size is " +
                                               jediPower.length);
        }

        //jediPosition,ennemiPosition have invalid position  
        try {
            checkLimit(jediPosition, sizeField);
        } catch (Exception e) {
            throw new IllegalArgumentException("Table jediPosition " +
                                               e.getMessage());
        }

        try {
            checkLimit(ennemiPosition, sizeField);
        } catch (Exception e) {
            throw new IllegalArgumentException("Table ennemiPosition " +
                                               e.getMessage());
        }
    }

    private static void checkLimit(int[] tab, int sizeField) {
        int min = Arrays.stream(tab).min().getAsInt();
        if (min < 0) {
            throw new IllegalArgumentException("a position is incorrect " + min);
        }
        int max = Arrays.stream(tab).max().getAsInt();
        if (max > sizeField) {
            throw new IllegalArgumentException("a position is incorrect " + max);
        }
    }

    private static int countPeople(int[] tab) {
        int nb = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != 0) {
                nb++;
            }
        }
        return nb;
    }

    private static void fillJedi(int[] jediPosition, String[] tab) {
        if (jediPosition[0] == jediPosition[1]) {
            tab[jediPosition[0] - 1] = "2";
        } else {
            tab[jediPosition[0] - 1] = "L";
            tab[jediPosition[1] - 1] = "Y";
        }
    }

    private static void fillPeople(int[] position, String[] tab, String value) {
        for (int i = 0; i < position.length; i++) {
            if (position[i] != 0) {
                tab[position[i] - 1] = value;
            }
        }
    }

    private static String buildString(String[][] tab) {
        String text = "";
//        for (int i = 1; i <= tab[0].length; i++) {
//            text+=i+" ";
//        }
//        text += "\n";
        for (String[] line : tab) {
            for (String el : line) {
                if (el == null) {
                    text += "_" + " ";
                } else {
                    text += el + " ";
                }
            }
            text += "\n";
        }
        return text;
    }

    private static void display(int[] jediPower, String[][] tab,
                                int[] ennemiPosition,
                                int currentJedi) {
        String player = (currentJedi == 0) ? "Luke" : "Yoda";
        int nbEnnemi = countPeople(ennemiPosition);
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ");
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ");
        System.out.println("Tour du Jedi " + player);
        System.out.println("");
        System.out.print("Luke de Force " + jediPower[0]);
        System.out.println(", Yoda de Force " + jediPower[1]);
        System.out.println("Il reste " + nbEnnemi + " ennemis");
        System.out.println("");
        String text = buildString(tab);
        System.out.println(text);
    }

    /**
     * Point d'entr\u00e9e de test de la classe.
     * <p>
     * @param args aucun argument
     */
    public static void main(String[] args) {
        System.out.println("'Do. Or do not. There is no try.' - Yoda");
    }
}
