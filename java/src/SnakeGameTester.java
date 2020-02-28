import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    /* TESTS FOR FINDING TAIL RECURSIVELY */

    /* 1st Test Case: Checks when the entire body of the Snake is in
       the border. Also tests when the head and tail are in the same row.
       Thanks to this case I noticed and fixed a mistake.               */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailExhaustive1() {
        boolean[][] arr = new boolean[3][3];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[1][2] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 0, 0);

        int[] expected = {0,2,7};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* 2nd Test Case: Testing when the head is in one border of the game/board
     * and the tail is in the center. */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailExhaustive2() {
        boolean[][] arr = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 0, 5);

        int[] expected = {3,3,6};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* 3rd Test Case: Testing method when Snake is only one cell long,
    *  therefore head is the same as tail, so the test should return head */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailExhaustive3() {
        boolean[][] arr = new boolean[3][3];
        arr[1][1] = true;

        SnakeGame a = new SnakeGame(arr, 1,1);

        int[] expected = {1,1,1};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* 4th Test Case: Tests when head is in one corner of the game.
       Snake changes direction two times, like a "Z" shape */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailExhaustive4() {
        boolean[][] arr = new boolean[5][5];
        arr[4][4] = true;
        arr[4][3] = true;
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 4, 4);

        int[] expected = {0,2,7};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* 5th Test case: Checking if method works when Tail is in one corner
       of the board/game, L shape Snake */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailExhaustive5() {
        boolean[][] arr = new boolean[6][6];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[2][3] = true;
        arr[3][3] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int[] expected = {0,0,7};

        assertArrayEquals(expected, a.findTailExhaustive());
    }

    /* TESTS FOR FINDING TAIL RECURSIVELY */

    /* 6th Test Case: Testing when the whole body of the Snake is in the border
       of the game/board. Every part of the snake has out of bounds neighbors  */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailRecursive1() {
        boolean[][] arr = new boolean[3][3];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[1][2] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 0, 0);

        int[] expected = {0,2,7};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    /* 7th Test Case: Testing when the head is on one border of the game/board
    *  and the tail is in the center. */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailRecursive2() {
        boolean[][] arr = new boolean[7][7];
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][4] = true;
        arr[0][5] = true;

        SnakeGame a = new SnakeGame(arr, 0, 5);

        int[] expected = {3,3,6};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    /* 8h Test Case: Testing method when Snake is only one cell long,
     * therefore head is the same as tail, so the test should return head */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailRecursive3() {
        boolean[][] arr = new boolean[3][3];
        arr[1][1] = true;

        SnakeGame a = new SnakeGame(arr, 1,1);

        int[] expected = {1,1,1};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    /* 9th Test Case: Tests when head is in one corner of the game.
       Snake changes direction two times, like a "Z" shape */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailRecursive4() {
        boolean[][] arr = new boolean[5][5];
        arr[4][4] = true;
        arr[4][3] = true;
        arr[3][3] = true;
        arr[2][3] = true;
        arr[1][3] = true;
        arr[0][3] = true;
        arr[0][2] = true;

        SnakeGame a = new SnakeGame(arr, 4, 4);

        int[] expected = {0,2,7};

        assertArrayEquals(expected, a.findTailRecursive());
    }

    /* 10th Test case: Checking if method works when Tail is in one corner
       of the board/game, L shape Snake */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void findTailRecursive5() {
        boolean[][] arr = new boolean[6][6];
        arr[0][0] = true;
        arr[1][0] = true;
        arr[2][0] = true;
        arr[2][1] = true;
        arr[2][2] = true;
        arr[2][3] = true;
        arr[3][3] = true;

        SnakeGame a = new SnakeGame(arr, 3, 3);

        int[] expected = {0,0,7};

        assertArrayEquals(expected, a.findTailRecursive());
    }
}