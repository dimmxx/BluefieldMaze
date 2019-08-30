package academy.mate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FindPath {

    private List<String> list;
    private String[][] maze;
    private StringBuilder sb = new StringBuilder();

    public FindPath(List<String> list) {
        this.list = list;
    }

    protected String findPath(){

        maze = new String[list.size()][];

        for (int i = 0; i < list.size(); i++){
            maze[i] = list.get(i).split("");
        }

        printMaze(maze);

        //making int waves to fill the maze in
        int iteration = 0;
        boolean exitFound = false;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("S")) maze[i][j] = "0";
            }
        }
        while (!exitFound) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    String cell = maze[i][j];
                    if (cell.equals(String.valueOf(iteration))) {
                        try {
                            if (maze[i + 1][j].equals(".")) maze[i + 1][j] = String.valueOf(iteration + 1);
                            if (maze[i + 1][j].equals("X")) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (maze[i - 1][j].equals(".")) maze[i - 1][j] = String.valueOf(iteration + 1);
                            if (maze[i - 1][j].equals("X")) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (maze[i][j + 1].equals(".")) maze[i][j + 1] = String.valueOf(iteration + 1);
                            if (maze[i][j + 1].equals("X")) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        try {
                            if (maze[i][j - 1].equals(".")) maze[i][j - 1] = String.valueOf(iteration + 1);
                            if (maze[i][j - 1].equals("X")) exitFound = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
            }
            iteration++;
        }


        printMaze(maze);

        //defining exit coordinates
        int exitY = -1;
        int exitX = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("X")) {
                    exitY = i;
                    exitX = j;
                }
            }
        }

        findBackPath(exitY, exitX);
        System.out.println(sb.toString());

        return null;
    }

    private void findBackPath(int pointY, int pointX) {

        Integer[] up = new Integer[3];
        Integer[] down = new Integer[3];
        Integer[] left = new Integer[3];
        Integer[] right = new Integer[3];

        try{
            up[0] = Integer.parseInt(maze[pointY - 1][pointX]);
            up[1] = pointY - 1;
            up[2] = pointX;
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            down[0] = Integer.parseInt(maze[pointY + 1][pointX]);
            down[1] = pointY + 1;
            down[2] = pointX;
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            left[0] = Integer.parseInt(maze[pointY][pointX - 1]);
            left[1] = pointY;
            left[2] = pointX - 1;
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            right[0] = Integer.parseInt(maze[pointY][pointX + 1]);
            right[1] = pointY;
            right[2] = pointX + 1;
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }

        if((up[0] != null && up[0].equals("0"))
                || (down[0] != null && down[0].equals("0"))
                || (right[0] != null && right.equals("0"))
                || (left[0] != null && left.equals("0"))) return;


        TreeMap<String, Integer[]> map = new TreeMap<>();

        if (up[0] !=null) map.put("u", up);
        if (down[0] !=null) map.put("d", down);
        if (right[0] !=null) map.put("r", right);
        if (left[0] !=null) map.put("l", left);

        sb.append(map.firstEntry().getKey());

        //findBackPath(map.firstEntry().getValue()[1], map.firstEntry().getValue()[2]);








    }















    private void printMaze(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
        }
        System.out.println();
    }









}
