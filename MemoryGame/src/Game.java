
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Game extends Canvas implements MouseListener {

    private String message = "";
    Card card = new Card();
    private int startX = 200, startY = 50, squareSize = 200;
    private String[][] board = new String[4][5];
    private boolean gameOver;
    private int turnstring = 1;
    private String flag = "";
    private int rowshow,colshow = 0;
    private int gameround = 0;
    private int finish = 0;
    private boolean show = false;

    public Game() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for (int i = 0; i <= 4; i++) {
            g.drawLine(startX, startY + i * squareSize, startX + 5 * squareSize, startY + i * squareSize);
            for (int j = 0; j <= 5; j++) {
                g.drawLine(startX + j * squareSize, startY, startX + j * squareSize, startY + 4 * squareSize);
            }
        }

        g.setFont(new Font("Arial", Font.ITALIC, 72));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\erdem\\OneDrive\\Masaüstü\\animals\\"+board[i][j]);
                g.drawImage(img, startX + j * squareSize, startY + i * squareSize, 200, 200, this);
                
            }
        }
        message = "Your moves: " + gameround;
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.setColor(Color.RED);
        g.drawString(message, 1250, 470);
    }

    public void mouseClicked(MouseEvent evt) {
        if (!gameOver) {
            
            if(finish == 10){
                JOptionPane.showMessageDialog(this,
                  "<html><h1>YOU WIN!!!!</h1></html>\n",
                  "WINNNERRRR!!!",
                  JOptionPane.PLAIN_MESSAGE,
                  new ImageIcon("C:\\Users\\erdem\\OneDrive\\Masaüstü\\cs201jpg\\win.png"));
                System.exit(0);
            }
            else if (evt.getX() > startX
                    && evt.getX() < startX + 5 * squareSize
                    && evt.getY() > startY
                    && evt.getY() < startY + 4 * squareSize) {
                int row = (evt.getY() - startY) / squareSize;
                int col = (evt.getX() - startX) / squareSize;
                if(show){
                    board[rowshow][colshow] = null;
                    show = false;
                }
                else if(board[row][col]==null&&turnstring==1){
                    board[row][col] = card.getCards()[row][col];
                    flag = board[row][col];
                    turnstring = 2;
                    gameround++;
                }
                else if(board[row][col]==null&&turnstring==2){
                    if(flag == card.getCards()[row][col]){
                        board[row][col] = card.getCards()[row][col];
                        turnstring = 1;
                        gameround++;
                        finish++;
                    }
                    else{
                        board[row][col] = card.getCards()[row][col];
                        rowshow = row;
                        colshow = col;
                        show = true;
                        gameround++;    
                    }
                    
                }


            }
            repaint();
        }//end if(!gameOver)
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
}
