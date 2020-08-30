package assign4;

import java.util.LinkedList;

public class transposeDigraph {
	
	private int V;                         // number of vertices
	private int E;                         // number of edges
	private LinkedList<Integer>[] adjlist; // adjecency lists
	
	public transposeDigraph(int V) {
		this.V = V;
		adjlist = (LinkedList<Integer>[])new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adjlist[v] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adjlist[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adjlist[v];
	}
	
	public transposeDigraph reverse() {
		// TODO
		transposeDigraph g = new transposeDigraph(V);
		
		for(int v = 0; v < V; v++){
			for(int w : adj(v)){
				g.addEdge(w, v);
			}
		}
		
		return g;
	}

	public static void main(String[] args) {

	}

}
