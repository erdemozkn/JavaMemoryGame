
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Card {
private String[][] cards;
private ArrayList<String> arl;
    public Card() {
        String[] arr = {"1.jpg","1.jpg","2.jpg","2.jpg","3.jpg","3.jpg","4.jpg","4.jpg","5.jpg","5.jpg","6.jpg","6.jpg","7.jpg","7.jpg","8.jpg","8.jpg","9.jpg","9.jpg","10.jpg","10.jpg"};
        arl = new ArrayList<String>();
        Collections.addAll(arl, arr);
        Collections.shuffle(arl);
        
        cards = new String[4][5];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                cards[i][j] = arl.get(index);
                index++;
            }
        }
    }

    public String[][] getCards() {
        return cards;
    }



}
