
/**
 * Décrivez votre classe Grill ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Grille
{
    public static final int WIDTH= 8 ; 
    public static final int HEIGHT= 8 ; 
    public static final int BLACK = 1 ;
    public static final int WHITE = 2 ;
    public static final int NONE = 0 ;
    
    private static int [][] grille_jeu ; // Game_Table
    private int [][] grille_calcule ; // result
    


    public Grille()
    {
           
        }
    
    public static void main(String[]args){
    
    Grille j = new Grille();
    j.CreateGrille_jeu();
    affichage(grille_jeu);
    }    
        
        
    /**
     * la grille de jeu
     */
    public  void CreateGrille_jeu(){ // create_table
    grille_jeu = new int [HEIGHT][WIDTH];
        for(int i = 0 ; i < HEIGHT ; i++ ){
            for(int j = 0 ; j < WIDTH; j++){
                // inisalsier toute les case à vide
                grille_jeu[i][j] = NONE ;
            }
        }
        // insialiser les case de milieu comme demander 
        grille_jeu[3][3] = BLACK; 
        grille_jeu[3][4] = WHITE;
        grille_jeu[4][3] = WHITE;
        grille_jeu[4][4] = BLACK;

    }
    
    /**
     * la grille où on fait le calcule pour le IA
     */
    public void CreateGrille_calcule(){ // counting blacks/whites tiles
    grille_jeu = new int [HEIGHT][WIDTH];
        for(int i = 0 ; i < HEIGHT ; i++ ){
            for(int j = 0 ; j < WIDTH; j++){
                grille_jeu[i][j] = NONE ;
            }
        }

        grille_jeu[3][3] = BLACK; 
        grille_jeu[3][4] = WHITE;
        grille_jeu[4][3] = WHITE;
        grille_jeu[4][4] = BLACK;

    }
    
    /**
     * on affiche l'arene
     */
     public static void affichage(int arene[][]) {
        for (int i = 0; i < arene.length; i++) {
            for (int j = 0; j < arene.length; j++) {
                if (i == 0 && j == 0) System.out.print("   ");
                else if (i == 0 && j < 10) System.out.print(j + "  ");
                else if (i == 0 && j > 9) System.out.print(j + " ");
                else if (j == 0 && i > 0) {
                    if (i < 10) System.out.print(i + "  ");
                    else if (i > 9) System.out.print(i + " ");
                } else if (j < 11) System.out.print(arene[i][j] + "  ");
                else if (j > 9) System.out.print(arene[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
