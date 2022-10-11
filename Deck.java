import java.util.*;

public class Deck {
    private ArrayList<Card> deck;
    public Deck()
    {
        deck = new ArrayList<Card>();
        
        for(int number= 2; number++) {
            for(int suit = 0; suit <= 3; suit++) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }
    public ArrayList<Card> getCards() {
        return deck;
    }
    public Card deal() {
        return deck.remove(0);
    }
    public void shuffle(){
        for(int i = 0; i < deck.size(); i++)
        {
            int randomIndex = Math.random(52);
            Card x = deck.get(i);
            Card y = deck.get(randomIndex);
            
            deck.set(i, y);
            deck.set(randomIndex, x);
        }
    }

}