

public class CountConnectedCells {
    static int num = 0;
    static int[][] grid = new int[6][6];

    // count the connected cells (above, below, left, right)
    // 0=water, 1=land, 2=been there done that 
    public static int count(int[][] grid, boolean[][] visited, int r, int c) {

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (Math.abs(i - r) + Math.abs(j - c) != 1) {
                    continue;
                }
                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                    continue;
                }
                if(visited[i][j])
                {
                    continue;
                }
                if (grid[i][j] != 1) {
                    continue;
                }

                visited[i][j] = true;
                num++;
                count(grid, visited, i, j);
            }
        }
        // ************************************
        // ************************************
        // ****** check all stopping conditions
        //        (the base cases)
        // ************************************
        // ************************************

        // FINISH ME
        // base case #1
        // see if we are off the board
        // if so, how many cells were connected?


        // FINISH ME
        // base case #2
        // see if we have ocean
        // if so, how many cells were connected?

        // FINISH ME
        // see if we have already been here
        // since it is land and we already counted it,
        //     how many connected cells did you find?


        // FINISH ME
        // mark this spot as being visited
        //    so that we don't recurse from here again


        // FINISH ME
        // now try to go North, East, South, and West
        // and return the number of connected cells in
        // each direction (keep adding to your count
        return 0;
    }

    /* public static boolean isValid(int[][] grid, int r, int c) {
        // FINISH ME


    } */


    // main method
    public static void main(String[] args) {

        // FINISH ME
        // declare a reference variable to tell
        // us where the grid is in RAM memory
        //    this will be a 2 dimensional array of
        //    integer numbers (0, 1, or 2)
        //    call the reference variable grid


        // FINISH ME
        // create our grid (matrix, 2D array)
        // and store its memory address in grid


        // fill with all water
        for (int r=0; r<grid.length; r++)
        {
            for (int c=0; c<grid[r].length; c++)
            {
                grid[r][c] = 0;
            }
        }

        // add your land 
        grid[2][3] = 1;
        grid[2][4] = 1;
        grid[2][5] = 1;
        grid[3][5] = 1;


        int numConnectedCells = count(grid, new boolean[6][6], 2, 3);


        System.out.println("Number of connected cells = " + num);



    }
}