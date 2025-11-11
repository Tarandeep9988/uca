import java.util.*;

class Graph {

  Map<Integer, Set<Integer>> edgeMap;

  Graph() {
    edgeMap = new HashMap<>();
  }
  void add(int a, int b) {
    edgeMap.computeIfAbsent(a, e -> new HashSet<>()).add(b);
    edgeMap.computeIfAbsent(b, e -> new HashSet<>()).add(a);
  }
  List<String> getAllPathsDfs(int startNode) {
    List<String> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    visited.add(startNode);
    getPathHelper(startNode, visited, ans, new StringBuilder());
    return ans;
  }
  private void getPathHelper(int node, Set<Integer> visited, List<String> ans, StringBuilder sb) {

    int sbBeforeLength = sb.length();
    sb.append(node).append("->");
    
    // Going to the neighbours of node;
    boolean flag = true;
    for (int nbr : edgeMap.get(node)) {
      if (!visited.contains(nbr)) {
        flag = false;
        visited.add(nbr);
        getPathHelper(nbr, visited, ans, sb);
      }
    }
    // If got a node, which do not have a nbr which is not visited, that means it is the end of the path and i cant go anywhere
    if (flag) {
      ans.add(sb.toString().substring(0, sb.length() - 2));
    }
    sb.setLength(sbBeforeLength);
  }
  private class Pair {
    int node;
    StringBuilder sb;
    Pair(int node) {
      this(node, new StringBuilder());
    }
    Pair(int node, StringBuilder sb) {
      this.node = node;
      this.sb = new StringBuilder(sb).append(node).append("->");
    }
  }
  List<String> getAllPathsBfs(int startNode) {
    List<String> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(startNode));
    visited.add(startNode);
    while (!q.isEmpty()) {
      Pair p = q.poll();
      boolean flag = true;
      // Going to the neighbours of node;
      for (int nbr : edgeMap.get(p.node)) {
        if (!visited.contains(nbr)) {
          flag = false;
          visited.add(nbr);
          q.offer(new Pair(nbr, p.sb));
        }
      }
      if (flag) {
        // Leaf Node
        ans.add(p.sb.toString().substring(0, p.sb.length() - 2));
      }
    }
    return ans;
  }

  public boolean isCycleDetected() {
    Set<Integer> visited = new HashSet<>();
    for (int node : edgeMap.keySet()) {
      if (!visited.contains(node)) {
        if (bfsCheck(node, visited)) {
          return true;
        }
      }
    }
    return false;
  }
  private boolean bfsCheck(int startNode, Set<Integer> visited) {
    Queue<Integer[]> q = new LinkedList<>();
    q.offer(new Integer[] {null, startNode});
    visited.add(startNode);
    while (!q.isEmpty()) {
      Integer parent = q.peek()[0];
      Integer node = q.poll()[1];
      // for nbr of node
      for (Integer nbr : edgeMap.get(node)) {
        if (!visited.contains(nbr)) {
          visited.add(nbr);
          q.offer(new Integer[] {node, nbr});
        }
        else if (!nbr.equals(parent)) {
          return true;
        }
      }
    }
    return false;
  }
  private boolean dfsCheck(Integer parent, Integer node, Set<Integer> visited) {
    visited.add(node);

    // for each nbr
    for (Integer nbr : edgeMap.get(node)) {
      if (!visited.contains(nbr)) {
        if (dfsCheck(node, nbr, visited)) {
          return true;
        }
      }
      else if (!nbr.equals(parent)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String args[]) {
    Graph g = new Graph();
    g.add(1, 2);
    g.add(2, 5);
    g.add(2, 3);
    g.add(3, 6);
    g.add(3, 7);
    g.add(3, 4);
    

    // Printing it via DFS
    System.out.println("DFS: " + g.getAllPathsDfs(1));

    // Printing it via BFS
    System.out.println("BFS: " + g.getAllPathsBfs(1));

    // Check Cycle
    System.out.println(g.isCycleDetected() ? "Cycle" : "No Cycle");

    // Adding 5, 1
    g.add(5, 1);
    System.out.println(g.isCycleDetected() ? "Cycle" : "No Cycle");
  }
}
