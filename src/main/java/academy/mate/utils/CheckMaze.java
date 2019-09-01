package academy.mate.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMaze {

    public static boolean checkMaze(List<String> list, boolean verifyIsRectangular) {

        Pattern pattern = Pattern.compile("^(?!.*S.*S)(?!.*X.*X)[SX.#]+$"); //https://stackoverflow.com/questions/57743346/regular-expression-for-exact-one-character-occurrence-at-any-place-of-the-string
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();

        if (verifyIsRectangular) {
            int mazeLength = list.get(0).length();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).length() != mazeLength) {
                    return false;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        matcher = pattern.matcher(stringBuilder.toString());

        if (matcher.find()) {
            return true;
        } else return false;
    }
}
