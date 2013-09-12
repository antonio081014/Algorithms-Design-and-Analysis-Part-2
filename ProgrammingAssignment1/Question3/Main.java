/**
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author antonio081014
 * @time Sep 11, 2013, 10:54:40 PM
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("edges.txt"));
			MSTGraph<Integer> g = new MSTGraph<Integer>();
			String[] str = in.readLine().split("\\s");
			int nodes = Integer.parseInt(str[0]);
			int edges = Integer.parseInt(str[1]);
			for (int i = 0; i < edges; i++) {
				str = in.readLine().split("\\s");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);
				g.addVertex(new Vertex<Integer>(a, a));
				g.addVertex(new Vertex<Integer>(b, b));
				g.addEdge(new Vertex<Integer>(a, a), new Vertex<Integer>(b, b),
						c);
			}
			in.close();
			long start = System.currentTimeMillis();
			// g.printGraph();
			print_prims(g);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * -3612829;
	 * */
	private void print_prims(MSTGraph<Integer> g) {
		System.out.println(g.MST_PRIMs(new Vertex<Integer>(1, 1)));
	}
}
