package assign4;

import java.util.LinkedList;

public class DFS {
	
	private int V;
	private boolean marked[];			   // marked array
	private LinkedList<Integer>[] adjlist;
	
	public DFS(int V) {
		this.V = V;
		adjlist = (LinkedList<Integer>[])new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adjlist[v] = new LinkedList<Integer>();
		}
	}
	
	public Iterable<Integer> adj(int v) {
		return adjlist[v];
	}

	public void dfs(int v){
		//depth-first search algorithm
		marked = new boolean[V];
		
		marked[v] = true;
		System.out.println("Visited vertex: " + v);
		for(int w : adj(v)){
			if(!marked[w]){
				dfs(w);
			}
		}
	}
}
