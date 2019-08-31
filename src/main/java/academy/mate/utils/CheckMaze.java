package academy.mate.utils;

import java.util.List;

public class CheckMaze {

    public static boolean checkMaze(List<String> list, boolean verifyIsRectangular) {

        for(int i = 0; i < list.size(); i++){
            for (char cell : list.get(i).toCharArray()){
                if(cell != '.' || cell != '#' || cell != 'S' || cell != 'X') return false;
            }
        }

        return true;
    }


}
