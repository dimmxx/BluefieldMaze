package academy.mate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    static int[][] mazeInt;

    public static void main(String[] args) {

        BufferReaderInput bufferReaderInput = new BufferReaderInput();
        List<String> list = new ArrayList<>();
        list = bufferReaderInput.readFromFile("mazeSmall.maze");
        char[][] maze = new char[list.size()][];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = list.get(i).toCharArray();
        }

        mazeInt = new int[maze.length][];
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

        int exitY = -1;
        int exitX = -1;
        for (int i = 0; i < mazeInt.length; i++) {
            for (int j = 0; j < mazeInt[i].length; j++) {
                if (mazeInt[i][j] == -3) {
                    exitY = i;
                    exitX = j;
                }
            }
        }

        findBackPath(exitY, exitX);
        System.out.println(sb.toString());





    }

    private static void printMaze(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("|%2d", array[i][j]);
            }
        }
        System.out.println();
    }

    private static StringBuilder sb = null;

    private static void findBackPath(int pointY, int pointX) {

        int up = -2;
        int down = -2;
        int right = -2;
        int left = -2;

        try{
            up = mazeInt[pointY - 1][pointX];
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            down = mazeInt[pointY + 1][pointX];
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            right = mazeInt[pointY][pointX + 1];
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            left = mazeInt[pointY][pointX - 1];
        }catch (ArrayIndexOutOfBoundsException e){
        }


        Math.min(Math.min(up, down), Math.min(left, right));


        if(up > 0 & up <= down & up <= left & up <= right) sb.append("d, ");
        if(left > 0 & left <= down & left <= up & left <= right) sb.append("r, ");
        if(right > 0 && right <= down & right <= up & right <= left) sb.append("l, ");
        if(down > 0 & down <= left & down <= up & down <= right) sb.append("u, ");
    }

}

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