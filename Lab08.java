import java.io.*;
import java.util.*;

public class Lab08 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        ArrayList<String> ar1 = new ArrayList<>();

        File file = new File("/home/eric/Desktop/dictionary.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = "";
        while ((st = br.readLine()) != null)
            ar1.add(st);

        Collections.sort(ar1, Comparator.comparing(String::length)); //Sort ar1 by string length.

        System.out.println("Enter the word you want the AI to guess.");


        String word = sc.nextLine(); //ar1.get(rd.nextInt(ar1.size()));


        ArrayList<String> remaining = new ArrayList<>();

        for (int i = 0; i < ar1.size(); i++) {

            if (ar1.get(i).length() == word.length()) {
                remaining.add(ar1.get(i));
            }
        }


        String build = "";

        for (int i = 0; i < word.length(); i++) {
            build += ".";
        }

        HashMap<String, Integer> map1 = buildMap(remaining);
        ArrayList<String> charFreq = getFreqArrayFromMap(map1);


        ArrayList<String> guessed = new ArrayList<String>();


        int count = 0;
        while (true) {

            String guess = charFreq.get(0);
            System.out.println("MY GUESS IS " + guess);
            guessed.add(guess);
            count++;


            build = buildString(word, build, guess);
            System.out.println("So far we have " + build);


            remaining = refineRemaining(remaining, build);
//            System.out.println("REMAINING ARRAY = " + remaining);

            map1 = buildMap(remaining);

            charFreq = getFreqArrayFromMap(map1);

            charFreq = removeGuessed(charFreq, guessed);

//            System.out.println(charFreq);


//            System.out.println("GUESSED ARRAY = " + guessed);


            System.out.println();
            System.out.println();


            if (remaining.size() == 1) {
                System.out.println("The word is " + remaining.get(0));
                System.out.println("It took me " + count + " attempts.");
                break;
            }


        }


    }


    public static ArrayList<String> removeGuessed(ArrayList<String> remaining, ArrayList<String> guessed) {


        for (int i = 0; i < guessed.size(); i++) {

            remaining.remove(guessed.get(i));

        }

        return remaining;

    }


    public static ArrayList<String> refineRemaining(ArrayList<String> remaining, String build) {

        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < build.length(); i++) {

            for (int j = 0; j < remaining.size(); j++) {

                if (build.charAt(i) != '.') {


                    try {

                        if (build.charAt(i) != remaining.get(j).charAt(i)) {
                            remaining.set(j, "");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                    }

                }


            }

        }

        for (int i = 0; i < remaining.size(); i++) {
            if (remaining.get(i) != "") {
                temp.add(remaining.get(i));
            }
        }


        return temp;

    }


    public static String buildString(String word, String build, String guess) {

        StringBuilder s1 = new StringBuilder(build);

        for (int i = 0; i < build.length(); i++) {

            if (word.charAt(i) == guess.charAt(0)) {

                s1.setCharAt(i, guess.charAt(0));

            }
        }

        return s1.toString();


    }


    public static ArrayList<String> getFreqArrayFromMap(HashMap<String, Integer> map1) {

        ArrayList<String> ar1 = new ArrayList<>();

        for (String i : map1.keySet()) {
            ar1.add(i);
        }

        return ar1;

    }


    public static HashMap<String, Integer> buildMap(ArrayList<String> remaining) {

        HashMap<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < remaining.size(); i++) {

            for (int j = 0; j < remaining.get(i).length(); j++) {

                String c1 = remaining.get(i).charAt(j) + "";

                if (map1.containsKey(c1)) {
                    map1.put(c1, map1.get(c1) + 1);
                } else {
                    map1.put(c1, 1);
                }

            }
        }

        return sortByValue(map1);

    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


}

