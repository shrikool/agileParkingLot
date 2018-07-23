package shrikant.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {
    private static final int LUDO_FACES = 6;

    public static void main(String[] args) {
        // Following array represents your snake ladder board
        // -1 represents no snake and ladder
        // any number greater than -1 represents index to which this it will take
        // but the value should be less than ladderBoard
        int[] ladderBoard = {-1, -1, -1, 9, -1, 8, -1, -1, -1, -1};

        int minNoOfDices = findMinNoOfDices(ladderBoard);
        System.out.println("Minimum number of dices :: " + minNoOfDices);
    }

    static int findMinNoOfDices(int[] ladderBoard) {
        if (ladderBoard == null || ladderBoard.length <= LUDO_FACES)
            return -1;
        if (ladderBoard.length <= LUDO_FACES)
            return 1;

        int[] visitedBoxes = new int[ladderBoard.length];
        Queue<Box> queue = new LinkedList<Box>();
        queue.offer(new Box(0, 0));
        visitedBoxes[0] = 1;
        Box currentBox = new Box(0, 0);

        while (!queue.isEmpty()) {
            currentBox = queue.poll();
            int box = currentBox.box;

            if (box == ladderBoard.length - 1)
                break;

            for (int i = box; i <= (box + LUDO_FACES) && i < ladderBoard.length; ++i) {
                if (visitedBoxes[i] != 1) {
                    Box newBox = new Box(box, currentBox.distance + 1);
                    visitedBoxes[i] = 1;

                    // Checking if there is any ladder or snake
                    if (ladderBoard[i] != -1) {
                        newBox.box = ladderBoard[i];
                    } else {
                        newBox.box = i;
                    }
                    queue.offer(newBox);
                }
            }
        }
        return currentBox.distance;
    }
}

class Box {
    int distance;
    int box;

    public Box(int box, int distance) {
        this.distance = distance;
        this.box = box;
    }
}
