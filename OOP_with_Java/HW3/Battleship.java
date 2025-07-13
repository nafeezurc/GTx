import java.util.Scanner;

public class Battleship {

    final static int MAX_INPUT = 5;
    final static int NUM_SHIPS = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!\n");
        Scanner input = new Scanner(System.in);
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        char[][] player1 = populateGrid(input);
        printBattleShip(player1);

        int i = 0;
        do { // gap so players can't see each other's boards
            System.out.println("");
            i++;
        } while(i < 100);
        
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        char[][] player2 = populateGrid(input);
        printBattleShip(player2);

        i = 0;
        do {
            System.out.println("");
            i++;
        } while(i < 100);

        char[][] p1History = new char[MAX_INPUT][MAX_INPUT];
        char[][] p2History = new char[MAX_INPUT][MAX_INPUT];
        fill(p1History);
        fill(p2History);

        int p1Lives = NUM_SHIPS;
        int p2Lives = NUM_SHIPS;

        boolean p1Turn = true;
        while(p1Lives > 0 && p2Lives > 0) {
            char[][] turnPlayer = p1Turn ? player1 : player2; // create alias to determine which player's turn it is
            char[][] waitPlayer = !p1Turn ? player1 : player2; // alias to determine which player is waiting
            char[][] turnHistory = p1Turn ? p1History : p2History; // create alias to determine which history board will be updated this turn
            System.out.println("Player " + (p1Turn ? 1 : 2) + ", enter hit row/column:");
            int x;
            int y;
            if(input.hasNextInt()) {
                x = input.nextInt();
                if(input.hasNextInt()) {
                    y = input.nextInt();
                    if(x < 0 || x >= MAX_INPUT || y < 0 || y > MAX_INPUT) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        continue;
                    }
                    if(waitPlayer[x][y] == '@') { // hit logic
                        System.out.println("PLAYER " + (p1Turn ? 1 : 2) + " HIT PLAYER " + (p1Turn ? 2 : 1) + "'s SHIP!");
                        waitPlayer[x][y] = 'X';
                        turnHistory[x][y] = 'X';
                        if(p1Turn) { // lives decremented based on whose turn it is
                            p2Lives--;
                        }
                        else {
                            p1Lives--;
                        }
                    }
                    else if(!(waitPlayer[x][y] == '-')) { // checks if a spot has been targetted
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        continue;
                    }
                    else { // miss otherwise
                        System.out.println("PLAYER " + (p1Turn ? 1 : 2) + " MISSED!");
                        waitPlayer[x][y] = 'O';
                        turnHistory[x][y] = 'O';
                    }
                }
            }
            printBattleShip(turnHistory);
            if(p1Lives > 0 && p2Lives > 0) System.out.println("");
            p1Turn = !p1Turn;
        }

        System.out.println("PLAYER " + (!p1Turn ? 1 : 2) + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n\nFinal boards:\n");
        printBattleShip(player1);
        System.out.println("");
        printBattleShip(player2);

    }
    
    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static char[][] populateGrid(Scanner input) {
        char[][] grid = new char[MAX_INPUT][MAX_INPUT];
        fill(grid);
        for(int i = 0; i < NUM_SHIPS; i++) {
            System.out.println("Enter ship " + (i + 1) + " location:");
            int x;
            int y;
            if(input.hasNextInt()) {
                x = input.nextInt();
                if(input.hasNextInt()) {
                    y = input.nextInt();
                    if(x < 0 || x >= MAX_INPUT || y < 0 || y >= MAX_INPUT) { // check for valid inputs
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        i--;
                        continue;
                    }
                    if(grid[x][y] == '@') { // check if spot is already populated
                        System.out.println("You already have a ship there. Choose different coordinates.");
                        i--;
                        continue;
                    }
                    else {
                        grid[x][y] = '@';
                    }
                }
                else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    i--;
                    continue;
                }
            }
            else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                i--;
            }
        }

        return grid;
    }

    private static void fill(char[][] grid) { // fill method to populate grids with default value '-'
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
            }
        }
    }

}
