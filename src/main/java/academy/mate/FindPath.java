package academy.mate;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

    private List<String> list;
    private String[][] maze;

    public FindPath(List<String> list) {
        this.list = list;
    }

    protected String findPath(){

        maze = new String[list.size()][];

        for (int i = 0; i < list.size(); i++){
            maze[i] = list.get(i).split("");
        }


        printMaze(maze);


        int iteration = 0;
        boolean exitFound = false;

        while (!exitFound) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    int cell = maze[i][j];
                    if (cell == iteration) {
                        try {
                            if (mazeInt[i + 1][j] == -1) mazeInt[i + 1][j] = iteration + 1;
                            if (mazeInt[i + 1][j] == -3) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (mazeInt[i - 1][j] == -1) mazeInt[i - 1][j] = iteration + 1;
                            if (mazeInt[i - 1][j] == -3) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (mazeInt[i][j + 1] == -1) mazeInt[i][j + 1] = iteration + 1;
                            if (mazeInt[i][j + 1] == -3) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (mazeInt[i][j - 1] == -1) mazeInt[i][j - 1] = iteration + 1;
                            if (mazeInt[i][j - 1] == -3) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
            }
            iteration++;
        }

















        return null;
    }


    private static void printMaze(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
        }
        System.out.println();
    }









}
