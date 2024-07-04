package Task3;

import java.util.LinkedList;
// Test TreadPool

public class Execise3 {
    public static void main(String[] args) {
        LinkedList<Runnable> taskList = new LinkedList<>();
        for (int ii = 1; ii < 9; ii++) {
            for (int jj = 1; jj < 9; jj++) {
                taskList.add(new Task((ii * jj), ii, jj));
            }
        }
        new TreadPoolExecutor(32, taskList);
    }
}
