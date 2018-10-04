
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

        Maze test2 = new Maze("src/src/largeMaze.txt");
        test2.buildGraph();
        test2.setSearch(new GreedyBestFirst());
        test2.search.search(test2);
        System.out.println("Solved Maze: ");
        test2.printMaze();

    }
}
