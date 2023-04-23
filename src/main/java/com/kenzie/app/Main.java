package com.kenzie.app;

// import necessary libraries

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, InputMismatchException {
        String URL = "https://jservice.kenzie.academy/api/clues";
        CustomHttpClient customHttpClient = new CustomHttpClient();

        String allCluesResponseBody = CustomHttpClient.sendGET(URL);
        QuizDTO allClues = CustomHttpClient.getClues(allCluesResponseBody);

        Scanner sc = new Scanner(System.in);

        String yes = "yes";
        boolean firstGame = true;


        System.out.println("1 or 2 players?");
        int numPlayers = sc.nextInt();

        while(!(numPlayers == 1 || numPlayers == 2)){
            System.out.println("Type \"1\" or \"2\" to select number of players");
            numPlayers = sc.nextInt();
        }
        sc.nextLine();


        while (numPlayers == 1 || numPlayers == 2) {
            //One player mode
            if (numPlayers == 1) {
                if (!firstGame) {
                    sc.nextLine();
                }

                System.out.println("Whats player 1's name?");
                String namePlayer1 = sc.nextLine();
                System.out.println("Welcome " + namePlayer1 + "!");
                System.out.println();

                Gameplay onePlayerMode = new Gameplay(namePlayer1);

                onePlayerMode.onePlayerGame(allClues);

                System.out.println("----------\nGame Over! \nYour total score was: " + onePlayerMode.getPlayer1Score());
                System.out.println();
                System.out.println("Type \"yes\" to play again.");
                if (firstGame) {
                    firstGame = false;
                }

                String playAgain = sc.nextLine().toLowerCase().replaceAll(" ", "");


                if (playAgain.equals(yes)) {
                    onePlayerMode.setPlayer1Score(0);
                    System.out.println("1 or 2 players?");
                    numPlayers = sc.nextInt();

                    while (!(numPlayers == 1 || numPlayers == 2)) {
                        System.out.println("Type \"1\" or \"2\" to select number of players");
                        numPlayers = sc.nextInt();
                    }
                } else {
                    numPlayers = -1;
                }
            }
            //Two player mode

            if (numPlayers == 2) {
                if (!firstGame) {
                    sc.nextLine();
                }

                System.out.println("Whats player 1's name?");
                String namePlayer1 = sc.nextLine();
                System.out.println("Welcome " + namePlayer1 + "!");
                System.out.println();

                System.out.println("Whats player 2's name?");
                String namePlayer2 = sc.nextLine();
                System.out.println("Welcome " + namePlayer2 + "!");
                System.out.println();

                Gameplay twoPlayerMode = new Gameplay(namePlayer1, namePlayer2);

                twoPlayerMode.twoPlayerGame(allClues);
                System.out.println("----------\nGame Over! \nPlayer 1's score was: " + twoPlayerMode.getPlayer1Score());
                System.out.println("\nPlayer 2's score was: " + twoPlayerMode.getPlayer2Score());
                System.out.println();
                System.out.println("Type \"yes\" to play again.");
                String playAgain = sc.nextLine().toLowerCase().replaceAll(" ", "");

                if (firstGame) {
                    firstGame = false;
                }

                if (playAgain.equals(yes)) {
                    twoPlayerMode.setPlayer1Score(0);
                    twoPlayerMode.setPlayer2Score(0);
                    System.out.println("1 or 2 players?");
                    numPlayers = sc.nextInt();
                    System.out.println(numPlayers);

                    while (!(numPlayers == 1 || numPlayers == 2)) {
                        System.out.println("Type \"1\" or \"2\" to select number of players");
                        numPlayers = sc.nextInt();
                    }
                } else {
                    numPlayers = -1;
                }
            }
        }
        System.out.println("Goodbye! Hope you had fun!");
    }
}

