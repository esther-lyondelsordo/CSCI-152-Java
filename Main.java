package LoDiceList;

public class Main {

    public static void main(String[] args) {
        //make a list
        CircularLList A = new CircularLList();

        //add 5 players
        A.insertPlayer(1, "Esther", 0, 0, 0, 0);
        A.insertPlayer(2, "Rhys", 0, 0, 0, 0);
        A.insertPlayer(3, "Madi", 0, 0, 0, 0);
        A.insertPlayer(4, "Julia", 0, 0, 0, 0);
        A.insertPlayer(5, "Nick", 0, 0, 0, 0);

        //initialize
        int highScore = 0;

        //game
        //while (totalScore < 20 for all players)
        while (highScore < 20) {
            //add bets before each round
            int cookingPot = 0;
            Player current = A.head;

            do {
                cookingPot += 1;
                current = current.next;
            }while (current != A.head);

            //call playRound method for each round
            A.playRound();

            //calculate high score
            A.sortList();
            //player with highest score is now in first node
            System.out.println("high score is: " + A.head.totalScore);
            highScore = A.head.totalScore;

            // add money to high scoring person's winnings
            System.out.print(A.head.Name + " won $" + cookingPot + " ");
            System.out.println();
            A.head.winnings += cookingPot;

        } //end while

        A.sortList();
        System.out.println("Final Scores: ");
        A.printList();

    }
}
