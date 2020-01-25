import java.io.FileNotFoundException;

public class Simulation {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String pathFile = "C:\\Users\\hugos\\OneDrive\\Área de Trabalho\\Hugo\\L'X\\2A\\P2\\INF421\\centers.1.in";
		Graph tree = Graph.Graph_text(pathFile);
		System.out.println(tree.N);
		for(int i=0;i<tree.N;i++) {
			System.out.print(tree.vertices[i]);
			System.out.print(" ");
		}
		System.out.println("\nEdges: ");
		for(int i=0;i<tree.N;i++) {
			for(int j=0; j<tree.N;j++) { 
				System.out.print(tree.edges[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
