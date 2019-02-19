import java.util.*;
public class Lab02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		String s1 = sc.nextLine();
		
		for(int i = 0; i < s1.length(); i++) {
			
			char a = s1.charAt(i);
			String binary = Integer.toBinaryString((int)a);
			
			while(binary.length() < 7) binary = "0"+binary;			
			
			if(map.containsKey(binary))map.put(binary, map.get(binary)+1);
			else map.put(binary, 1);
		}
		
		for (String key : map.keySet()) {
		    System.out.println("'" + (char)Integer.parseInt(key,2) +"' appeared " + map.get(key)+ " times");
		}
		 
	}


}
