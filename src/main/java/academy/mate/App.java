package academy.mate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        BufferReaderInput bufferReaderInput = new BufferReaderInput();
        List<String> list = new ArrayList<>();
        list = bufferReaderInput.readFromFile("mazeSmall.maze");
        char[][] maze = new char[list.size()][];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = list.get(i).toCharArray();
        }

        int[][] mazeInt = new int[maze.length][];
        for (int i = 0; i < mazeInt.length; i++) {
            mazeInt[i] = new int[maze[i].length];
        }

        for (int i = 0; i < mazeInt.length; i++) {
            for (int j = 0; j < mazeInt[i].length; j++) {
                if (maze[i][j] == 'S') mazeInt[i][j] = 0;
                if (maze[i][j] == '.') mazeInt[i][j] = -1;
                if (maze[i][j] == '#') mazeInt[i][j] = -2;
                if (maze[i][j] == 'X') mazeInt[i][j] = -3;
            }
        }
        int iteration = 0;
        boolean exitFound = false;

        while (!exitFound) {
            for (int i = 0; i < mazeInt.length; i++) {
                for (int j = 0; j < mazeInt[i].length; j++) {
                    int cell = mazeInt[i][j];
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

        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            System.out.println(maze[i]);
        }

        printMaze(mazeInt);

        







//        for(in}                                        t i = 0; i < 1000; i++){
//            System.out.println(i + ". " + (char)i);
//        }
//
//        String unicode = "\u2591";
//        PrintStream outUnicode = null;
//        try {
//            outUnicode = new PrintStream(System.out, true, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        outUnicode.println(unicode);
//
//        System.out.println("hello");


    }

    private static void printMaze(int[][] array){
        for(int i = 0; i < array.length; i++){
            System.out.println();
            for(int j = 0; j < array[i].length; j++){
                System.out.printf("|%2d", array[i][j]);
            }
        }
        System.out.println();
    }

}