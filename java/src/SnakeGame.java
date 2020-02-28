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

        //Copy all elements from the given boolean array to the board game
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
        int[] tailAndLength = {-1,-1,-1};
        int length = 0;

        resetCounters();

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j]) {
                    if (neighbors(i,j) == 1 && !(i == headPosition[0] && j == headPosition[1])) {
                        tailAndLength[0] = i;
                        tailAndLength[1] = j;
                    }
                    length++;
                }
                exhaustiveChecks++;
            }
        }

        tailAndLength[2] = length;

        //If Snake is one square long
        if (tailAndLength[1] == -1) {
            tailAndLength[0] = headPosition[0];
            tailAndLength[1] = headPosition[1];
        }

        return tailAndLength;
    }

    public int[] findTailRecursive() {
        resetCounters();

        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;

        //CHECKING IF IT'S TAIL
        if (neighbors(currentPosition[0], currentPosition[1]) == 1 && recursiveChecks!= 1) {
            int[] tailAndLength = new int[3];
            tailAndLength[0] = currentPosition[0];
            tailAndLength[1] = currentPosition[1];
            tailAndLength[2] = getRecursiveChecks();

            return tailAndLength;
        }

        //CHECKING UPPER SQUARE
        if (currentPosition[0]-1 >= 0)
            //CHECKING FOR OUT OF BOUNDS, AND FOR PREVIOUS
            if (currentPosition[0]-1 != previousPosition[0] || currentPosition[1] != previousPosition[1]) {
                if (game[currentPosition[0] - 1][currentPosition[1]]) {
                    int[] current = {currentPosition[0]-1, currentPosition[1]};
                    //CURRENT IS NOW PREVIOUS
                    return findTailRecursive(current, currentPosition);
                }
            }

        //CHECKING DOWN SQUARE
        if (currentPosition[0]+1 < game.length)
            //CHECKING FOR OUT OF BOUNDS, AND FOR PREVIOUS
            if (currentPosition[0]+1 != previousPosition[0] || currentPosition[1] != previousPosition[1]) {
                if (game[currentPosition[0] + 1][currentPosition[1]]) {
                    int[] current = {currentPosition[0]+1, currentPosition[1]};
                    //CURRENT IS NOW PREVIOUS
                    return findTailRecursive(current, currentPosition);
                }
            }

        //CHECKING LEFT SQUARE
        if (currentPosition[1]-1 >= 0)
            //CHECKING FOR OUT OF BOUNDS, AND FOR PREVIOUS
            if (currentPosition[0] != previousPosition[0] || currentPosition[1]-1 != previousPosition[1]) {
                if (game[currentPosition[0]][currentPosition[1]-1]) {
                    int[] current = {currentPosition[0], currentPosition[1]-1};
                    //CURRENT IS NOW PREVIOUS
                    return findTailRecursive(current, currentPosition);
                }
            }

        //CHECKING RIGHT SQUARE
        if (currentPosition[1]+1 < game.length)
            //CHECKING FOR OUT OF BOUNDS, AND FOR PREVIOUS
            if (currentPosition[0] != previousPosition[0] || currentPosition[1]+1 != previousPosition[1]) {
                if (game[currentPosition[0]][currentPosition[1]+1]) {
                    int[] current = {currentPosition[0], currentPosition[1]+1};
                    //CURRENT IS NOW PREVIOUS
                    return findTailRecursive(current, currentPosition);
                }
            }

        return new int[]{currentPosition[0], currentPosition[1], 1};
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

        //Checking for Up, Left, Right and Down respectively
        if (xCoord - 1 >= 0) if (game[xCoord-1][yCoord]) count++;
        if (yCoord - 1 >= 0) if (game[xCoord][yCoord-1]) count++;
        if (yCoord + 1 <= game.length-1) if (game[xCoord][yCoord+1]) count++;
        if (xCoord + 1 <= game.length-1) if (game[xCoord+1][yCoord]) count++;

        return count;
    }
}
