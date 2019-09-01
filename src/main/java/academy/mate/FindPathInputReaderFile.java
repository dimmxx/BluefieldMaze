package academy.mate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {

    public FindPathInputReaderFile(String source) {
        super(source);
    }

    @Override
    protected List<String> read() {
        List<String> list = new ArrayList<>();
        try {
            //bufferedReader = new BufferedReader(new FileReader(source));
            String line = bufferedReader.readLine();
            while (line != null){
                list.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
