package algorithms.backtracking.boggle;

import java.util.Arrays;
import java.util.List;

/**
 * A class to demonstrate Boggle game solution using backtracking algorithm.
 */
public class BoggleDemo {
    // Dictionary of valid words
    static final List<String> dictionary = Arrays.asList(
            "RAY", "APPLE", "FAKE", "BOOKS"
    );
    // Size of the boggle board
    static final int M = 4, N = 4;
    
    /**
     * Main method to demonstrate Boggle solving algorithm.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Boggle board configuration
        char[][] boggle = {
                {'T', 'Y', 'R', 'S'},
                {'N', 'U', 'A', 'K'},
                {'Z', 'F', 'E', 'O'},
                {'A', 'C', 'B', 'O'}
        };
        
        // 2D array to keep track of visited cells
        int visited[][] = new int[M][N];
        String str = "";
        
        // Start exploring words from each cell in the boggle board
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                findWords(boggle, visited, i, j, str);
            }
        }
    }
    
    /**
     * Recursive method to find words starting from a specific cell.
     *
     * @param boggle  The boggle board
     * @param visited 2D array to keep track of visited cells
     * @param i       Current row index
     * @param j       Current column index
     * @param word    The current word being formed
     */
    private static void findWords(char[][] boggle, int[][] visited, int i, int j, String word) {
        visited[i][j] = 1;
        word = word + boggle[i][j];
        
        // If the formed word is in the dictionary, print it
        if (dictionary.contains(word)) {
            System.out.println(word);
        }
        
        // Explore all neighboring cells
        for (int row = i - 1; row <= i + 1; row++) {
            for (int col = j - 1; col <= j + 1; col++) {
                if (isValid(row, col, visited)) {
                    findWords(boggle, visited, row, col, word);
                }
            }
        }
        
        // Backtrack: Mark the current cell as not visited
        visited[i][j] = 0;
    }
    
    /**
     * Checks if a cell is valid and has not been visited before.
     *
     * @param row     Row index of the cell
     * @param col     Column index of the cell
     * @param visited 2D array to keep track of visited cells
     * @return True if the cell is valid and not visited, false otherwise
     */
    private static boolean isValid(int row, int col, int[][] visited) {
        return (row >= 0 && row < M && col >= 0 && col < N && visited[row][col] == 0);
    }
}
