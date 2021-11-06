package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private List<Board> boards = new ArrayList<>();

    int shipChoice;
    List<Integer> CoordinatesAndShipType = new ArrayList<>();

    public List<Board> getBoards() {
        generateBoard();
        return boards;
    }

    public void generateBoard() {
        System.out.println("Select height: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select width: ");
        int y = scanner.nextInt();

        Board board1 = new Board(x, y);
        Board board2 = new Board(x, y);

        boards.add(board1);
        boards.add(board2);

    }

    public Input() {

    }

    public int getIntegerMenuOption() {
        shipChoice = scanner.nextInt();
        scanner.nextLine();
        return shipChoice;
    }


    private List<Integer> askCoordinatesForShipAndType() {
        this.CoordinatesAndShipType = new ArrayList<>();
        System.out.println("Select row: ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select col: ");
        int col = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Select ship: \n" + "1) Carrier \n2)Cruiser\n3)Battleship\n4)Destroyer\n5)Submarine");
        int shipType = scanner.nextInt();

        CoordinatesAndShipType.add(row);
        CoordinatesAndShipType.add(col);
        CoordinatesAndShipType.add(shipType);

        return CoordinatesAndShipType;

    }

    public Ship createShip(int player) {
        int GamePlayer = player + 1;
        Square shipPart;
        Ship ship;

        System.out.println("Player " + GamePlayer + " - place the ship");
        CoordinatesAndShipType = askCoordinatesForShipAndType();

        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);

        shipPart = new Square(row, col, SquareStatus.SHIP);

        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType - 1]);

        boards.get(player).buildShip(shipPart, ship);

        return ship;
    }

    public int[] shoot(int player) {
        int GamePlayer = player + 1;
        System.out.println("Player " + GamePlayer + " shoot!");
        System.out.println("Select row: ");
        int row = scanner.nextInt();
        System.out.println("Select col: ");
        int col = scanner.nextInt();
        return new int[]{row, col} ;
    }


}
