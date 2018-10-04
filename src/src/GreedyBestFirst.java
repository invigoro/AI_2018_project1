import java.util.ArrayList;
import java.util.Stack;

public class GreedyBestFirst implements IAlgorithm{
    @Override
    public void search(Maze maze){
        Stack<CopyNode> frontier = new Stack<CopyNode>();
        Node startMaze = maze.getStart();
        startMaze.setVisited();
        Node endMaze = maze.getGoal();
        CopyNode start = new CopyNode(startMaze, endMaze);
        startMaze.setPointer(start);
        frontier.push(start);
        CopyNode tempNode = null;
        while (!frontier.empty() && frontier.peek().getDistGreedy() != 0) {
            tempNode = frontier.pop();
            Node actualNode = tempNode.getRef();
            ArrayList<Node> children = actualNode.getConnections();
            if (children.size() <= 1 && tempNode != start) {
                tempNode.getRef().setVisited();
                children.get(0).setVisited();
            } else {
                for (int i = 0; i < children.size(); i++) {
                    if (children.get(i).getVisited()) {
                        if (tempNode.getGScore() < children.get(i).getPointer().getGScore() - 1) {
                            children.get(i).getPointer().setParent(tempNode);
                            //children.get(i).getPointer().setGScore(1 + tempNode.getGScore());
                            //children.get(i).getPointer().f(endMaze);
                            pushNode(children.get(i).getPointer(), frontier);
                        }
                    } else {
                        children.get(i).setVisited();
                        CopyNode makeNode = new CopyNode(children.get(i), endMaze, tempNode);
                        children.get(i).setPointer(makeNode);
                        //children.get(i).setSymbol('x');
                        pushNode(makeNode, frontier);
                    }
                    //maze.printMaze();
                }
            }
        }
        if (frontier.empty()){
            start = tempNode;
        }
        else {
            start = frontier.pop();
        }
        frontier.clear();
        CopyNode sol = endMaze.getPointer();
        while(sol.getParent() != null)
        {
            sol.getRef().setSymbol('x');
            sol = sol.getParent();
        }
        maze.printMaze();

    }
    public void pushNode(CopyNode inNode, Stack<CopyNode> frontier)
    {
        synchronized(frontier) {
            if (frontier.empty()) {
                frontier.push(inNode);
            } else {
                System.out.println(frontier.peek().getRef().getSymbol());
                Stack<CopyNode> temp = new Stack<CopyNode>();
            /*Iterator<CopyNode> iter = frontier.iterator();
            while(iter.hasNext()){
                CopyNode tempnode = iter.next();
                tempnode.setGScore(tempnode.recalcGScore());
            }*/
                while (frontier.size() != 0 && frontier.peek().getDistGreedy() < inNode.getDistGreedy()) {
                    temp.push(frontier.pop());
                }
                frontier.push(inNode);
                while (!temp.empty()) {
                    frontier.push(temp.pop());
                }
            }
        }

    }
}