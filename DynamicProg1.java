import java.util.*;

public class DynamicProg1 {
	public static void main(String[] args) {
		//Begin(Initializing)

		String[][] table = new String[3][4];

		// Hashtable<String, String[]> tableHash = new Hashtable<String, String[]>();

		// tableHash.put("guitar", table[0]);
		// tableHash.put("piano", table[1]);
		// tableHash.put("cloth", table[2]);

		Hashtable<String, Integer> weight = new Hashtable<String, Integer>();

		weight.put("guitar", 3);
		weight.put("piano", 4);
		weight.put("cloth", 1);

		Hashtable<String, Integer> cost = new Hashtable<String, Integer>();

		cost.put("guitar", 1250);
		cost.put("piano", 1500);
		cost.put("cloth", 500);
		cost.put("null", 0);

		String[] keys = new String[10];
		keys[0] = "guitar";
		keys[1] = "piano";
		keys[2] = "cloth";

		List<String> used = new ArrayList<String>();

		for(int row = 0; row < table.length; row++) {
			String[] rowArray = table[row];
			for(int cell = 0; cell < rowArray.length; cell++) {
				System.out.println(row + "     " + cell);
				table[row][cell] = mostValue(keys, cell+1, row, weight, cost);
				
				//
				// if (weight.get(keys[row])-1 <= cell) {
				// 	table[row][cell] = keys[row];
				// } else {
				// 	table[row][cell] = "null";
				// }

				if (row > 0) {
					if (getCost(table[row][cell], cost) < getCost(table[row-1][cell], cost)) {
						table[row][cell] = table[row-1][cell];
					}
				}
			}
		}

		System.out.println(Arrays.deepToString(table));

		//String[] fourthRow = new String[4];

		// int[][] table = new int[5][5];
		// int numb = 1;
		// for (int row = 0; row <= 4; row++) {
		// 	for (int column = 0; column <= 4; column++) {
		// 		table[row][column] = numb;
		// 		numb++;
		// 	}
		// }

		//Begin(Initializing)






		//Output
		
		//Output
	}

	public static String mostValue(String[] keys, int max, int row, Hashtable<String, Integer> weight, Hashtable<String, Integer> cost) {

		String mostValuable = "null";
		int price = getCost(mostValuable, cost);//another function

		if(weight.get(keys[row]) <= max) {
			mostValuable = keys[row];
		} else {
			mostValuable = "null";
		}

		String[] availableEl = new String[row+1];

		for (int begin = 0; begin <= row; begin++) {
			availableEl[begin] = keys[begin];
		}

		for (int i = 0; i <= availableEl.length-1; i++) {
			for (int numb = i+1; numb <= availableEl.length-1; numb++) {
				int sumWeight = weight.get(availableEl[i]) + weight.get(availableEl[numb]);
				System.out.println("weight     "+sumWeight+"/"+max);
				if (sumWeight <= max) {
					System.out.println("cost     "+getCost(availableEl[i] +","+availableEl[numb], cost)+"/"+getCost(mostValuable, cost));
					if (getCost(availableEl[i] +","+availableEl[numb], cost) > getCost(mostValuable, cost)) {
						mostValuable = availableEl[i] +","+availableEl[numb];
						price = getCost(mostValuable, cost);
					}	
				}
			}
		}
		return mostValuable;		
	}

	public static int getCost(String element, Hashtable<String, Integer> cost) {
		String[] elements = element.split(",");

		int sumCost = 0;

		for (String el : elements) {
			sumCost += cost.get(el);
		}

		return sumCost;
	}
}