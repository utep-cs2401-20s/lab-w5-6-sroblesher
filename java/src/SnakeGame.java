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

        resetCounters();

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) {
                    if (neighbors(i,j) == 1 && i != headPosition[0] && j != headPosition[1]){
                        tailAndLength[0] = i;
                        tailAndLength[1] = j;
                    }
                    length++;
                }
                exhaustiveChecks++;
            }
        }

        tailAndLength[2] = length;

        return tailAndLength;
    }

    public int[] findTailRecursive() {
        int tailAndLength[] = {-1, -1, -1};
        resetCounters();

        return tailAndLength;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

        if (neighbors(currentPosition[0], currentPosition[1]) == 1) {
            int tailAndLength[] = new int[3];
            tailAndLength[0] = currentPosition[0];
            tailAndLength[1] = currentPosition[1];
            return tailAndLength;
        }

        if (currentPosition[0]-1 >= 0)
            if (currentPosition[0]-1 != previousPosition[0] && currentPosition[1] != previousPosition[1]) {
                recursiveChecks++;
                if (game[currentPosition[0] - 1][currentPosition[1]]) {
                    findTailRecursive();
                }
            }

    }

    private void resetCounters() {
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks() {
        return recursiveChecks;
    }

    private static int getExhaustiveChecks() {
        return exhaustiveChecks;
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
