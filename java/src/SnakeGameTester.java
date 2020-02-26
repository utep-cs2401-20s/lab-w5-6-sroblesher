import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    @org.junit.jupiter.api.Test
    void findTailExhaustive1() {
        boolean arr[][] = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int expected[] = {0,5,6};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    @org.junit.jupiter.api.Test
    void findTailExhaustive2() {
        boolean arr[][] = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 0, 5);

        int expected[] = {3,3,6};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    @org.junit.jupiter.api.Test
    void findTailExhaustive3() {
        boolean arr[][] = new boolean[3][3];
        arr[1][1] = true;

        SnakeGame a = new SnakeGame(arr, 1,1);

        int expected[] = {1,1,1};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    @org.junit.jupiter.api.Test
    void findTailExhaustive4() {
        boolean arr[][] = new boolean[5][5];
        arr[4][4] = true;
        arr[4][3] = true;
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 4, 4);

        int expected[] = {0,2,7};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    @org.junit.jupiter.api.Test
    void findTailExhaustive5() {
        boolean arr[][] = new boolean[6][6];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[2][3] = true;
        arr[3][3] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int expected[] = {0,0,7};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* TESTS FOR FINDING TAIL RECURSIVELY */

    @org.junit.jupiter.api.Test
    void findTailRecursive1() {
        boolean arr[][] = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int expected[] = {0,5,6};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    @org.junit.jupiter.api.Test
    void findTailRecursive2() {
        boolean arr[][] = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 0, 5);

        int expected[] = {3,3,6};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    @org.junit.jupiter.api.Test
    void findTailRecursive3() {
        boolean arr[][] = new boolean[3][3];
        arr[1][1] = true;

        SnakeGame a = new SnakeGame(arr, 1,1);

        int expected[] = {1,1,1};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    @org.junit.jupiter.api.Test
    void findTailRecursive4() {
        boolean arr[][] = new boolean[5][5];
        arr[4][4] = true;
        arr[4][3] = true;
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 4, 4);

        int expected[] = {0,2,7};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    @org.junit.jupiter.api.Test
    void findTailRecursive5() {
        boolean arr[][] = new boolean[6][6];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[2][3] = true;
        arr[3][3] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int expected[] = {0,0,7};

        assertArrayEquals(expected, a.findTailRecursive());
    }
}