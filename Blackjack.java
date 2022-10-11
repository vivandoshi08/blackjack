import java.io.*;
import java.util.Scanner;


public class Blackjack {

    Scanner sc = new Scanner(System.in);
    private static final int STARTING_BANKROLL = 100;

    private String getPlayerMove()
    {
        while(true)
        {
            String move = sc.next("Enter hit or stand (h/s): ");
            move = move.toLowerCase();
            
            if(move.equals("h") || move.equals("s"))
            {
                return move;
            }
            System.out.println("Please try again."); 
        }
    }
    
    
    //  Dealer goes and does move.
    private void dealerTurn(Hand dealer, Deck deck)
    {
        while(true)
        {
            System.out.println("Dealer's hand");
            System.out.println(dealer);
            
            int value = dealer.getValue();
            System.out.println("Dealer's hand has value " + value);
            
            sc.next("Enter to continue...");
            
            if(value < 18)
            {
                System.out.println("Dealer hits");
                Card c = deck.deal();
                dealer.addCard(c);
                
                System.out.println("Dealer card = " + c);
                
                if(dealer.busted())
                {
                    System.out.println("Dealer busted");
                }
            }
            else
            {
                System.out.println("Dealer stands");
            }
        }
    }
    
    /**
    Player's hit or stand
     */
    private boolean playerTurn(Hand player, Deck deck) {
        while(true) {
            String move = getPlayerMove();
            
            if(move.equals("h")) {
                Card c = deck.deal();
                System.out.println("Your card was: " + c);
                player.addCard(c);
                System.out.println("Player's hand");
                System.out.println(player);
                if(player.busted()) {
                    return true;
                }
            }
            else if(move.equals("s")) {
                return false;
            }
            
        }
    }
    
    // figure out whether player wins or not

    private boolean playerWins(Hand player, Hand dealer)
    {
        if(player.busted()) {
            return false;
        }
        
        if(dealer.busted()) {
            return true;
        }
        
        return player.getValue() > dealer.getValue();
    }
    
    /**
     Check for Tie
     */
    private boolean push_tie(Hand player, Hand dealer) {
        return player.getValue()==dealer.getValue();
    }
    
    // find result
    private double findWinner(Hand dealer, Hand player, int bet) {
        if(playerWins(player, dealer)) {
            System.out.println("Player has won!");
            if(player.hasBlackjack()){
                return 1.5 * bet;
            }
            
            return bet;
        }
        else if(push_tie(player, dealer)) {
            System.out.println("You push");
            return 0;
        }
        else {
            System.out.println("Dealer wins");
            return bet;
        }
    }
    // Main round
    private double playRound(double bankroll)
    {
        int bet = sc.nextInt("What is your bet? ");
        Deck deck = new Deck();
        deck.shuffle();
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        System.out.println("Player's Hand");
        System.out.println(player);
        System.out.println("Dealer's hand");
        System.out.println(dealer);
        
        boolean playerBusted = playerTurn(player, deck);
        
        if(playerBusted) {
            System.out.println("You busted");
        }
        sc.next("Enter for dealer turn...");
        dealerTurn(dealer, deck);
        double bankrollChange = findWinner(dealer, player, bet);
        bankroll += bankrollChange;
        System.out.println("New bankroll: " + bankroll);
        return bankroll;
    }
    
    /**
     Final Initialization
     */
    public void main() {
        double bankroll = STARTING_BANKROLL;
        System.out.println("Starting bankroll: " + bankroll);
   
        while(true) {
            bankroll = playRound(bankroll);
            
            String playAgain = sc.next("Would you like to play again? (Y/N)");
            if(playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }
        
        System.out.println("Thanks for playing!");
    }
	
}