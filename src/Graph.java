import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int numberOfNodes = 500000;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public Graph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public void addEdge() {
        int randomNode1 = (int) (Math.random() * numberOfNodes);
        int randomNode2 = (int) (Math.random() * numberOfNodes);
        while (randomNode1 == randomNode2) {
            randomNode2 = (int) (Math.random() * numberOfNodes);
        }
        if (map.containsKey(randomNode1)) {
            map.get(randomNode1).add(randomNode2);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(randomNode2);
            map.put(randomNode1, list);
        }
        if(map.containsKey(randomNode2)) {
            map.get(randomNode2).add(randomNode1);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(randomNode1);
            map.put(randomNode2, list);
        }
    }

    public void addEdges(double numberOfEdges) {
        for (int i = 0; i < numberOfEdges; i++) {
            addEdge();
        }
    }

    public double getMaxNumberOfEdges() {
        double out = numberOfNodes * (numberOfNodes - 1) / 2;
        return out;
    }

    public double getProbabilityOfEdge(double l, double c) {
        double epsilon = l * Math.pow(numberOfNodes, (-1 / 3));
        double out = (c - epsilon);
        return out;
    }

    public double getNumberOfEdgesToAdd(double l, double c) {
        double probabilityOfEdge = getProbabilityOfEdge(l, c);
        double out = (probabilityOfEdge * (numberOfNodes - 1) / 2);
        return out;
    }

    public void createGraph(double l, double c) {
        double numberOfEdgesToAdd = getNumberOfEdgesToAdd(l, c);
        addEdges(numberOfEdgesToAdd);
    }

    public Component BFS(int startNode) {
        Component component = new Component();
        boolean[] visited = new boolean[numberOfNodes];
        List<Integer> queue = new ArrayList<>();
        visited[startNode] = true;
        queue.add(startNode);
        while (queue.size() != 0) {
            int currentNode = queue.remove(0);
            component.incrementNumberOfNodes();
            if (map.containsKey(currentNode)) {
                for (int i = 0; i < map.get(currentNode).size(); i++) {
                    int neighbour = map.get(currentNode).get(i);
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
            }
        }
        int edges = 0;
        for(int i = 0; i < numberOfNodes; i++) {
            if(visited[i]) {
                edges += map.remove(i).size();
            }
        }
        component.setNumberOfEdges(edges/2);
        return component;
    }

    public int getEmptyComponents() {
        return numberOfNodes - map.size();
    }
    public List<Component> getComponents() {
        List<Component> components = new ArrayList<>();
        for(int i = 0; i < numberOfNodes; i++) {
            if(map.containsKey(i)) {
                components.add(BFS(i));
            }
        }
        return components;
    }

    public void print() {
        for(int i = 0; i < numberOfNodes; i++) {
            if(map.containsKey(i)) {
                System.out.println(i + ": " + map.get(i));
            }
        }
    }


}
