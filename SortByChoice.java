import java.util.*;

public class SortByChoice {
	public static void main (String[] args) {
		// ArrayList<Integer> numbers = new ArrayList<Integer>();
		// numbers.add(10); etc...

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(7);
		numbers.add(9);
		numbers.add(3);
		numbers.add(5);

		Sort(numbers);
	}

	public static int FindSmallest(List<Integer> numbers) {
		int smallest = numbers.get(0);
		int smallestIndex = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) <= smallest) {
				smallest = numbers.get(i);
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}

	public static void Sort(List<Integer> numbers) {

		System.out.println(numbers);

		List<Integer> sortedList = new ArrayList<Integer>();
		List<Integer> bufferedList = new ArrayList<Integer>();
		bufferedList.addAll(numbers);

		for (int i: bufferedList) {
			sortedList.add(numbers.get(FindSmallest(numbers)));
			numbers.remove(FindSmallest(numbers));

		}
		System.out.println(sortedList);
		System.out.println(numbers);
	}
}