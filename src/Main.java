
public class Main{
    public static void main(String args[]){

        Maze test = new Maze("src/testMaze.txt");
        test.printMaze();

        test.buildGraph();
        //test.setSolution();
        System.out.println("solved Maze: ");
        test.printMaze();
        
    }
}