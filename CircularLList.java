package LoDiceList;

import java.awt.*;
import java.util.Objects;

public class CircularLList {
    Player head;

    //constructors
    CircularLList() {
        head = null;
    }

    public void insertPlayer(int playerNumber, String Name, int totalScore, int currentScore, int winnings, int round) {
        //new node with value to add to list
        Player newPlayer = new Player(playerNumber, Name, totalScore, currentScore, winnings, round);

        //new node for traversals
        Player curr = head;

        //inserting into empty list
        if (head == null) {
            System.out.println("Inserting into empty Circular list");
            head = newPlayer;
            newPlayer.next = head;
        }
        //head.next = newNode;

        // insert at end of list
        else  {
            System.out.println("Insert at end of Circular list");

            while ((curr.next != head)&&(curr.next != null)) {
                curr = curr.next;
            }
            curr.next  = newPlayer;
            newPlayer.next = head;

        }
    } //end insertPlayer

    public void printList() {
        Player curr = head;
        do {
            System.out.println("Player " + curr.playerNumber + " Name: " + curr.Name + " Score: " + curr.totalScore +
                    " Rounds played: " + curr.round + " Money won: " + curr.winnings);
            System.out.println();
            curr = curr.next;
        } while(curr != head);

    } //end printList

    //make dice
    int die1;
    int die2;
    int die3;
    //method to roll dice
    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        die3 = (int)(Math.random()*6) + 1;
    }

    public void playRound() {
        Player current = head, index = current.next;

        //traverse players, roll 3 dice until scoring possible and add points to currentScore
        do {
            //reset current scores
            if (current != null) {
                current.currentScore = 0;
            }
            System.out.println("Player :" + current.Name + " is rolling the dice: ");
            roll();

            if ((die1 == 1)&&(die2 == 1)&&(die3 == 1)) {
                System.out.println(current.Name + " rolled triple 1s for 7 points");
                current.currentScore += 7;
            }
            else if ((die1 == 2)&&(die2 == 2)&&(die3 == 2)) {
                System.out.println(current.Name + " rolled triple 2s for 8 points");
                current.currentScore += 8;
            }
            else if ((die1 == 3)&&(die2 == 3)&&(die3 == 3)) {
                System.out.println(current.Name + " rolled triple 3s for 9 points");
                current.currentScore += 9;
            }
            else if ((die1 == 4)&&(die2 == 4)&&(die3 == 4)) {
                System.out.println(current.Name + " rolled triple 4s for 10 points");
                current.currentScore += 10;
            }
            else if ((die1 == 5)&&(die2 == 5)&&(die3 == 5)) {
                System.out.println(current.Name + " rolled triple 5s for 11 points");
                current.currentScore += 11;
            }
            else if ((die1 == 6)&&(die2 == 6)&&(die3 == 6)) {
                System.out.println(current.Name + " rolled triple 6s for 12 points");
                current.currentScore += 12;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 1))||((Objects.equals(die2, die3))&&(die1 == 1))||
                    ((Objects.equals(die1, die3))&&(die2 == 1))) {
                System.out.println(current.Name + " rolled a point 1");
                current.currentScore += 1;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 2))||((Objects.equals(die2, die3))&&(die1 == 2))||
                    ((Objects.equals(die1, die3))&&(die2 == 2))) {
                System.out.println(current.Name + " rolled a point 2");
                current.currentScore += 2;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 3))||((Objects.equals(die2, die3))&&(die1 == 3))||
                    ((Objects.equals(die1, die3))&&(die2 == 3))) {
                System.out.println(current.Name + " rolled a point 3");
                current.currentScore += 3;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 4))||((Objects.equals(die2, die3))&&(die1 == 4))||
                    ((Objects.equals(die1, die3))&&(die2 == 4))) {
                System.out.println(current.Name + " rolled a point 4");
                current.currentScore += 4;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 5))||((Objects.equals(die2, die3))&&(die1 == 5))||
                    ((Objects.equals(die1, die3))&&(die2 == 5))) {
                System.out.println(current.Name + " rolled a point 5");
                current.currentScore += 5;
            }
            else if (((Objects.equals(die1, die2))&&(die3 == 6))||((Objects.equals(die2, die3))&&(die1 == 6))||
                    ((Objects.equals(die1, die3))&&(die2 == 6))) {
                System.out.println(current.Name + " rolled a point 6");
                current.currentScore += 6;
            }
                else if (((die1 == 4)&&(die2 == 5)&&(die3 == 6))||((die1 == 4)&&(die2 == 6)&&(die3 == 5))||
                        ((die1 == 5)&&(die2 == 4)&&(die3 == 6))||((die1 == 5)&&(die2 == 6)&&(die3 == 4))||
                        ((die1 == 6)&&(die2 == 4)&&(die3 == 5))||((die1 == 6)&&(die2 == 5)&&(die3 == 4))) {
                    System.out.println(current.Name + " rolled a point 4,5,6 for 13 points!");
                    current.currentScore += 13;
                }
                else if (((die1 == 1)&&(die2 == 2)&&(die3 == 3))||((die1 == 1)&&(die2 == 3)&&(die3 == 2))||
                        ((die1 == 2)&&(die2 == 1)&&(die3 == 3))||((die1 == 2)&&(die2 == 3)&&(die3 == 1))||
                        ((die1 == 3)&&(die2 == 1)&&(die3 == 2))||((die1 == 3)&&(die2 == 2)&&(die3 == 1))) {
                    System.out.println(current.Name + " rolled a point 1,2,3 for 0 points");
                    current.currentScore += 0;

                }
            else {
                System.out.println(current.Name + " rolled for 0 points");
                current.currentScore += 0;
            }

            index = index.next;

            current.round += 1;
            current.totalScore += current.currentScore;
            current = current.next;
        }while (current != head);
        sortList();
        printList();
        //call checkForTies after each player gets a valid roll
        checkForTies();
    } // end playRound


    public void checkForTies() {
        // make a circular list for tied players
        System.out.print("Checking for ties: ");
        CircularLList tiedPlayers = new CircularLList();

        //sort list so all ties are next to each other
        sortList();
        //traverse list to see if any of the current Scores are equal
        int numTies = 0;
        Player current = head, index = current.next;
        do {
            //Index will point to node next to current
            if ((current.currentScore == index.currentScore)&&(current != null)) {
                tiedPlayers.insertPlayer(current.playerNumber, current.Name, current.totalScore,
                        current.currentScore, current.winnings, current.round);
                tiedPlayers.insertPlayer(index.playerNumber, index.Name, index.totalScore,
                        index.currentScore, index.winnings, index.round);
                System.out.println("Tie found between " + current.Name + " and " + index.Name);
                numTies++;
            }
            index = index.next;
//            while (index != head) {
//                //If if the scores of current and the one after are equal,
//                // shallow copy the players to tiedPlayers, increment numTies
//
//            }
            current = current.next;
        }while (current != head);

        //if tiedPlayers is not empty, call playTieRound
        if (numTies != 0) {
            System.out.println("entering playoff round for tied players: ");
            tiedPlayers.playRound();
        }

    }


    // method to sort the list by descending order of total score
    public void sortList() {
        //Current will point to head
        Player current = head, index = null;
        Player temp = new Player(0,"",0,0,0,0);
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Sorting the list: ");
            do{
                //Index will point to node next to current
                index = current.next;
                while(index != head) {
                    //If current node is greater than index data, swaps the data
                    if(current.totalScore < index.totalScore) {
                        //swap temp and current
                        temp.playerNumber = current.playerNumber;
                        temp.Name = current.Name;
                        temp.totalScore =current.totalScore;
                        temp.currentScore = current.currentScore;
                        temp.winnings = current.winnings;
                        temp.round = current.round;
                        //swap current and index
                        current.playerNumber = index.playerNumber;
                        current.Name = index.Name;
                        current.totalScore = index.totalScore;
                        current.currentScore = index.currentScore;
                        current.winnings = index.winnings;
                        current.round = index.round;
                        //swap index and temp
                        index.playerNumber = temp.playerNumber;
                        index.Name = temp.Name;
                        index.totalScore = temp.totalScore;
                        index.currentScore = temp.currentScore;
                        index.winnings = temp.winnings;
                        index.round = temp.round;
                    }
                    index= index.next;
                }
                current =current.next;
            }while(current != head);
            System.out.println("Sorted list: ");
            printList();
            System.out.println();
        }
