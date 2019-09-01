package academy.mate.utils;

public class PrintMaze {

    public static void printMaze(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("|");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("|%2s%1s", array[i][j], "");
            }
        }
        System.out.println("|");
    }
}
