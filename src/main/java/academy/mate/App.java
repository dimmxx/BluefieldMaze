package academy.mate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class App {

    private static int[][] mazeInt;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        BufferReaderInput bufferReaderInput = new BufferReaderInput();
        List<String> list = bufferReaderInput.readFromFile("mazeSmall.maze");;

        FindPath findPath = new FindPath(list);
        System.out.println("\n" + findPath.findPath());


    }
}