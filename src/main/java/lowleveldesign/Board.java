package lowleveldesign;

public class Board {
    private int size;
    private char[][] grid;
    private char emptySymbol = '-';
    private int filledCells = 0;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = emptySymbol;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size &&grid[row][col] == emptySymbol;
    }

    public boolean fillCell(int row, int col, char symbol) {
        if(!isValidMove(row, col)) {
            System.out.println("Invalid move!");
            return false;
        }
        grid[row][col] = symbol;
        filledCells++;
        return true;
    }

    public boolean checkWin(int row, int col, char symbol) {
        // check row
        boolean win = true;
        for(int j = 0; j < size; j++) {
            if(grid[row][j] != symbol) {
                win = false;
                break;
            }
        }
        if(win) {
            return true;
        }

        // check column
        win = true;
        for(int i = 0; i < size; i++) {
            if(grid[i][col] != symbol) {
                win = false;
                break;
            }
        }
        if(win) {
            return true;
        }

        // check diagonal
        if(row == col) {
            win = true;
            for(int i = 0; i < size; i++) {
                if(grid[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) {
                return true;
            }
        }

        // check anti-diagonal
        if(row + col == size - 1) {
            win = true;
            for(int i = 0; i < size; i++) {
                if(grid[i][size - i - 1] != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) {
                return true;
            }
        }
        return false;
    }

    public boolean areAllCellsFilled() {
        return filledCells == size*size;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
