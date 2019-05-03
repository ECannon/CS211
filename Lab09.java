import java.util.*;
import java.math.*;
public class Lab09 {

	public static void main(String[] args) {
		
		
		double lon1 = 74.0445;
		double lat1 = 40.6892;
		
		double lon2 = 2.3499;
		double lat2 = 48.8530;
	
		
		System.out.println(haversine(lon1,lat1,lon2,lat2));
		
		
		

	}
	
	public static double haversine(double lon1, double lat1, double lon2, double lat2) {
		
		// distance between latitudes and longitudes 
        double dLat = Math.toRadians(lat2 - lat1); 
        double dLon = Math.toRadians(lon2 - lon1); 
  
        // convert to radians 
        lat1 = Math.toRadians(lat1); 
        lat2 = Math.toRadians(lat2); 
  
        // apply formulae 
        double a = Math.pow(Math.sin(dLat / 2), 2) +  
                   Math.pow(Math.sin(dLon / 2), 2) *  
                   Math.cos(lat1) *  
                   Math.cos(lat2); 
        double rad = 6371; 
        double c = 2 * Math.asin(Math.sqrt(a)); 
        return rad * c; 
		
		
		
	}

}
