package academy.mate;

import java.io.BufferedReader;
import java.util.List;

public abstract class AbstractFindPathInputReader {

    protected BufferedReader bufferedReader;
    protected List<String> list;

    protected abstract List<String> read(String source);

}
