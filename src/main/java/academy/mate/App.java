package academy.mate;

import academy.mate.utils.CheckMaze;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class App {

    private static int[][] mazeInt;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        //AbstractFindPathInputReader findPathInputReader = new FindPathInputReaderFile();
//        List<String> list = findPathInputReader.read("mazeSmall.maze");;
//
//        FindPath findPath = new FindPath(list);
//        System.out.println("\n" + findPath.findPath());
//
        AbstractFindPathInputReader findPathInputReader = new FindPathInputReaderStdIn();
        List<String> list = findPathInputReader.read("StdIn");

        System.out.println(list);
        System.out.println(CheckMaze.checkMaze(list, true));

       System.out.println("\n" + new FindPath(list).findPath());
    }

}