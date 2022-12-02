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

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public void incrementNumberOfNodes() {
        numberOfNodes++;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public void print() {
        System.out.print("Nodes: " + numberOfNodes + " | Edges: "+ numberOfEdges + " ---> ");
    }

    public String makeKey(){
        return this.numberOfNodes + "_" + this.numberOfEdges;
    }

    public static Component makeComponent(String key){
        String[] split = key.split("_");
        int numberOfNodes = Integer.parseInt(split[0]);
        int numberOfEdges = Integer.parseInt(split[1]);
        Component component = new Component(numberOfNodes, numberOfEdges);
        return component;
    }
}
