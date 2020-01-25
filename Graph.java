import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
public class Graph {
	//CHANGER POUR PRIVATE APRES
	public int[] vertices;//We are gonna keep the weight values here for every vertice
	//REMEMBER: vertices start in 1 and not 0
	public int[][] edges;//Adjacency Matrix
	public int N;
	
	public Graph(int N,  int[] weights, int[][] edges) {
		this.N = N;
		this.vertices = new int[N];
		this.edges = new int[N][N];
		this.vertices = weights.clone();
		this.edges = edges.clone();
	}
	
	public static Graph Graph_text(String pathFile) throws FileNotFoundException {//Build a graph based on the file inputed
		File inp = new File(pathFile);
		Scanner sc = new Scanner(inp);
		int N = (int)sc.nextLong();
		int edge1;
		int edge2;
		int []weights = new int[N];
		int [][] edges = new int[N][N];
		//Looking for the edges (it`s strange that we have a limited number of edges)
		for(int i=2;i<=N;i++){
			edge1 = (int)sc.nextLong();
			edge2 = (int)sc.nextLong();
			edges[edge1-1][edge2-1] = 1;
		}
		//Grabing weights
		for(int i=N+1;i<=2*N;i++) {
			weights[i-N-1] = (int)sc.nextLong();
		}
		sc.close();
		return new Graph(N,weights,edges);
	}
	
	public int distance(int u, int v) {//NOT DONE: Calculate the distance of two vertices (Denote d(u, v) as the distance between u and v in the tree, i.e., the number of edges on the unique path connecting u and v)
		if(v==u) return 0;
		//REMEMBER THAT THEY WILL INTRODUCE HERE VERTICE 1 AS VERTICE 0
		
		throw new Error("not done");
	}
	
	
	public int s_value(int x, int y) {//S(x,y)
		int value = 0;
		if(x == y) return Integer.MAX_VALUE;//We are not interested in the x==y
		for(int i=1;i<=N;i++) {
			value = value + this.vertices[i-1]*Math.min(distance(i,x),distance(i,y));		}
		return value;
	}
	
	public TwoCenters naive() {
		int s_values[][][] = new int[N][N][1];//Using another dimension to store the s_value
		int lowest_value = Integer.MAX_VALUE;
		int now = 0;
		int center1 = 1;
		int center2 = 2;
		for(int i = 1;i<=this.N;i++) {
			for(int j = 1;j<=this.N;j++) {
				now = s_value(i,j);
				if(now<=lowest_value) { lowest_value = now; center1 = i; center2 = j;}
				s_values[i-1][j-1][0] = now;
			}
		}
		return new TwoCenters(lowest_value, center1 , center2);
	}
}
