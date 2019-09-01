package academy.mate;

import academy.mate.utils.MazeGenerator;

import java.util.List;

public class FindPathInputReaderGenerated extends AbstractFindPathInputReader{


    @Override
    protected List<String> read() {
        return MazeGenerator.generateMaze(10, 10, "");
    }
}
