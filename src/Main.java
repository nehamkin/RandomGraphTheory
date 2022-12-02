import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static String maxComponentKey(int nodes, int edges){
        return nodes + "_" + edges;
    }
    public static List<Map<String, Integer>> runExperiment(int numberOfRun, int numberOfNodes, double l, double c) {
        List<Map<String, Integer>> listMap = new ArrayList<>();
        Map<String, Integer> maxes = new HashMap<>();
        maxes.put("MAX_MAP", -1);
        for (int i = 0; i < numberOfRun; i++) {
            Graph graph = new Graph(numberOfNodes);
            graph.createGraph(l, c);
            int numberOfEmptyComponents = graph.getEmptyComponents();
            List<Component> components = graph.getComponents();
            Map<String, Integer> map = mapComponents(components);
            map.put("EMPTY", numberOfEmptyComponents);
            String maxKey = maxComponentKey(map.get("MAX_NODES"), map.get("MAX_EDGES"));
            if(maxes.containsKey(maxKey)){
                maxes.put(maxKey, maxes.get(maxKey)+1);
            }
            else{
                maxes.put(maxKey, 1);
            }
            listMap.add(map);
        }
        listMap.add(maxes);
        return listMap;
    }

    public static Component getComponentWithMaxNumberOfNodes(List<Component> components) {
        Component componentWithMaxNumberOfNodes = components.get(0);
        for (Component component : components) {
            if (component.getNumberOfNodes() > componentWithMaxNumberOfNodes.getNumberOfNodes()) {
                componentWithMaxNumberOfNodes = component;
            }
        }
        return componentWithMaxNumberOfNodes;
    }
    public static Map<String, Integer> mapComponents (List<Component> components){
        Component maxComponent = getComponentWithMaxNumberOfNodes(components);
        Map<String, Integer> map = new HashMap<>();
        for (Component component : components) {
            String key = component.makeKey();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        map.put("MAX_NODES", maxComponent.getNumberOfNodes());
        map.put("MAX_EDGES", maxComponent.getNumberOfEdges());
        return map;
    }
    public static void main(String[] args) {
        List<Map<String, Integer>> experiments = runExperiment(10,500000, 0, 1);
        Map<String, Integer> maxesMap = new HashMap<>();
        for(Map<String,Integer> exp :  experiments){
            if(exp.containsKey("MAX_MAP")){
                maxesMap = exp;
                maxesMap.remove("MAX_MAP");
            }
        }
        for (String key : maxesMap.keySet()){
            Component component = Component.makeComponent(key);
            component.print();
            System.out.println(maxesMap.get(key));
            System.out.println("-----------------");
        }

    }
}
