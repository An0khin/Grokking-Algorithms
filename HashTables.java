import java.util.*; //for hashtables
public class HashTables{
	public static void main(String[] args) {
		//test();
		phone_dict();
	}
	public static void test() {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		table.put(1, "Evgeniy");
		System.out.println(table);
	}
	//Phones...
	public static void phone_dict() {
		Scanner scan = new Scanner(System.in);
		Hashtable<String, Integer> phones = new Hashtable<String, Integer>();
		asking(phones, scan);
	}
	public static void asking(Hashtable<String, Integer> phones, Scanner scan) {
		String question = scan.nextLine();
		if (question.equals("0")) {
			return;
		}
		if (question.equals("1")) {
			add_phone(phones, scan);
		} else if (question.equals("2")) {
			System.out.println(phones);
		} else if (question.equals("3")) {
			get_phone(phones, scan);
		}
		asking(phones, scan);
	}
	public static void add_phone(Hashtable<String, Integer> phones, Scanner scan) {
		System.out.println("Write name");
		String name = scan.nextLine();
		System.out.println("Write phone");
		int phone = Integer.parseInt(scan.nextLine());
		phones.put(name, phone);
	}
	public static void get_phone(Hashtable<String, Integer> phones, Scanner scan) {
		String name = scan.nextLine();
		System.out.println(phones.get(name));
	}
}