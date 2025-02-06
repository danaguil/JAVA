import java.util.Scanner;

public class TicTacToe {
    // include helper functions for functions that are going run in main
    // Board size will be a row and column of 3, will be used in functions
    final int BoardSize = 3;

    // Status will be used for game Status, either WIN, DRAW, or CONT
    // enum (data type) reps const values in related groups
    public enum Status {WIN, DRAW, CONTINUE}

    // board will have 3 arrays (2D arrays) with each reps the rows, then inside will have 3 object
    // so that it can reps the column
    // moves can be entered in EVEN index starting from 0,2,4
    char[][] board = {{' ' ,'|', ' ', '|', ' '}, {' ' ,'|', ' ', '|', ' '}, {' ' ,'|', ' ', '|', ' '}};

    // adding the players boolean for the game, true to start off
    boolean firstPlayer = true;

    // adding boolean for gameStatues, false to continue game
    boolean gameOver = false;

    // counting moves to check draws
    int moveCount = 0;

    /* gameStatus()
            function will be have the Status, can will be a tool for the for loop before
            We start another round
            It will check the board
            If any placement is occupied or not, or it there's no more (tie)
            If there's a winner in alignment
     */
    public Status gameStatus() {
        // Check rows and columns in a single loop
        for (int i = 0; i < BoardSize; i++) {
            if (board[i][0] == board[i][2] && board[i][2] == board[i][4] && board[i][0] != ' ')
                return Status.WIN; // Row check
            if (board[0][i * 2] == board[1][i * 2] && board[1][i * 2] == board[2][i * 2] && board[0][i * 2] != ' ')
                return Status.WIN; // Column check
        }

        // Check diagonals
        if ((board[0][0] == board[1][2] && board[1][2] == board[2][4] && board[0][0] != ' ') ||
                (board[0][4] == board[1][2] && board[1][2] == board[2][0] && board[0][4] != ' ')) {
            return Status.WIN;
        }

        if (moveCount >= 9) return Status.DRAW; // Check for draw based on move count

        return Status.CONTINUE;
    }

    /*  add play() public function
        loops until a player wins, and will also be calling printBoard() through loop
    */
    public void play(){
        while (!gameOver) {  // Loop until the game ends
            // print board first
            printBoard();
            // get the status of the game using gameStatus()
            Status gameStat = gameStatus();

            switch (gameStat) {
                // WIN CASE, prints out winner message
                case WIN:
                    if (!firstPlayer) { // Sets winner from gameStatues
                        System.out.println("Player X wins");
                    } else {
                        System.out.println("Player O wins");
                    }
                    gameOver = true; // game is over
                    break;
                case DRAW: // simple output message of a tie
                    System.out.println("It's a tie");
                    gameOver = true; // game is over
                    break;
                case CONTINUE:
                    // we need to know what player is next, return num to printStatus to get their move
                    if (firstPlayer) {
                        printStatus(1);
                    } else {
                        printStatus(2);
                    }
                    firstPlayer = !firstPlayer; // switch players turn
                    moveCount++;
                    break;
            }
        }
    }

    /* printStatus(player, int)
        just outputting the standing for each player
        Also going to ask what position for their move
            going to run validMove()
     */
    public void printStatus(int player) {
        Scanner scanner = new Scanner(System.in); // for inputting values

        String tempPlayer;
        if (player == 1){
            tempPlayer = "X";
        } else {
            tempPlayer = "O";
        }

        System.out.println("Player " + tempPlayer + "'s turn");

        int row, column;

        while (true) { // Keep asking until valid input
            System.out.print("Player " + tempPlayer + ": Enter row (1, 2, or 3): ");
            if (scanner.hasNextInt()) { // checks if we get an integer
                row = scanner.nextInt() - 1; // Convert to 0-based index if it is, helps us with the special array
                if (row < 0 || row >= BoardSize) { // Check if out of bounds
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                    scanner.nextLine(); // Clears
                    continue;
                } // can't add this to validMove because we won't have 'columns' value to add in
            } else { // case if we get a string/char
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            // same idea but with column
            System.out.print("Player " + tempPlayer + ": Enter column (1, 2, or 3): ");
            if (scanner.hasNextInt()) {
                column = scanner.nextInt() - 1;
                if (column < 0 || column >= BoardSize) {
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                    scanner.nextLine();
                    continue;
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            if (validMove(column, row)) { // If valid move, break loop
                break;  // repeats if we don't have a valid values
            }
        }

        printSymbol(column, row, tempPlayer.charAt(0));
        moveCount++;
    }


    /* validMove()
            Before it prints symbol onto the board, function will decide if it's valid
            If it's a valid choice between the rows and the column
            and if it's not occupied
     */
    public boolean validMove(int column, int row) {
        if (board[row][column * 2] != 'X' && board[row][column * 2]  != 'O') {
                return true;
        }
        System.out.println("Invalid Position!!");
        return false;
    }

    /* printSymbol()
            Printing the current players symbol to the placement of choice
            Used part of printBoard
     */
    public void printSymbol(int column, int row, char value) {
        board[row][column * 2] = value;
    }

    /* add printBoard() function
          - prints the content of the board in loops until the game end
          - print out using strings
     */
        public void printBoard(){
            for (int i = 0; i < BoardSize; i++) {  // Loop through rows
                System.out.println("\t\t|\t\t|");   // Empty line
                for(int j = 0; j < BoardSize + 2; j++) { // added 2 for the '|' in board, it's in the 2D array as well
                    System.out.print("\t" + board[i][j]);
                }
                // Print separator line except for the last row
                if (i < 2) {
                    System.out.println("\n _______|_______|_______");
                }
            }
            System.out.println("\n"); // new line
        }
}
