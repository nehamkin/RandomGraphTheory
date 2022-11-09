public class Component {
    private int numberOfNodes;
    private int numberOfEdges;

    Component() {
        numberOfNodes = 0;
        numberOfEdges = 0;
    }

    public void incrementNumberOfNodes() {
        numberOfNodes++;
    }

    public void incrementNumberOfEdges() {
        numberOfEdges++;
    }

    public void print() {
        System.out.println("Number of nodes: " + numberOfNodes);
        System.out.println("Number of edges: " + numberOfEdges);
    }
}
