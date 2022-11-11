import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<String, Integer> mapComponents (List<Component> components){
        Map<String, Integer> map = new HashMap<>();
        for (Component component : components) {
            String key = component.makeKey();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.createGraph(0, 1);
        graph.print();
        int numberOfEmptyComponents = graph.getEmptyComponents();
        System.out.println("Number of empty components: " + numberOfEmptyComponents);
        List<Component> components = graph.getComponents();
        Map<String, Integer> map = mapComponents(components);
        for (String key : map.keySet()) {
            Component component = Component.makeComponent(key);
            component.print();
            System.out.println("Number of components: " + map.get(key));
            System.out.println("-----------------");
        }
    }
}
