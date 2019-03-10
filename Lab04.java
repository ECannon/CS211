import java.util.*;

public class Lab04 {
	
    public static boolean check(String s1, String s2) {
    	
    	int greatest1 = 0, greatest2 = 0;
    	
    	for(int i = 0; i < s1.length(); i++) {
    		
    		if((int)s1.charAt(i) > (int)greatest1) {
    			greatest1 = (int)s1.charAt(i);
    		}
    	}
    	for(int i = 0; i < s2.length(); i++) {
    		
    		if((int)s2.charAt(i) > greatest2) {
    			greatest2 = (int)s2.charAt(i);
    		}
    	}
    	
    	if(greatest1 < greatest2) {
    		return true;
    	} else if(greatest1 == greatest2) {
    		if(s1.compareTo(s2) < 0) {
    			return true;
    		}
    	}
    	
    	return false;

    }


	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] ar1 = new String[n];
		
		for(int i = 0; i < ar1.length; i++) {
			ar1[i] = sc.nextLine();
		}
		
		quickSort(ar1,0,ar1.length-1);
		
		for(String i : ar1) {
			System.out.println(i);
		}
		

	}
	
	public static void quickSort(String[] arr, int start, int end){
		 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public static int partition(String[] arr, int start, int end){
    	
        String pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(check(arr[i], pivot)){
                String temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        String temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }
	
}
