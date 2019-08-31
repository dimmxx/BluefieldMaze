package academy.mate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {

    @Override
    protected List<String> read(String source) {
        List<String> list = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(source));
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
