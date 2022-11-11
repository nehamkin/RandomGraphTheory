public class Component {
    private int numberOfNodes;
    private int numberOfEdges;

    public Component() {
        numberOfNodes = 0;
        numberOfEdges = 0;
    }

    public Component(int numberOfNodes, int numberOfEdges) {
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
    }

    public void incrementNumberOfNodes() {
        numberOfNodes++;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public void print() {
        System.out.println("Number of nodes: " + numberOfNodes);
        System.out.println("Number of edges: " + numberOfEdges);
    }

    public String makeKey(){
        return this.numberOfNodes + "_" + this.numberOfEdges;
    }

    public static Component makeComponent(String key){
        String[] split = key.split("_");
        int numberOfNodes = Integer.parseInt(split[0]);
        int numberOfEdges = Integer.parseInt(split[1]);
        Component component = new Component(numberOfEdges, numberOfNodes);
        return component;
    }
}
