import java.util.*;

// graph4.java

/*
	Topological Sort.
	Go deep down and then add it into the stack
*/

class Edge {
	int src, des;
	Edge (int src, int des) {
		this.src = src;
		this.des = des;
	}
}

class Graph {
	List<List<Integer>> adjList = null;

	Graph(List<Edge> edges, int noVertex) {
		adjList = new ArrayList<>(noVertex);

		for(int i = 0; i < noVertex; i++)
			adjList.add(i, new ArrayList<>());

		for(int i = 0; i < edges.size(); i++) {
			int src = edges.get(i).src;
			int des = edges.get(i).des;

			adjList.get(src).add(des);
		}
	}

}

class graph4 {

	public static void tSort(Graph graph, int noVertex) {

		boolean []visited = new boolean[noVertex];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < noVertex; i++){
			if (visited[i] == false)
				tSort(graph.adjList, i, visited, stack);
		}

		System.out.println("Topological Sort : " + stack);
	}

	public static void tSort(List<List<Integer>> adjList, int root, boolean []visited, Stack<Integer> stack) {

		System.out.println("For Root :" + root +" stack " + (stack) );
		
		visited[root] = true;

		List<Integer> neighbour = adjList.get(root);
		for(int i = 0; i < neighbour.size(); i++) {
			int u = neighbour.get(i);
			if( !visited[u] )
				tSort(adjList, u, visited, stack);

			System.out.println(stack);
		}
		stack.push(root);
	}


	public static void main(String[] args) {

		int noVertex = 6; 

		List<Edge> edges = Arrays.asList(
			new Edge(5, 2),
			new Edge(5, 0), 
			new Edge(4, 0), 
			new Edge(4, 1), 
			new Edge(2, 3), 
			new Edge(3, 1)
		);

		Graph graph = new Graph(edges, noVertex);

		System.out.println("Graph : " + graph.adjList);

		tSort(graph, noVertex);
	}
}
