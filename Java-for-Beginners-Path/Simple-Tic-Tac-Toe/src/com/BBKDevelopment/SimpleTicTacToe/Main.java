package com.BBKDevelopment.SimpleTicTacToe;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static String[][] gameTable = new String[3][3];
    static boolean isGameCompleted = false;
    static String currentPlayer = "X";
    static String winner = "";

    public static void main(String[] args) {
        for(int i = 0; i<3; i++) {
            for(int k = 0; k<3; k++) {
                gameTable[i][k] = " ";
            }
        }

        drawTable();

        for(int i = 0; i<3; i++) {
            for(int k = 0; k<3; k++) {
                while (gameTable[i][k] == " ") {
                    playGame();
                    if(checkStatus()) {
                        System.out.println(winner + " wins");
                        System.exit(0);
                    }
                }
                System.out.println("Draw");
            }
        }
    }

    public static void drawTable() {
        String firstLine = "---------";
        String secondLine = "|" + " " + gameTable[0][0] + " " + gameTable[0][1] + " " + gameTable[0][2] + " " + "|";
        String thirdLine = "|" + " " + gameTable[1][0] + " " + gameTable[1][1] + " " + gameTable[1][2] + " " + "|";
        String fourthLine = "|" + " " + gameTable[2][0] + " " + gameTable[2][1] + " " + gameTable[2][2] + " " + "|";
        String fifthLine = "---------";

        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(fourthLine);
        System.out.println(fifthLine);
    }

    public static void playGame() {
        while(!isGameCompleted) {
            isGameCompleted = makeMove();
        }
        isGameCompleted = false;
        if(currentPlayer == "X") {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    public static boolean makeMove() {
        System.out.print("Enter the coordinates: ");

        String userInput = scanner.nextLine();
        userInput = userInput.replaceAll("\\s+","");
        int first = 0;
        int second = 0;

        try {
            first = Integer.parseInt(String.valueOf(userInput.charAt(0)));
            second = Integer.parseInt(String.valueOf(userInput.charAt(1)));
            System.out.println(first + " " + second);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if(first > 3 || second > 3 || first < 1 || second < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if(!gameTable[first-1][second-1].equals(" ")) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        gameTable[first-1][second-1] = currentPlayer;
        drawTable();
        return true;
    }

    public static boolean checkStatus() {
        for(int i = 0; i<3; i++) {
            if(gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] != " "){
                winner = gameTable[i][0];
                return true;
            }
        }

        for(int i = 0; i<3; i++) {
            if(gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] != " "){
                winner = gameTable[i][0];
                return true;
            }
        }

        if(gameTable[0][0] == gameTable[1][1] && gameTable[0][0] == gameTable[2][2] && gameTable[0][0] != " ") {
            winner = gameTable[0][0];
            return true;
        } else if(gameTable[0][2] == gameTable[1][1] && gameTable[0][2] == gameTable[2][0] && gameTable[0][2] != " ") {
            winner = gameTable[0][2];
            return true;
        } else if(gameTable[0][0] == gameTable[1][0] && gameTable[0][0] == gameTable[2][0] && gameTable[0][0] != " ") {
            winner = gameTable[0][0];
            return true;
        } else if(gameTable[0][1] == gameTable[1][1] && gameTable[0][1] == gameTable[2][1] && gameTable[0][1] != " ") {
            winner = gameTable[0][1];
            return true;
        } else if(gameTable[0][2] == gameTable[1][2] && gameTable[0][2] == gameTable[2][2] && gameTable[0][2] != " ") {
            System.out.println("abc7");
            winner = gameTable[0][2];
            return true;
        } else
            return false;
    }
}
