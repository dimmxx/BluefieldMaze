package academy.mate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class App {

    private static int[][] mazeInt;
    private static StringBuilder sb = new StringBuilder();

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

    private static void findBackPath(int pointY, int pointX) {

        Integer[] up = new Integer[3];
        Integer[] down = new Integer[3];
        Integer[] left = new Integer[3];
        Integer[] right = new Integer[3];
        up[0] = -2;
        down[0] = -2;
        left[0] = -2;
        right[0] = -2;

        try{
            up[0] = mazeInt[pointY - 1][pointX];
            up[1] = pointY - 1;
            up[2] = pointX;
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            down[0] = mazeInt[pointY + 1][pointX];
            down[1] = pointY + 1;
            down[2] = pointX;
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            left[0] = mazeInt[pointY][pointX - 1];
            left[1] = pointY;
            left[2] = pointX - 1;
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try{
            right[0] = mazeInt[pointY][pointX + 1];
            right[1] = pointY;
            right[2] = pointX + 1;
        }catch (ArrayIndexOutOfBoundsException e){
        }

        TreeMap<String, Integer[]> map = new TreeMap<>();

        if (up[0] > 0) map.put("u", up);
        if (down[0] > 0) map.put("d", down);
        if (right[0] > 0) map.put("r", right);
        if (left[0] > 0) map.put("l", left);

        sb.append(map.firstEntry().getKey());

        if(up[0] != 0 && down[0] != 0 && right[0] != 0 && left[0] != 0){
            findBackPath(map.firstEntry().getValue()[1], map.firstEntry().getValue()[2]);
        }



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