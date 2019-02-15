import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class Lab01 {

	public static void main(String[] args) {

		Random rd = new Random();
		String alphabet = "0123456789abcdef";
		String key = "";
		String doubleHash = "";

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 64; i++) {
			key += alphabet.charAt(rd.nextInt(alphabet.length() - 1));
		}

		String string80 = "80" + key;

		try {
			doubleHash = sha256(string80);
			doubleHash = sha256(doubleHash);
		} catch (NoSuchAlgorithmException e) {
			
		}

		string80 = string80 + doubleHash.substring(0, 8);

		String finalString = base58(string80);

		System.out.println(finalString);

	}

	static String sha256(String input) throws NoSuchAlgorithmException {
		byte[] in = hexStringToByteArray(input);
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(in);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static String base58(String s1) {

		BigInteger n = new BigInteger(s1, 16);

		String r = "";
		String characters = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

		while (n.compareTo(BigInteger.valueOf(0)) > 0) {

			BigInteger remainder = (n.mod(BigInteger.valueOf(58)));
			r = characters.charAt(remainder.intValue()) + r;
			n = n.divide(BigInteger.valueOf(58));

		}

		return r;

	}

}