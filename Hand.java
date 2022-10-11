import java.util.*;

public class Hand {
    private ArrayList<Card> cards;
    public Hand() {
        cards = new ArrayList<Card>();
    }
    public void addCard(Card c) {
        cards.add(c);
    }
    public int getValue() {
        int sum = 0;
        int aceCount = 0;
        for(Card c: cards) {
            sum += c.getValue();
        }
        while(sum > 21 && aceCount > 0) {
            sum -= 10;
        }
        
        return sum;
    }
    public boolean hasBlackjack() {
        return getValue() == 21 && cards.size() == 2;
    }
    public boolean busted() {
        return getValue() > 21;
    }
    public String toString() {
        String result = "";
        for(Card c: cards) {
            result += c + " ";
        }
        result += "(" + getValue() + ")";
        return result;
    }

}