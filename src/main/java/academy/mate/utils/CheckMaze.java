package academy.mate.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMaze {

    public static boolean checkMaze(List<String> list, boolean verifyIsRectangular) {

        Pattern pattern = Pattern.compile("^[SX\\#\\.]+$");
        Matcher matcher;

        if(verifyIsRectangular){
            int lastStringLength = list.get(0).length();
            for(int i = 1; i < list.size(); i++){
                if(list.get(i).length() != lastStringLength){
                    return false;
                }else{
                    lastStringLength = list.get(i).length();
                }
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(pattern.matcher(list.get(i)).find()) return true;
        }
        return false;
    }


}
