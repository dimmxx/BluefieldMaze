package academy.mate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    @Override
    protected List<String> read() {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()) break;
                list.add(line);
            }
            bufferedReader.close();
        }catch (IOException e){

        }

        return list;
    }
}
