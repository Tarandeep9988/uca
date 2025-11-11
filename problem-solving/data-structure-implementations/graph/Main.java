public class Main {
    public static void main(String[] args) {

        // System.out.println("===== BFS TEST =====");
        // Graph g = new Graph(8);
        // g.addEdge(1, 3);
        // g.addEdge(2, 4);
        // g.addEdge(1, 5);
        // g.addEdge(4, 6);
        // g.addEdge(1, 2);
        // g.addEdge(6, 7);
        // g.addEdge(7, 8);

        // BFS traversal = new BFS(1, g);
        // traversal.printPath(8);
        // System.out.println("isConnected(7): " + traversal.isConnected(7));
        // System.out.println("----------------------------");

        // System.out.println("===== CONNECTED COMPONENTS TEST =====");
        // Graph g1 = new Graph(6);
        // g1.addEdge(1, 2);
        // g1.addEdge(2, 3);
        // g1.addEdge(4, 5);

        // ConnectedComponents cc1 = new ConnectedComponents(g1);
        // System.out.println("Total Components: " + cc1.count()); // Expected: 3
        // System.out.println("Connected(1,3): " + cc1.connected(1,3)); // true
        // System.out.println("Connected(1,4): " + cc1.connected(1,4)); // false
        // System.out.println("Connected(4,5): " + cc1.connected(4,5)); // true
        // System.out.println("----------------------------");

        // Graph g2 = new Graph(5);
        // g2.addEdge(1, 2);
        // g2.addEdge(2, 3);
        // g2.addEdge(3, 4);
        // g2.addEdge(4, 5);

        // ConnectedComponents cc2 = new ConnectedComponents(g2);
        // System.out.println("Total Components: " + cc2.count()); // Expected: 1
        // System.out.println("Connected(1,5): " + cc2.connected(1,5)); // true
        // System.out.println("----------------------------");

        // Graph g3 = new Graph(4);
        // ConnectedComponents cc3 = new ConnectedComponents(g3);
        // System.out.println("Total Components: " + cc3.count()); // Expected: 4
        // System.out.println("Connected(1,2): " + cc3.connected(1,2)); // false
        // System.out.println("----------------------------");

        System.out.println("===== BIPARTITE GRAPH TEST =====");

        // Bipartite graph (even cycle)
        Graph bg1 = new Graph(4);
        bg1.addEdge(1, 2);
        bg1.addEdge(2, 3);
        bg1.addEdge(3, 4);
        bg1.addEdge(4, 1);
        System.out.println("Test 1: Even cycle (Should be Bipartite)");
        new BipartiteGraph(bg1);
        System.out.println("----------------------------");

        // Non-bipartite graph (odd cycle)
        Graph bg2 = new Graph(3);
        bg2.addEdge(1, 2);
        bg2.addEdge(2, 3);
        bg2.addEdge(3, 1);
        System.out.println("Test 2: Odd cycle (Should NOT be Bipartite)");
        new BipartiteGraph(bg2);
        System.out.println("----------------------------");

        // Disconnected bipartite graph
        Graph bg3 = new Graph(6);
        bg3.addEdge(1, 2);
        bg3.addEdge(3, 4);
        bg3.addEdge(5, 6);
        System.out.println("Test 3: Disconnected bipartite graph");
        new BipartiteGraph(bg3);
        System.out.println("----------------------------");

        // Single node (always bipartite)
        Graph bg4 = new Graph(1);
        System.out.println("Test 4: Single node (Should be Bipartite)");
        new BipartiteGraph(bg4);
        System.out.println("----------------------------");

        // Bipartite tree
        Graph bg5 = new Graph(5);
        bg5.addEdge(1, 2);
        bg5.addEdge(1, 3);
        bg5.addEdge(2, 4);
        bg5.addEdge(3, 5);
        System.out.println("Test 5: Tree structure (Should be Bipartite)");
        new BipartiteGraph(bg5);
        System.out.println("----------------------------");

        System.out.println("✅ All static test cases executed successfully!");
    }

}
