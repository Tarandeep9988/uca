import java.util.*;
public class BFS{
    int vis[];
    private final int s;
    int edgeTo[];

    BFS(int s, Graph g){
        this.s = s;
        vis = new int[g.vertices()+1];
        edgeTo = new int[g.vertices()+1];

        bfs(g,s);
    }

    public void bfs(Graph g, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = 1;
        edgeTo[s] = s;

        ArrayList<ArrayList<Integer>> adj = g.adj;
        while (q.size() > 0) {
            int node = q.poll();
            for(int neigh : adj.get(node)){
                if(vis[neigh] == 0){
                    vis[neigh] = 1;
                    edgeTo[neigh] = node;
                    q.add(neigh);
                }
            }
        }
    }

    public boolean isConnected(int v){
        return vis[v] == 0 ? false : true;
    }

    public void printPath(int v){
        Stack<Integer> st = new Stack<>();

        while(v != edgeTo[v]){
            st.push(v);
            v = edgeTo[v];
        }

        st.push(v);

        System.out.print("Path :- ");
        while(st.size() > 0){
            System.out.print(st.pop());
            if(st.size() > 0)System.out.print(" -> ");
        }
        System.out.println();
    }

}
