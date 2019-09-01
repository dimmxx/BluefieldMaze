package academy.mate.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MazeGenerator {

    public static List<String> generateMaze(int height, int length, String density) {

        String[][] maze = new String[height][length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++){
                maze[i][j] = ".";
            }
        }

        PrintMaze.printMaze(maze);

        Random random = new Random();
        maze[random.nextInt(height)][random.nextInt(length)] = "S";
        maze[random.nextInt(height)][random.nextInt(length)] = "X";

        PrintMaze.printMaze(maze);

        for (int i = 0; i < height*length/3; i++){
            int pointY = random.nextInt(height);
            int pointX = random.nextInt(length);

            if(maze[pointY][pointX].equals("S") || maze[pointY][pointX].equals("X")){
                i -= i;
            } else maze[pointY][pointX] = "#";
        }

        PrintMaze.printMaze(maze);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < height; i++){
            String str = Arrays.toString(maze[i]);
            str = str.substring(1, str.length()-1).replace(",", "");
            list.add(str);
        }
        return list;
    }


}
