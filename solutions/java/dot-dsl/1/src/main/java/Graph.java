import java.util.*;

public class Graph {

    private final Set<Node> nodes;
    private final Set<Edge> edges;
    private final Map<String, String> attributes;

    public Graph() {
        this(Collections.emptyMap());
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = new HashMap<>(attributes);
        this.nodes = new LinkedHashSet<>();
        this.edges = new LinkedHashSet<>();
    }

    public Collection<Node> getNodes() {
        return Collections.unmodifiableSet(nodes);
    }

    public Collection<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public Graph node(String name) {
        nodes.add(new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        nodes.add(new Node(name, attributes));
        return this;
    }

    public Graph edge(String start, String end) {
        edges.add(new Edge(start, end));
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        edges.add(new Edge(start, end, attributes));
        return this;
    }
}
