import java.util.*;
import java.math.BigInteger;

public class Lab06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long p = sc.nextLong();
		long g = sc.nextLong();
		long gxMODp = sc.nextLong();

		long c1 = sc.nextLong();
		long c2 = sc.nextLong();

		for (int i = 0; i <= p; i++) {

			if (modPow(g, i, p) == gxMODp) {

				long p1 = modPow(c1, p - 1 - i, p);
				long finalNum = modMult(p1, c2, p);
				System.out.println(finalNum);
				break;

			}

		}

	}

	public static long modPow(long number, long power, long modulus) {

		if (power == 0)
			return 1;
		else if (power % 2 == 0) {
			long halfpower = modPow(number, power / 2, modulus);
			return modMult(halfpower, halfpower, modulus);
		} else {
			long halfpower = modPow(number, power / 2, modulus);
			long firstbit = modMult(halfpower, halfpower, modulus);
			return modMult(firstbit, number, modulus);
		}
	}

	public static long modMult(long first, long second, long modulus) {

		if (second == 0)
			return 0;
		else if (second % 2 == 0) {
			long half = modMult(first, second / 2, modulus);
			return (half + half) % modulus;
		} else {
			long half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		}
	}

}
