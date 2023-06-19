import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
class Main {
  public static void main(String[] args) {
   JFrame win = new JFrame("Memory Card Game");
   win.setSize(1600,940);
   win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   win.add( new Game() );
   Container c = win.getContentPane();
   c.setBackground(Color.LIGHT_GRAY);
   win.setVisible(true);
  }
}
