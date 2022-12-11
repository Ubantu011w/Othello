import java.util.InputMismatchException;
import java.util.Scanner;
public class Grille {

  public static final int WIDTH = 8; 
  public static final int HEIGHT = 8;
  public static final int BLACK = 1 ;
  public static final int WHITE = 2 ;
  public static final int NONE = 0;

  public static final int PLAYABLE = 5; // مجال للعب

  int numberOfFreeTiles; // عدد البلاطات التي يمكن اللعب فيها

  int[][] table = new int[HEIGHT][WIDTH];

  public static void main(String[] args) {
    Grille grille = new Grille();
    grille.createTable();
    grille.print();

    Player playerWhite = new Player(WHITE, "White");
    Player playerBlack = new Player(BLACK, "Black");

    Player[] players = {playerBlack, playerWhite};
    Scanner s = new Scanner(System.in);
    grille.play(s, players, grille);
  }

  boolean play(Scanner s, Player[] players, Grille grille) {
    int turn = 0;
    while (numberOfFreeTiles != 0) {
      output("Player " + players[turn].name + "'s turn.");
      Player player = players[turn];
      try {
        int x = s.nextInt();
        int y = s.nextInt();
        if (table[x - 1][y - 1] == NONE) {
          table[x - 1][y - 1] = player.color;
        } else {
          output("Tile already taken, choose another.");
          continue;
        }
      } catch (InputMismatchException e) {
        output("Input can't be string");
        continue;
      } catch (ArrayIndexOutOfBoundsException i) {
        output("Directions out of board");
        continue;
      }
      turn++;
      if (turn > 1)
        turn = 0;
      grille.print();
    }
    return false;
  }

  void output(String string) {
    System.out.println(string);
  }

  void createTable() {
    for (int i = 0; i < HEIGHT; i++) {

      int[] row = table[i];

      for (int j = 0; j < WIDTH; j++) {
        row[j] = NONE;
      }

    }
    // start
    table[3][3] = BLACK; 
    table[3][4] = WHITE;
    table[4][3] = WHITE;
    table[4][4] = BLACK;
  }

  void print() {
    for (int i = 0; i < HEIGHT; i++) { // print table
      int[] row = table[i];
      System.out.println();
      for (int j = 0; j < WIDTH; j++) {
        System.out.print(row[j] + "  ");        
      }
    }
    System.out.println(); // more space
  }
}
