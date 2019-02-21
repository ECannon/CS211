import java.util.*;
public class Lab02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			
			char a = s1.charAt(i);
			String binary = Integer.toBinaryString((int)a);
			
			while (binary.length() < 7) binary = "0" + binary;
			 
			System.out.print(binary + " ");
			
			if(map.containsKey(a)) map.put(a, map.get(a)+1);
			else map.put(a, 1);
		}
		System.out.println();
		
		for(Character key : map.keySet()) {
			if(map.get(key) > 1) System.out.println("' " + key + "' " + "appeared " + map.get(key) + " times");
			else System.out.println("' " + key + "' " + "appeared " + map.get(key) + " time");
		}
		 
	}


}
