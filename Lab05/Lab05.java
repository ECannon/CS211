import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Lab05 {

	public static int score = 0;

	public static void main(String[] args) throws Exception {

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		FileIO reader = new FileIO();
		String[] contents = reader.load("C:\\Users\\ericc\\OneDrive\\Desktop\\dictionary.txt");

		for (int i = 0; i < contents.length; ++i)
			contents[i] = contents[i].substring(0, contents[i].length() - 1);

		ArrayList<String> ar1 = new ArrayList<String>(Arrays.asList(contents));

		int timeLimit = 30;
		CountdownTimer timer = new CountdownTimer(timeLimit);
		System.out.println("*****30 SECONDS REMAINING*****");
		System.out.println();

		while (true) {

			String word = ar1.get(rd.nextInt(ar1.size() - 1));

			System.out.println("Try guess the word!");
			System.out.println();

			word = word.substring(0, rd.nextInt(word.length() - 2) + 1);

			System.out.println(word);

			String guess = sc.nextLine().toLowerCase();

			System.out.println();

			if (ar1.contains(guess) && (guess.startsWith(word))) {
				System.out.println("CORRECT");

				playCorrect();

				score++;

			} else {
				playWrong();
				System.out.println("WRONG");
			}

			System.out.println();

		}
	}

	public static void playCorrect() {

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\ericc\\OneDrive\\Desktop\\correct.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

	}

	public static void playWrong() {

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\ericc\\OneDrive\\Desktop\\wrong.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

	}

}