//        Player current = head, index = current.next;
//        int numPlayers = 0;
//        //set tail pointer
//        do {
//            numPlayers++;
//            current = current.next;
//        } while(current != head);
//        System.out.println("number of players = " + numPlayers);
//
//        // sort
//        if (head == null) {
//            System.out.println("List is empty");
//        }
//        else {
//            System.out.println("Sorting the list: ");
//            for (int i = 0; i < numPlayers; i++) {
//                current = head;
//                index = head.next;
//                for (int j = 0; j < (numPlayers - 1); j++) {
//                    System.out.println("current.totalScore: " + current.totalScore + " index.totalScore: " + index.totalScore);
//                    if (current.totalScore < index.totalScore) {
//                        Player temp = current;
//                        current = index;
//                        index = temp;
//                    }
//                    current = index;
//                    index = index.next;
//
//                }
//            }
//            do {
//                //Index will point to node next to current
//                index = current.next;
//                do {
//                    //If current node is less than index data, swaps the data
//                    if (current.totalScore < index.totalScore) {
//                        temp = current.totalScore;
//                        current.totalScore = index.totalScore;
//                        index.totalScore = temp;
//                    }
//                    index = index.next;
//                } while (index != head);
//                current = current.next;
//            }while (current != head);
//        }
    } // end sortList


} //end CircularLList

