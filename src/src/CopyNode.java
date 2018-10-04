
public class CopyNode {
    private Node reference;
    private CopyNode parent;
    public CopyNode previous, next;
    private int dist = 2147483647;
    private int distGreedy = 214783647;
    private int gscore = 0;
    private boolean solution = false;

    public CopyNode(Node inRef, Node goal, CopyNode inNode)
    {
        reference = inRef;
        parent = inNode;
        gscore = parent.getGScore() + 1;
        h(goal);
        f(goal);

    }
    public CopyNode(Node inRef, Node goal)
    {
        reference = inRef;
    }
    public CopyNode()
    {
        reference = null;
        parent = null;
    }
    public Node getRef()
    {
        return reference;
    }
    public int recalcGScore()
    {
        if(gscore == 0)
        {
            return 0;
        }
        else
        {
            return parent.recalcGScore() + 1;
        }
    }
    public CopyNode getParent()
    {
        return parent;
    }
    public int getDistGreedy()
    {
        return distGreedy;
    }
    public void h(Node goal)
    {
        int x = reference.getX();
        int y = reference.getY();
        int x1 = goal.getX();
        int y1 = goal.getY();
        dist = Math.abs(x - x1) + Math.abs(y - y1);
    }
    public void f(Node goal) {
        distGreedy = distGreedy + parent.getGScore() + 1;
    }
    public int getDist()
    {
        return dist;
    }
    public int getGScore()
    {
        return gscore;
    }
    public void setGScore(int inscore)
    {
        gscore = inscore;
    }
    public void setParent(CopyNode inNode)
    {
        parent = inNode;
    }
    public boolean solutionGet()
    {
        return solution;
    }
    public void solutionSet(boolean sol)
    {
        solution = sol;
    }
}