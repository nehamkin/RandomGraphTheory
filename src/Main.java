import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.createGraph(0, 1);
        graph.print();
        int numberOfEmptyComponents = graph.getEmptyComponents();
        System.out.println("Number of empty components: " + numberOfEmptyComponents);
        List<Component> components = graph.getComponents();
        for(Component component : components) {
            component.print();
            System.out.println("-------------");
        }
    }
}
