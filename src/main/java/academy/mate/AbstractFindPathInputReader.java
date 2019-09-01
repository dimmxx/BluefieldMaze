package academy.mate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public abstract class AbstractFindPathInputReader {

    protected BufferedReader bufferedReader;
    protected List<String> list;

    public AbstractFindPathInputReader() {
    }

    public AbstractFindPathInputReader(String source) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected abstract List<String> read();

}
