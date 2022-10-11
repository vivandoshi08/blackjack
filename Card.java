public class Card {
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;
    private static final int HEARTS = 0;
    private static final int DIAMONDS = 1;
    private static final int SPADES = 2;
    private static final int CLUBS = 3;
    private int number;
    private int suit;
    private int value;
    private String[] ranks = {"?", "?", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String[] suits = {"H", "D", "S", "C"};
    
    public Card(int r, int s) {
        number= r;
        suit = s;
    }
    public int getRank() {
        return number;
    }
    
    public int getSuit() {
        return suit;
    }
    public int getValue() {
        int value = number;
        if(number> 10){
            value = 10;
        }
        
        if(number== ACE){
            value = 11;
        }
        
        return value;
    }
    public String rankToString(int r) {
        return ranks[r];
    }
    
    public String suitToString(int s) {
        return suits[s];
    }
    public String getSuitAsString() {
        return suitToString(suit);
    }
    public String getRankAsString() {
        return rankToString(number);
    }

    public String toString() {
        String rankString = ranks[rank];
        String suitString = suits[suit];
        return rankString + suitString;
    }

    
}