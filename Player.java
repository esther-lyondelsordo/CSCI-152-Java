package LoDiceList;


public class Player {
    int playerNumber;
    String Name;
    int totalScore;
    int currentScore;
    int winnings;
    int round;
    Player next;

    // Constructor to create a new node
    // Next is by default initialized
    // as null
    Player(int playerNumber, String Name, int totalScore, int currentScore, int winnings, int round) {
        this.playerNumber = playerNumber;
        this.Name = Name;
        this.totalScore = totalScore;
        this.currentScore = currentScore;
        this.winnings = winnings;
        this.round = round;
        this.next = null;
    }

    //default constructor
//    Player() {
//    }

}
