
public class Main{
    public static void main(String args[]){

        Maze test = new Maze("src/src/largeMaze.txt");
        test.printMaze();

        test.buildGraph();
        test.setSearch(new AStar());
        test.search.search(test);
        //test.setSolution();
        System.out.println("solved Maze: ");
        test.printMaze();

    }
}
