import java.util.*;

public class Graphs{
	public static void main(String[] args) {
		Hashtable<String, String[]> graph = new Hashtable<String, String[]>();
		String[] names1 = {"alice", "bob", "claire"};
		String[] names2 = {"anuj", "peggy"};
		String[] names3 = {"peggy"};
		String[] names4 = {"thom", "jonny"};
		String[] names5 = new String[1];
		String[] names6 = new String[1];
		String[] names7 = new String[1];
		String[] names8 = new String[1];
		graph.put("you", names1);
		graph.put("bob", names2);
		graph.put("alice", names3);
		graph.put("claire", names4);
		graph.put("anuj", names5);
		graph.put("peggy", names6);
		graph.put("thom", names7);
		graph.put("jonny", names8);
		search("you", graph);


	}
	public static void search(String name, Hashtable<String, String[]> graph) {
		ArrayDeque<String> deque = new ArrayDeque<String>();
		add(deque, graph.get(name));
		List<String> searched = new ArrayList<String>();
		String person;
		String firstLet;
		while(!deque.isEmpty()) {
			person = deque.poll();
			if (!searched.contains(person)) {
				firstLet = Character.toString(person.charAt(person.length()-1));
				if (firstLet.equals("m")) {
					System.out.println(person);
					System.out.println(true);
				} else {
					searched.add(person);
					add(deque, graph.get(person));
				}
			}
		}
		System.out.println(false);
	}
	public static void add(ArrayDeque<String> deque, String[] names) {
		if (names[0] != null) {
			for (String element : names) {
				deque.offer(element);
			}
		}
	}
}