package academy.mate;

import academy.mate.model.Move;

import java.util.List;
import java.util.TreeMap;

public class FindPath {

    private List<String> list;
    private String[][] maze;
    private StringBuilder sb = new StringBuilder();
    private TreeMap<Integer, Move> map = new TreeMap<>();
    private int cellNumber;

    protected FindPath(List<String> list) {
        this.list = list;
    }

    protected String findPath(){

        maze = new String[list.size()][];

        for (int i = 0; i < list.size(); i++){
            maze[i] = list.get(i).split("");
        }

        printMaze(maze);

        //calculating the quantity of all the cells in the maze
        for (int i = 0; i < maze.length; i++){
            cellNumber += maze[i].length;
        }

        //making int waves to fill the maze in
        int iteration = 0;
        boolean exitFound = false;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("S")) maze[i][j] = "0";
            }
        }
        while (!exitFound) {
            if(iteration > cellNumber & !exitFound) return "\nThere is no possible way out from the maze";
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
        return sb.reverse().toString();
    }

    private void findBackPath(int pointY, int pointX) {

        map.clear();

        Move up = new Move();
        Move down = new Move();
        Move left = new Move();
        Move right = new Move();

        try{
            up.setValue(Integer.parseInt(maze[pointY - 1][pointX]));
            up.setPointY(pointY - 1);
            up.setPointX(pointX);
            up.setMove("d"); //d - down. Not up because the reversed string will be returned from the start to the exit
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            down.setValue(Integer.parseInt(maze[pointY + 1][pointX]));
            down.setPointY(pointY + 1);
            down.setPointX(pointX);
            down.setMove("u");
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            left.setValue(Integer.parseInt(maze[pointY][pointX - 1]));
            left.setPointY(pointY);
            left.setPointX(pointX - 1);
            left.setMove("r");
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }
        try{
            right.setValue(Integer.parseInt(maze[pointY][pointX + 1]));
            right.setPointY(pointY);
            right.setPointX(pointX + 1);
            right.setMove("l");
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (NumberFormatException e){
        }

        //the condition to exit the recursion
        if(up.getValue() != null && up.getValue() == 0){
            sb.append(up.getMove());
            return;
        }
        if(down.getValue() != null && down.getValue() == 0){
            sb.append(down.getMove());
            return;
        }
        if(right.getValue() != null && right.getValue() == 0){
            sb.append(right.getMove());
            return;
        }
        if(left.getValue() != null && left.getValue() == 0){
            sb.append(left.getMove());
            return;
        }

        if (up.getValue() !=null) map.put(up.getValue(), up);
        if (down.getValue() !=null) map.put(down.getValue(), down);
        if (right.getValue() !=null) map.put(right.getValue(), right);
        if (left.getValue() !=null) map.put(left.getValue(), left);

        sb.append(map.firstEntry().getValue().getMove());

        findBackPath(map.firstEntry().getValue().getPointY(), map.firstEntry().getValue().getPointX());
    }















    private void printMaze(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("|");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("|%2s%1s", array[i][j], "");
            }
        }
        System.out.println("|");
    }









}
