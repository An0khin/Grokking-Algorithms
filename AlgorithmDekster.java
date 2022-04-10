import java.util.*;

public class AlgorithmDekster {
	public static void main (String[] args) {
		//Graph
		Hashtable<String, Hashtable<String, Integer>> graph = new Hashtable<String, Hashtable<String, Integer>>();
		Hashtable<String, Integer> forStart = new Hashtable<String, Integer>();
		Hashtable<String, Integer> forA = new Hashtable<String, Integer>();
		Hashtable<String, Integer> forB = new Hashtable<String, Integer>();
		Hashtable<String, Integer> forEnd = new Hashtable<String, Integer>();

		//Filling
		forStart.put("A", 6);
		forStart.put("B", 2);
		graph.put("Start", forStart);
		forA.put("End", 1);
		graph.put("A", forA);
		forB.put("A", 3);
		forB.put("End", 5);
		graph.put("B", forB);
		graph.put("End", forEnd);
		//Filling

		//Graph

		//Costs
		Hashtable<String, Integer> costs = new Hashtable<String, Integer>();

		//Filling
		costs.put("A", 6);
		costs.put("B", 2);
		costs.put("End", (int) Double.POSITIVE_INFINITY);
		//Filling

		//Costs

		//Parents
		Hashtable<String, String> parents = new Hashtable<String, String>();

		//Filling
		parents.put("A", "Start");
		parents.put("B", "Start");
		parents.put("End", "nobody");
		//Filling

		//Parents

		List<String> processed = new ArrayList<String>();

		String node = FindSmallestNode(costs, processed);

		while (!node.equals("")) {
			int cost = costs.get(node);
			Hashtable<String, Integer> neighbors = graph.get(node);

			Enumeration<String> neighborsKeys = neighbors.keys();

			while(neighborsKeys.hasMoreElements()) {
				String neighbor = neighborsKeys.nextElement();
				int newCost = cost + neighbors.get(neighbor);

				if (costs.get(neighbor) > newCost) {
					costs.replace(neighbor, newCost);
					parents.replace(neighbor, node);
				}
			}
			processed.add(node);
			node = FindSmallestNode(costs, processed);
		}

		System.out.println(parents);
		System.out.println(costs);
	}

	public static String FindSmallestNode(Hashtable<String, Integer> costs, List<String> processed) {
		int smallest = (int) Double.POSITIVE_INFINITY;
		String smallestNode = "";

		Enumeration<String> keys = costs.keys();

		while (keys.hasMoreElements()) {
			String node = keys.nextElement();
			if (smallest > costs.get(node) && !processed.contains(node)) {
				smallest = costs.get(node);
				smallestNode = node;
			}
		}

		return smallestNode;
	}
}