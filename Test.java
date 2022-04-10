import java.util.*; //for ArrayList<type>

public class Test{
	public static void main (String[] args) {
		// arraylist();
		// recursy(3);
		// System.out.println(factorial(5));
		// findBiggestMutualDivider(1680, 640);

		// List<Integer> array = new ArrayList<Integer>();
		// array.add(5);
		// array.add(10);
		// array.add(3);
		// System.out.println(sumElementsArray(array));

		// List<Integer> array = new ArrayList<Integer>();
		// array.add(3);
		// System.out.println(sizeArray(array));

		// List<Integer> array = new ArrayList<Integer>();
		// array.add(5);
		// array.add(10);
		// array.add(3);
		// System.out.println(findBiggestNumber(array));

		// List<Integer> array = new ArrayList<Integer>();
		// array.add(10);
		// array.add(5);
		// array.add(7);
		// array.add(14);
		// array.add(25);
		// System.out.println(quickSort(array));

		// Hashtable<String, Boolean> voted = new Hashtable<String, Boolean>();
		// Scanner scan = new Scanner(System.in);
		// ask(voted, scan); 

	}
	public static void arraylist() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(32);
		list.add(645);
		list.add(12);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
	}
	public static void recursy(int i) {
		System.out.println(i);
		if (i <= 1) {
			return;
		}
		recursy(i-1);
	}
	public static int factorial(int i) {
		if (i == 1) {
			return 1;
		} else {
			return i * factorial(i-1);
		}
	}
	public static void findBiggestMutualDivider(int width, int length) {
		int smallest;
		if (width == length) {
			System.out.println(width + "x" + length);
		}

		if (width < length) {
			if (length % width != 0) {
				findBiggestMutualDivider(width, length % width);
			} else {
				System.out.println(width + "x" + width);
			}
		} else if (length < width) {
			if (width % length != 0) {
				findBiggestMutualDivider(length, width % length);
			} else {
				System.out.println(length + "x" + length);
			}
		}
	}
	public static int sumElementsArray(List<Integer> array) {
		if (array.size() == 1) {
			return array.get(0);
		}
		int first = array.get(0);
		array.remove(0);
		return first + sumElementsArray(array);
	}
	public static int sizeArray(List array) {
		int count = 1;
		if (array.size() == 1) {
			count = 1;
			return count;
		} else {
			array.remove(0);
			return count + sizeArray(array);
		}
	}
	public static int findBiggestNumber(List<Integer> array){
		int biggest = array.get(0);
		if (array.size() == 1) {
			return array.get(0);
		}
		array.remove(0);
		int numb = findBiggestNumber(array);
		if (numb > biggest) {
			biggest = numb;
		}
		return biggest;
	}
	public static List<Integer> quickSort(List<Integer> array) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		List<Integer> newArray = new ArrayList<Integer>();
		if (array.size() < 2) {
			return array;
		} else {
			//int pivot = array.get(0); //Not best way
			int pivot = array.get((int) Math.random() * array.size()); //The best way

			for (int i : array) {
				if (i < pivot) {
					left.add(i);
				} 
				if (i > pivot) {
					right.add(i);
				}
			}

			left = quickSort(left);
			right = quickSort(right);

			for (int i : left) {
				newArray.add(i);
			}

			newArray.add(pivot);

			for (int i : right) {
				newArray.add(i);
			}

			return newArray;
		}
	}
	public static void Vote(Hashtable<String, Boolean> table, Scanner scan) {
		ask(table, scan);
	}
	public static void ask(Hashtable<String, Boolean> table, Scanner scan) {
		String question = scan.nextLine();
		if (question.equals("0")) {
			return;
		} else if (question.equals("1")) {
			String name = scan.nextLine();
			if (!table.containsKey(name)) {
				table.put(name, true);
			} else {
				System.out.println("This person already has voted");
			}
		} else if (question.equals("2")) {
			System.out.println(table);
		}
		ask(table, scan);
	}
}