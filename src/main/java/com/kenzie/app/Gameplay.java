package com.kenzie.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameplay {
    private int player1Score;
    private int player2Score;
    private String namePlayer1;
    private String namePlayer2;

    public Gameplay(String namePlayer1){
        this.player1Score = 0;
        this.player2Score = 0;
        this.namePlayer1 = namePlayer1;
    }

    public Gameplay(String namePlayer1, String namePlayer2){
        this.player1Score = 0;
        this.player2Score = 0;
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public void setNamePlayer1(String namePlayer1) {
        this.namePlayer1 = namePlayer1;
    }

    public String getNamePlayer2() {
        return namePlayer2;
    }

    public void setNamePlayer2(String namePlayer2) {
        this.namePlayer2 = namePlayer2;
    }

    public void onePlayerGame(QuizDTO allClues) {
        for (int i = 0; i < 10; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("----------");
            System.out.println("Question " + (i + 1) + ":");
            System.out.println("----------");

            int number = (int) (Math.random() * 100);
            Clues currentQuestion = allClues.getClues().get(number);
            System.out.println(currentQuestion.toString());
            String userAnswer = sc.nextLine();


            try {
                if (userAnswer.equals("")) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                while (userAnswer.equals("")) {
                    System.out.println("Please type your answer!");
                    userAnswer = sc.nextLine();
                }
            }

            if (userAnswer.toLowerCase().replaceAll(" ", "")
                    .equals(currentQuestion.getAnswer().toLowerCase()
                            .replaceAll(" ", ""))) {
                System.out.println("Congrats " + getNamePlayer1() + ", You are correct!");
                player1Score++;
                System.out.println("Your score: " + getPlayer1Score());
            } else {
                System.out.println("I'm sorry " + getNamePlayer1() + ", that's not the right answer." +
                        "\nThe correct answer was: " + currentQuestion.getAnswer());
                System.out.println("Your score: " + getPlayer1Score());
            }

            System.out.println();
        }
    }

    public void twoPlayerGame(QuizDTO allClues){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            //player 1 turn
            System.out.println("Player 1");
            System.out.println("----------");
            System.out.println("Question " + (i + 1) + ":");
            System.out.println("----------");
            int number = (int) (Math.random() * 100);
            Clues currentQuestion = allClues.getClues().get(number);
            System.out.println(currentQuestion.toString());
            String userAnswer = sc.nextLine();


            try {
                if (userAnswer.equals("")){
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException e){
                while(userAnswer.equals("")){
                    System.out.println("Please type your answer!");
                    userAnswer = sc.nextLine();
                }
            }

            if (userAnswer.toLowerCase().replaceAll(" ", "")
                    .equals(currentQuestion.getAnswer().toLowerCase()
                            .replaceAll(" ", ""))) {
                System.out.println("Congrats " + getNamePlayer1() + ", You are correct!");
                player1Score++;
                System.out.println("Player 1's score: " + getPlayer1Score());
            } else {
                System.out.println("I'm sorry " + getNamePlayer1() + ", that's not the right answer." +
                        "\nThe correct answer was: " + currentQuestion.getAnswer());
                System.out.println("Player 1's score: " + getPlayer1Score());
            }
            System.out.println();
            //player 2 turn
            System.out.println("Player 2");
            System.out.println("----------");
            System.out.println("Question " + (i + 1) + ":");
            System.out.println("----------");
            number = (int) (Math.random() * 100);
            currentQuestion = allClues.getClues().get(number);
            System.out.println(currentQuestion.toString());
            userAnswer = sc.nextLine();

            try {
                if (userAnswer.equals("")){
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException e){
                while(userAnswer.equals("")){
                    System.out.println("Please type your answer!");
                    userAnswer = sc.nextLine();
                }
            }

                if (userAnswer.toLowerCase().replaceAll(" ", "")
                        .equals(currentQuestion.getAnswer().toLowerCase()
                                .replaceAll(" ", ""))) {
                    System.out.println("Congrats " + getNamePlayer2() + ", You are correct!");
                    player2Score++;
                    System.out.println("Player 2's score: " + getPlayer2Score());
                } else {
                    System.out.println("I'm sorry " + getNamePlayer2() + ", that's not the right answer." +
                            "\nThe correct answer was: " + currentQuestion.getAnswer());
                    System.out.println("Player 2's score: " + getPlayer2Score());
                }
                System.out.println();
            }
    }

}
