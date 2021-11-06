package com.company;

public class Battleship {

    private Display display;
    private Game game = new Game();

    private Input input;

    public Battleship(){
        display = new Display();

    }

    public void start(){
        display.printMenu();
        mainMenu();
    }

    public void mainMenu(){
        int choice;
        boolean exit = false;

        input = new Input();

        while (true){
            display.printMainMenuOptions();
            System.out.println("Enter your choice: \n");
            choice = input.getIntegerMenuOption();

            switch (choice) {
                case 0:
                    display.printMessages("Play the game");
                    game.gameLogic();
                    break;
                case 1:
                    System.out.flush();
                    display.printGameRules();
                    break;
                case 2:
                    display.printMessages("Exit the game");
                    exitGame();
                    break;
            }
        }
    }
    public void exitGame(){
        display.printExitMessage();
        System.exit(1);
    }
}
