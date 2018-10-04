import java.util.ArrayList;

public class Node{
    private int x;
    private int y;
    private ArrayList<Node> connections;
    private Boolean visited;
    private Node parent;
    private CopyNode pointerNode;
    private char symbol;
    private int cost;

    //constructor
    public Node(int x, int y, char symbol){
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        visited = false;
        cost = 0;
        connections = new ArrayList<Node>();
    }

    //set methods

    public void setVisited(){
        visited = true;
    }

    public void addChild(Node node){
        connections.add(node);
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void addParent(Node parent) {
        this.parent = parent;
    }

    //get methods
    public int getCost(){
        return cost;
    }

    public char getSymbol(){
        return symbol;
    }

    public Node getParent() {
        return parent;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Node> getConnections(){
        return connections;
    }

    public Node getChild(int i) {
        return connections.get(i);
    }

    public boolean getVisited() {return visited;}

    public CopyNode getPointer()
    {
        return pointerNode;
    }
    public void setPointer(CopyNode inNode)
    {
        pointerNode = inNode;
    }
    public void setUnvisited()
    {
        visited = false;
    }

}