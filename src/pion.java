import java.util.LinkedList;

public class pion {

  LinkedList<pion> Adjacencies = new LinkedList<>();
  int[] position;
  boolean color;

  // black: true
  // white: false
  public pion(boolean color, int[] position, LinkedList<pion> Adjacencies) {
    this.color = color;
    this.position = position;
    this.Adjacencies = Adjacencies;
  }

  public void changeColor() {

  }
  
}