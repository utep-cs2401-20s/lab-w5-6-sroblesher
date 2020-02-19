public class SnakeGame {
    //ELEMENTS
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //CONSTRUCTORS
    SnakeGame(){
        game = new boolean[1][1];
    }

    SnakeGame(boolean[][] arr, int xCoord, int yCoord) {
        game = new boolean[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                game[i][j] = arr[i][j];
            }
        }

        headPosition = new int[2];
        headPosition[0] = xCoord;
        headPosition[1] = yCoord;
    }

    //METHODS
    public int[] findTailExhaustive() {
        int[] tailAndLength = new int[3];
        int length = 0;

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) {
                    if (neighbors(i,j) == 1 && i != headPosition[0] && j != headPosition[1])
                    length++;
                }
            }
        }

        tailAndLength[2] = length;

        return tailAndLength;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {

    }

    private void resetCounters() {

    }

    private static int getRecursiveChecks() {

    }

    private static int getExhaustiveChecks() {

    }

    public int neighbors(int xCoord, int yCoord) {
        int count = 0;

        if (xCoord - 1 >= 0) if (game[xCoord-1][yCoord]) count++;
        if (yCoord - 1 >= 0) if (game[xCoord][yCoord-1]) count++;
        if (yCoord + 1 <= game.length-1) if (game[xCoord][yCoord+1]) count++;
        if (xCoord + 1 <= game.length-1) if (game[xCoord+1][yCoord]) count++;

        return count;
    }
}
