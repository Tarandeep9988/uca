import java.util.ArrayList;

public class Graph{
	int V;
	ArrayList<ArrayList<Integer>> adj;
	int E;

	Graph(int V) {
		this.V = V;
    	adj = new ArrayList<>();

		for(int i = 0; i <= V; i++) adj.add(new ArrayList<>());
  	}


	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
		this.E++;
	}

	public ArrayList<Integer> adjacent(int v) {
		return adj.get(v);
	}	

	public int edge() {
		return this.E;
	}

	public int vertices() {
		return this.V;
	}

}

