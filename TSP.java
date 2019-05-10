
import java.util.*;

public class TSP {

	public static void main(String[] args) {

		
		double[] burritoBar = {53.38195, -6.59192};
		Double[][] ar1 = getArr();
		Graph g1 = new Graph(101);
		
		
		
		for(int i = 0; i < ar1.length; i++) {
			for(int j = 0; j < ar1.length; j++) {

				if(i != j) {
					g1.addEgde(i, j, haversine(ar1[i][0], ar1[i][1], ar1[j][0], ar1[j][1]));
				}
			}
		
		}
		
		
		g1.printGraph();
	
		
		
		
		
		
		
		
		
		
		
	}
	
	public static class Edge {
        int source;
        int destination;
        double weight;

        public Edge(int source, int destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph {
    	
    	
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, double weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }


	public static double haversine(double lon1, double lat1, double lon2, double lat2) {

		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double rad = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));
		return rad * c;

	}
	
	
	
	
	
	
	

	public static Double[][] getArr() {

		String ar1[][] = {
				{"BurritoBar", "8:00PM", "53.38195", "-6.59192"},
				{ "33 The Paddocks, Oldtown Mill, Celbridge, Co. Kildare", "7:12 PM", "53.3473", "-6.55057" },
				{ "156 Glendale, Leixlip, Co. Kildare", "7:12 PM", "53.37077", "-6.48279" },
				{ "26 Thornhill Meadows, Celbridge, Co. Kildare", "7:12 PM", "53.35152", "-6.54989" },
				{ "47 Meadowbrook Avenue,Maynooth Co Kildare", "7:12 PM", "53.37278", "-6.59611" },
				{ "112 Mill Lane, Kilcock, Co. Kildare", "7:13 PM", "53.40126", "-6.6683" },
				{ "54 Willowbrook Lawns, Celbridge, Co. Kildare", "7:14 PM", "53.34484", "-6.54766" },
				{ "416A Ballyoulster, Celbridge, Co. Kildare", "7:15 PM", "53.34133", "-6.51856" },
				{ "37 The Orchard, Oldtown Mill, Celbridge, Co. Kildare", "7:15 PM", "53.34492", "-6.5557" },
				{ "4 Abbey Park Grove, Clane, Co. Kildare", "7:16 PM", "53.29206", "-6.67685" },
				{ "36 Rinawade Park, Leixlip, Co. Kildare", "7:16 PM", "53.36483", "-6.51278" },
				{ "1 The Close, Temple Manor,Celbridge , Co.Kildare", "7:16 PM", "53.33067", "-6.54686" },
				{ "35 Beech Park Wood Beech Park,Leixlip Co Kildare", "7:16 PM", "53.36287", "-6.52468" },
				{ "544 Riverforest, Leixlip, Co. Kildare", "7:17 PM", "53.37416", "-6.49494" },
				{ "54 Courtown Park,Kilcock Co Kildare", "7:17 PM", "53.39549", "-6.67647" },
				{ "10 The Drive, Abbeyfarm, Celbridge, Co. Kildare", "7:18 PM", "53.33239", "-6.55163" },
				{ "43 The Woodlands, Castletown, Celbridge, Co. Kildare", "7:18 PM", "53.34678", "-6.53415" },
				{ "1002 Avondale, Leixlip, Co. Kildare", "7:18 PM", "53.36869", "-6.48314" },
				{ "38 Parsons Hall, Maynooth, Co. Kildare", "7:19 PM", "53.37521", "-6.6103" },
				{ "32 The View, St.Wolstan Abbey,Celbridge, Co.Kildare", "7:20 PM", "53.33751", "-6.53173" },
				{ "10 Glen Easton Crescent, Leixlip, Co. Kildare", "7:21 PM", "53.37184", "-6.50065" },
				{ "11 Rinawade View, Leixlip, Co. Kildare", "7:21 PM", "53.36143", "-6.51849" },
				{ "856 Old Greenfield, Maynooth, Co. Kildare", "7:21 PM", "53.37473", "-6.59338" },
				{ "28 The Avenue, Castletown, Co.Kildare", "7:22 PM", "53.34514", "-6.53615" },
				{ "9 The Park, Louisa Valley, Leixlip, Co. Kildare", "7:22 PM", "53.36115", "-6.48907" },
				{ "33 Leinster Wood,Carton Demesne, Maynooth, Co. Kildare", "7:23 PM", "53.39351", "-6.5542" },
				{ "16 Priory Chase, St.Raphaels Manor,,Celbridge, Co.Kildare", "7:23 PM", "53.33886", "-6.55468" },
				{ "14 The Rise, Louisa Valley, Leixlip, Co. Kildare", "7:25 PM", "53.36115", "-6.48907" },
				{ "646 Riverforest,Leixlip Co Kildare", "7:26 PM", "53.37497", "-6.4991" },
				{ "76 Castle Dawson, Maynooth, Co. Kildare", "7:27 PM", "53.37565", "-6.60716" },
				{ "23 Priory Way, St.Raphaels Manor,,Celbridge, Co.Kildare", "7:27 PM", "53.3354", "-6.55111" },
				{ "5 Rinawade View, Leixlip, Co. Kildare", "7:28 PM", "53.36143", "-6.51849" },
				{ "11 The Park, Louisa Valley, Leixlip, Co. Kildare", "7:28 PM", "53.36115", "-6.48907" },
				{ "117 Royal Meadows,Kilcock Co Kildare", "7:28 PM", "53.39459", "-6.66995" },
				{ "12 Maynooth Park, Maynooth, Co. Kildare", "7:29 PM", "53.37122", "-6.586" },
				{ "30 Ryevale Lawns, Leixlip, Co. Kildare", "7:30 PM", "53.36656", "-6.49183" },
				{ "44 Rinawade Avenue, Leixlip, Co. Kildare", "7:30 PM", "53.36141", "-6.51834" },
				{ "7 Straffan Green, Straffan Wood, Maynooth, Co. Kildare", "7:30 PM", "53.37323", "-6.58859" },
				{ "29 Castletown, Leixlip, Co. Kildare", "7:31 PM", "53.36292", "-6.50203" },
				{ "1 Kyldar House, Manor Mills, Maynooth, Co. Kildare", "7:31 PM", "53.38122", "-6.59226" },
				{ "83 Thornhill Meadows, Celbridge, Co. Kildare", "7:31 PM", "53.35098", "-6.54915" },
				{ "90 Vanessa Lawns, Celbridge, Co. Kildare", "7:31 PM", "53.34312", "-6.54747" },
				{ "50 The Lawn, Oldtown Mill, Celbridge, Co. Kildare", "7:31 PM", "53.34197", "-6.55492" },
				{ "20 Habourview, The Glenroyal Centre, Maynooth, Co. Kildare", "7:31 PM", "53.37954", "-6.58793" },
				{ "13 The Little Grove, Celbridge, Co Kildare", "7:32 PM", "53.33835", "-6.53984" },
				{ "10 Brookfield Avenue,Maynooth Co Kildare", "7:32 PM", "53.36976", "-6.59828" },
				{ "35 Rail Park, Co.Kildare", "7:32 PM", "53.37811", "-6.57952" },
				{ "10 Fair Green Court, Kilccock,, Co. Kildare", "7:33 PM", "53.39847", "-6.66787" },
				{ "3 Lyreen Park,Maynooth Co Kildare", "7:34 PM", "53.38579", "-6.58673" },
				{ "34 Silken Vale, Maynooth, Co. Kildare", "7:34 PM", "53.37626", "-6.59308" },
				{ "35 Glen Easton Square, Leixlip, Co. Kildare", "7:34 PM", "53.37336", "-6.48219" },
				{ "10 The Court, Abbey Farm,,Celbridge, Co.Kildare", "7:34 PM", "53.33032", "-6.55311" },
				{ "4 Glendale, Leixlip, Co. Kildare", "7:35 PM", "53.37201", "-6.48517" },
				{ "628 Riverforest, Leixlip, Co. Kildare", "7:35 PM", "53.37416", "-6.49731" },
				{ "111 Elton Court, Leixlip, Co. Kildare", "7:36 PM", "53.36164", "-6.50526" },
				{ "169 Glendale, Co.Kildare", "7:36 PM", "53.37043", "-6.48193" },
				{ "94 Croduan Forest Park, Celbridge, Co. Kildare", "7:36 PM", "53.35372", "-6.54564" },
				{ "13 Abbey Park Court , Clane, , Co Kildare.,", "7:37 PM", "53.2908", "-6.67746" },
				{ "533 Courtown Road, Kilcock, Co. Kildare", "7:37 PM", "53.39792", "-6.6711" },
				{ "13 The Hawthorns, Kilcock, Co. Kildare", "7:37 PM", "53.39315", "-6.66909" },
				{ "106 The Drive, Castletown,,Celbridge, Co.Kildare", "7:39 PM", "53.34439", "-6.53841" },
				{ "15 Willow Rise, Primrose Gate, Celbridge, Co. Kildare", "7:41 PM", "53.33591", "-6.53566" },
				{ "7 Rinawade Park, Leixlip, Co. Kildare", "7:41 PM", "53.3632", "-6.51178" },
				{ "40 Oaklawn West., Leixlip, Co. Kildare", "7:42 PM", "53.36833", "-6.50589" },
				{ "12 Castlevillage Avenue, Celbridge, Co. Kildare", "7:42 PM", "53.35298", "-6.54921" },
				{ "107 Castle Dawson, Maynooth, Co. Kildare", "7:43 PM", "53.38122", "-6.59226" },
				{ "2 The Downs, St.Wolstan Abbey,,Celbridge, Co.Kildare", "7:43 PM", "53.33605", "-6.53414" },
				{ "44 Simmonstown Manor, Celbridge, Co. Kildare", "7:43 PM", "53.33324", "-6.53978" },
				{ "2 Parsons Street, Maynooth, Co. Kildare", "7:43 PM", "53.38039", "-6.59368" },
				{ "6 Glen Easton View,Leixlip Co Kildare", "7:45 PM", "53.36883", "-6.51468" },
				{ "78 Crodaun Forest Park, Celbridge, Co. Kildare", "7:45 PM", "53.35401", "-6.54603" },
				{ "172 Woodview, Castletown, Celbridge, Co. Kildare", "7:45 PM", "53.34745", "-6.53401" },
				{ "116 Connaught Street, Kilcock, Co. Kildare", "7:46 PM", "53.39839", "-6.66767" },
				{ "35 The Paddocks, Oldtown Mill, Celbridge, Co. Kildare", "7:47 PM", "53.3473", "-6.55057" },
				{ "11 The Lodge,, Abbeylands,, Clane,, Co. Kildare.,", "7:48 PM", "53.29128", "-6.67836" },
				{ "113 Elton Court, Leixlip, Co. Kildare", "7:48 PM", "53.36158", "-6.50533" },
				{ "3 Greenfield Drive, Maynooth, Co. Kildare", "7:48 PM", "53.3727", "-6.58757" },
				{ "13 Castlevillage Lawns, Celbridge, Co. Kildare", "7:48 PM", "53.35321", "-6.55412" },
				{ "902 Lady Castle, K Club, Straffan, Co. Kildare", "7:49 PM", "53.31159", "-6.60538" },
				{ "13 Rinawade Close, Leixlip, Co. Kildare", "7:50 PM", "53.36455", "-6.51435" },
				{ "Apartment 1, The Lamps, School Street, Kilcock, Co. Kildare", "7:50 PM", "53.39999", "-6.66807" },
				{ "2 Beaufield Drive, Maynooth, Co. Kildare", "7:50 PM", "53.37414", "-6.60028" },
				{ "509 Riverforest, Leixlip, Co. Kildare", "7:50 PM", "53.37402", "-6.49363" },
				{ "43 The Green Moyglare Hall,Maynooth Co Kildare", "7:51 PM", "53.38983", "-6.5951" },
				{ "636 St.Patrick Park,Celbridge, Co.Kildare", "7:51 PM", "53.34033", "-6.54596" },
				{ "132 The Peninsula, Alexandra Walk, Clane, Co. Kildare", "7:51 PM", "53.28973", "-6.67445" },
				{ "14 Rye River Crescent, Dun Carraig, Leixlip, Co. Kildare", "7:52 PM", "53.36518", "-6.48913" },
				{ "348 Ryevale Lawns, Leixlip, Co. Kildare", "7:52 PM", "53.36873", "-6.49619" },
				{ "17 The Crescent, Abbey Farm,,Celbridge, Co.Kildare", "7:52 PM", "53.33256", "-6.55056" },
				{ "36 Castledawson,Maynooth Co Kildare", "7:53 PM", "53.37565", "-6.60701" },
				{ "28 The Lawn Moyglare Abbey,Maynooth Co Kildare", "7:53 PM", "53.38895", "-6.60579" },
				{ "104c Beatty Park, Celbridge, Co. Kildare", "7:54 PM", "53.34648", "-6.54552" },
				{ "40 Thornhill Meadows, Celbridge, Co. Kildare", "7:55 PM", "53.35202", "-6.55099" },
				{ "18 College Green, Maynooth, Co.Kildare", "7:55 PM", "53.37247", "-6.60044" },
				{ "1 Beaufield Crescent, Maynooth, Co Kildare", "7:56 PM", "53.37449", "-6.60005" },
				{ "6 Glen Easton Grove ,Leixlip Co Kildare", "7:56 PM", "53.36559", "-6.51914" },
				{ "14 The Avenue, Rochford, Bakers Walk, Kilcock, Co. Kildare", "7:57 PM", "53.39648", "-6.66612" },
				{ "7 Riverlawn, Abbeyfarm, Celbridge, Co. Kildare", "7:57 PM", "53.33239", "-6.55163" },
				{ "51 Royal Meadows, Kilcock, Co. Kildare", "7:57 PM", "53.39512", "-6.67084" },
				{ "96 Priory Lodge, St. Raphael's Manor, Celbridge, Co. Kildare", "7:58 PM", "53.33835", "-6.53984" },
				{ "18 Castle Dawson, Maynooth, Co. Kildare", "7:58 PM", "53.37538", "-6.60707" } };

//		for(int i = 0; i < ar1.length; i++) {
//			for(int j = 0; j < ar1[i].length; j++) {
//				System.out.print(ar1[i][j] + "|||");
//			}
//			System.out.println();
//		}

		Double[][] temp = new Double[ar1.length][2];

		for (int i = 0; i < ar1.length; i++) {
			temp[i][0] = Double.parseDouble(ar1[i][2]);
			temp[i][1] = Double.parseDouble(ar1[i][3]);

		}

		return temp;

	}

}
