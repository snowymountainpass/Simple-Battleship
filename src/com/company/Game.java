package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Ship> shipsPlayer1 = new ArrayList<>();
    private List<Ship> shipsPlayer2 = new ArrayList<>();

    List<Board> boards;

    public void gameLogic(){
        Input board = new Input();
        boards = board.getBoards();
        Board boardPlayer1 = boards.get(0);
        Board boardPlayer2 = boards.get(1);

        for(int i=0;i<2;i++ ){
            Ship one = board.createShip(0);
            while (!one.isPlacementOk(one, shipsPlayer1, boardPlayer1)){
                one = board.createShip(0);
            }
            shipsPlayer1.add(one);
        }

        for(int i=0;i<2;i++ ){
            Ship one = board.createShip(1);
            while (!one.isPlacementOk(one, shipsPlayer1, boardPlayer2)){
                one = board.createShip(1);
            }
            shipsPlayer2.add(one);
        }

        Player player1 = new Player(shipsPlayer1,boardPlayer2);
        Player player2 = new Player(shipsPlayer2,boardPlayer1);

        boolean gameRun = true;

        Display display = new Display();

        System.out.println("----------Player1 Board----------");
        display.printBoard(boardPlayer1);

        System.out.println("---------------------------");

        System.out.println("----------Player2 Board----------");
        display.printBoard(boardPlayer2);

        int numberOfShipsPlayer1 = player1.numberOfShipSquares(shipsPlayer1);
        int numberOfShipsPlayer2 = player2.numberOfShipSquares(shipsPlayer2);

        while (gameRun){
            int[] shootCoordinates;
            shootCoordinates = board.shoot(0);
            if(player2.handleShooting(shootCoordinates[0],shootCoordinates[0])){
                numberOfShipsPlayer2--;
            }
            display.printBoard(player2.getBoard());


            if(numberOfShipsPlayer2 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println("Player1 wins!");
                break;
            }

            shootCoordinates = board.shoot(1);
            if(player1.handleShooting(shootCoordinates[0],shootCoordinates[0])){
                numberOfShipsPlayer1--;
            }
            display.printBoard(player1.getBoard());

            if(numberOfShipsPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("Player2 wins!");
                break;
            }

        }

    }


}
